package unidades;
import mapa.celda;
import javax.swing.*;

import main.Visitor;
public class Jugador extends Unidad{
     protected int vidas;
     protected int puntaje;

     
     public Jugador(celda c,int prof){
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 cell=c;
    	 vidas=3;
    	 speed=15;
    	 puntaje=0;
    	 graficos=new Icon[4];
    	 graficos[0]=new ImageIcon(this.getClass().getResource("/resources/down.png"));
    	 graficos[1]=new ImageIcon(this.getClass().getResource("/resources/up.png"));
    	 graficos[2]=new ImageIcon(this.getClass().getResource("/resources/right.png"));
    	 graficos[3]=new ImageIcon(this.getClass().getResource("/resources/left.png"));
    	 grafico=new JLabel();
    	 grafico.setIcon(graficos[1]);
    	 
    	 
    	 
     }
     public boolean Accept(Visitor V){
    	 return V.visitPlayer(this);
     }
     public int getPuntaje(){
    	 return puntaje;
     }
     public void setPuntaje(int p){
    	 puntaje=p;
     }
     public int getVidas(){
    	 return vidas;
     }
     public void AumentarDisparos()
     {
     }
}
