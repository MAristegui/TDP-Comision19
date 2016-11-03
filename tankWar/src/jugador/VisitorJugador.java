<<<<<<< HEAD
package jugador;
import disparo.Disparo;
import obstaculos.Acero;
import obstaculos.Aguila;
import disparo.DisparoEnemigo;
import disparo.DisparoPlayer;
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
	   public boolean visitDisparoPlayer(DisparoPlayer d){
		   return true;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   return false;
	   }
	   public boolean visitPowerUp(PowerUp pw)
	   {
		   Jugador j=(Jugador)objeto;
		   j.sumarPuntaje(500);
		   pw.AplicarPowerUP(j);
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
=======
package jugador;
import main.*;
import obstaculos.*;
import powerUp.*;
import disparo.*;
import enemigo.*;
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
	   public boolean visitDisparo(DisparoPlayer d){
		   return true;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   return false;
	   }
	   public boolean visitPowerUp(PowerUp pw){
	     if(objeto!=null) {
		   Jugador j=(Jugador)objeto;
		   pw.AplicarPowerUP(j);
		   j.addPowerUp();
		   }
		   return true;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){
		  if(d!=null){
		  d.destruir();
		  }
		  if (objeto!=null){
		   Jugador j=(Jugador) objeto;
		   j.impact();
		  }
		   return false;
	   }

	@Override
	public boolean visitAcero(Acero acero) {
		return false;
	}

	@Override
	public boolean visitAguila(Aguila aguila) {
		return false;
	}
}
>>>>>>> origin/master
