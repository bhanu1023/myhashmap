# MyHashMap Project

This project provides custom implementations of Map data structures in Java.

## Features

### MyHashMap
A hash table implementation with the following characteristics:
- **O(1)** average time complexity for get/put operations
- Uses separate chaining for collision resolution
- Dynamic resizing when load factor exceeds 0.75
- Keys returned in hash bucket order (not sorted)

### MyTreeMap (New!)
A binary search tree implementation with the following characteristics:
- **O(log n)** time complexity for get/put operations
- Maintains keys in sorted order automatically
- In-order traversal provides sorted key/value iteration
- Requires keys to implement `Comparable<Key>`

## Common Interface

Both implementations follow the same `MyMap<Key, Value>` interface:

```java
public interface MyMap<Key, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    int size();
    boolean containsKey(Key key);
    List<Key> keys();
    List<Value> values();
}
```

## Usage Examples

### MyHashMap Usage
```java
MyHashMap<String, String> hashMap = new MyHashMap<>();
hashMap.put("apple", "fruit");
hashMap.put("dog", "animal");
System.out.println(hashMap.get("apple")); // "fruit"
System.out.println(hashMap.keys()); // [dog, apple] (hash order)
```

### MyTreeMap Usage
```java
MyTreeMap<String, String> treeMap = new MyTreeMap<>();
treeMap.put("apple", "fruit");
treeMap.put("dog", "animal");
System.out.println(treeMap.get("apple")); // "fruit"
System.out.println(treeMap.keys()); // [apple, dog] (sorted order)
```

## Running the Examples

### Basic Demos
```bash
# Run basic demo showing both HashMap and TreeMap
mvn exec:java -Dexec.mainClass="org.example.Main"

# Run TreeMap-specific test
mvn exec:java -Dexec.mainClass="org.example.TreeMapTest"

# Run comparison demo
mvn exec:java -Dexec.mainClass="org.example.ComparisonDemo"
```

### Build the Project
```bash
mvn clean compile
```

## Key Differences

| Feature | MyHashMap | MyTreeMap |
|---------|-----------|-----------|
| Time Complexity | O(1) average | O(log n) |
| Key Ordering | Hash order | Sorted order |
| Key Requirements | hashCode() & equals() | Comparable |
| Memory Usage | Lower | Higher (tree structure) |
| Best Use Case | Fast lookups | Sorted iteration |

## Implementation Details

### MyTreeMap
- Uses a binary search tree (BST) structure
- TreeNode contains key, value, left, and right references
- In-order traversal ensures sorted key/value retrieval
- Handles duplicate keys by updating the value
- Supports null checking for defensive programming

### MyHashMap
- Uses an array of linked lists (separate chaining)
- Dynamic resizing when load factor > 0.75
- Growth factor of 2x when resizing
- HashMapNode contains key, value, and next references