package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;
import main.Visitor;
import mapa.celda;
import jugador.Jugador;

public class ConvertirAcero extends PowerUp{
	public ConvertirAcero(celda c,int prof){
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_CA.png")));
	}

	
	public void AplicarPowerUP(Jugador J) {
	    GUI.playSound("convertirAcero.wav");
		cell.mejorar();
		this.destruir();
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}
}
