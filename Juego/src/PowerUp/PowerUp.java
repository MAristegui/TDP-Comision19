package PowerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Abstract.*;
import Jugador.Jugador;
import Mapa.*;

import resources.*;

import Mapa.*;
public abstract class PowerUp extends ObjetoLogico {
	
	protected PowerUp(Celda c){
		celda=c;
	}
	public boolean Aceptar(Visitor V) {
		V.VisitPowerUp(this);
		return true;
	}
	public abstract void AplicarPowerUP(Jugador J);


}

