package org.example.MyHashMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyHashMap<Key, Value> implements MyMap <Key, Value>{
    private static final int INITIAL_CAPACITY = 16;
    private static final double THRESHOLD = 0.75f;
    private static final int GROWTH_FACTOR = 2;

    private class HashMapNode{
        public Key key;
        public Value value;
        public HashMapNode next;

        public HashMapNode(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMapNode [] buckets;
    private int size;

    public MyHashMap(){
        buckets = (HashMapNode[]) Array.newInstance(HashMapNode.class, INITIAL_CAPACITY);
    }

    private int getHashCode(Key key){
        return Math.abs(key.hashCode());
    }
    private int getIndex(Key key){
        int hash = getHashCode(key);
        return ((hash) % buckets.length);
    }

    private HashMapNode getNode(Key key){
        int index = getIndex(key);
        HashMapNode head = buckets[index];

        while(head != null){
            if(head.key.equals(key)) return head;
            head = head.next;
        }

        return null;
    }


    private void rehash(){
        int newCapacity = buckets.length * GROWTH_FACTOR;
        List<Key> keylist = new ArrayList<>();
        List<Value> valuelist = new ArrayList<>();

        for(Key key: keys()){
            Value value = get(key);
            keylist.add(key);
            valuelist.add(value);
        }

        buckets = (HashMapNode[]) Array.newInstance(HashMapNode.class, newCapacity);
        size = 0;
        for(int i=0; i<keylist.size(); i++){
            put(keylist.get(i), valuelist.get(i));
        }
    }

    private void insert(Key key, Value value){
        int index = getIndex(key);
        HashMapNode head = buckets[index];
        HashMapNode new_node = new HashMapNode(key, value);

        //insert
        new_node.next = head;
        buckets[index] = new_node;
        size++;

        if((float) size / buckets.length > THRESHOLD){
            rehash();
        }
    }

    @Override
    public void put(Key key, Value value) {
        HashMapNode node = getNode(key);

        if(node == null) insert(key, value);
        else node.value = value;

    }

    @Override
    public Value get(Key key) {
        HashMapNode node = getNode(key);
        if(node != null) return node.value;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Key key) {
        return getNode(key) != null;
    }

    @Override
    public List<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        for(HashMapNode head: buckets){
            HashMapNode tmp = head;
            while (tmp != null){
                keyList.add(tmp.key);
                tmp=tmp.next;
            }
        }

        return keyList.size() > 0 ? keyList : null;
    }

    @Override
    public List<Value> values() {
        List<Value> keyList = new ArrayList<>();
        for(HashMapNode head: buckets){
            HashMapNode tmp = head;
            while (tmp != null){
                keyList.add(tmp.value);
                tmp = tmp.next;
            }
        }

        return keyList.size() > 0 ? keyList : null;
    }
}
