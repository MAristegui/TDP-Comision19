package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoBasico extends Enemigo{
      public EnemigoBasico(celda c, int prof){
    	  super(c,prof);
    	  resistencia=1;
    	  frecuencia_disparos=3;
    	  speed=40;
    	  graficos=new Icon[4];
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/drowzee0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/drowzee1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/drowzee2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/drowzee3.gif"));
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 100;
      }
      public void disparar(){
    	  
    	  DisparoEnemigo d1=new DisparoEnemigo(cell,this,3,15,1);
    	  
      }
}
