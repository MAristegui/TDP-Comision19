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
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/AumentarDisparo.png")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.AumentarDisparos();
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}



	
	
	
}
