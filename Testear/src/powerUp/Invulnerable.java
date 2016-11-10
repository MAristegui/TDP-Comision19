package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.Visitor;
import mapa.celda;

public class Invulnerable extends PowerUp {

	private Thread t;
	public Invulnerable(celda c,int prof) {
		super(c,prof);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AD.gif")));
		t=new Thread();
	}

	
	
	public void AplicarPowerUP(Jugador J){
		System.out.println("HGOLACASCO");
		J.setInvulnerable();
		this.destruir();
	}



	
	public boolean Accept(Visitor V) {
		return V.visitPowerUp(this);
	}




}
