package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import obstaculos.Acero;
import disparo.DisparoEnemigo;
import mapa.celda;

public class EnemigoPoder extends Enemigo{
	private int tipo;
      public EnemigoPoder(celda c, int prof,int tipo){
    	  super(c,prof);
    	  resistencia=1;
    	  frecuencia_disparos=4;
    	  speed=20;
    	  this.tipo=tipo;
    	  graficos=new Icon[4];
    	  switch(tipo){
    	  case 0:
	    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/monferno0.gif"));
	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/monferno1.gif"));
	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/monferno2.gif"));
	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/monferno3.gif"));
	    	 break;
    	  case 1:
    		 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/prinplup0.gif"));
 	    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/prinplup1.gif"));
 	    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/prinplup2.gif"));
 	    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/prinplup3.gif"));
    		  break;
    	  }
	    	 grafico=new JLabel();
	    	 grafico.setIcon(graficos[1]);
	    	 e=new EnemigoRun(this);
	    	
      }
      public int getPuntaje(){
    	  return 300;
      }
      public void disparar(){
    	
    	  if(tipo==0)
    	  new DisparoEnemigo(cell,this,3,7,3);
    	  else
    		  new DisparoEnemigo(cell,this,3,7,5);
      }
      
      public void dañarAcero(Acero a){
      	a.dañar(1);
      
}
      }
