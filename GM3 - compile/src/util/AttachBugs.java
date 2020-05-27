package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AttachBugs {
    private File f1;
    private ArrayList<String> l = new ArrayList<>(1000);
    private int len;
    public AttachBugs(){
//        this.f1 = new File("F:/JavaProjects_IDEA/GM3 - 1/data/device.txt");
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(this.f1));
//            String s = null;
//            while((s = br.readLine())!=null){
//                assert false;
//                this.l.add(s);
//            }
//            br.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        this.l.add("NULL");
        this.l.add("NULL");
    }
    public String pop(){
        len = l.size();
        Random r = new Random(System.currentTimeMillis());
        int ran1 = r.nextInt(len);
        return l.get(ran1);
    }

}

