package unidades;
import mapa.celda;
import main.Visitor;
public class DisparoEnemigo extends Disparo{
   public DisparoEnemigo(celda c,Unidad e, int prof){
	   super(c,e,prof);
	   V=new VisitorDisparoEnemigo(this);
   }
   public boolean Accept(Visitor V){
	   return V.visitDisparoEnemigo(this);
   }
}
