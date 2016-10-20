package unidades;

import main.gameObject;
import obstaculos.Bridge;
import obstaculos.Grass;
import obstaculos.Pared;
import obstaculos.Rock;
import obstaculos.Water;
import main.Visitor;
import PowerUp.*;
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
	   return true;
   }
   public boolean visitDisparoEnemigo(DisparoEnemigo d){
	   return true;
   }
}
