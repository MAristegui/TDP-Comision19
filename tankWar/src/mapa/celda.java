package mapa;
import main.gameObject;
import enemigo.Enemigo;
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
  	   listaObjetosLogicos=new gameObject[5];
    		switch(tipo){
	    		case  'a' : 
	    			listaObjetosLogicos[0]=null;
	    			break;
	    		case 'b':
	    			listaObjetosLogicos[0]=new Rock(this,0);
	    			
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
	    			listaObjetosLogicos[0]=new Water(this,tipo,0);
	    			break;
	    		case 'p':
	    		case 'q':
	    		case 'r':
	    			listaObjetosLogicos[0]=new Bridge(this,tipo,0);
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
	    			listaObjetosLogicos[2]=new Grass(this,tipo,2);
	    			break;
	    		case '6':
	    			listaObjetosLogicos[0]=new Pared(this);
	    		break;
	    		case '7':
	    			listaObjetosLogicos[0]=new Acero(this,0);
	    			
	    			
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
   public void gameOver(){
	   Map.gameOver();
   }
   public void destruirEnemigo(Enemigo e){
	   Map.destruirEnemigo(e);
   }
   public void detenerTiempo(){
	   Map.detenerTiempo();
   }
   public void eliminarEnemigos(){
	   Map.eliminarEnemigos();
   }
   public void aumentarPuntaje(int i){
	   Map.aumentarPuntaje(i);
   }
   public void mejorar(){
	   Map.mejorar();
   }
}