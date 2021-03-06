package disparo;
import obstaculos.Acero;
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
    	   cell.getObjects()[profundidad]=this;
    	   this.speed=speed;

       }

       
       public abstract boolean Accept(Visitor V);
       public boolean getIsRunning(){
    	   
    	   return isRunning ;
       }
       public int getAlto(){
      	 return alto;
       }
       public int getAncho(){
      	 return ancho;
       }
      public void daņarAcero(Acero a){
    	  j.daņarAcero(a);
      }
       public void destruir(){
    	   super.destruir();
    	   
       }
       public void restarDisparosEnEjecucion(){}
}