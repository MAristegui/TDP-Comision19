package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import obstaculos.Acero;
public class Nivel4 extends State{
	public Nivel4(Jugador jugador){
    	this.jugador=jugador;
    	velocidad_jugador=16;
    	velocidad_disparo=6;
 	    disparos_simultaneos=3;
 	    resistencia=4;
 	    disparos_en_ejecucion=0;
    }
    public State lvlUp(){
    	return null;
    }
    public void setGraficos(Icon[] graficos, JLabel grafico){
    	graficos[0]=new ImageIcon(this.getClass().getResource("/resources/megaCharizard0.gif"));
     	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/megaCharizard1.gif"));
     	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/megaCharizard2.gif"));
     	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/megaCharizard3.gif"));
      	 grafico.setIcon(graficos[jugador.getDireccion()]);
       }
    public void dañarAcero(Acero a){
    	a.dañar(1);
    }
}
