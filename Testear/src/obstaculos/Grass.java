package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.celda;
import main.Visitor;

public class Grass extends obstaculo implements Runnable {
	private char tipo;
	private  Thread t;
	private int sprite;
	public Grass(celda c, char tipo,int prof,int sprite){
		   this.tipo=tipo;
		   this.sprite=sprite;
		   profundidad=prof;
		   cell=c;
		   grafico=new JLabel();
		   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+".png")));
	   }
	public boolean Accept(Visitor V){
		return V.visitGrass(this);
	}
	public void Colision(){
		t=new Thread(this);
		t.start();
	}
	public int getSprite(){
		return sprite;
	}
	public void run(){
        grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+"_1.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
         grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+"_2.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
        grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+"_3.png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
          grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+"_"+sprite+".png")));
    	
	}
}
