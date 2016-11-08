package mapa;

import gui.GUI;
import jugador.Jugador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.swing.*;

import enemigo.Enemigo;
import enemigo.EnemyFactory;
import main.Juego;
import main.gameObject;
import obstaculos.Acero;
import obstaculos.Aguila;
import powerUp.*;
public class map implements Runnable{
    private GUI gui;
    private celda[][] celdas;
    private Jugador player;
    private JLabel puntaje;
    private static URL url;
    private int score;
    private JLabel vidas;
    int contEnemigos=0;
    private int matados=0;
    private JLabel enemigosRestantes;
    protected Collection<celda> mejorables;
    private int Enemigos_matados=0;
    private boolean gameOver=false;
    private EnemyFactory factory;
    private  Collection<Enemigo> EnemigosActuales;
    private int enemigosTotales=16;
    private Juego juego;
    private int sprite;
    private Thread t;
    private AudioClip clip;
    public map(GUI migui,int sprites,int score,Jugador player,Juego juego){
    	 /*El mapa tiene una longitud de 27x27 celdas de 16 pixeles cada una.*/
   	 java.net.URL url = GUI.class.getResource("/resources/FondoS.wav"); 
          clip = Applet.newAudioClip(url);
         clip.loop();
    	 gui=migui;
    	 sprite=sprites;
    	 this.juego=juego;
    	 this.score=score;
    	 this.player=player;
    	 gui.setResizable(false);
    	 celdas=new celda[27][27];
    	 EnemigosActuales=new ArrayList<Enemigo>();
    	 try{
    	/*Añado el fondo*/
         
    	 JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/Fondo_"+sprites+".png")));
    	 fondo.setBounds(0, 0, 592, 592);
    	 gui.add(fondo,new Integer(0));
    	 
    	 
    	 puntaje=new JLabel(""+score);
    	 puntaje.setFont(new Font("Serif", Font.PLAIN, 20));
    	 puntaje.setForeground(Color.white);
    	 puntaje.setBounds(517,140,100,32);
    	 gui.add(puntaje,new Integer(2));
    	 vidas=new JLabel("3");
    	 vidas.setFont(new Font("Serif",Font.PLAIN,20));
    	 vidas.setForeground(Color.white);
    	 vidas.setBounds(517,235,100,32);
    	 enemigosRestantes= new JLabel("16");
    	 enemigosRestantes.setFont(new Font("Serif",Font.PLAIN,20));
    	 enemigosRestantes.setForeground(Color.white);
    	 enemigosRestantes.setBounds(517,350,100,32);
    	 gui.add(enemigosRestantes,new Integer(2));
    	 gui.add(vidas,new Integer(2));
    	 inicializarCeldas(sprites);
    	 añadirJugador();
    	 t=new Thread(this);
    	 factory=new EnemyFactory();
    	 mejorables=new LinkedList<celda>();
    	 mejorables.add(celdas[9][25]);
    	 mejorables.add(celdas[9][24]);
    	 mejorables.add(celdas[9][23]);
    	 mejorables.add(celdas[10][23]);
    	 mejorables.add(celdas[11][23]);
 	     mejorables.add(celdas[12][23]);
 	     mejorables.add(celdas[12][24]);
 	     mejorables.add(celdas[12][25]);
 	    
    	 t.start();
    	 }catch(FileNotFoundException e){
    		 System.out.println("ERROR, ARCHIVO DE MAPA NO ENCONTRADO.");
    	 }
    	 catch(IOException e){
    		 System.out.println("ERROR INESPERADO LEYENDO EL ARCHIVO.");
    	 }
    	 
     }
     public void actualizarPuntaje(){
    	 puntaje.setText(score+"");
     }
     public void actualizarEnemigosRestantes(){
    	 enemigosRestantes.setText(16-Enemigos_matados+"");
     }
     public void cambiarVidas(int life){
    	 vidas.setText(life+"");
     }
     private void inicializarCeldas(int t) throws FileNotFoundException, IOException{
    	    String sCurrentLine="";
    	    Random rnd=new Random();
    	    int r=rnd.nextInt(2);
    	    InputStream is = getClass().getResourceAsStream("/resources/mapa_"+r+".txt");
            InputStreamReader isr = new InputStreamReader(is);

    	    BufferedReader b = new BufferedReader(isr);
    	  
    	    int j=0;
    	    while ((sCurrentLine = b.readLine()) != null) {
    	    	
    	    	for (int x=0;x<sCurrentLine.length();x++){
    	    		char letra_actual=sCurrentLine.charAt(x);
    	    		celdas[x][j]=new celda(letra_actual,this,x,j,t);
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
    	   graf2.setIcon(new ImageIcon(this.getClass().getResource("/resources/Aguila_"+t+".gif")));
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
       gameObject[] objetos=celdas[20][24].getObjects();
  	   objetos[1]=player;
       player.setCelda(celdas[20][24]);
  	   JLabel graf=player.getGrafico();
  	   graf.setBounds(25+16*20, 114+16*24, 30, 30);
  	   gui.add(graf,new Integer(2));
  	  
     }
     
     public Jugador getJugador(){
    	 return player;
     }
     public GUI getGui(){
    	 return gui;
     }
     public void run(){
          while(!gameOver){
        	  try {
  				Thread.sleep(2000);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
        	  if(EnemigosActuales.size()<3&&enemigosTotales>0)
        	  if(contEnemigos!=16 )
        	  agregarEnemigo();
        	  if(matados==3){
        	  agregarPowerUp();
        	  matados=0;
        	  }
        	  
          }
          t.interrupt();
    	 
    	  
    	
     }
     private void agregarEnemigo(){
    	 if(enemigosTotales<=0){
    		 gameOver=true;
    		 System.out.println("Ganaste el juego papu.");
    	 }
    	 else{
    		 Random rnd=new Random();
    		 int r=rnd.nextInt(4);
    		 switch(r){
    		 case 0:
    			 
    			 gameObject[] objetos=celdas[3][2].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[3][2], 1,sprite);
    				 JLabel grafico=e.getGrafico();
    				 objetos[1]=e;
    				 grafico.setBounds(27+16*3, 118+16*2, 26, 26);
    				 EnemigosActuales.add(e);
    				 gui.add(grafico,new Integer(2));
    				 contEnemigos++;
    			 }
    			 break;
    		 case 1:
    			 objetos=celdas[16][10].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[16][10], 1,sprite);
    				 JLabel grafico=e.getGrafico();
    				 objetos[1]=e;
    				 grafico.setBounds(27+16*16, 118+16*10, 26, 26);
    				 EnemigosActuales.add(e);
    				 gui.add(grafico,new Integer(2));
    				 contEnemigos++;
    			 }
    			 break;
    		 case 2:
    			 objetos=celdas[9][15].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[9][15], 1,sprite);
    				 JLabel grafico=e.getGrafico();
    				 objetos[1]=e;
    				 grafico.setBounds(27+16*9, 118+16*15, 26, 26);
    				 EnemigosActuales.add(e);
    				 gui.add(grafico,new Integer(2));
    				 contEnemigos++;
    			 }
    			 break;
    		 case 3:
    			 objetos=celdas[14][21].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[14][21], 1,sprite);
    				 JLabel grafico=e.getGrafico();
    				 objetos[1]=e;
    				 grafico.setBounds(27+16*14, 118+16*21, 26, 26);
    				 EnemigosActuales.add(e);
    				 gui.add(grafico,new Integer(2));
    				 contEnemigos++;
    			 }
    			 break;
    		 }
    	 }
     }
     private void agregarPowerUp(){
    	 Random r=new Random();
  		int x=r.nextInt(25)+1;
  		int y=r.nextInt(25)+1;
  		while (true){
  			
  		if(celdas[x][y].getObjects()[4]==null && celdas[x][y].getObjects()[0]==null){
  		   gameObject[] objetos2=celdas[x][y].getObjects();
  		   int c=r.nextInt(5)+0;
  		   PowerUp p;
  		   switch(c){
  		   case 0:
  			   objetos2[4]=new EliminarEnemigos(celdas[x][y],4);
  		  	  
  		  	   break;
  		  case 1:
  			   objetos2[4]=new AumentarNivel(celdas[x][y],4);
  		  	
  		  	   break;
  		   case 2:
  			   objetos2[4]=new AumentarVida(celdas[x][y],4);

  		  	   break;
  		   case 3:
  			   objetos2[4]=new DetenerTiempo(celdas[x][y],4);

  		  	   break; 
  		  	   
  		   case 4:
  			   objetos2[4]=new ConvertirAcero(celdas[x][y],4);

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
     
     public void detenerTiempo(){
    	 for(Enemigo e:EnemigosActuales){
    		 e.detener(10000);
    	 }
     }
     public void eliminarEnemigos(){
    	 LinkedList<Enemigo> eliminar= new LinkedList<Enemigo>();
         
         for(Enemigo el:EnemigosActuales)
     		{
        	 eliminar.add(el);

     		}
        	
        	for(Enemigo el:eliminar)
        		el.destruir();
        	
        	EnemigosActuales.clear();
        }
  
     public void aumentarPuntaje(int i){
    	 score+=i;
    	 actualizarPuntaje();
     }
     public void destruirEnemigo(Enemigo e){
    	 Enemigos_matados++;
    	 actualizarEnemigosRestantes();
    	 score=score+e.getPuntaje();
    	 actualizarPuntaje();
    	 EnemigosActuales.remove(e);
    	 matados++;
    	 enemigosTotales--;
    	 gui.repaint();
    	 if(Enemigos_matados==16)
    		 {
    		 gameOver=true;
    		 gameOver();
    		 }
    		 
     }
     public void gameOver() {

         
         for(Enemigo el:EnemigosActuales)
     		{
        	 el.setIsRunning(false);

     		}
        	
        	
        	
        	EnemigosActuales.clear();
    	 gameOver=true;
    	 clip.stop();
		juego.gameOver();
		
	}
	public void mejorar() {
  		//Cambia las paredes por acero nuevas.
		for(celda c:mejorables){
  			if(c.getObjects()[1]==null){
  			if(c.getObjects()[0]!=null){
  			c.getObjects()[0].getGrafico().setIcon(null);
  			c.getObjects()[0]=null;
  			
  			}
  			c.getObjects()[0]=new Acero(c,0);
  			
  			JLabel graf=c.getObjects()[0].getGrafico();
  			graf.setBounds(32+16*c.getPosX(),128+16*c.getPosY(),16,16);
  		    gui.add(graf,new Integer(1));
  		    }
  		}

}
	public int getScore() {
		return score;
	}
	
}
