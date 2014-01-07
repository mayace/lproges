package com.github.lproges.compiler;

import java.util.ArrayList;
import java.util.Arrays;

public class Sim {

    private final String scope;
    private final String name;
    private final Object type;
    private final Object rol;
    private final int pos;
    private final int size;
    private final int[] dimensions; // arreglos
    private final Object[] param_list; // metodos

    /**
     * Definicion para variables
     *
     * @param scope
     * @param name
     * @param type
     * @param rol
     * @param pos
     * @param size
     */
    public Sim(String scope, String name, Object type, Object rol, int pos, int size) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.rol = rol;
        this.pos = pos;
        this.size = size;
        this.dimensions = new int[]{};
        this.param_list = new Object[]{};
    }

    /**
     * Definicion para variables tipo arreglo
     *
     * @param scope
     * @param name
     * @param type
     * @param rol
     * @param pos
     * @param size
     * @param dimensions
     */
    public Sim(String scope, String name, Object type, Object rol, int pos, int size, int... dimensions) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.rol = rol;
        this.pos = pos;
        this.size = size;
        this.dimensions = dimensions;
        this.param_list = new Object[]{};
    }

    /**
     * Definicion para metodo
     *
     * @param scope
     * @param name
     * @param type
     * @param rol
     * @param size
     * @param param_list
     */
    public Sim(String scope, String name, Object type, Object rol, int size, Object[] param_list) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.rol = rol;
        this.pos = -1;
        this.size = size;
        this.dimensions = new int[]{};
        this.param_list = param_list;
    }

    public int getSize() {
        return size;
    }

    public String getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    public Object getType() {
        return type;
    }

    public int getPos() {
        return pos;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public Object getRol() {
        return rol;
    }

    public Object[] getParam_list() {
        return param_list;
    }

    public String getFullName() {
        String ret = getScope() + "." + getName();
        return ret;
    }

    public static Object[] getArrayHeader() {
        return new Object[]{"Scope", "Nombre", "Tipo", "Rol", "Posicion", "Tamanio", "Dimensiones", "Parametros"};
    }

    public Object[] toArray() {
        return new Object[]{getScope(), getName(), getType(), getRol(), getPos(), getSize(), Arrays.toString(getDimensions()), Arrays.toString(getParam_list())};
    }

}
