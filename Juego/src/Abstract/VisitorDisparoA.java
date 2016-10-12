package Abstract;

import Enemigo.Enemigo;
import Jugador.Jugador;
import Mapa.Agua;
import Mapa.Roca;
import PowerUp.PowerUp;

public class VisitorDisparoA extends Visitor{
	
	

	@Override
	public boolean VisitEnemigo(Enemigo E) {
		E.disminuirVida();
		Disparo p=(DisparoA) o;
		p.getTanque().EliminarDisparo(p);
		return false;
	}

	@Override
	public boolean VisitPlayer(Jugador P) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitAgua(Agua A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitRoca(Roca R) {
		R.destruir();
		return false;
	}

	@Override
	public boolean VisitDisparoA(DisparoA da) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitPowerUp(PowerUp P) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
