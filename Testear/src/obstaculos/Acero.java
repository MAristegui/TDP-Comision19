package obstaculos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Visitor;
import mapa.celda;

public class Acero extends obstaculo implements Runnable{
	Thread t;
	private int resistencia;
	private int sprite;
	   public Acero(celda c,int prof){
		   resistencia=4;
		   cell=c;
		   profundidad=prof;
		   grafico=new JLabel();
		   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero_0.png")));
	   }
	public boolean Accept(Visitor V) {
		return V.visitAcero(this);
	}
   public void dañar(int i){
	   
	   if(resistencia==1&&i!=0)
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
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero_0.png")));
   	
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
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero4.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero5.png")));
   	
   	try{
   		Thread.sleep(80);
   	}catch(Exception e){}
   	grafico.setIcon(null);
   	
	}
	else{
		 grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero_0.png")));
	   	
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
	    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Acero_0.png")));
	}
   }
}
