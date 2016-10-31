package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import obstaculos.Acero;
public class Nivel2 extends State implements Runnable{
   public Nivel2(Jugador jugador){
	   velocidad_jugador=12;
	   velocidad_disparo=8;
	   disparos_simultaneos=1;
	   disparos_en_ejecucion=0;
	   resistencia=1;
	   this.jugador=jugador;
   }
   
   public State lvlUp(){
	   Thread t=new Thread(this);
	   t.start();
	   return new Nivel3(jugador);
   }
   public void setGraficos(Icon[] graficos, JLabel grafico){
	   	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/charmeleon0.gif"));
	   	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/charmeleon1.gif"));
	   	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/charmeleon2.gif"));
	   	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/charmeleon3.gif"));
	   	 grafico.setIcon(graficos[jugador.getDireccion()]);
	    }
   public void run(){
	   
   	JLabel grafico=jugador.getGrafico();
   	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmeleonEv"+jugador.getDireccion()+"1.png")));
   	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmeleonEv"+jugador.getDireccion()+"2.png")));
   	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmeleonEv"+jugador.getDireccion()+"3.png")));
   	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charizard"+jugador.getDireccion()+".gif")));
   	
   	
   	}
   public void dañarAcero(Acero a){
	   a.dañar(0);
   }
}
