package powerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;
import jugador.Jugador;
import mapa.*;
import main.*;

public abstract class PowerUp extends gameObject {
	
	private JLabel graficoBrillo;

	protected PowerUp(celda c,int prof){
		GUI.playSound("aparecePowerUp.wav");
		cell=c;
		profundidad=prof;
	}
	public boolean Aceptar(Visitor V) {
		return V.visitPowerUp(this);
	}
	public abstract void AplicarPowerUP(Jugador J);
	public JLabel getGraficoBrillo() {
		graficoBrillo=new JLabel();
		graficoBrillo.setIcon(new ImageIcon(this.getClass().getResource("/resources/Power_up.gif")));
		return graficoBrillo;
	}

   public void destruir(){
	   super.destruir();
	   graficoBrillo.setIcon(null);
   }
}

