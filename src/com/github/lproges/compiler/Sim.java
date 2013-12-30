package com.github.lproges.compiler;

public class Sim {

    private final String scope;
    private final String name;
    private final String type;
    private final int pos;

    public Sim(String scope, String name, String type, int pos) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.pos = pos;
    }

    public String getScope() {
        return scope;
    }

    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPos() {
        return pos;
    }

}
