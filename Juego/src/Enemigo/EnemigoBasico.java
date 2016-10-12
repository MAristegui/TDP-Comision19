package Enemigo;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Abstract.*;
import Mapa.Celda;

public class EnemigoBasico extends Enemigo {
// ELIMINAR METDOOS MOIE y MAAM DE JUEGO, JUNTO CON SU ATRIBUTO J. y eliminar ESTE ATRIBUTO TAMBIEN(MODIFICAR
	//INVOCACIONES Y DECLARACION DE ENEMIGOBASICO)
	protected Juego J;
	
	public EnemigoBasico(int v, int r, Celda c, int p, Juego J) {
		super(v, r, c, p);
		this.J=J;
		this.Imagen=new Icon[4];
		V=new VisitorEnemigoBasico();
		this.Imagen[2] = new ImageIcon(this.getClass().getResource("/resources/Enemigo.png"));
		this.Imagen[0] = new ImageIcon(this.getClass().getResource("/resources/Enemigo.png"));
		this.Imagen[1] = new ImageIcon(this.getClass().getResource("/resources/Enemigo.png"));
		this.Imagen[3] = new ImageIcon(this.getClass().getResource("/resources/Enemigo.png"));
		// TODO Auto-generated constructor stub
	}

	public boolean Aceptar(Visitor V) {
		return (V.VisitEnemigo(this));
	
	}

	@Override
	public void run() {
		Random r=new Random();
		// TODO Auto-generated method stub
	while(true){
		int mov=r.nextInt(4);
		System.out.println("ROBERSTO SE MUEVE");
		System.out.println(mov);
		J.MOIE(mov);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resistencia==0)
			{
			IsRunnable=false;
			celda.eliminarEnemigo(this);
			}
		}
	}
	
	
}
