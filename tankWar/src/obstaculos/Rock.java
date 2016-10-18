package obstaculos;
import javax.swing.*;

import main.Visitor;
import mapa.celda;
public class Rock extends obstaculo {
	private int resistencia;
    public Rock(celda c,int prof){
    	profundidad=prof;
    	cell=c;
    	resistencia=3;
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
}
