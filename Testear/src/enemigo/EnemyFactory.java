package enemigo;

import java.util.Random;

import mapa.celda;

public class EnemyFactory {
  
	public Enemigo crearEnemigo(celda c,int prof,int tipo){
		Random rnd=new Random();
		int i=rnd.nextInt(4);
		Enemigo e=null;
		switch(i){
		case 0:
			e=new EnemigoBasico(c,prof,tipo);
			break;
		case 1:
			e=new EnemigoPoder(c,prof,tipo);
			break;
		case 2:
			e=new EnemigoRapido(c,prof,tipo);
			break;
		case 3:
			e=new EnemigoBlindado(c,prof,tipo);
		 break;
		}
		return e;
	}
}
