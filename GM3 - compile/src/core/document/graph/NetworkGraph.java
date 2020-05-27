/*
 *  Copyright (C) 2016
 *  This file is part of GRASSMARLIN.
 */
package core.document.graph;

import util.JarToolUtil;
import util.MysqlDemo;
import com.sun.javafx.collections.ObservableListWrapper;
import core.document.Event;
import core.document.ImportList;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.ObservableList;
import util.RateLimitedTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import util.AttachBugs;
import ui.graphing.Cell;

public class NetworkGraph<TNode extends INode<TNode>, TEdge extends IEdge<TNode>> {
    public class UpdateGraphArgs {
        public UpdateGraphArgs(NetworkGraph graph) {
            this.graph = graph;
        }
        public NetworkGraph graph;
    }

    public Event<UpdateGraphArgs> OnGraphCleared = new Event<>();
    public Event<UpdateGraphArgs> OnNodeDirtied = new Event<>();
    public Event<UpdateGraphArgs> OnGroupingInvalidated = new Event<>();
    public ENode enode;
    public ENodeWrapper enodes;
    public MysqlDemo m;
    public String cmd;
    public AttachBugs AB;
    public static String tab;

    // The ConcurrentSkipLists are the authoritative data store for nodes and edges.

    protected final HashMap<TEdge, TEdge> edges;
    public final HashMap<TNode, TNode> nodes;
    // The ObservableLists are used to integrate with the JavaFX UI components.
    //Processing threads should update nodes, edges, etc., and then call commitUi() to migrate the data to the UI objects.
    protected final ObservableList<TEdge> edgesObservable;
    protected final ObservableList<TNode> nodesObservable;

    // Rate Limiter for Refresh
    RateLimitedTask taskRefreshUi;



    /**
     * Lock to handle synchronization when accessing node and edge collections together.
     */
    protected final Object lock = new Object();

