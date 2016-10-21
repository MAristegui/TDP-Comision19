package obstaculos;
import javax.swing.*;

import main.Visitor;
import mapa.celda;
public class Rock extends obstaculo implements Runnable{
	private int resistencia;
	private Thread t;
    public Rock(celda c,int prof){
    	profundidad=prof;
    	cell=c;
    	resistencia=1;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/b.png")));
    	
    	
    }
    public int getResistencia(){
    	return resistencia;
    }
    public void restarResistencia(){
    	if(resistencia==1){
    		destruir();
    	}else
    		resistencia--;
    }
    public boolean Accept(Visitor V){
    	return V.VisitRock(this);
    }
    public void destruir(){
    	t=new Thread(this);
    	t.start();
    }
    public void run(){
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
    	cell.getObjects()[getProfundidad()].getGrafico().setIcon(null);
    	cell.getObjects()[getProfundidad()]=null;
    	
    }

}
