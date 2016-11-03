package enemigo;
import javax.swing.Icon;
import obstaculos.Acero;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import main.Unidad;
import main.Visitor;
import mapa.celda;
public abstract class Enemigo extends Unidad{
	 protected int resistencia;
	 protected int frecuencia_disparos;
	 private int alto;
	 private int ancho;
	 protected EnemigoRun e;
	    public Enemigo(celda c, int profundidad){
	    	V=new VisitorEnemigo(this);
	    	alto=26;
	    	ancho=26;
	    	cell=c;
	    	isRunning=true;
	    	this.profundidad=profundidad;
	    	
	    	
	    		
	    			
	    }
	
	
	public abstract int getPuntaje();
	public boolean Accept(Visitor V){
		return V.visitEnemigo((Enemigo)this);
		}
	 public int getAlto(){
    	 return alto;
     }
     public int getAncho(){
    	 return ancho;
     }
     public int getFrecuenciaDisparos(){
    	 return frecuencia_disparos;
     }
	public boolean restarResistencia(){
		if(resistencia==1){
			destruir();
			return true;
		}
		else{
		resistencia--;
		return false;
		}
	}
	
	public void destruir(){
		cell.destruirEnemigo(this);
		stopThread();
		super.destruir();
		
	}
	public void dañarAcero(Acero a){
		a.dañar(0);
	}
	public void detener(int i){
		e.parar();
	}
	public abstract void disparar();
}
