package Abstract;
import javax.swing.*;

import Jugador.Jugador;

import java.awt.event.*;
import Enemigo.*;
import Mapa.Mapa;
import resources.*;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Random;
import Mapa.*;
public class Juego {
	private Jugador jugador;
	private Enemigo E;
	private Mapa map;
	private Celda[][] celdas;
	private Timer t;
	private GUI gui;
	private Juego J;
	private int contTiempo;
	private boolean moviendo=false;
	private Collection Enemigos;
	public Juego(final GUI gui){
		contTiempo=0;
		this.gui=gui;
		map=new Mapa(20,20);
		celdas=map.getCeldas();
		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/FondoMapa2.png")));
		fondo.setBounds(0, 0, 640, 640);
		J=this;
		gui.add(fondo,new Integer(-1));
		jugador = new Jugador(5,3,1,celdas[8][8]);
		new Thread(jugador).start();
		JLabel graficoJugador= jugador.getGrafico();
		graficoJugador.setOpaque(false);
		gui.add(graficoJugador,new Integer(1));
		graficoJugador.setBounds(celdas[8][8].getX()*32,celdas[8][8].getY()*32,32,32);
		
		for(int i=0;i<celdas.length;i++)
			for(int j=0;j<celdas[0].length;j++)
						{
								if (celdas[i][j]!=null)//celda no nula
								{	//celda tiene GameObject
									if (celdas[i][j].getObject()!=null){
										JLabel gr=celdas[i][j].getObject().getGrafico();
										gui.add(gr,new Integer(0));
										gr.setBounds(i*32,j*32,32,32);
										gr.setVisible(true);
										gui.repaint();
									}
								}
															
				
	}
		final JButton EliminarEnemigo=new JButton("Eliminar Enemigo.");
		EliminarEnemigo.setBounds(0,640,327,32);
		EliminarEnemigo.setFocusable(false);
		EliminarEnemigo.setVisible(false);
		JLabel puntaje=new JLabel("Puntaje: ");
		final JLabel puntajeInt=new JLabel("0");
		puntajeInt.setBounds(320,673,100,32);
		puntaje.setBounds(270,673,100,32);
		
		final JButton AgregarEnemigo=new JButton("Agregar Enemigo.");
		AgregarEnemigo.setBounds(0,640,327,32);
		AgregarEnemigo.setFocusable(false);
		AgregarEnemigo.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  Enemigo enemigoPrueba=new EnemigoBasico(5,3,celdas[9][9],200,J);
				  new Thread(enemigoPrueba).start();
				  celdas[9][9].setObject(enemigoPrueba);
				    JLabel graficoEnemigo= enemigoPrueba.getGrafico();
					graficoEnemigo.setOpaque(false);
					gui.add(graficoEnemigo,new Integer(4));
					graficoEnemigo.setBounds(celdas[9][9].getX()*32,celdas[9][9].getY()*32,32,32);
					E=enemigoPrueba;
					AgregarEnemigo.setVisible(false);
					AgregarEnemigo.setEnabled(false);
					EliminarEnemigo.setVisible(true);
					EliminarEnemigo.setEnabled(true);
					gui.repaint();
				  } 
				} );
		EliminarEnemigo.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  Enemigo enemigo=(Enemigo)celdas[9][9].getObject();
				  celdas[9][9].getObject().destruir();
				  jugador.setPuntaje(jugador.getPuntaje()+enemigo.getPuntaje());
				  puntajeInt.setText(""+jugador.getPuntaje());
				  
				  AgregarEnemigo.setVisible(true);
					AgregarEnemigo.setEnabled(true);
					EliminarEnemigo.setVisible(false);
					EliminarEnemigo.setEnabled(false); 
			  }
			  }
		);
		
		
		final JButton EliminarPiedra=new JButton("Eliminar Piedra.");
		EliminarPiedra.setBounds(327,640,328,32);
		EliminarPiedra.setFocusable(false);
		EliminarPiedra.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    celdas[11][8].getObject().destruir();
			    EliminarPiedra.setEnabled(false);
			  } 
			} );
		
		
		gui.add(EliminarPiedra);
		gui.add(EliminarEnemigo);
		gui.add(AgregarEnemigo);
		gui.add(puntajeInt);
		gui.add(puntaje);
		
	}
	private void moverAux(int dir){
		JLabel graficoJugador= jugador.getGrafico();
		if(dir==2&&contTiempo!=32){
			graficoJugador.setBounds(graficoJugador.getBounds().x,graficoJugador.getBounds().y-1,32,32);
			contTiempo++;
		}
		else
			if(dir==1&&contTiempo!=32){
				graficoJugador.setBounds(graficoJugador.getBounds().x-1,graficoJugador.getBounds().y,32,32);	
			contTiempo++;				
			}
			else
				if(dir==3&&contTiempo!=32){
					graficoJugador.setBounds(graficoJugador.getBounds().x+1,graficoJugador.getBounds().y,32,32);	
				contTiempo++;
				}
				else
					if(dir==0&&contTiempo!=32){
						graficoJugador.setBounds(graficoJugador.getBounds().x,graficoJugador.getBounds().y+1,32,32);	
					contTiempo++;
					}
		if(contTiempo==32){
			t.stop();
			contTiempo=0;
			moviendo=false;
		}
	}
	
	public void mover(int dir){	
		
		if(!moviendo){
			moviendo=true;
		int direccion = 0;
		switch (dir){
			case KeyEvent.VK_SPACE :
				System.out.println("ROBERTO");
				jugador.disparar();	
				break;
			case KeyEvent.VK_UP : //Arriba
				direccion = 2;
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 1;
				break;
			case KeyEvent.VK_DOWN : //Abajo
				direccion = 0;
				break;	
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 3;
				break;	
		}
		
		boolean puedoMover=jugador.mover(direccion);
	
		if(puedoMover)
			switch(direccion){
			case 2:
			ActionListener accion2= new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
		        moverAux(2);
				}
			};
	      
			t=new Timer(3,accion2);
	        t.start();
	   //     gui.repaint();

			break;
			case 1:
				ActionListener accion1= new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
			        moverAux(1);
					}
				};
		      
				t=new Timer(3,accion1);
		        t.start();
		      //  gui.repaint();	
			break;
			case 0: ActionListener accion0= new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
			        moverAux(0);
					}
				};
		      
				t=new Timer(3,accion0);
		        t.start();
		       // gui.repaint();
			break;
			case 3: ActionListener accion3= new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
			        moverAux(3);
					}
				};
		      
				t=new Timer(3,accion3);
		        t.start();
		       // gui.repaint();
		        break;
			}
		else
			moviendo=false;
		
		
		
	}
		
	}

	private void mAMA(int dir){
		JLabel graficoEnemigo= E.getGrafico();
		if(dir==2&&contTiempo!=32){
			graficoEnemigo.setBounds(graficoEnemigo.getBounds().x,graficoEnemigo.getBounds().y-1,32,32);
			contTiempo++;
		}
		else
			if(dir==1&&contTiempo!=32){
				graficoEnemigo.setBounds(graficoEnemigo.getBounds().x-1,graficoEnemigo.getBounds().y,32,32);	
			contTiempo++;				
			}
			else
				if(dir==3&&contTiempo!=32){
					graficoEnemigo.setBounds(graficoEnemigo.getBounds().x+1,graficoEnemigo.getBounds().y,32,32);	
				contTiempo++;
				}
				else
					if(dir==0&&contTiempo!=32){
						graficoEnemigo.setBounds(graficoEnemigo.getBounds().x,graficoEnemigo.getBounds().y+1,32,32);	
					contTiempo++;
					}
		if(contTiempo==32){
			t.stop();
			contTiempo=0;
		}
	}
	public void MOIE(int dir){
		
		boolean puedoMover=E.mover(dir);
	
	if(puedoMover)
		switch(dir){
		case 2:
		ActionListener accion2= new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				mAMA(2);
			}
		};
      
		t=new Timer(3,accion2);
        t.start();
   //     gui.repaint();

		break;
		case 1:
			ActionListener accion1= new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
				mAMA(1);
				}
			};
	      
			t=new Timer(3,accion1);
	        t.start();
	      //  gui.repaint();	
		break;
		case 0: ActionListener accion0= new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					mAMA(0);
				}
			};
	      
			t=new Timer(3,accion0);
	        t.start();
	       // gui.repaint();
		break;
		case 3: ActionListener accion3= new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					mAMA(3);
				}
			};
	      
			t=new Timer(3,accion3);
	        t.start();
	       // gui.repaint();
	        break;
		}
	else
		moviendo=false;
	
	
	
}
	
}




