package Abstract;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.util.*;
import Mapa.Celda;

public abstract class Unidad extends ObjetoLogico{
    
	//atributos
	protected int velocidad;
	protected Icon[] Imagen;
//	

	protected int dirActual;
	//constructor
	protected Unidad(int v,Celda C){
		velocidad=v;
		celda=C;
	//	disparos=new LinkedList<DisparoA>();
	//	cantDisparos=1;
		dirActual=0;
		//disparos=new LinkedList<DisparoA>();
	}
	
	//metodos y consultas

	public int getVelocidad(){
		return velocidad;
	}
	
	public void setVelocidad(int v){
		velocidad=v;
	}
	   public JLabel getGrafico(){
			if(this.grafico == null){
				this.grafico = new JLabel(Imagen[0]);
			}
			
			return this.grafico;
		}
	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.Imagen[dir]);
		}
	}
	
	protected void aXb(Celda a){
		a.setObject(this);
		celda.setObject(null);
		celda=a;
		System.out.println(a.getX());
		System.out.println(a.getY());
	}

	public boolean mover(int dir )
    { Celda C;
    boolean puedo=true;
    	switch (dir) {
		case 0 : //Arriba
			 C= celda.getCelda(celda.getX(),celda.getY()+1);
				if(C!=null)
				{
					if(C.getObject()==null)
						aXb(C);
					else
						if(C.getObject().Colision(this))
							aXb(C);
						else
							puedo=false;
					
				}
				else
					puedo=false;
			break;
		case 1 : //Izquierda
			 C= celda.getCelda(celda.getX()-1,celda.getY());
				if(C!=null)
				{
					if(C.getObject()==null)
						aXb(C);
					else
						if(C.getObject().Colision(this))
							aXb(C);
						else
							puedo=false;
					
				}
				else
					puedo=false;
			break;
		case 2 : //Abajo
			 C= celda.getCelda(celda.getX(),celda.getY()-1);
				if(C!=null)
				{
					if(C.getObject()==null)
						aXb(C);
					else
						if(C.getObject().Colision(this))
							aXb(C);
						else
							puedo=false;
					
				}
				else
					puedo=false;
			break;
		case 3 : //Derecha
			 C= celda.getCelda(celda.getX()+1,celda.getY());
				if(C!=null)
				{
					if(C.getObject()==null)
						aXb(C);
					else
						if(C.getObject().Colision(this))
							aXb(C);
						else
							puedo=false;
					
				}
				else
					puedo=false;
			break;
			
	}
    	cambiarGrafico(dir);
    	dirActual=dir;
    	return puedo;
	
}
public boolean Colision(ObjetoLogico o){
	return o.Colision(this);
}
	
	
}
