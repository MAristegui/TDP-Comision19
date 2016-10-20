package PowerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import unidades.*;
import mapa.*;
import main.*;

import resources.*;

public abstract class PowerUp extends gameObject {
	
	protected PowerUp(celda c,int prof){
		cell=c;
		profundidad=prof;
	}
	public boolean Aceptar(Visitor V) {
		V.visitPowerUp(this);
		return true;
	}
	public abstract void AplicarPowerUP(Jugador J);


}

