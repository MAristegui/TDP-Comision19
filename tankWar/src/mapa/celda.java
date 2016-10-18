package mapa;
import main.gameObject;
import gui.GUI;
import obstaculos.*;
public class celda {
   private gameObject[] listaObjetosLogicos;
   private map Map;
   private int posX;
   private int posY;
   public celda(char tipo, map Mapa,int posX, int posY){
	   this.posX=posX;
	   this.posY=posY;
	   Map=Mapa;
  	   listaObjetosLogicos=new gameObject[4];
    		switch(tipo){
	    		case  'a' : 
	    			listaObjetosLogicos[1]=null;
	    			break;
	    		case 'b':
	    			listaObjetosLogicos[1]=new Rock(this,1);
	    			
	    			break;
	    		case 'c':
	    		case 'd':
	    		case 'e':
	    		case 'f':
	    		case 'g':
	    		case 'h':
	    		case 'i':
	    		case 'j':
	    		case 'k':
	    		case 'l':
	    		case 'm':
	    		case 'n':
	    		case 'o':
	    			listaObjetosLogicos[1]=new Water(this,tipo,1);
	    			break;
	    		case 'p':
	    		case 'q':
	    		case 'r':
	    			listaObjetosLogicos[1]=new Bridge(this,tipo,1);
	    			break;
	    		case 's':
	    		case 't':
	    		case 'u':
	    		case 'v':
	    		case 'w':
	    		case 'x':
	    		case 'y':
	    		case 'z':
	    		case '1':
	    		case '2':
	    		case '3':
	    		case '4':
	    		case '5':
	    			listaObjetosLogicos[1]=new Grass(this,tipo,1);
	    			break;
	    		case '6':
	    			listaObjetosLogicos[1]=new Pared(this);
	    		
	    			
	    			
   }
   
}
   public gameObject[] getObjects(){
	   return listaObjetosLogicos;
   }
   public int getPosX(){
	   return posX;
   }
   public int getPosY(){
	   return posY;
   }
   public celda getCelda(int x, int y){
	   return Map.getCelda(x, y);
   }
   public GUI getGui(){
	   return Map.getGui();
   }
}