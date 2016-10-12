package Jugador;

import Abstract.*;
import Enemigo.Enemigo;
import Mapa.Agua;
import Mapa.Roca;
import PowerUp.*;

public class VisitorJugador extends Visitor {
	
	public VisitorJugador(ObjetoLogico O){
		o=O;
	}

	@Override
	public boolean VisitEnemigo(Enemigo E) {
		System.out.println("SON TODOS PUTOS SI");
		return false;
	}

	@Override
	public boolean VisitPlayer(Jugador P) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitAgua(Agua A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitRoca(Roca R) {
		return false;
	}

	@Override
	public boolean VisitDisparoA(DisparoA da) {
		return false;
	}

	@Override
	public boolean VisitPowerUp(PowerUp P) {
		P.AplicarPowerUP((Jugador) o);
		System.out.println("SABEEE");
		return true;
	}

}
