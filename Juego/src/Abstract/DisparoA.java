package Abstract;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

public class DisparoA extends Disparo{
	private boolean viajando;
	public DisparoA(int v, int r,Celda C,Unidad u){
		super(v, r, C, u);
		this.Imagen=new Icon[4];
		this.Imagen[2] = new ImageIcon(this.getClass().getResource("/resources/playerUp.gif"));
		this.Imagen[0] = new ImageIcon(this.getClass().getResource("/resources/playerDown.gif"));
		this.Imagen[1] = new ImageIcon(this.getClass().getResource("/resources/playerLeft.gif"));
		this.Imagen[3] = new ImageIcon(this.getClass().getResource("/resources/playerRight.gif"));
	
	}
	
	 public boolean Aceptar(Visitor V){
		 viajando =V.VisitDisparoA(this);
		 return viajando;
	 }

	@Override
	public void run() 
	{	while(true)
		if(!viajando){
			
			IsRunnable=false;
			break;
		}
	}
}
