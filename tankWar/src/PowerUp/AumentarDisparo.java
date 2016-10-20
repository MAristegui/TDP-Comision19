package PowerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.*;
import unidades.Jugador;
import mapa.*;

public class AumentarDisparo extends PowerUp {
	
	public AumentarDisparo(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("C:/Users/mudo/Downloads/TDP-Comision19-master (1)/TDP-Comision19-master/tankWar/src/resourcesAumentarDisparo.png")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.AumentarDisparos();
		this.destruir();
	}



	@Override
	public boolean Accept(Visitor V) {
		return V.VisitPowerUp(this);
	}



	
	
	
}
