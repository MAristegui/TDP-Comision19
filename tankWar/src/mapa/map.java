package mapa;
import gui.GUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;
import main.gameObject;
import unidades.*;
public class map {
    private GUI gui;
    private celda[][] celdas;
    private Jugador player;
     public map(GUI migui){
    	 /*El mapa tiene una longitud de 27x27 celdas de 16 pixeles cada una.*/
    	 gui=migui;
    	 celdas=new celda[27][27];
    	 try{
    	 inicializarCeldas();
    	 añadirJugador();
    	 }catch(FileNotFoundException e){
    		 System.out.println("ERROR, ARCHIVO DE MAPA NO ENCONTRADO.");
    	 }
    	 catch(IOException e){
    		 System.out.println("ERROR INESPERADO LEYENDO EL ARCHIVO.");
    	 }
    	 
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
    	    		if(objetos[1]!=null&&letra_actual!='6'){
    	    			JLabel graf=objetos[1].getGrafico();
    	    			graf.setBounds(32+16*x,128+16*j,16,16);
    	    			if(letra_actual!='s'&&letra_actual!='t'&&letra_actual!='u'&&letra_actual!='v'&&
    	    					letra_actual!='w'&&letra_actual!='x'&&letra_actual!='y'&&letra_actual!='z'&&
    	    					letra_actual!='1'&&letra_actual!='2'&&letra_actual!='3'&&letra_actual!='4'&&
    	    					letra_actual!='5')
    	    			gui.add(graf,new Integer(1));
    	    			else
    	    		    gui.add(graf,new Integer(3));
    	    			
    	    		}
    	    		  
    	    		    	    		
    	    	}
    	    	 j++;
    	    }
    	   b.close();
    	   
    	}
     public celda getCelda(int x, int y){
    	 return celdas[x][y];
     }
     public void añadirJugador(){
       gameObject[] objetos=celdas[20][25].getObjects();
  	   objetos[0]=new Jugador(celdas[20][25],0);
  	   player=(Jugador)objetos[0];
  	   JLabel graf=player.getGrafico();
  	   graf.setBounds(32+16*20, 128+16*25, 16, 16);
  	   gui.add(graf,new Integer(2));
     }
     public Jugador getJugador(){
    	 return player;
     }
     public GUI getGui(){
    	 return gui;
     }
}
