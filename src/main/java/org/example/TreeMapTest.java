package org.example;

import org.example.MyHashMap.MyTreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        System.out.println("Testing MyTreeMap functionality...");
        
        MyTreeMap<String, String> treeMap = new MyTreeMap<>();
        
        // Test putting elements in random order
        treeMap.put("dog", "canine");
        treeMap.put("apple", "fruit");
        treeMap.put("zebra", "animal");
        treeMap.put("banana", "fruit");
        treeMap.put("cat", "feline");
        
        System.out.println("Size: " + treeMap.size());
        
        // Test getting elements
        System.out.println("Get 'apple': " + treeMap.get("apple"));
        System.out.println("Get 'cat': " + treeMap.get("cat"));
        System.out.println("Get 'nonexistent': " + treeMap.get("nonexistent"));
        
        // Test containsKey
        System.out.println("Contains 'dog': " + treeMap.containsKey("dog"));
        System.out.println("Contains 'elephant': " + treeMap.containsKey("elephant"));
        
        // Test keys in sorted order
        System.out.println("Keys (sorted): " + treeMap.keys());
        
        // Test values in corresponding sorted order
        System.out.println("Values (in key order): " + treeMap.values());
        
        // Test updating existing key
        treeMap.put("apple", "red fruit");
        System.out.println("Updated apple: " + treeMap.get("apple"));
        System.out.println("Size after update: " + treeMap.size());
        
        System.out.println("TreeMap test completed successfully!");
    }
}