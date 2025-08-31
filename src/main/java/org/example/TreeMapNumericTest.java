package org.example;

import org.example.MyHashMap.MyTreeMap;

public class TreeMapNumericTest {
    public static void main(String[] args) {
        System.out.println("Testing MyTreeMap with Integer keys...");
        
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();
        
        // Add integers in random order
        treeMap.put(50, "fifty");
        treeMap.put(30, "thirty");
        treeMap.put(70, "seventy");
        treeMap.put(20, "twenty");
        treeMap.put(40, "forty");
        treeMap.put(60, "sixty");
        treeMap.put(80, "eighty");
        
        System.out.println("Size: " + treeMap.size());
        
        // Test keys should be in sorted order
        System.out.println("Keys (sorted): " + treeMap.keys());
        System.out.println("Values (in key order): " + treeMap.values());
        
        // Test edge cases
        MyTreeMap<String, Integer> emptyMap = new MyTreeMap<>();
        System.out.println("Empty map keys: " + emptyMap.keys());
        System.out.println("Empty map values: " + emptyMap.values());
        System.out.println("Empty map size: " + emptyMap.size());
        
        System.out.println("Numeric TreeMap test completed successfully!");
    }
}