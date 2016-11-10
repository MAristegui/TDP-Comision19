package obstaculos;
import javax.swing.*;
import main.Visitor;
import mapa.celda;
public class Rock extends obstaculo implements Runnable{
	private int resistencia;
	private Thread t;
	private int sprite;
    public Rock(celda c,int prof,int sprite){
    	profundidad=prof;
    	cell=c;
    	this.sprite=sprite;
    	resistencia=3;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/b_"+sprite+".png")));
    	
    	
    }
    public int getResistencia(){
    	return resistencia;
    }
    public void restarResistencia(){
    	if(resistencia==1){
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
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1_"+sprite+".png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra2_"+sprite+".png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra3_"+sprite+".png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra4_"+sprite+".png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra5_"+sprite+".png")));
    	
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	grafico.setIcon(null);
    	
    	}
    	else{
    		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1_"+sprite+".png")));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra2_"+sprite+".png")));
        	
        	try{
        		Thread.sleep(60);
        	}catch(Exception e){}
    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra3_"+sprite+".png")));
        	try {
			    Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	    grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/piedra1_"+sprite+".png"))); 
    	}
    	
    }

}
