package com.softel.model.utils;


import java.util.*;

public class KeyComparator {

    public static void main(String[] args){
        List<Map.Entry<Integer,String>> mappingList = null;
        Map<Integer,String> map = new TreeMap<Integer,String>();
        map.put(5, "month");
        map.put(2, "bread");
        map.put(8, "attack");

        //通过ArrayList构造函数把map.entrySet()转换成list
        mappingList = new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
        //通过比较器实现比较排序
        Collections.sort(mappingList, new Comparator<Map.Entry<Integer,String>>(){
            public int compare(Map.Entry<Integer,String> mapping1,Map.Entry<Integer,String> mapping2){
                return mapping1.getKey().compareTo(mapping2.getKey());
            }
        });

        for(Map.Entry<Integer,String> mapping:mappingList){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
