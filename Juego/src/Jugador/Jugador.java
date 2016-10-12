package Jugador;
import java.awt.Point;
import Mapa.Celda;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Abstract.Tanque;
import Abstract.Visitor;
public class Jugador extends Tanque{
    //atributos
	private int vidas;
	private int puntaje;
	private State nivel;
	//constructor
	public Jugador(int velocidad,int resistencia, int vidas,Celda c){
		super(velocidad,resistencia,c);
		V= new VisitorJugador(this);
		this.vidas=vidas;
		this.Imagen=new Icon[4];
		this.Imagen[2] = new ImageIcon(this.getClass().getResource("/resources/playerUp.gif"));
		this.Imagen[0] = new ImageIcon(this.getClass().getResource("/resources/playerDown.gif"));
		this.Imagen[1] = new ImageIcon(this.getClass().getResource("/resources/playerLeft.gif"));
		this.Imagen[3] = new ImageIcon(this.getClass().getResource("/resources/playerRight.gif"));
		grafico=new JLabel();
	    this.grafico.setIcon(this.Imagen[0]);
	    puntaje=0;
	    nivel=new Nivel1();
	}
	
	public void setPuntaje(int p){
		puntaje=p;
	}
	public int getPuntaje(){
		return puntaje;
	}
	

	//metodos

	@Override
	public boolean Aceptar(Visitor V) {
		return (V.VisitPlayer(this));
	
	}
	
	public void AumentarDisparos(){
		cantDisparos++;
	}

	@Override
	public void run() {
		while(true){
			if (resistencia==0)
				//vida--; "segundos de invunerabilidad".
			if (vidas==0) {
				System.out.println("SOS PUTO JAJAJJA");
				IsRunnable=false;
			}
		}
		
	}
	
	
}