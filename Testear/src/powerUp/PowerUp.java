package powerUp;
import jugador.Jugador;
import mapa.*;
import main.*;

public abstract class PowerUp extends gameObject {
	
	protected PowerUp(celda c,int prof){
		cell=c;
		profundidad=prof;
	}
	public boolean Aceptar(Visitor V) {
		return V.visitPowerUp(this);
	}
	public abstract void AplicarPowerUP(Jugador J);


}

