package PowerUp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Abstract.*;
import Mapa.*;

import resources.*;

import Mapa.*;
public abstract class PowerUp extends ObjetoLogico {
	
	protected PowerUp(Celda c){
		grafico=new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/playerUp.gif")));
		celda=c;
	}
	public abstract boolean Colision(ObjetoLogico o);

}
