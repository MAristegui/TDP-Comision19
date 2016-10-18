package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.celda;
import main.Visitor;

public class Grass extends obstaculo  {
	public Grass(celda c, char tipo,int prof){
		   profundidad=prof;
		   cell=c;
		   grafico=new JLabel();
		   grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/"+tipo+".png")));
	   }
	public boolean Accept(Visitor V){
		return V.visitGrass(this);
	}
}
