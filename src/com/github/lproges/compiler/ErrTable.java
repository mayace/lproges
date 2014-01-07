package com.github.lproges.compiler;

import java.util.ArrayList;

public class ErrTable<T> extends ArrayList<T> {

    public static enum ERORR {

        NULL;

        public static String getNULL() {
            return "Puntero nulo.";
        }
    }
}
