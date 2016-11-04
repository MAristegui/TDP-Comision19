package mapa;
import gui.GUI;
import gui.GameOver;
import jugador.Jugador;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    private int score;
    private JLabel vidas;
<<<<<<< HEAD
    private int matados=0;
    private JLabel enemigosRestantes;
    protected Collection<celda> mejorables;
    private int Enemigos_matados=0;
    private boolean gameOver=false;
    private EnemyFactory factory;
    private  Collection<Enemigo> EnemigosActuales;
    private int enemigosTotales=16;
    public map(GUI migui){
=======
    private JLabel Restantes;
    //private boolean gameOver=false;
    private EnemyFactory factory;
    private Collection<Enemigo> EnemigosActuales;
    protected Collection<celda> mejorables;
    private int Enemigos;
	private boolean perdiste;
	private int obtenido;
	private boolean Ganaste;
	private int matados;
	private int score;
     public map(GUI migui){
>>>>>>> origin/master
    	 /*El mapa tiene una longitud de 27x27 celdas de 16 pixeles cada una.*/
    	 gui=migui;
    	 score=0;
    	 gui.setResizable(false);
    	 celdas=new celda[27][27];
    	 EnemigosActuales=new ArrayList<Enemigo>();
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
<<<<<<< HEAD
    	 enemigosRestantes= new JLabel("16");
    	 enemigosRestantes.setFont(new Font("Serif",Font.PLAIN,20));
    	 enemigosRestantes.setForeground(Color.lightGray);
    	 enemigosRestantes.setBounds(517,350,100,32);
    	 gui.add(enemigosRestantes,new Integer(2));
=======
    	 Enemigos=16;
    	 Restantes=new JLabel("16");
    	 Restantes.setFont(new Font("Serif", Font.PLAIN, 20));
    	 Restantes.setForeground(Color.lightGray);
    	 Restantes.setBounds(517,350,100,32);
    	 gui.add(Restantes,new Integer(2));
    	 perdiste=false;
    	 Ganaste=false;
    	 obtenido=0;
    	 matados=0;
>>>>>>> origin/master
    	 gui.add(vidas,new Integer(2));
    	 Thread t=new Thread(this);
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
    	 JButton añadirEliminarEnemigos=new JButton();
    	 añadirEliminarEnemigos.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_EE.gif")));
    	 añadirEliminarEnemigos.setBounds(505,400,16,16);
    	 añadirEliminarEnemigos.addActionListener(new ActionListener() { 
    		  public void actionPerformed(ActionEvent e) { 
    		    añadirPowerUp(21,22,0);
    		  } 
    		} );
    	 añadirEliminarEnemigos.setFocusable(false);
    	 gui.add(añadirEliminarEnemigos,new Integer(2));
    	 
    	 JButton añadirAumentarVida=new JButton();
    	 añadirAumentarVida.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AV.gif")));
    	 añadirAumentarVida.setBounds(505,432,16,16);
    	 añadirAumentarVida.addActionListener(new ActionListener() { 
    		  public void actionPerformed(ActionEvent e) { 
    		    añadirPowerUp(21,22,2);
    		  } 
    		} );
    	 añadirAumentarVida.setFocusable(false);
    	 gui.add(añadirAumentarVida,new Integer(2));
    	 
    	 JButton añadirAumentarNivel=new JButton();
    	 añadirAumentarNivel.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_AD.gif")));
    	 añadirAumentarNivel.setBounds(537,432,16,16);
    	 añadirAumentarNivel.addActionListener(new ActionListener() { 
    		  public void actionPerformed(ActionEvent e) { 
    		    añadirPowerUp(21,22,3);
    		  } 
    		} );
    	 añadirAumentarNivel.setFocusable(false);
    	 gui.add(añadirAumentarNivel,new Integer(2));
    	 
    	 JButton añadirConvertirAcero=new JButton();
    	 añadirConvertirAcero.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_CA.png")));
    	 añadirConvertirAcero.setBounds(537,400,16,16);
    	 añadirConvertirAcero.addActionListener(new ActionListener() { 
    		  public void actionPerformed(ActionEvent e) { 
    		    añadirPowerUp(21,22,4);
    		  } 
    		} );
    	 añadirConvertirAcero.setFocusable(false);
    	 gui.add(añadirConvertirAcero,new Integer(2));
    	 
    	 JButton añadirDetenerTiempo=new JButton();
    	 añadirDetenerTiempo.setIcon(new ImageIcon(this.getClass().getResource("/resources/PowerUp_DE.gif")));
    	 añadirDetenerTiempo.setBounds(537,464,16,16);
    	 añadirDetenerTiempo.addActionListener(new ActionListener() { 
    		  public void actionPerformed(ActionEvent e) { 
    		    añadirPowerUp(21,22,1);
    		  } 
    		} );
    	 añadirDetenerTiempo.setFocusable(false);
    	 gui.add(añadirDetenerTiempo,new Integer(2));
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
<<<<<<< HEAD
     public void actualizarEnemigosRestantes(){
    	 enemigosRestantes.setText(16-Enemigos_matados+"");
=======
     public void addPwup(){
    	 score=score+500;
    	 obtenido=obtenido+500;
    	 puntaje.setText(score+"");
>>>>>>> origin/master
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
<<<<<<< HEAD
  	  
=======
 	   
 	   
>>>>>>> origin/master
     }
     private void añadirPowerUp(int i, int j,int tipo){
    	 if(celdas[i][j].getObjects()[1]==null&&celdas[i][j].getObjects()[4]==null){
    	 PowerUp p=null;
    	 switch(tipo){
    	 case 0:
    		 p= new EliminarEnemigos(celdas[i][j],4);
    		 break;
    	 case 1:
    		 p=new DetenerTiempo(celdas[i][j],4);
    		 break;
    	 case 2:
    		 p=new  AumentarVida(celdas[i][j],4);
    		 break;
    	 case 3:
    		 p=new AumentarNivel(celdas[i][j],4);
    		 break;
    	 case 4:
    		 p=new ConvertirAcero(celdas[i][j],4);
    		 break;
    	 }
         gameObject[] objetos=celdas[i][j].getObjects();
    	   objetos[4]=p;
    	   JLabel graf=p.getGrafico();
    	   graf.setBounds(32+16*i, 128+16*j, 16, 16);
    	   gui.add(graf,new Integer(2));
    	 }
       }
     public Jugador getJugador(){
    	 return player;
     }
     public GUI getGui(){
    	 return gui;
     }
     public void run(){
<<<<<<< HEAD
          while(!gameOver){
        	  if(EnemigosActuales.size()<4)
        	  agregarEnemigo();
        	  if(matados==3){
        	  agregarPowerUp();
        	  matados=0;
        	  }
        	  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          }
=======
          

  	   while(!perdiste && !Ganaste){
  		   
      		 int Actuales=EnemigosActuales.size();
      		 System.out.println(Actuales);
      		 try {
      			 if(obtenido>=2000){
      				 player.setVidas(player.getVidas()+1);
      				 obtenido=0;
      			 	}
      			 if (Actuales<4 && Enemigos>0)
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
>>>>>>> origin/master
    	 
    	  
    	
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
    				 Enemigo e=factory.crearEnemigo(celdas[3][2], 1);
                                                         EnemigosActuales.add(e);
    				 objetos[1]=e;
                                                         JLabel grafico=e.getGrafico();
    				 grafico.setBounds(27+16*3, 118+16*2, 26, 26);
    				 gui.add(grafico,new Integer(2));
    			 }
    			 break;
    		 case 1:
    			 objetos=celdas[16][10].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[16][10], 1);
    				 EnemigosActuales.add(e);
                                                         objetos[1]=e;
    				 JLabel grafico=e.getGrafico();
    				 grafico.setBounds(27+16*16, 118+16*10, 26, 26);
    				 gui.add(grafico,new Integer(2));
    			 }
    			 break;
    		 case 2:
    			 objetos=celdas[9][15].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[9][15], 1);
    				 EnemigosActuales.add(e);
                                                         objetos[1]=e;
    				 JLabel grafico=e.getGrafico();
    				 grafico.setBounds(27+16*9, 118+16*15, 26, 26);
    				gui.add(grafico,new Integer(2));
    			 }
    			 break;
    		 case 3:
    			 objetos=celdas[14][21].getObjects();
    			 if (objetos[1]==null){
    				 Enemigo e=factory.crearEnemigo(celdas[14][21], 1);
    				 EnemigosActuales.add(e);
				  objetos[1]=e;
    				 JLabel grafico=e.getGrafico();
    				 grafico.setBounds(27+16*14, 118+16*21, 26, 26);
    				 gui.add(grafico,new Integer(2));
    			 }
    			 break;
    		 }
    	 }
