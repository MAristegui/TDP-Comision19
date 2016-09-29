package Abstract;
import Mapa.*;
import java.util.*;

import javax.swing.JLabel;

public class Tanque extends Unidad {

	protected int cantDisparos;
	protected List<DisparoA> disparos; 
	protected int resistencia;
	
	protected Tanque(int v,int r,Celda c){
	super(v,c);
	resistencia=r;
	}
	
	public int getResistencia(){
		return resistencia;
	}
	public void setResistencia(int r){
		resistencia=r;
	}
 
    /* protected void Aumentardisparos(){
    cantDisparos++;
    }
    protected Boolean disparar()
	{
		if (disparos.size()<cantDisparos)
		{
			Celda C;
			
			switch(dirActual)
			{
				case 0 :
					C=celda.getCelda(celda.getX(), celda.getY()+1);
				case 1 :
					C=celda.getCelda(celda.getX()-1, celda.getY());
				case 2 :
					C=celda.getCelda(celda.getX(), celda.getY()-1);
				case 3 :
					C=celda.getCelda(celda.getX()+1, celda.getY());
					
					DisparoA d=new DisparoA(1,1,C,this);
					disparos.add(d);
					C.setObject(d);
					while(true)
					{	d.mover(dirActual);
					switch(dirActual){
					case 0 :
						C=celda.getCelda(celda.getX(), celda.getY()+1);
					case 1 :
						C=celda.getCelda(celda.getX()-1, celda.getY());
					case 2 :
						C=celda.getCelda(celda.getX(), celda.getY()-1);
					case 3 :
						C=celda.getCelda(celda.getX()+1, celda.getY());
					
						if(C==null)
							break;
					}
					}
			//agregar el disparo al mapa
			}
		}
		return true;
	}
	
	protected void EliminarDisparo(Disparo d)
	{//estoy se eje
			disparos.remove(d);
					
	}
		*/
	

	public boolean disminuirVida()
	{
		resistencia--;
		return (resistencia==0);
	}
	public boolean Colision(Tanque t){
		return false;
	}
	
}
