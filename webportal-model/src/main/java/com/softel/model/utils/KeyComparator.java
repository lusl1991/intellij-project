package com.softel.model.utils;


import java.util.*;

public class KeyComparator {

    public static List<Map.Entry<Integer,String>> sort(Map<Integer, String> map){
        List<Map.Entry<Integer,String>> mappingList = new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
        //通过比较器实现比较排序
        Collections.sort(mappingList, new Comparator<Map.Entry<Integer,String>>(){
            public int compare(Map.Entry<Integer,String> mapping1,Map.Entry<Integer,String> mapping2){
                return mapping1.getKey().compareTo(mapping2.getKey());
            }
        });
        return mappingList;
    }

    public static void main(String[] args){
        Map<Integer,String> map = new TreeMap<Integer,String>();
        map.put(5, "month");
        map.put(2, "bread");
        map.put(8, "attack");

        List<Map.Entry<Integer,String>> mappingList = sort(map);

        for(Map.Entry<Integer,String> mapping:mappingList){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