<<<<<<< HEAD
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
=======
>>>>>>> origin/master
     
     public void detenerTiempo(){
    	 for(Enemigo e:EnemigosActuales){
    		 e.detener(10000);
    	 }
     }
<<<<<<< HEAD
     public void eliminarEnemigos(){
    	 LinkedList<Enemigo> eliminar= new LinkedList<Enemigo>();
         
         for(Enemigo el:EnemigosActuales)
     		{
        	 eliminar.add(el);
=======
    
    
     public void mejorar() {
 		//Cambia las paredes por acero nuevas.
 		for(celda c:mejorables){
 			if(c.getObjects()[1]==null){
 				if(c.getObjects()[0]!=null)
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
>>>>>>> origin/master

     		}
        	
        	for(Enemigo el:eliminar){
        		if(el!=null)
        		el.destruir();
        		else
        			System.out.println("ESTA BUGEADO MACHO");
        	}
        	
        	EnemigosActuales=new LinkedList<Enemigo>();
        }
     public void gameOver(){
    	
    	 gui.gameOver();
     }
     public void aumentarPuntaje(int i){
    	 score+=i;
    	 actualizarPuntaje();
     }
     public void destruirEnemigo(Enemigo e){
    	 Enemigos_matados++;
    	 actualizarEnemigosRestantes();
    	 score=score+e.getPuntaje();
<<<<<<< HEAD
    	 actualizarPuntaje();
    	 EnemigosActuales.remove(e);
    	 matados++;
    	 enemigosTotales--;
    	 gui.repaint();
    	 if(Enemigos_matados==16)
    		 {
    		 System.out.println("ROBERTO A GANADO");
    		 }
    		 
     }
     public void mejorar() {
  		//Cambia las paredes por acero nuevas.
		for(celda c:mejorables){
  			if(c.getObjects()[1]==null){
  			if(c.getObjects()[0]!=null)
  			c.getObjects()[0].destruir();
  			
  			c.getObjects()[0]=new Acero(c,0);
  			JLabel graf=c.getObjects()[0].getGrafico();
  			graf.setBounds(32+16*c.getPosX(),128+16*c.getPosY(),16,16);
  		    gui.add(graf,new Integer(1));
  		    }
  		}
=======
    	 obtenido=obtenido+e.getPuntaje();
    	 EnemigosActuales.remove(e);
    	 Restantes.setText((Enemigos+EnemigosActuales.size())+"");
    	 gui.repaint();
    	 if(EnemigosActuales.size()==0 && Enemigos==0)
    		 {Ganaste=true;
    		 gui.Victory();
    		 }
    		 
     }

 	public void gameOver() {
		System.out.println("ROBERTO PERDIO JAJAJA ");
		if(player!=null)
			{player.destruir();
				player=null;
			}
		perdiste=true;
		gui.Finish();
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
>>>>>>> origin/master

}
}
