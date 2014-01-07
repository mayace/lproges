package com.github.lproges.compiler;

import java.util.HashMap;

public abstract class SimTable<K,V> {

    private final HashMap<K, V> table = new HashMap<>();
    
    public static enum ROL{
        CLASS,VARIABLE,ARRAY,FUNCTION,METHOD,PARAMETER
    }
    public static enum TIPO{
        INT,FLOAT,STRING,CHAR,BOOLEAN,VOID
    }

    public abstract K getKey(Object... args);

    public void add(K key, V sim) {
        getTable().put(key, sim);
    }

    public V get(K key) {
        return getTable().get(key);
    }

    public boolean contains(K key) {
        return getTable().containsKey(key);
    }

    public HashMap<K, V> getTable() {
        return table;
    }

}
