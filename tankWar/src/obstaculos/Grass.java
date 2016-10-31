package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.celda;
import main.Visitor;

public class Grass extends obstaculo implements Runnable {
	private char tipo;
	private  Thread t;
	public Grass(celda c, char tipo,int prof){
		   this.tipo=tipo;
		   profundidad=prof;
		   cell=c;
		   grafico=new JLabel();
		   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+".png")));
	   }
	public boolean Accept(Visitor V){
		return V.visitGrass(this);
	}
	public void Colision(){
		t=new Thread(this);
		t.start();
	}
	public void run(){
        grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_1.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
         grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_2.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
        grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_3.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
          grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+".png")));
    	
	}
}
