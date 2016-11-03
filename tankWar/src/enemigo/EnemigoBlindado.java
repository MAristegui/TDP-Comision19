package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoBlindado extends Enemigo{
      public EnemigoBlindado(celda c, int prof){
    	  super(c,prof);
    	  resistencia=4;
    	  frecuencia_disparos=3;
    	  speed=40;
    	  graficos=new Icon[4];
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/graveler0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/graveler1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/graveler2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/graveler3.gif"));
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 400;
      }
      public void disparar(){
    	  if(!getMoviendo()){
        	  DisparoEnemigo d1=new DisparoEnemigo(cell,this,3,10,4);
        	  }
      }
}
