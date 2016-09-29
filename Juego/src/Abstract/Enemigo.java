package Abstract;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.*;
public class Enemigo extends Tanque{
	protected int puntaje;
	public Enemigo(int v, int r, Celda c,int p){
		super(v,r,c);
		puntaje=p;
		grafico=new JLabel();
		grafico.setIcon( new ImageIcon(this.getClass().getResource("/resources/Enemigo.png")));
	}
	public int getPuntaje(){
		return puntaje;
	}
	public boolean Colision(ObjetoLogico o){
		return false;
	}
}
