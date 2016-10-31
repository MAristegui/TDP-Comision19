package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoRapido extends Enemigo{
      public EnemigoRapido(celda c, int prof){
    	  super(c,prof);
    	  resistencia=1;
    	  speed=13;
    	  graficos=new Icon[4];
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/grovyle0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/grovyle1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/grovyle2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/grovyle3.gif"));
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 200;
      }
      public void disparar(){
    	  DisparoEnemigo d1=new DisparoEnemigo(cell,this,3,10,2);
      }
}
