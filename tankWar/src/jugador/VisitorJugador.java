package jugador;
import disparo.Disparo;
import obstaculos.Acero;
import obstaculos.Aguila;
import disparo.DisparoEnemigo;
import enemigo.Enemigo;
import main.Visitor;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import powerUp.*;
import main.gameObject;
public class VisitorJugador extends Visitor{
	
	    public VisitorJugador(gameObject o){
	    	objeto=o;
	    }
	    
	   public  boolean VisitRock(Rock r){
		return false;
	   }
	   public  boolean VisitWater(Water w){
		   return false;
	   }
	   public  boolean visitPared(Pared p){
		   return false;
	   }
	   public  boolean visitGrass(Grass g){
		   g.Colision();
		   return true;
	   }
	   public  boolean visitPlayer(Jugador j){
		   return false;
	   }
	   public  boolean visitBridge(Bridge b){
		   return true;
	   }
	   public boolean visitDisparo(Disparo d){
		   return true;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   return false;
	   }
	   public boolean visitPowerUp(PowerUp pw)
	   {
		   pw.AplicarPowerUP((Jugador)objeto);
		   return true;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){
		   d.destruir();
		   Jugador j=(Jugador)objeto;
		   j.impact();
		   return false;
	   }
	   public boolean visitAcero(Acero a){
		   return false;
	   }
	   public boolean visitAguila(Aguila a){
		   return false;
	   }
}
