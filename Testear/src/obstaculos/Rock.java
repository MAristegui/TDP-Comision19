package obstaculos;


import java.net.URL;

import javax.swing.*;

import main.Visitor;
import mapa.celda;
public class Rock extends obstaculo implements Runnable{
	private int resistencia;
	private static URL urll;
	private Thread t;
	private int sprite;
    public Rock(celda c,int prof,int sprite){
    	profundidad=prof;
    	cell=c;
    	this.sprite=sprite;
    	resistencia=3;
    	grafico=new JLabel();
    	urll = (Rock.class.getClassLoader().getResource("resources/b_"+sprite+".png"));
    	grafico.setIcon(new ImageIcon(urll));
    	
    	
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
    public int getSprite(){
    	return sprite;
    }
    public void destruir(){
    	isRunning=false;
    	t=new Thread(this);
    	t.start();
    }
    public void run(){
    	if(!isRunning){
    	cell.getObjects()[getProfundidad()]=null;
    	urll = (Acero.class.getClassLoader().getResource("resources/piedra1_"+sprite+".png"));
    	grafico.setIcon(new ImageIcon(urll));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	urll = (Acero.class.getClassLoader().getResource("resources/piedra2_"+sprite+".png"));
grafico.setIcon(new ImageIcon(urll));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	urll = (Acero.class.getClassLoader().getResource("resources/piedra3_"+sprite+".png"));
grafico.setIcon(new ImageIcon(urll));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	urll = (Acero.class.getClassLoader().getResource("resources/piedra4_"+sprite+".png"));
grafico.setIcon(new ImageIcon(urll));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	urll = (Acero.class.getClassLoader().getResource("resources/piedra5_"+sprite+".png"));
grafico.setIcon(new ImageIcon(urll));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	grafico.setIcon(null);
    	
    	}
    	else{
    		urll = (Acero.class.getClassLoader().getResource("resources/piedra1_"+sprite+".png"));
    		grafico.setIcon(new ImageIcon(urll));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
        	urll = (Acero.class.getClassLoader().getResource("resources/piedra2_"+sprite+".png"));
    grafico.setIcon(new ImageIcon(urll));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
        	urll = (Acero.class.getClassLoader().getResource("resources/piedra3_"+sprite+".png"));
    grafico.setIcon(new ImageIcon(urll));
        	try {
			    Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	urll = (Acero.class.getClassLoader().getResource("resources/piedra1_"+sprite+".png"));
        	    grafico.setIcon(new ImageIcon(urll)); 
    	}
    	
    }

}
