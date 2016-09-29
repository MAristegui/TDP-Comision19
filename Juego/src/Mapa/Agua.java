package Mapa;

import javax.swing.*;
import Abstract.*;
public class Agua extends ObjetoLogico{
    public Agua(Celda c){
    	celda=c;
		celda.setObject(this);
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/Agua.gif")));
    	
    }
    
    public boolean Colision(ObjetoLogico o)
    {
    	return false;
    }
}

