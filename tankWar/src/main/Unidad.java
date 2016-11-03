package main;
import javax.swing.JLabel;
import obstaculos.Acero;

import disparo.DisparoEnemigo;
import jugador.Jugador;

import javax.swing.Icon;

import mapa.celda;
public abstract class Unidad extends gameObject implements Runnable {
    protected int speed;
    protected Visitor V;
    protected Icon[] graficos;
    protected int dirActual=2;
    protected Thread t1;
    private volatile  boolean moviendo=false;
   
    
    public abstract void daņarAcero(Acero a);
public boolean mover(int dir){
	        boolean pude=false;
	        celda C;
	    	switch (dir) {
			case 0 : //Abajo
				if(!moviendo){
				dirActual=0;
				grafico.setIcon(graficos[0]);
				C=cell.getCelda(cell.getPosX(), cell.getPosY()+1);
				boolean acepto=true;
				for(int i=0;i<5&&acepto&&getIsRunning();i++){
					if(C.getObjects()[i]!=null){
						if(!C.getObjects()[i].Accept(V)){
							acepto=false;
						}
					}
				}
				if(acepto){
					pude=true;
					C=cell.getCelda(cell.getPosX(), cell.getPosY()+1);
					intercambiar_celdas(C);
				}
				}
				break;
			case 1 : //Izquierda
				if(!moviendo){
				dirActual=1;
				 grafico.setIcon(graficos[1]);
				 C=cell.getCelda(cell.getPosX()-1, cell.getPosY());
				 boolean acepto=true;
					for(int i=0;i<5&&acepto&&getIsRunning();i++){
						if(C.getObjects()[i]!=null){
							if(!C.getObjects()[i].Accept(V)){
								acepto=false;
							}
						}
					}
					if(acepto){
						pude=true;
						C=cell.getCelda(cell.getPosX()-1, cell.getPosY());
						intercambiar_celdas(C);
					}
				}
				break;
			case 2 : //Arriba
				if(!moviendo){
				dirActual=2;
				grafico.setIcon(graficos[2]);
				
				C=cell.getCelda(cell.getPosX(), cell.getPosY()-1);
				boolean acepto=true;
				for(int i=0;i<5&&acepto&&getIsRunning();i++){
					if(C.getObjects()[i]!=null){
						if(!C.getObjects()[i].Accept(V)){
							acepto=false;
						}
					}
				}
				if(acepto){
					pude=true;
					C=cell.getCelda(cell.getPosX(), cell.getPosY()-1);
					intercambiar_celdas(C);
				}
				}
				break;
			case 3 : //Derecha
				if(!moviendo){
				dirActual=3;
				 grafico.setIcon(graficos[3]);
				 C=cell.getCelda(cell.getPosX()+1, cell.getPosY());
				 boolean acepto=true;
					for(int i=0;i<5&&acepto&&isRunning;i++){
						if(C.getObjects()[i]!=null){
							if(!C.getObjects()[i].Accept(V)){
								acepto=false;
							}
						}
					}
					if(acepto){
						pude=true;
						C=cell.getCelda(cell.getPosX()+1, cell.getPosY());
						intercambiar_celdas(C);
					}
				}
				break;
			case 4:
				Jugador j=(Jugador)this;
				j.disparar();
				break;
				
		}

		
	return pude;
}
public void intercambiar_celdas(celda C){
	moviendo=true;
    C.getObjects()[profundidad]=this;
	cell.getObjects()[profundidad]=null;
	cell=C;
	moverGrafico();
}
public int  getVelocidad(){
	 return speed;
}
  public void run(){
	  for(int i=0;i<16&&isRunning;i++){
		  switch(dirActual){
		  case 0:
			  grafico.setBounds(grafico.getX(), grafico.getY()+1, getAncho(), getAlto());
			  break;
		  case 1:
			  grafico.setBounds(grafico.getX()-1, grafico.getY(), getAncho(), getAlto());
			  break;
		  case 2:
			  grafico.setBounds(grafico.getX(), grafico.getY()-1, getAncho(), getAlto());
			  break;
		  case 3:
			  grafico.setBounds(grafico.getX()+1, grafico.getY(), getAncho(), getAlto());
			  break;
		  }
		  
		  try{
			  Thread.sleep(getVelocidad());
		  }catch(InterruptedException e){
			  
		  }
		  
	  }
	  t1.interrupt();
	  moviendo=false;
  }
  
  public void moverGrafico(){
	      t1=new Thread(this);
		  t1.start();
	  
	  
	  
  }
  public void stopThread(){
	  t1.interrupt();
  }
  public int getDireccion(){
	  return dirActual;
  }
  public abstract int getAncho();
  public abstract int getAlto();

  public boolean getMoviendo()
  {
	  return moviendo;
  }
 
}