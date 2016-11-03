package disparo;

import main.gameObject;
import obstaculos.*;
import main.Visitor;
import powerUp.*;
import jugador.Jugador;
import enemigo.Enemigo;
public class VisitorDisparo extends Visitor {
	  public VisitorDisparo(gameObject o){
	    	objeto=o;
	    }
	    
	   public  boolean VisitRock(Rock r){
		   if(objeto!=null){
		   DisparoPlayer d=(DisparoPlayer) objeto; 
		   d.destruir();
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
		   DisparoPlayer d=(DisparoPlayer) objeto; 
		   d.destruir();	
		   p.ColisionDisparo();
		   }
		   

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
	   public boolean visitDisparo(DisparoPlayer d){
		   if(objeto!=null){
		   DisparoPlayer d1=(DisparoPlayer) objeto;
		   d1.destruir();
		   }
		   if(d!=null){
		   d.destruir();
		   }
		  
		   return false;
	   }
	   public boolean visitEnemigo(Enemigo e){
		   if(e!=null)
		   e.restarResistencia();
		   if(objeto!=null){
		   DisparoPlayer d=(DisparoPlayer) objeto; 
		   d.destruir();
		   }
		   return false;
	   }
	   public boolean visitPowerUp(PowerUp pw)
	   {
		   return true;
	   }
	   public boolean visitDisparoEnemigo(DisparoEnemigo d){
		   if (objeto!=null){
		   DisparoPlayer d2=(DisparoPlayer) objeto; 
		   d2.destruir();
		   }
		   if(d!=null){
		   d.destruir();
		   }
		   return false;
	   }

	@Override
	public boolean visitAcero(Acero acero) {
		if(objeto!=null){
		   objeto.destruir();
		   Disparo d=(Disparo)objeto;
		   d.dañarAcero(acero);
		}	
			return false;
	}

	@Override
	public boolean visitAguila(Aguila aguila) {
		if(objeto!=null){
		Disparo d=(Disparo) objeto; 
		   d.destruir();
		aguila.finish();
		}	
		return false;
	}

}

