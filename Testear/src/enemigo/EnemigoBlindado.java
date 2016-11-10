package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoBlindado extends Enemigo{
      public EnemigoBlindado(celda c, int prof,int tipo){
    	  super(c,prof);
    	  resistencia=4;
    	  frecuencia_disparos=3;
    	  speed=40;
    	  graficos=new Icon[4];
    	  switch(tipo){
    	  case 0:
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/bastiodon0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/bastiodon1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/bastiodon2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/bastiodon3.gif"));
	    	 break;
	    	 case 1:
	    		 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/nosepass0.gif"));
		    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/nosepass1.gif"));
		    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/nosepass2.gif"));
		    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/nosepass3.gif"));
	    		 break;
    	  }
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 400;
      }
      public void disparar(){
    	  new DisparoEnemigo(cell,this,3,10,4);
      }
}
