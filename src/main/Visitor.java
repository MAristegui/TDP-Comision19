package main;
import disparo.*;
import enemigo.Enemigo;
import jugador.Jugador;
import obstaculos.*;
import powerUp.*;
public abstract  class Visitor {
   protected gameObject objeto;
   
   public abstract boolean VisitRock(Rock r);
   public abstract boolean VisitWater(Water w);
   public abstract boolean visitPared(Pared p);
   public abstract boolean visitGrass(Grass g);
   public abstract boolean visitPlayer(Jugador j);
   public abstract boolean visitBridge(Bridge b);
   public abstract boolean visitDisparo(DisparoPlayer d);
   public abstract boolean visitEnemigo(Enemigo e);
   public abstract boolean visitPowerUp(PowerUp pw);
   public abstract boolean visitDisparoEnemigo(DisparoEnemigo d);
   public abstract boolean visitAcero(Acero a);
   public abstract boolean visitAguila(Aguila a);
}