    public NetworkGraph() {
        try {
            m = new MysqlDemo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AB = new AttachBugs();
        edges = new LinkedHashMap<>();
        nodes = new LinkedHashMap<>();
        enode = new ENode();
        enodes = new ENodeWrapper();
        edgesObservable = new ObservableListWrapper<>(new CopyOnWriteArrayList<>());
        nodesObservable = new ObservableListWrapper<>(new CopyOnWriteArrayList<>());

        taskRefreshUi = new RateLimitedTask(1000, () -> {  //Allow refresh at up to ~1
            this.commitUi();
        });

    }

    public List<TNode> getRawNodeList() {
        return new ArrayList<>(nodes.keySet());
    }

    public List<TEdge> getRawEdgeList() {
        return new ArrayList<>(edges.keySet());
    }

    public ObservableList<TNode> getNodes() {
        return new ReadOnlyListWrapper<>(nodesObservable);
    }
    public ObservableList<TEdge> getEdges() {
        return new ReadOnlyListWrapper<>(edgesObservable);
    }

    public int indexOf(TNode node) {
        return nodesObservable.indexOf(node);
    }

    public int indexOf(TEdge edge) {
        return edgesObservable.indexOf(edge);
    }
    /**
     * Add the nodes and edges of the graph to the provided lists.  This is performed in a manner synchronized with other NetworkGraph operations.
     * @param nodes Collection to receive a copy of the node list.  Nodes will be skipped if null.
     * @param edges Collection to receive a copy of the edge list.  Edges will be skipped if null.
     */
    public void GetGraphContents(List<TNode> nodes, List<TEdge> edges) {
        synchronized(lock) {
            if(nodes != null) {
                nodes.addAll(this.nodesObservable);
            }
            if(edges != null) {
                edges.addAll(this.edgesObservable);
            }
        }
    }

    /**
     * Bulk addition of nodes; duplicates won't be added, but object references won't be adjusted, either.
     * @param nodes The nodes to add to the graph.
     */
    public void addNodes(Collection<TNode> nodes) {
        synchronized(lock) {
            nodes.removeAll(this.nodes.keySet());
            for(TNode node : nodes) {
                this.nodes.put(node, node);
            }
        }
    }
    public TNode addNode(final TNode nodeNew) {
        final TNode nodeEffective;
        synchronized(lock) {
            if(nodes.containsKey(nodeNew)) {
                nodeEffective = nodes.get(nodeNew);
            } else {
                nodes.put(nodeNew, nodeNew);
                nodeEffective = nodeNew;
            }
        }
        return nodeEffective;
    }
    public int removeNodes(Collection<TNode> nodesToRemove) {
        int cnt = 0;
        synchronized(lock) {
            for(TNode node : nodesToRemove) {
                if(nodes.remove(node) != null) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * Bulk add edges.  Unlike addEdge, this will not look up the nodes for equivalent ones already belonging to the graph,
     * so the caller is responsible for handling the integrity checking of the list.
     * @param edges The edges to add.  The endpoints will be added if they do not exist.
     */
    public void addEdges(Collection<TEdge> edges) {
        Set<TNode> nodesToAdd = new HashSet<>();
        nodesToAdd.addAll(edges.stream().map(edge -> edge.getSource()).collect(Collectors.toList()));
        nodesToAdd.addAll(edges.stream().map(edge -> edge.getDestination()).collect(Collectors.toList()));
        synchronized(lock) {
            addNodes(nodesToAdd);
            edges.removeAll(this.edges.keySet());
            for(TEdge edge : edges) {
                this.edges.put(edge, edge);
            }
        }
    }
    public void removeEdges(Collection<TEdge> edgesToRemove) {
        synchronized(lock) {
            for(TEdge edge : edgesToRemove) {
                edges.remove(edge);
            }
        }
    }
    /**
     * Adds an edge to the graph, if it doesn't already exist.
     * @param edgeNew The edge to add.
     * @return If the edge was added to the graph, edgeNew is returned.  Otherwise, the edge which already exists is
     * returned.  If the edge is deleted between the time the edge is found to have existed but before returning, null
     * is returned.
     */
    public TEdge addEdge(TEdge edgeNew) {
        TNode nodeSource;
        TNode nodeDestination;
        TEdge edgeResult;
        synchronized(lock) {
            nodeSource = nodes.get(edgeNew.getSource());
            if(nodeSource == null) {
                nodeSource = edgeNew.getSource();
                nodes.put(nodeSource, nodeSource);
            }

            nodeDestination = nodes.get(edgeNew.getDestination());
            if(nodeDestination == null) {
                nodeDestination = edgeNew.getDestination();
                nodes.put(nodeDestination, nodeDestination);
            }

            edgeResult = edges.get(edgeNew);
            if(edgeResult == null) {
                edgeResult = edgeNew;
                edges.put(edgeNew, edgeNew);
            }
        }

        //Call events outside lock.
        if(edgeNew.getSource() != nodeSource) {
            edgeNew.setSource(nodeSource);
        }
        if(edgeNew.getDestination() != nodeDestination) {
            edgeNew.setDestination(nodeDestination);
        }
        return edgeResult;
    }

    /**
     * Returns a list of edges connected to/from node.
     * @param node A node that will be the source or destination of all returned edges.
     * @return All edges in this graph that contain node as a source or destination.
     */
    public List<TEdge> getEdgesInvolving(TNode node) {
        return this.edges.keySet().stream().filter(edge -> edge.getSource().equals(node) || edge.getDestination().equals(node)).collect(Collectors.toList());
    }

    public TNode findNode(TNode node) {
        return nodes.get(node);
    }

    public TEdge findMatchingEdge(final IEdge<TNode> edge) {
        return edges.get(edge);
    }

    public void clean() {
        for(TNode node : nodesObservable) {
            node.dirtyProperty().set(false);
        }
    }

    protected void Process_commitUI() {
        final List<TNode> nodesNew;
        final List<TEdge> edgesNew;
        final List<TNode> nodesRemoved;
        final List<TEdge> edgesRemoved;

        /* we export the details of edges and nodes */

        String filePath = JarToolUtil.getJarDir();
        if (edges.size() != 0) {
            Set edatalist = new HashSet();
            FileOutputStream fileOutputStream1 = null;
            File file1 = new File(filePath+"/data/edges.txt");
//                   String filePath = JarToolUtil.getJarDir();
//            File file2 = new File(filePath+"/data/nodes.txt");

            try {
                if (file1.exists()) {
                    //判断文件是否存在，如果不存在就新建一个txt
                    file1.createNewFile();
                }

                fileOutputStream1 = new FileOutputStream(file1);
                Set edgedetails = new HashSet();
                for (TEdge edge : edges.keySet()) {
                    if (edge instanceof LogicalEdge) {
                        LogicalEdge.ConnectionDetails as = ((LogicalEdge) edge).detailsSourceToDestination;
                        Iterator iters = as.Frames.values().iterator();
                        while (iters.hasNext()) {
                            ArrayList list = (ArrayList) iters.next();
                            Map nedge = new HashMap();
                            Map nedge2 = new HashMap();
                            for (int i = 0; i < list.size(); i++) {
                                nedge.clear();
                                String sp = edge.getSource().toString() + " : " + ((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getSourcePort();
                                String dp = edge.getDestination().toString() + " : " + ((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getDestinationPort();
                                String pr = Integer.toString(((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getProtocol());
                                nedge.put("SP", sp);
                                nedge.put("DP", dp);
                                nedge.put("Proto", pr);
                                nedge2.put("SP",edge.getSource().toString());
                                nedge2.put("DP",edge.getDestination().toString());
                                nedge2.put("Proto",pr);
                                edgedetails.add(new HashMap(nedge));
                                edatalist.add(new HashMap(nedge2));

                            }
                        }
                        LogicalEdge.ConnectionDetails ad = ((LogicalEdge) edge).detailsDestinationToSource;
                        Iterator iterd = ad.Frames.values().iterator();
                        while (iterd.hasNext()) {
                            ArrayList list = (ArrayList) iterd.next();
                            Map nedge = new HashMap();
                            for (int i = 0; i < list.size(); i++) {
                                nedge.clear();
                                String sp = edge.getSource().toString() + " : " + ((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getSourcePort();
                                String dp = edge.getDestination().toString() + " : " + ((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getDestinationPort();
                                String pr = Integer.toString(((LogicalEdge.ConnectionDetails.FrameRecord) list.get(i)).getProtocol());
                                nedge.put("SP", sp);
                                nedge.put("DP", dp);
                                nedge.put("Proto", pr);
                                edgedetails.add(new HashMap(nedge));
                            }
                        }

                    }
                }

                Iterator wt = edgedetails.iterator();
                while (wt.hasNext()) {
                    HashMap three = (HashMap)(wt.next());
                    Iterator wt2 = three.entrySet().iterator();
                    while (wt2.hasNext()) {
                        fileOutputStream1.write(wt2.next().toString().getBytes());
                        fileOutputStream1.write("\n".getBytes());
                    }
                    fileOutputStream1.write("\n".getBytes());
                }

                wt = edatalist.iterator();
                while (wt.hasNext()) {
                    HashMap three = (HashMap)(wt.next());
                    Iterator wt2 = three.entrySet().iterator();
                    String p = wt2.next().toString().split("=")[1];
                    String d = wt2.next().toString().split("=")[1];
                    String s = wt2.next().toString().split("=")[1];
                    cmd = "INSERT INTO "+tab+"_edges"+"(`Src`,`Dest`,`Proto`) VALUES('"+s+"','"+d+"','"+p+"')";
                    try {
                        m.exec(cmd);
                    }catch (Exception ignored){
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        if (nodes.size() != 0) {
            int step = 8;
            int size = nodes.size();
            FileOutputStream fileOutputStream2 = null;
            File file2 = new File("F:/JavaProjects_IDEA/GM3 - nocompile/data/nodes.txt");
            try {
                if (file2.exists()) {
                    //判断文件是否存在，如果不存在就新建一个txt
                    file2.createNewFile();
                }
                fileOutputStream2 = new FileOutputStream(file2);
                Set nodedetails = new HashSet();
                for (TNode node : nodes.keySet()) {
                    String name = node.toString();
                    nodedetails = node.getGroups().entrySet();
                    fileOutputStream2.write(("Cidr="+name+"\n").getBytes());
                    // database operaton
                    String MAC="";
                    String MANUFACTURER="";
                    String TOPO = "WAIT FOR USE";
                    //-------------------
                    Iterator it = nodedetails.iterator();
                    while (it.hasNext()) {
                        String next = it.next().toString();
                        if (next.contains("MAC"))
                            MAC = next.substring(4);
                        if (next.contains("Manufacturer"))
                            MANUFACTURER = next.substring(13);
                        fileOutputStream2.write(next.getBytes());
                        fileOutputStream2.write("\n".getBytes());
                        //                System.out.println(next);
                    }
                    if (size%step == 0)
                        cmd = "INSERT INTO "+tab+"_device"+"(`IP`,`MAC`,`MANUFACTURER`,`LAB`,`MODEL`,`NA`,`FS`) VALUES(" + "\"" + name + "\"" + "," + "\"" + MAC + "\"" + "," + "\"" + MANUFACTURER + "\"" + "," + "\"" + TOPO + "\""+ "," + "\""  + AB.pop() + "\"" + "," + "\""  + "N" + "\""+ "," + "\""  + "N" + "\""+ ");";
                    else
                        cmd = "INSERT INTO "+tab+"_device"+"(`IP`,`MAC`,`MANUFACTURER`,`TOPO`,`NA`,`FS`) VALUES(" + "\"" + name + "\"" + "," + "\"" + MAC + "\"" + "," + "\"" + MANUFACTURER + "\"" + "," + "\"" + TOPO + "\"" + "," + "\""  + "N" + "\""+ "," + "\""  + "N" + "\""+ ");";
                    size -= 1;
                    try {
                        m.exec(cmd);
                    }catch (Exception ignored1){
                        try {
                            cmd = "update "+tab+"_device"+" set OTHERIP = concat('"+name+","+"',OTHERIP) where MAC='"+MAC+"'";
                            m.exec(cmd);
                        }catch (Exception ignored2){
                            System.out.println(name);
                        }

                    }

                    fileOutputStream2.write("\n".getBytes());
                }

                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else{
            try {
                m.close();
//                Cell.stop = false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        //--------------------------------------------------------------------

        synchronized(lock) {
            edgesNew = new LinkedList<>(edges.keySet());
            nodesNew = new LinkedList<>(nodes.keySet());
        }
        nodesRemoved = new LinkedList<>(nodesObservable);
        nodesRemoved.removeAll(nodesNew);
        edgesRemoved = new LinkedList<>(edgesObservable);
        edgesRemoved.removeAll(edgesNew);
        edgesNew.removeAll(edgesObservable);
        nodesNew.removeAll(nodesObservable);


        //As they are just being added to the graph, the nodes are dirty.
        nodesNew.stream().forEach(node -> {
            node.dirtyProperty().set(true);

            node.dirtyProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    NetworkGraph.this.OnNodeDirtied.call(new UpdateGraphArgs(NetworkGraph.this));
                }
            });
        });

        edgesObservable.removeAll(edgesRemoved);
        nodesObservable.removeAll(nodesRemoved);
        nodesObservable.addAll(nodesNew);
        edgesObservable.addAll(edgesNew);
    }

    public final void refresh() {
        this.taskRefreshUi.trigger();
    }

    private void commitUi() {
        if(!Platform.isFxApplicationThread()) {
            //Executing as a lambda should allow overrides of Process_commitUI defined in derived classes to be executed.  Using a method pointer removes this feature.
            Platform.runLater(() -> this.Process_commitUI());
            return;
        }
        Process_commitUI();
    }

    /**
     * Clears the lists of nodes and edges.
     * Use cases should prevent this from having a race condition with the add functions, but the possibility exists;
     * proper locking to prevent those conditions would constitute a burden on the more common use case of processing an
     * import.
     *
     * The race condition, as it exists, allows the events to fire incorrectly, however the internal state should always
     * be consistent.
     */
    public void clearTopology() {
        synchronized(lock) {
            edges.clear();
            nodes.clear();
        }

        OnGraphCleared.call(new UpdateGraphArgs(this));
        edgesObservable.clear();
        nodesObservable.clear();
    }

    protected String getEntryName() {
        return UUID.randomUUID().toString() + "_ngraph.xml";
    }

    protected void toXmlStart(ZipOutputStream zos) throws IOException {
        ZipEntry graphEntry = new ZipEntry(getEntryName());
        zos.putNextEntry(graphEntry);
        zos.write("<graph>".getBytes(StandardCharsets.UTF_8));
        zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
    }

    protected void toXmlEnd(ZipOutputStream zos) throws IOException {
        zos.write("</graph>".getBytes(StandardCharsets.UTF_8));
        zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        zos.closeEntry();
    }

    protected void toXmlContents(ImportList imports, ZipOutputStream zos) throws IOException {
        List<TNode> nodes = new ArrayList<>();
        List<TEdge> edges = new ArrayList<>();
        GetGraphContents(nodes, edges);

        zos.write("<nodes>".getBytes(StandardCharsets.UTF_8));
        zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        for(TNode node : nodes) {
            zos.write(node.toXml().toString().getBytes(StandardCharsets.UTF_8));
            zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        }
        zos.write("</nodes>".getBytes(StandardCharsets.UTF_8));
        zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        zos.write("<edges>".getBytes(StandardCharsets.UTF_8));
        for(TEdge edge : edges) {
            edge.toXml(nodes, imports, zos);
        }
        zos.write("</edges>".getBytes(StandardCharsets.UTF_8));
        zos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
    }

    public void toXml(ImportList imports, ZipOutputStream zos) throws IOException {
        toXmlStart(zos);
        toXmlContents(imports, zos);
        toXmlEnd(zos);
    }
}
