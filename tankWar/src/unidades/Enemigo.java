package unidades;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;
public class Enemigo extends Unidad{
	 private int resistencia;
	    public Enemigo(celda c, int profundidad){
	    	resistencia=4;
	    	speed=30;
	    	cell=c;
	    	isRunning=true;
	    	this.profundidad=profundidad;
	    	V=new VisitorEnemigo(this);
	    	graficos=new Icon[4];
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/down.png"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/up.png"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/right.png"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/left.png"));
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	
	    	EnemigoRun e=new EnemigoRun(this);
	    		
	    			
	    }
	
	
	
	public boolean Accept(Visitor V){
		return V.visitEnemigo((Enemigo)this);
		}
	public void restarResistencia(){
		if(resistencia==1)
			destruir();
		else
		resistencia--;
	}
	public boolean getIsRunnable(){
		return isRunning;
	}
}
