package obstaculos;
import mapa.celda;

import main.Visitor;
public class Pared extends obstaculo {
    public Pared(celda c){
    	cell=c;
    }
    public boolean Accept(Visitor V){
    	return V.visitPared(this);
    }
}
