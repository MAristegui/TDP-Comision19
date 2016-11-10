package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoBasico extends Enemigo{
      public EnemigoBasico(celda c, int prof,int tipo){
    	  super(c,prof);
    	  resistencia=1;
    	  frecuencia_disparos=3;
    	  speed=40;
    	  graficos=new Icon[4];
    	  switch(tipo){
    	  case 0:
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/misdreavus0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/misdreavus1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/misdreavus2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/misdreavus3.gif"));
	    	 break;
    	  case 1:
    		 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/riolu0.gif"));
 	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/riolu1.gif"));
 	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/riolu2.gif"));
 	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/riolu3.gif"));
    		  break;
    	  }
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 100;
      }
      public void disparar(){
    	  
    	  new DisparoEnemigo(cell,this,3,15,1);
      }
}
