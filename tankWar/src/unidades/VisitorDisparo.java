package unidades;

import main.gameObject;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import main.Visitor;
public class VisitorDisparo extends Visitor {
	  public VisitorDisparo(gameObject o){
	    	objeto=o;
	    }
	    
	   public  boolean VisitRock(Rock r){
		objeto.destruir();
		r.restarResistencia();
		return false;
	   }
	   public  boolean VisitWater(Water w){
		   return true;
	   }
	   public  boolean visitPared(Pared p){
		   objeto.destruir();
		   return false;
	   }
	   public  boolean visitGrass(Grass g){
		   return true;
	   }
	   public  boolean visitPlayer(Jugador j){
		   return true;
	   }
	   public  boolean visitBridge(Bridge b){
		   return true;
	   }
	   public boolean visitDisparo(Disparo d){
		   objeto.destruir();
		   d.destruir();
		   return true;
	   }
}
