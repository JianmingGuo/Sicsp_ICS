package core.document.graph;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "nodes")
public class ENodeWrapper {
    public ArrayList<ENode> Enodes;


    @XmlElement(name = "node")
    public List<ENode> getEnodes() {
        return Enodes;
    }

    public void setEnodes(LinkedHashMap<LogicalNode, LogicalNode> nodes) {
        this.Enodes = new ArrayList<ENode>();
        ENode n = new ENode();
        for (LogicalNode i : nodes.keySet()) {
            n.setEnode(i);
            Enodes.add(new ENode(n));
        }

    }

    public ENode get1stEnode(){
        return Enodes.get(0);
    }
}