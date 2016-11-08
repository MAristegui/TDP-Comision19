
package disparo;

import main.gameObject;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import powerUp.*;
import obstaculos.Acero;
import obstaculos.Aguila;
import enemigo.Enemigo;
import jugador.Jugador;
import main.Visitor;
public class VisitorDisparoEnemigo extends Visitor {
	  public VisitorDisparoEnemigo(gameObject o){
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
		   p.ColisionDisparo();
		   return false;
	   }
	   public  boolean visitGrass(Grass g){
		   //g.Colision();
		   return true;
	   }
	   public  boolean visitPlayer(Jugador j){
		   objeto.destruir(); 
		   j.impact();
		   return false;
	   }
	   public  boolean visitBridge(Bridge b){
		   return true;
	   }
	   public boolean visitDisparoPlayer(DisparoPlayer d){
		   objeto.destruir();
		   d.destruir();
		   return false;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   return true;
	   }
	   public boolean visitPowerUp(PowerUp pw)
	   {
		   return true;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){
		  objeto.destruir();
		  d.destruir();
		  return false;
	   }
	   public boolean visitAcero(Acero a){
		   objeto.destruir();
		   DisparoEnemigo d=(DisparoEnemigo)objeto;
		   d.dañarAcero(a);
		   return false;
	   }
	   public boolean visitAguila(Aguila a){
           a.getCelda().gameOver();
		   objeto.destruir();
		   return false;
	   }
}


