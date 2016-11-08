package enemigo;
import obstaculos.Acero;
import obstaculos.Aguila;
import main.gameObject;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import powerUp.*;
import disparo.DisparoEnemigo;
import disparo.DisparoPlayer;
import jugador.Jugador;
import main.Visitor;
public class VisitorEnemigo extends Visitor{
	public VisitorEnemigo(gameObject o){
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
	   d.destruir();
	   Enemigo e=(Enemigo)objeto;
	   e.restarResistencia();
	   return false;
   }
   public boolean visitEnemigo(Enemigo e){
	   return false;
   }
   public boolean visitPowerUp(PowerUp pw)
   {
	   return true;
   }
   public boolean visitDisparoEnemigo(DisparoEnemigo d){
	   return true;
   }
   public boolean visitAcero(Acero a){
	   return false;
   }
   public boolean visitAguila(Aguila a){
	   return false;
   }
}
