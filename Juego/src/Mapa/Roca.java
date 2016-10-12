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
	@Override
	public boolean Aceptar(Visitor V) {
		return V.VisitRoca(this);
	}
	
}
