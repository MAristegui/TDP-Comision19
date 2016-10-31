package main;
import gui.GUI;
import jugador.Jugador;

import java.awt.event.KeyEvent;

import mapa.map;
public class Juego {
	private map m;
	private Jugador jugador;
   public Juego(GUI gui){
	   map mapa=new map(gui);
	   
	  jugador=mapa.getJugador();
	  
   }
   public void mover(int dir){
	   int direccion = 0;
		switch (dir){
			case KeyEvent.VK_UP : //Arriba
				direccion = 2;
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 1;
				break;
			case KeyEvent.VK_DOWN : //Abajo
				direccion = 0;
				break;	
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 3;
				break;
			case KeyEvent.VK_SPACE : //Espacio
				direccion=4;
				break;
		}
		jugador.mover(direccion);
   }
public boolean Victory() {
	
	return m.Victory();
}
public boolean Finish() {

	return m.finish();
}
}
