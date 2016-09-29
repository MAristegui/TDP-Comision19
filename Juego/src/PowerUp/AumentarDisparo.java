package PowerUp;
import Abstract.ObjetoLogico;
import Jugador.Jugador;
import Mapa.*;

public class AumentarDisparo extends PowerUp {
	
	public AumentarDisparo(Celda c){
		super(c);
	}
	public boolean Colision(ObjetoLogico o){
		  System.out.println("TROLO");
		  Jugador op=(Jugador) o;
		  op.setResistencia(op.getResistencia()+1);
		  celda.getObject().setGraph(null);
		  celda.setObject(null);
		  this.celda=null;
		  
		  return true;
		 }
	public boolean Colision(Jugador op){
		System.out.println("TROLO");
		op.setResistencia(op.getResistencia()+1);
		celda.setObject(null);
		this.celda=null;
		return true;
	}
	
}
