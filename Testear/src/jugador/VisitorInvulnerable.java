package jugador;
import main.*;
import obstaculos.*;
import powerUp.*;
import disparo.*;
import enemigo.*;
public class VisitorInvulnerable extends Visitor{
	
	    public VisitorInvulnerable(gameObject o){
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
	   public boolean visitPowerUp(PowerUp pw){
	     if(objeto!=null) {
		   Jugador j=(Jugador)objeto;
		   pw.AplicarPowerUP(j);
		   j.sumarPuntaje(500);
		   }
		   return true;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){
		  if(d!=null){
		  d.destruir();
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
