package powerUp;

import gui.GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.Visitor;
import mapa.celda;

public class Invulnerable extends PowerUp{

	public Invulnerable(celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/pokeball.png")));
	}

	public void AplicarPowerUP(Jugador J) {
		GUI.playSound("Invulnerable.wav");
		J.setInvulnerable();
		this.destruir();
	}

	public boolean Accept(Visitor V) {
		
		return V.visitPowerUp(this);
	}

}
