package obstaculos;
import javax.swing.*;
import mapa.celda;

import main.Visitor;
public class Pared extends obstaculo implements Runnable {
    public Pared(celda c){
    	cell=c;
    	grafico=new JLabel();
    	grafico.setIcon(null);
    }
    public boolean Accept(Visitor V){
    	return V.visitPared(this);
    }
    public void run(){
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp1.png")));
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp2.png")));
    	try{
    		Thread.sleep(80);
    	}catch(Exception e){}
    	grafico.setIcon(null);
    }
    public void ColisionDisparo(){
    	Thread t=new Thread(this);
    	t.start();
    }
}
