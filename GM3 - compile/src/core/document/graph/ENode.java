package core.document.graph;

import util.Cidr;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static util.ReverHash.Revhash;

@XmlRootElement
public class ENode {
    public Cidr cidr;
    public Cidr network;
    public String Mac;
    private LinkedHashMap fingerprint;


    public ENode(ENode i){
        this.cidr = i.cidr;
        this.network = i.network;
        this.Mac = i.Mac;
        this.fingerprint = i.fingerprint;
    }
    public ENode(){
        super();
    }


    @XmlJavaTypeAdapter(MapAdapter.class)
    public HashMap getFingerprint() {
        return fingerprint;
    }

    public void setEnode(LogicalNode node){
        this.cidr = node.getIp();
        this.network = node.network.get();
        this.fingerprint = new LinkedHashMap();
        for(ComputedProperty i : node.annotations.get("MAC")){
            this.Mac = i.getValue();
            break;
        }
        HashMap tmp = node.fingerprintPayloadResults;
//        tmp =  node.fingerprintPayloadResults;
//        this.fingerprint = new HashMap();
//        LinkedHashMap n = new LinkedHashMap();
        Revhash(tmp);
        try {
            this.fingerprint.putAll(tmp);
        }catch (Exception e){

            LinkedHashMap a = new LinkedHashMap();
        }

    }


}
