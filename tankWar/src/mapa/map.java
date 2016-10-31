package mapa;
import gui.GUI;
import gui.GameOver;
import jugador.Jugador;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import disparo.*;
import enemigo.Enemigo;
import enemigo.EnemigoBasico;
import enemigo.EnemigoBlindado;
import enemigo.EnemigoRapido;
import enemigo.EnemyFactory;
import main.gameObject;
import obstaculos.Acero;
import obstaculos.Aguila;
import powerUp.*;
public class map implements Runnable{
    private GUI gui;
    private celda[][] celdas;
    private Jugador player;
    private JLabel puntaje;
    private JLabel vidas;
    //private boolean gameOver=false;
    private EnemyFactory factory;
    private Collection<Enemigo> EnemigosActuales;
    protected Collection<celda> mejorables;
    private int Enemigos;
	private boolean perdiste;
	private boolean Ganaste;
	private int matados;
	private int score;
     public map(GUI migui){
    	 /*El mapa tiene una longitud de 27x27 celdas de 16 pixeles cada una.*/
    	 score=0;
    	 gui=migui;
    	 gui.setResizable(false);
    	 celdas=new celda[27][27];
    	 EnemigosActuales=new LinkedList<Enemigo>();
    	 try{
    	 inicializarCeldas();
    	 añadirJugador();
    	 puntaje=new JLabel("0");
    	 puntaje.setFont(new Font("Serif", Font.PLAIN, 20));
    	 puntaje.setForeground(Color.lightGray);
    	 puntaje.setBounds(517,140,100,32);
    	 gui.add(puntaje,new Integer(2));
    	 vidas=new JLabel("3");
    	 vidas.setFont(new Font("Serif",Font.PLAIN,20));
    	 vidas.setForeground(Color.lightGray);
    	 vidas.setBounds(517,235,100,32);
    	 Enemigos=16;
    	 perdiste=false;
    	 Ganaste=false;
    	 matados=0;
    	 gui.add(vidas,new Integer(2));
    	 mejorables=new LinkedList<celda>();
    	 mejorables.add(celdas[9][25]);
    	 mejorables.add(celdas[9][24]);
    	 mejorables.add(celdas[9][23]);
    	 mejorables.add(celdas[10][23]);
    	 mejorables.add(celdas[11][23]);
 	     mejorables.add(celdas[12][23]);
 	     mejorables.add(celdas[12][24]);
 	     mejorables.add(celdas[12][25]);
    	 EnemigosActuales=new LinkedList<Enemigo>();
    	 Thread t=new Thread(this);
    	 factory=new EnemyFactory();
    	 
    	 t.start();
    	 }catch(FileNotFoundException e){
    		 System.out.println("ERROR, ARCHIVO DE MAPA NO ENCONTRADO.");
    	 }
    	 catch(IOException e){
    		 System.out.println("ERROR INESPERADO LEYENDO EL ARCHIVO.");
    	 }
    	 
     }
     public void cambiarPuntaje(int score){
    	 puntaje.setText(score+"");
     }
     public void cambiarVidas(int life){
    	 vidas.setText(life+"");
     }
     private void inicializarCeldas() throws FileNotFoundException, IOException{
    	    String sCurrentLine="";
    	    FileReader f=new FileReader(this.getClass().getResource("/resources/mapa.txt").getFile());

    	    BufferedReader b = new BufferedReader(f);
    	  
    	    int j=0;
    	    while ((sCurrentLine = b.readLine()) != null) {
    	    	
    	    	for (int x=0;x<sCurrentLine.length();x++){
    	    		char letra_actual=sCurrentLine.charAt(x);
    	    		celdas[x][j]=new celda(letra_actual,this,x,j);
    	    		gameObject[] objetos=celdas[x][j].getObjects();
    	    		if(objetos[0]!=null){
    	    			JLabel graf=objetos[0].getGrafico();
    	    			graf.setBounds(32+16*x,128+16*j,16,16);
    	    		    gui.add(graf,new Integer(1));
    	    			
    	    		}else
    	    			if(objetos[2]!=null){
    	    				JLabel graf=objetos[2].getGrafico();
    	    				graf.setBounds(32+16*x,128+16*j,16,16);
    	    				gui.add(graf,new Integer(3));
    	    			}
    	    		  
    	    		    	    		
    	    	}
    	    	 j++;
    	    }
    	   b.close();
    	   JLabel graf2=new JLabel();
    	   graf2.setIcon(new ImageIcon(this.getClass().getResource("/resources/zapdos.gif")));
    	   graf2.setBounds(32+16*10, 128+16*24, 32, 32);
    	   gui.add(graf2,new Integer(2));
    	   gameObject[] objetos=celdas[10][24].getObjects();
    	   objetos[1]=new Aguila(celdas[10][24],1);
    	   objetos=celdas[11][24].getObjects();
    	   objetos[1]=new Aguila(celdas[10][24],1);
    	   objetos=celdas[10][25].getObjects();
    	   objetos[1]=new Aguila(celdas[11][24],1);
    	   objetos=celdas[11][25].getObjects();
    	   objetos[1]=new Aguila(celdas[10][25],1);
    	   
    	}
     public celda getCelda(int x, int y){
    	 return celdas[x][y];
     }
     private void añadirJugador(){
       gameObject[] objetos=celdas[20][25].getObjects();
  	   objetos[1]=new Jugador(celdas[20][25],1,this);
  	   player=(Jugador)objetos[1];
  	   JLabel graf=player.getGrafico();
  	   graf.setBounds(25+16*20, 114+16*25, 30, 30);
  	   gui.add(graf,new Integer(2));
  	   /*PRUEBApowerUP*/
  	   gameObject[] objetos2=celdas[20][23].getObjects();
  	   objetos2[0]=new Estrella(celdas[20][23],0);
  	   Estrella powerUp=(Estrella)objetos2[0];
  	   JLabel graf2=powerUp.getGrafico();
  	   graf2.setBounds(32+16*20, 128+16*23, 16, 16);
  	   gui.add(graf2,new Integer(2));
  	   
  	   objetos2=celdas[20][21].getObjects();
	   objetos2[0]=new Estrella(celdas[20][21],0);
	   powerUp=(Estrella)objetos2[0];
	   graf2=powerUp.getGrafico();
	   graf2.setBounds(32+16*20, 128+16*21, 16, 16);
	   gui.add(graf2,new Integer(2));
	   
	   objetos2=celdas[20][19].getObjects();
	   objetos2[0]=new Estrella(celdas[20][19],0);
	   powerUp=(Estrella)objetos2[0];
	   graf2=powerUp.getGrafico();
	   graf2.setBounds(32+16*20, 128+16*19, 16, 16);
	   gui.add(graf2,new Integer(2));
	   
  	  gameObject[] objetos3=celdas[20][16].getObjects();
 	   objetos3[0]=new EliminarEnemigos(celdas[20][16],0);
 	   JLabel graf3=objetos3[0].getGrafico();
 	   graf3.setBounds(32+16*20, 128+16*16, 16, 16);
 	   gui.add(graf3,new Integer(2));
     }
     public Jugador getJugador(){
    	 return player;
     }
     public GUI getGui(){
    	 return gui;
     }
     public void run(){
          

  	   while(!perdiste && !Ganaste){
  		   
      		 int Actuales=EnemigosActuales.size();
      		 System.out.println(Actuales);
      		 try {
      			 if (Actuales<4)
      				 agregarEnemigo();
      			if (matados==4){
      				addPowerUP();
      				matados=0;
      			}
  				Thread.sleep(1500);
  			} catch (InterruptedException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
      		 
      		
      	} 
    	 
    	  
    	
     }
     private void agregarEnemigo(){
    		
    		 Random rnd=new Random();
    		 int r=rnd.nextInt(4);
    		 switch(r){
    		 case 0:
    			 gameObject[] objetos=celdas[3][2].getObjects();
    			 if (objetos[1]==null){
    				 objetos[1]=factory.crearEnemigo(celdas[3][2], 1);
    				 JLabel grafico=objetos[1].getGrafico();
    				 grafico.setBounds(27+16*3, 118+16*2, 26, 26);
    				 EnemigosActuales.add((Enemigo)objetos[1]);
    				 gui.add(grafico,new Integer(2));
    				 Enemigos--;
    			 }
    			 break;
    		 case 1:
    			 objetos=celdas[16][10].getObjects();
    			 if (objetos[1]==null){
    				 objetos[1]=factory.crearEnemigo(celdas[16][10], 1);
    				 JLabel grafico=objetos[1].getGrafico();
    				 grafico.setBounds(27+16*16, 118+16*10, 26, 26);
    				 EnemigosActuales.add((Enemigo)objetos[1]);
    				 gui.add(grafico,new Integer(2));
    				 Enemigos--;
    			 }
    			 break;
    		 case 2:
    			 objetos=celdas[9][15].getObjects();
    			 if (objetos[1]==null){
    				 objetos[1]=factory.crearEnemigo(celdas[9][15], 1);
    				 JLabel grafico=objetos[1].getGrafico();
    				 grafico.setBounds(27+16*9, 118+16*15, 26, 26);
    				 EnemigosActuales.add((Enemigo)objetos[1]);
    				 gui.add(grafico,new Integer(2));
    				 Enemigos--;
    			 }
    			 break;
    		 case 3:
    			 objetos=celdas[14][21].getObjects();
    			 if (objetos[1]==null){
    				 objetos[1]=factory.crearEnemigo(celdas[14][21], 1);
    				 JLabel grafico=objetos[1].getGrafico();
    				 grafico.setBounds(27+16*14, 118+16*21, 26, 26);
    				 EnemigosActuales.add((Enemigo)objetos[1]);
    				 gui.add(grafico,new Integer(2));
    				 Enemigos--;
    			 }
    			 break;
    		 }
    	 }
     
     private void agregarPowerUp(){
    	 System.out.println("salva!");
     }
     public void detenerTiempo(){
    	 for(Enemigo e:EnemigosActuales){
    		 e.detener(5000);
    	 }
     }
    
    
     public void mejorar() {
 		//Cambia las paredes por acero nuevas.
 		for(celda c:mejorables){
 			if(c.getObjects()[1]==null){
 			c.getObjects()[0].destruir();
 			c.getObjects()[0]=new Acero(c,0);
 			JLabel graf=c.getObjects()[0].getGrafico();
 			graf.setBounds(32+16*c.getPosX(),128+16*c.getPosY(),16,16);
 		    gui.add(graf,new Integer(1));
 		    }
 		}
 		
 	}
     public void addPowerUP(){
 		Random r=new Random();
 		int x=r.nextInt(25)+1;
 		int y=r.nextInt(25)+1;
 		while (true){
 			
 		if(celdas[x][y].getObjects()[4]==null && celdas[x][y].getObjects()[0]==null){
 		   gameObject[] objetos2=celdas[x][y].getObjects();
 		   int c=r.nextInt(6)+0;
 		   PowerUp p;
 		   switch(c){
 		   case 0:
 			   objetos2[4]=new EliminarEnemigos(celdas[x][y],4);
 		  	  
 		  	   break;
 		  case 1:
 			   objetos2[4]=new Casco(celdas[x][y],4);
 		  	
 		  	   break;
 		   case 2:
 			   objetos2[4]=new Estrella(celdas[x][y],4);

 		  	   break;
 		   case 3:
 			   objetos2[4]=new AumentarVida(celdas[x][y],4);

 		  	   break; 
 		  	   
 		   case 4:
 			   objetos2[4]=new DetenerTiempo(celdas[x][y],4);

 		  	   break;
 		   case 5:   
 			   objetos2[4]=new Pala(celdas[x][y],4);

 		  	   break;
 		  	   
 				}
 		   p=(PowerUp) objetos2[4];
 		   JLabel graf2=p.getGrafico();
 	  	   graf2.setBounds(32+16*x, 128+16*y, 16, 16);
 	  	   gui.add(graf2,new Integer(2));
 		   	break;
 			}
 		else
 		{
 			x=r.nextInt(25)+1;
 			y=r.nextInt(25)+1;
 			
 		}
 		}
 	}
     public void destruir(Enemigo e){
    	 matados++;
    	 score=score+e.getPuntaje();
    	 EnemigosActuales.remove(e);
    	 gui.repaint();
    	 if(EnemigosActuales.size()==0&&Enemigos==0)
    		 {Ganaste=true;
    		 System.out.println("ROBERTO A GANADO");
    		 }
    		 
     }
     public boolean finish() {

 		return perdiste;
 	}
 	public void gameOver() {
		System.out.println("ROBERTO PERDIO JAJAJA ");
		if(player!=null)
			{player.destruir();
				player=null;
			}
		perdiste=true;
	}
 	public boolean Victory(){
   	 return Ganaste;
    }
	 
 	public void eliminarEnemigos(){
        LinkedList<Enemigo> eliminar= new LinkedList<Enemigo>();
        
        for(Enemigo el:EnemigosActuales)
    		{
       	 eliminar.add(el);
    			System.out.println(el);
    		}
       	
       	for(Enemigo el:eliminar)
       		el.destruir();
       	
       	EnemigosActuales.clear();
       }

}
