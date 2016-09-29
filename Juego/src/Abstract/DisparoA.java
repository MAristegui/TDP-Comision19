package Abstract;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

public class DisparoA extends Disparo{
	
	public DisparoA(int v, int r,Celda C,Unidad u){
		super(v, r, C, u);
	
	}
	
	public boolean Colision(ObjetoLogico o){
		
		return true;
		
	}
}
