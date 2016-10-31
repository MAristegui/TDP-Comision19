package disparo;

import main.gameObject;
import obstaculos.Acero;
import obstaculos.Aguila;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import powerUp.*;
import enemigo.Enemigo;
import jugador.Jugador;
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
		   p.ColisionDisparo();
		   return false;
	   }
	   public  boolean visitGrass(Grass g){
		   g.Colision();
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
	   public boolean visitEnemigo(Enemigo e){
		   if(e.restarResistencia()){
			   DisparoPlayer d=(DisparoPlayer)objeto;
			   d.sumarPuntaje(e.getPuntaje());
		   }
		   objeto.destruir();
		   return false;
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
		   Disparo d=(Disparo)objeto;
		   d.dañarAcero(a);
		   return false;
	   }
	   public boolean visitAguila(Aguila a){
		   objeto.destruir();
	       a.gameOver();
		   return false;
	   }
}

