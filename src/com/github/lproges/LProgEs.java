package com.github.lproges;

import com.github.lproges.compiler.Attr;
import com.github.lproges.compiler.Nodo;
import com.github.lproges.compiler.Sim;
import com.github.lproges.compiler.SimTable;
import com.github.lproges.gui.Win;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LProgEs {

    public static void main(String[] args) {
        
        LinkedList<String> l = new LinkedList();
        
        
        com.github.lproges.compiler.Compiler c = new com.github.lproges.compiler.Compiler(new int[100], new int[100]);
        
        Object f = 1.0;
        
        System.err.println(MessageFormat.format("{0}.{1}.{2}", "uno", "dos", "tres"));
    }
    
}
