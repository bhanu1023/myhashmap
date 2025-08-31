package org.example;

import org.example.MyHashMap.MyHashMap;
import org.example.MyHashMap.MyTreeMap;

public class ComparisonDemo {
    public static void main(String[] args) {
        System.out.println("=== Comparison: MyHashMap vs MyTreeMap ===\n");
        
        // Test data in random order
        String[] keys = {"dog", "apple", "zebra", "banana", "cat", "elephant", "fish"};
        String[] values = {"canine", "fruit", "animal", "fruit", "feline", "mammal", "aquatic"};
        
        // HashMap demonstration
        System.out.println("--- MyHashMap (unordered) ---");
        MyHashMap<String, String> hashMap = new MyHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
        }
        System.out.println("Size: " + hashMap.size());
        System.out.println("Keys (hash order): " + hashMap.keys());
        System.out.println("Values (hash order): " + hashMap.values());
        
        // TreeMap demonstration
        System.out.println("\n--- MyTreeMap (sorted) ---");
        MyTreeMap<String, String> treeMap = new MyTreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            treeMap.put(keys[i], values[i]);
        }
        System.out.println("Size: " + treeMap.size());
        System.out.println("Keys (sorted): " + treeMap.keys());
        System.out.println("Values (in key order): " + treeMap.values());
        
        // Performance characteristics demonstration
        System.out.println("\n--- Performance & Features Comparison ---");
        System.out.println("HashMap:");
        System.out.println("  - O(1) average get/put operations");
        System.out.println("  - Keys returned in hash bucket order");
        System.out.println("  - Memory efficient for large datasets");
        
        System.out.println("\nTreeMap:");
        System.out.println("  - O(log n) get/put operations");
        System.out.println("  - Keys always returned in sorted order");
        System.out.println("  - Maintains sorted structure automatically");
        System.out.println("  - Useful for range queries and sorted iteration");
        
        System.out.println("\nBoth implement the same MyMap interface for consistency!");
    }
}