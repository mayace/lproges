package com.github.lproges.compiler;

public class Sim {

    private final String name;
    private final String type;
    private final int pos;

    public Sim(String name, String type, int pos) {
        this.name = name;
        this.type = type;
        this.pos = pos;
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
