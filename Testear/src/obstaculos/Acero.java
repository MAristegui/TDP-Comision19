package obstaculos;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;

public class Acero extends obstaculo implements Runnable{
	Thread t;
	private int resistencia;
	private int sprite;
	private static URL urll;
	   public Acero(celda c,int prof){
		   resistencia=4;
		   cell=c;
		   profundidad=prof;
		   grafico=new JLabel();
		   urll = (Acero.class.getClassLoader().getResource("resources/Acero_0.png"));
		   grafico.setIcon(new ImageIcon(urll));
	   }
	public boolean Accept(Visitor V) {
		return V.visitAcero(this);
	}
   public void dañar(int i){
	   if(resistencia==1)
		   destruir();         
	   else{
		   resistencia-=i;
		   t=new Thread(this);
		   t.start();
	   }
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
   	urll = (Acero.class.getClassLoader().getResource("resources/Acero_0.png"));
   	grafico.setIcon(new ImageIcon(urll));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	urll = (Acero.class.getClassLoader().getResource("resources/Acero2.png"));
grafico.setIcon(new ImageIcon(urll));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	urll = (Acero.class.getClassLoader().getResource("resources/Acero3.png"));
grafico.setIcon(new ImageIcon(urll));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	urll = (Acero.class.getClassLoader().getResource("resources/Acero4.png"));
grafico.setIcon(new ImageIcon(urll));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	urll = (Acero.class.getClassLoader().getResource("resources/Acero5.png"));
grafico.setIcon(new ImageIcon(urll));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	grafico.setIcon(null);
   	
	}
	else{
		urll = (Acero.class.getClassLoader().getResource("resources/Acero_0.png"));
	 	grafico.setIcon(new ImageIcon(urll));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	   	urll = (Acero.class.getClassLoader().getResource("resources/Acero2.png"));
	grafico.setIcon(new ImageIcon(urll));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	   	urll = (Acero.class.getClassLoader().getResource("resources/Acero3.png"));
	grafico.setIcon(new ImageIcon(urll));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	   	urll = (Acero.class.getClassLoader().getResource("resources/Acero_0.png"));
	grafico.setIcon(new ImageIcon(urll));
	}
   }
}
