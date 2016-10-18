package main;
import javax.swing.*;

import mapa.celda;
public abstract class gameObject {
     protected JLabel grafico;
     protected celda cell;
     protected int profundidad;
     protected volatile boolean isRunnable;
     
     public JLabel getGrafico(){
    	 return grafico;
     }
     public void setGrafico(JLabel graf){
    	 grafico=graf;
     }
     public void destruir(){
    	 this.isRunnable=false;
    	 cell.getObjects()[getProfundidad()].getGrafico().setIcon(null);
    	 cell.getObjects()[getProfundidad()]=null;
    	// cell=null;
    	
     }
     
     public abstract boolean Accept(Visitor V);
     public int getProfundidad(){
    	 return profundidad;
     }
}
