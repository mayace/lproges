package com.github.lproges.compiler;

import java.util.HashMap;

public abstract class SimTable<T> extends HashMap<Object, T> {

    public abstract Object getKey(Object... args);

    public abstract T add(Object... args);

    public abstract T get(Object... args);
    
}
