package com.github.lproges.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        if (isLeaf()) {
            exec_leaf(compiler);
        } else {
            exec_oper(compiler, operations);
        }

    }

    private void exec_oper(CompilerStuff compiler, Object operations) {
        // recopilando informacion
        HashMap<Object, Operation> oper_map = (HashMap) operations;
        Object nodo_oper = getOpertation();
        Operation oper = oper_map.get(nodo_oper);

        // ejecutar operacion
        oper.exec(this, compiler, operations);
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
            nodo.exec(compiler, operations);
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

        Attr leaf_ref = (Attr) getRef(); // atributo que trae
        Attr leaf_val = new Attr(); // atributo a enviar

        // informacion de lo recibido
        Object leaf_info = leaf_ref.get("info");
        Object leaf_ref_val = leaf_ref.get("val");
        String leaf_ref_tipo = leaf_ref.getString("tipo");  // trea string... el modelo son las hojas en las gramaticas

//        String a_tres = "// Obtencion de valor";
        // procesar la informacion
        if (isId()) {
//            // obtenecion de la llave correspondiente..
//            Object a_key = leaf_ref_val;
//            if (table.containsKey(a_key)) {
//                // informacion del simbolo
//                Sim a_sim = table.get(a_key);
//                leaf_ref_tipo = a_sim.getType();
//                int a_pos = a_sim.getPos();
//
//                // tres direcciones
//                final String temp1 = compiler.getTemp();
//                final String temp2 = compiler.getTemp();
//                a_tres += String.format("%s = p + %s;\n", temp1, a_pos);
//                // obtener el valor segun el tipo
//                switch (leaf_ref_tipo) {
//                    case "boolean":
//                        // valor en la pila
//                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
//                        break;
//                    case "int":
//                        // valor en la pila
//                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
//                        break;
//                    case "float":
//                        // referencia en el heap
//                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
//                        break;
//                    case "char":
//                        // char as int
//                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
//                        break;
//                    case "string":
//                        // referencia en el heap
//                        a_tres += String.format("%s = pila[%s];", temp2, temp1);
//                        break;
//                    default:
//                        errors.add(new Err("Tipo no soportado: " + leaf_ref_tipo, leaf_info, Err.TIPO.SEMANTICO));
//                }
//
//            } else {
//                errors.add(new Err("Variable no declarada: " + leaf_ref_val, leaf_info, Err.TIPO.SEMANTICO));
//            }
        } else {
            // si es una constante
//            if (leaf_ref_val instanceof String) {
//                String leaf_ref_val_str = (String) leaf_ref_val;
//                a_tres = compiler.getTemp() + "=" + leaf_ref_val + ";";
//            }
        }
        // enviar el resultado...
        leaf_val.set("tipo", leaf_ref_tipo);
        leaf_val.set("val", leaf_ref_val);
        leaf_val.set("info", leaf_info);

        setVal(leaf_val);
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

        public abstract void exec(Nodo nodo, CompilerStuff compiler, Object operations);

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

        /// useful stuff
        public TableModel get_errors_tablemodel() {

            final LinkedList<Err> _errors = getErrors();
            Object[] data_header = Err.getArrayHeader();
            Object[][] data = new Object[_errors.size()][];

            for (int i = 0; i < _errors.size(); i++) {
                Err err = _errors.get(i);
                data[i] = err.toArray();
            }

            return new DefaultTableModel(data, data_header);
        }

        public TableModel get_symtable_tablemode() {
            HashMap<Object, Sim> _simtable = getSimtable();
            Object[] data_header = Sim.getArrayHeader();
            Object[][] data = new Object[_simtable.size()][];

            int i = 0;
            for (Map.Entry<Object, Sim> entry : _simtable.entrySet()) {
                Object key = entry.getKey();
                Sim val = entry.getValue();

                data[i] = val.toArray();
                i++;
            }

            return new DefaultTableModel(data, data_header);
        }
        // manejo de posiciones de las variables
        HashMap<Object, LinkedHashMap<Object, Sim>> temp_stack_simtable = new HashMap<>();

        /**
         * Retorna el conjunto de simbolos para la llave dada.
         *
         * @param key
         * @return
         */
        public LinkedHashMap<Object, Sim> get_temp_simtable(Object key) {
            if (!temp_stack_simtable.containsKey(key)) {
                temp_stack_simtable.put(key, new LinkedHashMap<Object, Sim>());
            }
            return temp_stack_simtable.get(key);
        }

        public void addVar(String scope, String name, String type, String rol, int size) {
            final LinkedHashMap<Object, Sim> temp_simtable = get_temp_simtable(scope);
            // calulcar aqui la posicion que se da... si en caso el arrego se manejara en la pila
            int pos = temp_simtable.size();
            //
            final Sim sim = new Sim(scope, name, type, rol, pos, size);
            temp_simtable.put(getKey(scope, name), sim);
        }

        public void addMethod(String scope, String name, String type, Object... param_list) {

            // obtener key del metodo
            Object key = getKey(scope, name, param_list);

            // obtener los simbolos que corresponden a la llave
            LinkedHashMap<Object, Sim> _temp_simtable = get_temp_simtable(key);
            // calcular el tamanio del metodo
            int size = 0;
            for (Map.Entry<Object, Sim> entry : _temp_simtable.entrySet()) {
                Object entry_key = entry.getKey();
                Sim entry_val = entry.getValue();
                size += entry_val.getSize();
            }
            // crear el simbolo para el metodo
//            Sim sim = new Sim(scope, name, type, size, param_list);
            // agregar metodo a la tabla de simbolos
//            getSimtable().put(key, sim);
            // agregar simbolos que corresponden al metodo
//            getSimtable().putAll(_temp_simtable);

//            temp_stack_simtable.remove(key);
        }

        public void addError(Err error) {
            getErrors().add(error);
        }

        public boolean existsKey(String scope, String name, Object... param_list) {
            Object key = getKey(scope, name, param_list);

            return get_temp_simtable(scope).containsKey(key) || getSimtable().containsKey(key);
        }

        public Object getKey(String scope, String name, Object... param_list) {
            Object key = (scope == null || scope.isEmpty() ? "" : scope + ".") + name;
            if (param_list != null && param_list.length > 0) {
                for (int i = 0; i < param_list.length; i++) {
                    Object param = param_list[i];
                    key += (i == 0 ? "," : ".") + param;
                }
            }
            return key;
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
