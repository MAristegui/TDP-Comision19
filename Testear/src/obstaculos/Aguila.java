package obstaculos;
import mapa.celda;
import javax.swing.*;
import main.Visitor;
public class Aguila extends obstaculo{
    public Aguila(celda c, int prof){
    	cell=c;
    	profundidad=prof;
    	grafico=new JLabel();
    }
    public boolean Accept(Visitor v){
    	return v.visitAguila(this);
    }

}
