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
	 private int disparos_en_ejecucion;
	 private int disparos_simultaneos;
	 private int alto;
	 private int ancho;
	 protected EnemigoRun e;
	    public Enemigo(celda c, int profundidad){
	    	alto=26;
	    	ancho=26;
	    	disparos_en_ejecucion=0;
	    	disparos_simultaneos=1;
	    	cell=c;
	    	isRunning=true;
	    	this.profundidad=profundidad;
	    	V=new VisitorEnemigo(this);
	    	
	    		
	    			
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
	public void dañarAcero(Acero a){
		a.dañar(0);
	}
	public void detener(int i){
		e.parar();
	}
	public abstract void disparar();
	public void destruir(){
		isRunning=false;
		detener(5000);
		cell.destruir(this);
		super.destruir();
	}	
}
