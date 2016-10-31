package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;
import jugador.Jugador;

public class Estrella extends PowerUp{

	
	
	public Estrella(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AD.gif")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.lvlUp();
		System.out.println("SUBI EL LVL PAPU");
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}

}
