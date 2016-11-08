package powerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.*;
import mapa.*;

public class AumentarNivel extends PowerUp {
	
	public AumentarNivel(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AD.gif")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.lvlUp();
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}



	
	
	
}
