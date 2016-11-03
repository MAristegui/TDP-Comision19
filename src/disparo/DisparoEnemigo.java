package disparo;
import mapa.celda;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Unidad;
import main.Visitor;
public class DisparoEnemigo extends Disparo{
   public DisparoEnemigo(celda c,Unidad e, int prof,int speed,int tipo){
	   super(c,e,prof,speed);
	   grafico=new JLabel();
  	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/disparoEnemigo"+tipo+".png")));
  	   grafico.setBounds(32+16*cell.getPosX(), 128+16*cell.getPosY(), 16, 16);
	   cell.getGui().add(grafico,new Integer(2));
  	   graficos=new Icon[4];
	   graficos[0]=new ImageIcon(this.getClass().getResource("/resources/disparoEnemigo"+tipo+".png"));
	   graficos[1]=new ImageIcon(this.getClass().getResource("/resources/disparoEnemigo"+tipo+".png"));
	   graficos[2]=new ImageIcon(this.getClass().getResource("/resources/disparoEnemigo"+tipo+".png"));
	   graficos[3]=new ImageIcon(this.getClass().getResource("/resources/disparoEnemigo"+tipo+".png"));
  	   DisparoRun d=new DisparoRun(this,dirActual);
	   V=new VisitorDisparoEnemigo(this);
   }
   public boolean Accept(Visitor V){
	   return V.visitDisparoEnemigo(this);
   }
}
