package Abstract;
import Enemigo.*;
import Mapa.*;
import Jugador.*;
import PowerUp.*;

public abstract class Visitor {
	
	protected ObjetoLogico o;

public abstract boolean VisitEnemigo(Enemigo E);

public abstract boolean VisitPlayer(Jugador P);

public abstract boolean VisitAgua(Agua A);

public abstract boolean VisitRoca(Roca R);

public abstract boolean VisitDisparoA(DisparoA da);

public abstract boolean VisitPowerUp(PowerUp P);

//public abstract boolean VisitDisparoE(DisparoE de);
public ObjetoLogico getObjeto(){
	return o;
}

}
