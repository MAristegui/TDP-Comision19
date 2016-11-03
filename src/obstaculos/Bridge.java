package obstaculos;
import javax.swing.*;
import main.Visitor;
import mapa.celda;
public class Bridge extends obstaculo  {
   public Bridge(celda c, char tipo,int profundidad){
	   cell=c;
	   grafico=new JLabel();
	   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+".png")));
   }
   
   public boolean Accept(Visitor V){
	   return V.visitBridge(this);	   
   }
}
