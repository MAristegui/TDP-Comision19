package unidades;
import main.gameObject;

import javax.swing.JLabel;
import javax.swing.Icon;

import main.Visitor;
import mapa.celda;
public abstract class Unidad extends gameObject implements Runnable {
    protected int speed;
    protected Visitor V;
    protected Icon[] graficos;
    protected int dirActual=2;
    protected Thread t1;
    private volatile  boolean moviendo=false;
public void mover(int dir){
	 celda C;
	 
	    	switch (dir) {
			case 0 : //Abajo
				if(!moviendo){
				dirActual=0;
				grafico.setIcon(graficos[0]);
				C=cell.getCelda(cell.getPosX(), cell.getPosY()+1);
				if(C.getObjects()[1]!=null){ //Si no es piso 
					if(C.getObjects()[1].Accept(V)){
						C.getObjects()[profundidad]=this;
						cell.getObjects()[profundidad]=null;
						cell=C;
						moverGrafico();
						
					}
				}
				else{
					C.getObjects()[profundidad]=this;
					cell.getObjects()[profundidad]=null;
					cell=C;
					moverGrafico();
				}
				}
				break;
			case 1 : //Izquierda
				if(!moviendo){
				dirActual=1;
				 grafico.setIcon(graficos[3]);
				 C=cell.getCelda(cell.getPosX()-1, cell.getPosY());
					if(C.getObjects()[1]!=null){ //Si no es piso 
						if(C.getObjects()[1].Accept(V)){
							C.getObjects()[profundidad]=this;
							cell.getObjects()[profundidad]=null;
							cell=C;
							moverGrafico();
							
						}
					}
					else{
						C.getObjects()[profundidad]=this;
						cell.getObjects()[profundidad]=null;
						cell=C;
						moverGrafico();
			
					}
				}
				break;
			case 2 : //Arriba
				if(!moviendo){
				dirActual=2;
				grafico.setIcon(graficos[1]);
				
				C=cell.getCelda(cell.getPosX(), cell.getPosY()-1);
				if(C.getObjects()[1]!=null){ //Si no es piso 
					if(C.getObjects()[1].Accept(V)){
						C.getObjects()[profundidad]=this;
						cell.getObjects()[profundidad]=null;
						cell=C;
						moverGrafico();
					}
				}
				else{
					C.getObjects()[profundidad]=this;
					cell.getObjects()[profundidad]=null;
					cell=C;
					moverGrafico();
				}
				}
				break;
			case 3 : //Derecha
				if(!moviendo){
				dirActual=3;
				 grafico.setIcon(graficos[2]);
				 C=cell.getCelda(cell.getPosX()+1, cell.getPosY());
					if(C.getObjects()[1]!=null){ //Si no es piso 
						if(C.getObjects()[1].Accept(V)){
							C.getObjects()[profundidad]=this;
							cell.getObjects()[profundidad]=null;
							cell=C;
							moverGrafico();
						}
					}
					else{
						C.getObjects()[profundidad]=this;
						cell.getObjects()[profundidad]=null;
						cell=C;
						moverGrafico();
					}
				}
				break;
			case 4:
				
				Disparo d=new Disparo(cell,this,3);
				break;
			case 5:
				DisparoEnemigo d1=new DisparoEnemigo(cell,this,3);
				break;
				
		}

		
	
}
public int  getVelocidad(){
	 return speed;
}
  public void run(){
	  moviendo=true;
	  for(int i=0;i<16;i++){
		  switch(dirActual){
		  case 0:
			  grafico.setBounds(grafico.getX(), grafico.getY()+1, 16, 16);
			  break;
		  case 1:
			  grafico.setBounds(grafico.getX()-1, grafico.getY(), 16, 16);
			  break;
		  case 2:
			  grafico.setBounds(grafico.getX(), grafico.getY()-1, 16, 16);
			  break;
		  case 3:
			  grafico.setBounds(grafico.getX()+1, grafico.getY(), 16, 16);
			  break;
		  }
		  
		  try{
			  Thread.sleep(speed);
		  }catch(InterruptedException e){
			  
		  }
		  
	  }
	  moviendo=false;
  }
  
  public void moverGrafico(){
		  t1=new Thread(this);
		  t1.start();
	  
	  
	  
  }
  public int getDireccion(){
	  return dirActual;
  }

  public boolean getMoviendo()
  {
	  return moviendo;
  }
 
}