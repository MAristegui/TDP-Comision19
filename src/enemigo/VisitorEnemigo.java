package enemigo;

import main.gameObject;
import obstaculos.*;
import main.*;
import powerUp.*;
import jugador.Jugador;
import disparo.*;
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
   public boolean visitDisparo(DisparoPlayer d){
	   if(d!=null)
	   d.destruir();
	   
	   if(objeto!=null){
	   Enemigo e=(Enemigo) objeto;
	   e.restarResistencia();
	   }
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

   public boolean visitAcero(Acero acero) {
	return false;
   }

@Override
public boolean visitAguila(Aguila aguila) {
	return false;
}
}
