package main;
import javax.swing.*;

import mapa.celda;
public abstract class gameObject {
     protected JLabel grafico;
     protected celda cell;
     protected int profundidad;
     protected boolean isRunning=true;
     
     
     public JLabel getGrafico(){
    	 return grafico;
     }
     public void setGrafico(JLabel graf){
    	 grafico=graf;
     }
     public void destruir(){
    	 isRunning=false;
    	 grafico.setIcon(null);
    	 cell.getObjects()[profundidad]=null;
     }
     
     public abstract boolean Accept(Visitor V);
     public int getProfundidad(){
    	 return profundidad;
     }
     public celda getCelda(){
    	 return cell;
     }
     public boolean getIsRunning(){
    	 return isRunning;
     }
     public void setIsRunning(boolean is){
    	 isRunning=is;
     }
     public void setCelda(celda c){
    	 cell=c;
     }
}
