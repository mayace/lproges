package com.github.lproges.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import java_cup.runtime.Symbol;

public class Attr extends HashMap<String, Object> {


    //<editor-fold defaultstate="collapsed" desc="constructores">
    /**
     * Inserta n cantidad de atributos [key1,val1,key2,val2,...,keyn,valn]
     *
     * @param args
     */
    public Attr(Object... args) {
        String key = null;
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (i % 2 == 0) {
                key = arg.toString();
            } else {
                put(key, arg);
            }
        }
    }

    //</editor-fold>
    public Object set(String nombre, Object valor) {
        return this.put(nombre, valor);
    }

    //<editor-fold defaultstate="collapsed" desc="get">
    public String getString(String nombre) {
        String val = null;

        if (this.containsKey(nombre)) {
            try {
                val = String.valueOf(this.get(nombre));
            } catch (Exception exc) {
                return null;
            }
        }

        return val;
    }

    public Float getFloat(String nombre) {
        Float val = null;

        if (this.containsKey(nombre)) {
            try {
                val = Float.valueOf(this.get(nombre).toString());
            } catch (NumberFormatException exc) {
                return null;
            }
        }

        return val;
    }

    public Integer getInteger(String nombre) {
        Integer val = null;

        if (this.containsKey(nombre)) {
            try {
                val = new Integer(this.get(nombre).toString());
            } catch (NumberFormatException exc) {
                return null;
            }
        }

        return val;
    }

    public Boolean getBoolean(String nombre) {
        try {
            return Boolean.valueOf(get(nombre).toString());
        } catch (Exception exc) {
            return null;
        }
    }

    public Nodo getNodo(String nombre) {
        try {
            return ((Nodo) get(nombre));
        } catch (Exception exc) {
            return null;
        }
    }

    public Attr getAttr(String nombre) {
        try {
            return ((Attr) get(nombre));
        } catch (Exception exc) {
            return null;
        }
    }

    public Symbol getSymbol(String nombre) {
        try {
            return ((Symbol) get(nombre));
        } catch (Exception exc) {
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="listas">
    public ArrayList<Attr> getList(String nombre) {
        ArrayList<Attr> val = null;

        if (this.containsKey(nombre)) {
            try {
                val = (ArrayList<Attr>) this.get(nombre);
            } catch (Exception exc) {
                return null;
            }
        }

        return val;
    }

    public ArrayList<Integer> getIntegerList(String nombre_l, String nombre) {
        ArrayList<Attr> val = null;

        if (this.containsKey(nombre_l)) {
            try {
                val = (ArrayList<Attr>) this.get(nombre_l);
            } catch (Exception exc) {
                return null;
            }
        }
        ArrayList<Integer> val2 = new ArrayList<>();
        for (Attr mc : val) {
            Integer v = mc.getInteger(nombre);
            if (v != null) {
                val2.add(v);
            } else {
                return null;		//si getInteger tira null que returne null
            }
        }

        return val2;
    }

    public ArrayList<Float> getFloatList(String list_nombre, String nombre) {
        ArrayList<Attr> val = null;

        if (this.containsKey(list_nombre)) {
            try {
                val = (ArrayList<Attr>) this.get(list_nombre);
            } catch (Exception exc) {
                return null;
            }
        }
        ArrayList<Float> val2 = new ArrayList<>();
        for (Attr mc : val) {
            Float v = mc.getFloat(nombre);
            if (v != null) {
                val2.add(v);
            } else {
                return null;		//si getInteger tira null que returne null
            }
        }

        return val2;
    }

    public ArrayList<String> getStringList(String list_nombre, String nombre) {
        ArrayList<Attr> val = null;

        if (this.containsKey(list_nombre)) {
            try {
                val = (ArrayList<Attr>) this.get(list_nombre);
            } catch (Exception exc) {
                return null;
            }
        }
        ArrayList<String> val2 = new ArrayList<>();
        for (Attr mc : val) {
            String v = mc.getString(nombre);
            if (v != null) {
                val2.add(v);
            } else {
                return null;		//si getInteger tira null que returne null
            }
        }

        return val2;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="otros">
    public String getHtmlTable() {
        String html_table = "<table>";
        html_table += String.format("<tr><td><b>%s</b></td><td><b>%s</b></td></tr>", "Key", "Value");
        for (Entry<String, Object> entry : this.entrySet()) {
            html_table += String.format("<tr><td>%s</td><td>%s</td></tr>", entry.getKey(), entry.getValue());
        }
        html_table += "</table>";
        return html_table;
    }

    public String toString(String separator, String... except) {

        HashSet<String> except_set = new HashSet<>();
        if (except != null) {
            except_set.addAll(Arrays.asList(except));
        }

        String string = "";
        boolean first = true;
        for (Entry<String, Object> entry : this.entrySet()) {
            String entry_key = entry.getKey();

            if (!except_set.contains(entry_key)) {
                if (first) {
                    string += String.format("%s=%s", entry.getKey(), entry.getValue());
                    first = false;
                } else {
                    string += String.format("%s%s=%s", separator, entry.getKey(), entry.getValue());
                }
            }
        }

        return string;
    }
    //</editor-fold>
}
