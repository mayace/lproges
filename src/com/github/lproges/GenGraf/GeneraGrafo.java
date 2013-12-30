/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.lproges.GenGraf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author orlando
 */
//clase que sirve para generar archivo .dot y .png del grafo

public class GeneraGrafo {
    //aqui van las etiquetas de cada nodo del grafo y su id
    String etiquetas="";
    //aqui van las direcciones de cada bloque hacia cada bloque indicado por el id
    String direcciones="";
    
    public void generarGrafo()
    {
        
        String dot="";
        
        //etiquetas = etiqetas+"{ node[label=\""+raiz.etiqueta+"\"]\""+raiz+"\";}\n";
        etiquetas = etiquetas+"{ node[label=\"INICIO\"]\"inicio\";}\n";
        //recorrer los bloues para generar el archivo .dot y .png
        //recorrer(BLOQUES)
        
        
        dot = "digraph G {\n\n node [fillcolor=\"#D7DFE8\", shape=box, style=\"filled\"]\nedge[arrowhead=\"vee\"];\n"+etiquetas+direcciones+"\n}\n";
        creaDot(dot);
        

    }
    
    /*public void Recorrer(Nodo actual)
    {
    //se recorre la lista para generar el archivo .dot
        Iterator iterador = raiz.lista.iterator();
        
        Iterator it= actual.lista.iterator();
        while (it.hasNext())
        {
            Nodo next = (Nodo)it.next();
            Recorrer(next);
            this.etiquetas = this.etiquetas +"{ node[label=\""+next.etiqueta+"\"]\""+next+"\";}\n";
            salida = salida +"\""+actual+"\" -> " + "\""+next+"\";\n";
        }
    }*/
        
    public void creaDot(String contenido)
    {
        try {
            File f=new File("Grafo.dot");
            FileWriter fr=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fr);
            PrintWriter out = new PrintWriter(bw);
            out.println(contenido);
            out.close();
            bw.close();
            fr.close();
        }

         catch(Exception e) {
            System.out.println("Error de escritura: "+e.toString());
        }
    }
    
    public void creaPng( String direccionDot, String direccionPng )
    {
        try
        {
        ProcessBuilder pbuilder;
/*
* Realiza la construccion del comando
* en la linea de comandos esto es:
* dot -Tpng -o archivo.png archivo.dot
*/
        pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
        pbuilder.redirectErrorStream( true );
        //Ejecuta el proceso
        pbuilder.start();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
}
