package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoRapido extends Enemigo{
	private int tipo;
      public EnemigoRapido(celda c, int prof,int tipo){
    	  super(c,prof);
    	  resistencia=1;
    	  frecuencia_disparos=5;
    	  speed=13;
    	  this.tipo=tipo;
    	  graficos=new Icon[4];
    	  switch(tipo){
    	  case 0:
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/Grovyle0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/Grovyle1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/Grovyle2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/Grovyle3.gif"));
	    	 break;
    	  case 1:
    		 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/glaceon0.gif"));
 	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/glaceon1.gif"));
 	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/glaceon2.gif"));
 	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/glaceon3.gif"));
    	  }
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 200;
      }
      public void disparar(){
    	
    	  if(tipo==0)
    	 new DisparoEnemigo(cell,this,3,10,2);
    	  else
    		  new DisparoEnemigo(cell,this,3,10,5);
      }
}
