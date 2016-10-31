package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;
import jugador.Jugador;

public class Pala extends PowerUp{
	public Pala(celda c,int prof){
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_EE.gif")));
	}

	
	public void AplicarPowerUP(Jugador J) {
		J.mejorar();
		System.out.println("PALA");
		this.destruir();
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}
}
