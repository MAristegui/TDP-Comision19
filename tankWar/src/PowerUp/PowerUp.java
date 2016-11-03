package powerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.*;
import jugador.Jugador;
import mapa.*;
import main.*;

import resources.*;

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

