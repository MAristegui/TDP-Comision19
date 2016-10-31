package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import obstaculos.Acero;
public class Nivel3 extends State implements Runnable{
    public Nivel3(Jugador jugador){
    	this.jugador=jugador;
    	velocidad_jugador=20;
    	velocidad_disparo=8;
 	    disparos_simultaneos=2;
 	    resistencia=2;
 	    disparos_en_ejecucion=0;
    }
    public State lvlUp(){
    	Thread t=new Thread(this);
    	t.start();
    	return new Nivel4(jugador);
    }
    public void run(){
    	 
    	JLabel grafico=jugador.getGrafico();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charizardEv"+jugador.getDireccion()+"1.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charizardEv"+jugador.getDireccion()+"2.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charizardEv"+jugador.getDireccion()+"3.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/megaCharizard"+jugador.getDireccion()+".gif")));
    	
    	
    	}
    public void setGraficos(Icon[] graficos, JLabel grafico){
      	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/charizard0.gif"));
      	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/charizard1.gif"));
      	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/charizard2.gif"));
      	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/charizard3.gif"));
      	 grafico.setIcon(graficos[jugador.getDireccion()]);
       }
    public void dañarAcero(Acero a){
    	a.dañar(0);
    }
}
