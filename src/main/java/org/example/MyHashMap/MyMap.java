package org.example.MyHashMap;

import java.util.List;

public interface MyMap<Key , Value> {
    public void put(Key key, Value value);

    public Value get(Key key);

    public int size();

    public boolean containsKey(Key key);

    public List<Key> keys();

    public List<Value> values();
}
