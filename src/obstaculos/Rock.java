package obstaculos;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.*;

import jugador.State;
import main.Visitor;
import mapa.celda;
public class Rock extends obstaculo implements Runnable{
	private int resistencia;
	private Thread t;
    public Rock(celda c,int prof){
    	profundidad=prof;
    	cell=c;
    	resistencia=3;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/b.png")));
    	
    	
    }
    public int getResistencia(){
    	return resistencia;
    }
    public void restarResistencia(){
    	if(resistencia==1){
    		/*try{
  	          URL url = State.class.getResource("/resources/roca_destruida.wav"); 
  	             AudioClip clip = Applet.newAudioClip(url);
  	             clip.play();
  	          }catch (Exception e){;}*/
    		destruir();
    	}else{
    		resistencia--;
    		t=new Thread(this);
    		t.start();
    	}
    }
    public boolean Accept(Visitor V){
    	return V.VisitRock(this);
    }
    public void destruir(){
    	isRunning=false;
    	t=new Thread(this);
    	t.start();
    }
    public void run(){
    	if(!isRunning){
    	cell.getObjects()[getProfundidad()]=null;
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra2.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra3.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra4.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra5.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	grafico.setIcon(null);
    	
    	}
    	else{
    		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1.png")));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra2.png")));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra3.png")));
        	try {
			    Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1.png"))); 
    	}
    	
    }

}
