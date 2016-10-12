package PowerUp;

import Abstract.DisparoA;
import Abstract.Visitor;
import Enemigo.Enemigo;
import Jugador.Jugador;
import Mapa.Agua;
import Mapa.Roca;

public class VisitorPowerUP extends Visitor {

	@Override
	public boolean VisitEnemigo(Enemigo E) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitPlayer(Jugador P) {
		
		return true;
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitPowerUp(PowerUp P) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
