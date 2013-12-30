/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.lproges.GenGraf;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;


import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author orlando
 */
//frame donde se muestra el grafo, solo para eso sirve
public class MarcoGrafo extends JFrame {
    Image fondo;
    File imgPath;
    
    public MarcoGrafo(/*File pathImagen*/){
            super("Grafo 3 Direcciones");
            this.setSize(500, 600);
            //this.imgPath= pathImagen;
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); 
        cargaImagen();
        repaint();
      }
    
    public void cargaImagen(){
           
            try {
                 //imgStream = new FileInputStream(this.imgPath);
                  //imgStream = MarcoGrafo.class.getResourceAsStream("Grafo.png");//el path debe ser directo img es mi directorio
                  fondo = new ImageIcon("Grafo.png").getImage();
                  //fondo = ImageIO.read(imgStream);
            } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
      }
    
    public void paint(Graphics g)
      {
            Graphics g2 = (Graphics2D)g;
            g2.drawImage(fondo, 0, 0, 500, 600, null);//dibujo la imagen x, y, tamaño vertical y horizontal
            this.repaint();
      }
    
}
