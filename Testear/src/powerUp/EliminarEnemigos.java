package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;
import jugador.Jugador;
import main.Visitor;
import mapa.celda;

public class EliminarEnemigos extends PowerUp{
	public EliminarEnemigos(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_EE.gif")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		 GUI.playSound("eliminarEnemigos.wav");
		J.eliminarEnemigos();
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}
}
