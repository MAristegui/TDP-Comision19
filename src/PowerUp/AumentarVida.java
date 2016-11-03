package powerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.*;
import mapa.*;

public class AumentarVida extends PowerUp {
	
	public AumentarVida(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AV.gif")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.setVidas(J.getVidas()+1);
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}



	
	
	
}