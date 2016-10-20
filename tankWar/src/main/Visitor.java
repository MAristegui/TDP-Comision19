package main;
import unidades.*;
import obstaculos.*;
import PowerUp.*;
public abstract  class Visitor {
   protected gameObject objeto;
   
   public abstract boolean VisitRock(Rock r);
   public abstract boolean VisitWater(Water w);
   public abstract boolean visitPared(Pared p);
   public abstract boolean visitGrass(Grass g);
   public abstract boolean visitPlayer(Jugador j);
   public abstract boolean visitBridge(Bridge b);
   public abstract boolean visitDisparo(Disparo d);
   public abstract boolean visitEnemigo(Enemigo e);
   public abstract boolean visitPowerUp(PowerUp pw);
   public abstract boolean visitDisparoEnemigo(DisparoEnemigo d);
}
