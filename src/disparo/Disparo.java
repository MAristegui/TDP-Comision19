package disparo;
import javax.swing.Icon;
import obstaculos.Acero;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Unidad;
import main.Visitor;
import mapa.celda;
public abstract class Disparo extends Unidad  {
	protected Unidad j;
	protected int ancho;
	protected int alto;
	
       protected Disparo(celda C, Unidad j, int prof,int speed){
    	   profundidad=prof;
    	   isRunning=true;
    	   this.j=j;
    	   ancho=16;
    	   alto=16;
    	   dirActual=j.getDireccion();
    	   cell=C;
    	   cell.getObjects()[3]=this;
    	   this.speed=speed;

       }

       public boolean getIsRunning(){
    	   
    	   return isRunning ;
       }
       public int getAlto(){
      	 return alto;
       }
       public int getAncho(){
      	 return ancho;
       }
      public void dañarAcero(Acero a){
    	  j.dañarAcero(a);
      }
       public void destruir(){
    	   super.destruir();
    	   
       }
       public void restarDisparosEnEjecucion(){}
}