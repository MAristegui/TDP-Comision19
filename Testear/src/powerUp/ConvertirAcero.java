package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		cell.mejorar();
		this.destruir();
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}
}
