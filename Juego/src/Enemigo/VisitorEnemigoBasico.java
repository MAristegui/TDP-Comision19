package Enemigo;

import Abstract.*;
import Jugador.Jugador;
import Mapa.Agua;
import Mapa.Celda;
import Mapa.Roca;
import PowerUp.*;

public class VisitorEnemigoBasico extends Visitor {


	@Override
	public boolean VisitEnemigo(Enemigo E) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitPlayer(Jugador P) {
		System.out.println("SON TODOS PUTOS SI2");
		return false;
	}

	@Override
	public boolean VisitAgua(Agua A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitRoca(Roca R) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitDisparoA(DisparoA da) {
		Enemigo enem=(EnemigoBasico) o;
		da.getTanque().EliminarDisparo(da);
		enem.disminuirVida();
		return false;
	}

	@Override
	public boolean VisitPowerUp(PowerUp P) {
		// TODO Auto-generated method stub
		return false;
	}

}
