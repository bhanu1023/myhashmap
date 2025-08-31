package org.example;

import org.example.MyHashMap.MyHashMap;
import org.example.MyHashMap.MyTreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MyHashMap Demo ===");
        MyHashMap<String, String> map = new MyHashMap<>();
        for(int i=0;i<205;i++) map.put("name" + i, "Banu" + i);
        map.put("nametes", "Banutest");
        System.out.println(map.get("name1"));
        System.out.println("HashMap size: " + map.size());
        
        System.out.println("\n=== MyTreeMap Demo ===");
        MyTreeMap<String, String> treeMap = new MyTreeMap<>();
        
        // Add some sample data to demonstrate sorted order
        treeMap.put("dog", "canine");
        treeMap.put("apple", "fruit");
        treeMap.put("zebra", "animal");
        treeMap.put("banana", "fruit");
        treeMap.put("cat", "feline");
        
        System.out.println("TreeMap size: " + treeMap.size());
        System.out.println("Get 'apple': " + treeMap.get("apple"));
        System.out.println("Contains 'dog': " + treeMap.containsKey("dog"));
        
        // Demonstrate sorted keys and values
        System.out.println("Keys (sorted): " + treeMap.keys());
        System.out.println("Values (in key order): " + treeMap.values());
    }
}