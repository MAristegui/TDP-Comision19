package unidades;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Visitor;
import mapa.celda;
public class Disparo extends Unidad  {
	private Jugador j;
	
       public Disparo(celda C, Jugador j, int prof){
    	   profundidad=prof;
    	   isRunnable=true;
    	   this.j=j;
    	   dirActual=j.getDireccion();
    	   V=new VisitorDisparo(this);
    	   cell=C;
    	   cell.getObjects()[3]=this;
    	   speed=2;
    	   grafico=new JLabel();
      	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
      	   grafico.setBounds(32+16*cell.getPosX(), 128+16*cell.getPosY(), 16, 16);
		   cell.getGui().add(grafico,new Integer(2));
      	   graficos=new Icon[4];
    	   graficos[0]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
    	   graficos[1]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
    	   graficos[2]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
    	   graficos[3]=new ImageIcon(this.getClass().getResource("/resources/disparo.png"));
      	   DisparoRun d=new DisparoRun(this,dirActual);
       }

       
       public boolean Accept(Visitor Vis){
    	   return Vis.visitDisparo(this);
       }
       public boolean getIsRunnable(){
    	   
    	   return isRunnable;
       }
}
