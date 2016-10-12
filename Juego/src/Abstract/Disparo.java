package Abstract;

import Mapa.Celda;

public abstract class Disparo extends Unidad{
	

protected boolean movido;
protected Unidad u;

public Disparo(int v, int r, Celda c, Unidad u) {
	super(v,c);
	this.u=u;
	movido=false;
}
public Tanque getTanque()
{
	return (Tanque) u;
}

}
