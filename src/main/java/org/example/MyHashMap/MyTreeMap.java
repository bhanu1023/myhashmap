package org.example.MyHashMap;

import java.util.ArrayList;
import java.util.List;

public class MyTreeMap<Key extends Comparable<Key>, Value> implements MyMap<Key, Value> {
    
    private class TreeNode {
        public Key key;
        public Value value;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private TreeNode root;
    private int size;
    
    public MyTreeMap() {
        this.root = null;
        this.size = 0;
    }
    
    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        root = putRecursive(root, key, value);
    }
    
    private TreeNode putRecursive(TreeNode node, Key key, Value value) {
        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = putRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = putRecursive(node.right, key, value);
        } else {
            // Key already exists, update value
            node.value = value;
        }
        
        return node;
    }
    
    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        TreeNode node = getRecursive(root, key);
        return node != null ? node.value : null;
    }
    
    private TreeNode getRecursive(TreeNode node, Key key) {
        if (node == null) {
            return null;
        }
        
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getRecursive(node.left, key);
        } else if (cmp > 0) {
            return getRecursive(node.right, key);
        } else {
            return node;
        }
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean containsKey(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return getRecursive(root, key) != null;
    }
    
    @Override
    public List<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        inOrderKeys(root, keyList);
        return keyList.size() > 0 ? keyList : null;
    }
    
    private void inOrderKeys(TreeNode node, List<Key> keyList) {
        if (node != null) {
            inOrderKeys(node.left, keyList);
            keyList.add(node.key);
            inOrderKeys(node.right, keyList);
        }
    }
    
    @Override
    public List<Value> values() {
        List<Value> valueList = new ArrayList<>();
        inOrderValues(root, valueList);
        return valueList.size() > 0 ? valueList : null;
    }
    
    private void inOrderValues(TreeNode node, List<Value> valueList) {
        if (node != null) {
            inOrderValues(node.left, valueList);
            valueList.add(node.value);
            inOrderValues(node.right, valueList);
        }
    }
}