package jugador;
import javax.swing.*;
import obstaculos.Acero;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Nivel1 extends State implements Runnable{
    public Nivel1(Jugador jugador,int d){
    	velocidad_jugador=20;
    	velocidad_disparo=12;
    	disparos_simultaneos=1;
    	disparos_en_ejecucion=d;
    	resistencia=1;
    	this.jugador=jugador;
    }

    public State lvlUp(){
    	Thread t=new Thread(this);
    	t.start();
    	return new Nivel2(jugador);
    }
    public void setGraficos(Icon[] graficos, JLabel grafico){
     
   	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/charmander0.gif"));
   	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/charmander1.gif"));
   	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/charmander2.gif"));
   	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/charmander3.gif"));
   
   	 grafico.setIcon(graficos[jugador.getDireccion()]);
    }
    public void run(){
 
    	JLabel grafico=jugador.getGrafico();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmanderEv"+jugador.getDireccion()+"1.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmanderEv"+jugador.getDireccion()+"2.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmanderEv"+jugador.getDireccion()+"3.png")));
    	try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/charmeleon"+jugador.getDireccion()+".gif")));
    	
    	
    	}
    public void dañarAcero(Acero a){
    	a.dañar(0);
    }
    }

