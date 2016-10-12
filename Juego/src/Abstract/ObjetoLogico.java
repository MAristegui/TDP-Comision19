package Abstract;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
public abstract class ObjetoLogico{
	
	//atributos comunes
	protected JLabel grafico;
	protected Celda celda;
    protected static final int width=32;
    protected static final int height=32;
    protected Visitor V;
    public JLabel getGrafico(){
    	return grafico;}
    public void setGraph(ImageIcon i){
    	grafico.setIcon(i);
    }
    
   public abstract boolean Aceptar(Visitor V);
   
   public void destruir(){
	  setGraph(null);
	  celda.setObject(null);
	 
	}
	
}
