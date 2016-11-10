package jugador;

import disparo.DisparoEnemigo;
import main.gameObject;

public class VisitorJugadorInvulnerable extends VisitorJugador{
	public VisitorJugadorInvulnerable(gameObject o){
    	super(o);
    }
	public boolean visitDisparoEnemigo(DisparoEnemigo d){
		d.destruir();
		return false;
	}
}
