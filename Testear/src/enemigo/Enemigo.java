package enemigo;
import gui.GUI;
import main.Unidad;
import main.Visitor;
import mapa.celda;
import obstaculos.Acero;
public abstract class Enemigo extends Unidad{
	 protected int resistencia;
	 protected int frecuencia_disparos;
	 private int alto;
	 private int ancho;
	 protected EnemigoRun e;
	    public Enemigo(celda c, int profundidad){
	    	GUI.playSound("EnemigoAparece.wav");
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
		GUI.playSound("EnemigoMuere.wav");
		super.destruir();
		cell.destruirEnemigo(this);
	}
	public void da�arAcero(Acero a){
		a.da�ar(0);
	}
	public void detener(int i){
		e.parar();
	}
	public void detener(){
		e.parar(1);
	}
	public abstract void disparar();


	public void parar() {
		e.parar();
		
	}
}
