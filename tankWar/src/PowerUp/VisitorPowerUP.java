package PowerUp;

import main.*;
import unidades.*;
import mapa.*;
import obstaculos.*;

public class VisitorPowerUP extends Visitor {

	@Override
	public boolean VisitRock(Rock r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitWater(Water w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPared(Pared p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitGrass(Grass g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		PowerUp p=(PowerUp) objeto;
		p.AplicarPowerUP(j);
		return true;
	}

	@Override
	public boolean visitBridge(Bridge b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitDisparo(Disparo d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitPowerUp(PowerUp p) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
