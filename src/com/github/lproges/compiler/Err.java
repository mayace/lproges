package com.github.lproges.compiler;

import java.text.MessageFormat;
import java_cup.runtime.Symbol;

public class Err {

    private String msg;
    private Symbol sym;
    private TIPO TIPO;

    public static final String FORMAT = "[Error] in line {0} column {1} on value '{2}'. Message: {3}";

    public Err(String msg, Object sym, TIPO type) {
        this.msg = msg;
        this.TIPO = type;

        if (sym instanceof Symbol) {
            this.sym = (Symbol) sym;
        }
    }

    public enum TIPO {

        LEXICO, SINTACTICO, SEMANTICO
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public TIPO getType() {
        return TIPO;
    }

    public void setType(TIPO type) {
        this.TIPO = type;
    }

    public Symbol getSym() {
        return sym;
    }

    public void setSym(Symbol sym) {
        this.sym = sym;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="otros">
    @Override
    public String toString() {
        Symbol s = getSym();
        int line = -1;
        int column = -1;
        String value = "null";

        if (s != null) {
            line = s.left + 1;
            column = s.right + 1;
            value = s.value.toString();
        }

        return MessageFormat.format(FORMAT, line, column, value, getMsg());

    }

    public void println() {

        String t = "Unknow";
        if (getType() != null) {
            t = getType().name();
        }

        System.err.println(t + " Error:");
        System.err.println(toString());
    }

    public static Object[] getArrayHeader() {
        return new String[]{"TIPO", "LINEA", "COLUMNA", "TOKEN", "MENSAJE"};
    }

    public Object[] toArray() {
        final Symbol sym1 = (getSym() == null ? new Symbol(-1) : getSym());

        return new Object[]{getType(), sym1.left, sym1.right, sym1.value, getMsg()};
    }
    //</editor-fold>
}
