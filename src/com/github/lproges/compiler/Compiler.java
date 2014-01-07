package com.github.lproges.compiler;

import java.text.MessageFormat;
import java.util.Stack;

public class Compiler {

    private final int stack[];
    private final int heap[];
    private int p = 0;
    private int h = 0;

    private final SimTable<String, Sim> simtable = new SimTable<String, Sim>() {

        @Override
        public String getKey(Object... args) {
            String scope = (String) args[0];
            String name = (String) args[1];
            String variant = (String) args[2];

            if (variant == null || variant.isEmpty()) {
                return MessageFormat.format("{0}.{1}", scope, name);
            } else {
                return MessageFormat.format("{0}.{1},{2}", scope, name, variant);
            }

        }
    };
    private final ErrTable<Err> errortable = new ErrTable<>();

    private int temp = 0;
    private int tag = 0;

    public Compiler(int[] stack, int[] heap) {
        this.stack = stack;
        this.heap = heap;
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setP(int p) {
        this.p = p;
    }

    public SimTable<String, Sim> getSimtable() {
        return simtable;
    }

    public ErrTable<Err> getErrortable() {
        return errortable;
    }

    public int[] getStack() {
        return stack;
    }

    public int[] getHeap() {
        return heap;
    }

    public int getP() {
        return p;
    }

    public int getH() {
        return h;
    }

    public int getTemp() {
        return temp;
    }

    public int getTag() {
        return tag;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="stmts">
    public class Def implements IStmt {

        String scope;
        String id;
        SimTable.TIPO type;
        Object info;
        Object[] modifier;
        Def[] parameter;
        int[] dimension;

        SimTable.ROL rol;

        public Def(String id, SimTable.TIPO type, Object info, Object[] modifier) {
            this.id = id;
            this.type = type;
            this.info = info;
            this.modifier = modifier;
            this.parameter = null;
            this.dimension = null;
            this.rol = SimTable.ROL.VARIABLE;
        }

        public Def(String id, SimTable.TIPO type, Object info, Object[] modifier, int[] dimension) {
            this.id = id;
            this.type = type;
            this.info = info;
            this.modifier = modifier;
            this.parameter = null;
            this.dimension = dimension;
            this.rol = SimTable.ROL.ARRAY;
        }

        public Def(String id, SimTable.TIPO type, Object info, Object[] modifier, Def[] parameter) {
            this.id = id;
            this.type = type;
            this.info = info;
            this.modifier = modifier;
            this.parameter = parameter;
            this.dimension = null;
            this.rol = (type == SimTable.TIPO.VOID ? SimTable.ROL.METHOD : SimTable.ROL.FUNCTION);
        }

        @Override
        public void exec() {
            final SimTable<String, Sim> tsim = getSimtable();
            final String key = tsim.getKey(scope, id, parameter);

            if (tsim.contains(key)) {
                final String msg = MessageFormat.format("Ya existe el simbolo: ({0}){1}.", rol, id);
                getErrortable().add(new Err(msg, info, Err.TIPO.SEMANTICO));
            } else {
                final int pos = getP();
                int size = 0;
                switch (rol) {
                    case CLASS:
                        break;
                    case VARIABLE:
                        size = 1;
                        tsim.add(key, new Sim(scope, id, type, rol, pos, size));
                        break;
                    case ARRAY:
                        size = 1;
                        tsim.add(key, new Sim(scope, id, type, rol, pos, size, dimension));
                        break;
                    case FUNCTION:
                        size = 0;

                        tsim.add(key, new Sim(scope, id, type, rol, size, parameter));
                        break;
                    case METHOD:
                        size = 0;
                        tsim.add(key, new Sim(scope, id, type, rol, size, parameter));
                        break;
                    case PARAMETER:
                        break;
                    default:
                        throw new AssertionError(rol.name());

                }
                setP(pos + size);
            }
        }

    }

    public interface IStmt {

        public void exec();
    }
    //</editor-fold>

}
