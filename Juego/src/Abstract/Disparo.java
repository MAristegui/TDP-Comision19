package Abstract;

import Mapa.Celda;

public abstract class Disparo extends Unidad{
	
	
private Unidad u;

public Disparo(int v, int r, Celda c, Unidad u2) {
	super(v,c);
	this.u=u;
}

public boolean Colision(ObjetoLogico o)
{
	Unidad aux=(Unidad) o;
	//aux.disminuirVida();
	return true;
}


}
