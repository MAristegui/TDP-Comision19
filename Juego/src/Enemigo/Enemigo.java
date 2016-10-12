package Enemigo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Abstract.*;

import Mapa.*;
public abstract class Enemigo extends Tanque{
	protected int puntaje;
	public Enemigo(int v, int r, Celda c,int p){
		super(v,r,c);
		puntaje=p;
		grafico=new JLabel();
	}
	public int getPuntaje(){
		return puntaje;
	}

}
