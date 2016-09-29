package Mapa;

import javax.swing.*;
import Abstract.*;
public class Roca extends ObjetoLogico{
	protected int Resistencia; 
	public Roca(Celda c){
		celda=c;
		celda.setObject(this);
		Resistencia=1;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Roca.png")));
    	
    }
	/* public boolean Colision(Disparo d){
		System.out.println("EHAEHAEEE");
		return true;
		}*/
		
    public boolean Colision(ObjetoLogico o){
    	System.out.println("sos puto eh");
    	return false;
    }
}
