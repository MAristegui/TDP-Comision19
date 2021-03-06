package disparo;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;
import jugador.Jugador;
import main.Unidad;
import main.Visitor;
import mapa.celda;

public class DisparoPlayer extends Disparo{
    public DisparoPlayer(celda C, Unidad j, int prof,int speed){
       super(C,j,prof,speed);
	   V=new VisitorDisparoPlayer(this);
 	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
  	   grafico.setBounds(32+16*cell.getPosX(), 128+16*cell.getPosY(), 16, 16);
	   cell.getGui().add(grafico,new Integer(2));
  	   graficos=new Icon[4];
	   graficos[0]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[1]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[2]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
	   graficos[3]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
  	   new DisparoRun(this,dirActual);
    }

    	 public void destruir(){
      	   super.destruir();
      	   
      	   Jugador jug=(Jugador)j;
      	   jug.restarDisparosEnEjecucion();
      	 GUI.playSound("disparoColision.wav");
      	   
         }
    	 public boolean Accept(Visitor V){
    		 return V.visitDisparoPlayer(this);
    	 }
    
}
