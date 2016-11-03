
package disparo;

import main.gameObject;
import obstaculos.*;
import main.*;
import powerUp.*;
import enemigo.Enemigo;
import jugador.Jugador;
public class VisitorDisparoEnemigo extends Visitor {
	  public VisitorDisparoEnemigo(gameObject o){
	    	objeto=o;
	    }
	    
	   public  boolean VisitRock(Rock r){
		   if(objeto!=null){
		   objeto.destruir();
		   }
		   if(r!=null)
		   r.restarResistencia();
		   
		return false;
	   }
	   public  boolean VisitWater(Water w){
		   return true;
	   }
	   public  boolean visitPared(Pared p){
		   if(objeto!=null){
		   objeto.destruir();
		   p.ColisionDisparo();
			}
		   
		   return false;
	   }
	   public  boolean visitGrass(Grass g){
		   g.Colision();
		   return true;
	   }
	   public  boolean visitPlayer(Jugador j){
		   if(objeto!=null)
		  	 objeto.destruir();
		  if(j!=null)
		   	j.impact();
		   	
		   return false;
		   
	   }
	   public  boolean visitBridge(Bridge b){
		   return true;
	   }
	   public boolean visitDisparo(DisparoPlayer d){
		   if(objeto!=null)
		   objeto.destruir();
		   
		  if( d!=null)
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
		  return true;
	   }

	public boolean visitAcero(Acero acero) {
		if(objeto!=null){
			objeto.destruir();
			}
		return false;
	}

	@Override
	public boolean visitAguila(Aguila aguila) {
		if(objeto!=null){
		objeto.destruir();
		aguila.finish();
		}
		return false;
	}
}


