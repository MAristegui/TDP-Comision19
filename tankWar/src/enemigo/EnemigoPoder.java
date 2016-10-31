package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoPoder extends Enemigo{
      public EnemigoPoder(celda c, int prof){
    	  super(c,prof);
    	  resistencia=1;
    	  speed=20;
    	  graficos=new Icon[4];
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/combusken0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/combusken1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/combusken2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/combusken3.gif"));
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 300;
      }
      public void disparar(){
    	  DisparoEnemigo d1=new DisparoEnemigo(cell,this,3,7,3);
      }
      
}
