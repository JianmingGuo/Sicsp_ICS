package util;

import java.util.*;

public class ReverHash {
    public static void Revhash(HashMap p) {
        boolean flag = false;
        for (Object value : p.values()) {
            if (value instanceof HashMap) {
                Revhash((HashMap) value);
                flag = true;
            }
        }
        if (flag == true) {
            Iterator i = p.entrySet().iterator();
            while (i.hasNext()) {
                Object next = i.next();
                if (next instanceof HashMap.Entry) {
                    HashMap a = (HashMap) ((Map.Entry) next).getValue();
                    ((Map.Entry) next).setValue(new LinkedHashMap(a));
                }
            }
        } else {
        }


    }
}
//        LinkedHashMap result = new LinkedHashMap();
//        LinkedHashMap tmpmap = new LinkedHashMap();
//        Iterator i = p.entrySet().iterator();
//        while (i.hasNext()) {
//            Object next = i.next();
//            if (next instanceof HashMap.Entry) {
//                if (((Map.Entry) next).getValue() instanceof HashMap){
//                    HashMap a1 = new HashMap((HashMap)((Map.Entry) next).getValue());
//                    Iterator j = a1.entrySet().iterator();
//                    while (j.hasNext()) {
//                        Object n1 = j.next();
//                        if (n1 instanceof HashMap.Entry) {
//                            if (((Map.Entry) n1).getValue() instanceof HashMap){
//                                HashMap a2 = new HashMap((HashMap)((Map.Entry) next).getValue());
//                                Iterator l = a1.entrySet().iterator();
//                                while (l.hasNext()) {
//                                    Object n2 = l.next();
//                                    if (n2 instanceof HashMap.Entry) {
//                                        if (((Map.Entry) n2).getValue() instanceof HashMap){
//                                            HashMap a3 = new HashMap((HashMap)((Map.Entry) n2).getValue());
//                System.out.println((((Map.Entry) next).getKey()).getClass());

//            else {
////                if (next instanceof HashSet) {
////                    LinkedHashSet tmpset = new LinkedHashSet();
////                    tmpset.addAll((HashSet)next);
////                }

