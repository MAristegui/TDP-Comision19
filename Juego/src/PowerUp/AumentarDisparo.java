package PowerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Abstract.ObjetoLogico;
import Abstract.Visitor;
import Jugador.Jugador;
import Mapa.*;

public class AumentarDisparo extends PowerUp {
	
	public AumentarDisparo(Celda c) {
		super(c);
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/AumentarDisparo.png")));
	}

	
	
	public void AplicarPowerUP(Jugador J){
		J.AumentarDisparos();
		celda.getObject().setGraph(null);
		celda.setObject(null);
	}
	
	
	
}
