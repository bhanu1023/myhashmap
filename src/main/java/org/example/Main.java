package org.example;

import org.example.MyHashMap.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        for(int i=0;i<205;i++) map.put("name" + i, "Banu" + i);
        map.put("nametes", "Banutest");
        System.out.println(map.get("name1"));
        System.out.println("==========================");
        System.out.println(map.keys());
        System.out.println(map.values());
        System.out.println(map.size());
    }
}