package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;

public class Acero extends obstaculo implements Runnable{
	Thread t;
	private int resistencia;
	   public Acero(celda c,int prof){
		   resistencia=4;
		   cell=c;
		   profundidad=prof;
		   grafico=new JLabel();
		   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero.png")));
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
   public void destruir(){
	isRunning=false;
   	t=new Thread(this);
   	t.start();
   }
   public void run(){
	if(!isRunning){
   	cell.getObjects()[getProfundidad()]=null;
   	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero2.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero3.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/acero4.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/acero5.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	grafico.setIcon(null);
   	
	}
	else{
	 	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero.png")));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero2.png")));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero3.png")));
	   	
	   	try{
	   		Thread.sleep(60);
	   	}catch(Exception e){}
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero.png")));
	}
   }
}
