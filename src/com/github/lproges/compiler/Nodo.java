package com.github.lproges.compiler;

import java.util.HashMap;
import java.util.LinkedList;

public class Nodo {

    private Object opertation = null;
    private Nodo left = null;
    private Nodo right = null;
    private Object val = null;
    private Object ref = null;

    private boolean leaf = false;
    private boolean id = false;

    //<editor-fold defaultstate="collapsed" desc="constructur">
    /**
     * string Crea como nodo
     *
     * @param operation
     * @param left
     * @param right
     */
    public Nodo(String operation, Nodo left, Nodo right) {
        this.opertation = operation;
        this.left = left;
        this.right = right;
    }

    /**
     * Crea como hoja
     *
     * @param ref
     * @param id
     */
    public Nodo(Object ref, boolean id) {
        this.leaf = true;
        this.ref = ref;
        this.id = id;
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="exec">
    /**
     *
     * @param compiler Objetos stack,heap,symbol table and errors
     * @param operations Conjuntos de operaciones ejecutables para nodo
     */
    public void exec(CompilerStuff compiler, Object operations) {
        // procesar nodos hijos
        exec_nodo(getLeft(), compiler, operations);
        exec_nodo(getRight(), compiler, operations);

        // procesar nodo
        Object nodo_oper = getOpertation();
        if (operations instanceof HashMap) {
            HashMap map = (HashMap) operations;
            Object get = map.get(nodo_oper);
            if (get instanceof Operation) {
                Operation oper = (Operation) get;
                oper.exec(this,compiler, operations);
            }
        }
    }

    /**
     * Procesar un nodo especifico
     *
     * @param nodo
     * @param compiler
     * @param operations
     */
    private void exec_nodo(Nodo nodo, CompilerStuff compiler, Object operations) {
        if (nodo != null) {
            if (nodo.isLeaf()) {
                nodo.exec_leaf(compiler);
            } else {
                nodo.exec(compiler, operations);
            }
        }
    }

    /**
     * Procesa un nodo hoja
     *
     * @param compiler
     */
    private void exec_leaf(CompilerStuff compiler) {

        HashMap<Object, Sim> table = compiler.getSimtable();
        LinkedList<Err> errors = compiler.getErrors();

        Attr a = (Attr) getRef(); // atributo que trae
        Attr b = new Attr(); // atributo a enviar

        // informacion de lo recibido
        Object a_info = a.get("info");
        String a_val = a.getString("val");
        String a_tipo = a.getString("tipo");
        String a_tres = "// Obtencion de valor";

        // procesar la informacion
        if (isId()) {
            // obtenecion de la llave correspondiente..
            Object a_key = a_val;
            if (table.containsKey(a_key)) {
                // informacion del simbolo
                Sim a_sim = table.get(a_key);
                a_tipo = a_sim.getType();
                int a_pos = a_sim.getPos();

                // tres direcciones
                final String temp1 = compiler.getTemp();
                final String temp2 = compiler.getTemp();
                a_tres += String.format("%s = p + %s;\n", temp1, a_pos);
                // obtener el valor segun el tipo
                switch (a_tipo) {
                    case "boolean":
                        // valor en la pila
                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
                        break;
                    case "int":
                        // valor en la pila
                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
                        break;
                    case "float":
                        // referencia en el heap
                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
                        break;
                    case "char":
                        // char as int
                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
                        break;
                    case "string":
                        // referencia en el heap
                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
                        break;
                    default:
                        errors.add(new Err("Tipo no soportado: " + a_tipo, a_info, Err.TIPO.SEMANTICO));
                }

            } else {
                errors.add(new Err("Variable no declarada: " + a_val, a_info, Err.TIPO.SEMANTICO));
            }
        } else {
            // si es una constante
            if (a_val instanceof String) {
                String a_str = (String) a_val;
                a_tres = compiler.getTemp() + "=" + a_val + ";";
            }
        }
        // enviar el resultado...
        b.set("tipo", a_tipo);
        b.set("val", a_val);
        b.set("tres", a_tres);
        b.set("info", a_info);

        setVal(b);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public void setOpertation(String opertation) {
        this.opertation = opertation;
    }

    public Object getOpertation() {
        return opertation;
    }

    public Object getRef() {
        return ref;
    }

    public void setRef(Object ref) {
        this.ref = ref;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="classes">
    public static abstract class Operation {

        Object id;

        public Operation(Object id) {
            this.id = id;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public abstract void exec(Nodo nodo,CompilerStuff compiler, Object operations);

    }

    public static class CompilerStuff {

        private int temp = 0;
        private int tag = 0;
        private int p = 0;
        private int h = 0;
        private final int stack[];
        private final int heap[];
        private final HashMap<Object, Sim> simtable;
        private final LinkedList<Err> errors;

        public CompilerStuff(int[] stack, int[] heap, HashMap<Object, Sim> simtable, LinkedList<Err> errors) {
            this.stack = stack;
            this.heap = heap;
            this.simtable = simtable;
            this.errors = errors;
        }

        public int[] getStack() {
            return stack;
        }

        public int[] getHeap() {
            return heap;
        }

        public HashMap<Object, Sim> getSimtable() {
            return simtable;
        }

        public LinkedList<Err> getErrors() {
            return errors;
        }

        public int getH() {
            return h;
        }

        public int getP() {
            return p;
        }

        public void setH(int h) {
            this.h = h;
        }

        public void setP(int p) {
            this.p = p;
        }

        public String getTag() {
            String ret = "l" + tag;
            tag++;
            return ret;
        }

        public String getTemp() {
            String ret = "t" + temp;
            temp++;
            return ret;
        }

    }

    public class Tres {

        LinkedList<String> lines = new LinkedList<>();

        public void add_getRef(String temp, int pos, String s1) {

        }

        public void add(String temp, String oper, String s1, String s2) {
            lines.add(String.format("%s = %s %s %s;", temp, oper, s1, s2));
        }

        @Override
        public String toString() {
            String ret = "";
            for (String line : lines) {
                ret += line + "\n";
            }
            return ret;
        }

        public LinkedList<String> getLines() {
            return lines;
        }

    }
    //</editor-fold>
}
