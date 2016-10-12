package Mapa;

import Abstract.ObjetoLogico;
import Enemigo.Enemigo;
import PowerUp.AumentarDisparo;
import PowerUp.PowerUp;

public  class Celda  {
   protected ObjetoLogico objeto;
   protected boolean traspasable;
   protected Mapa map;
   protected int x,y;
    public Celda(char tipo,Mapa map){
    	this.map=map;
    		switch(tipo){
    		case  'N' : 
    			objeto=null;
    			break;
    		case 'E':
    			objeto=new Agua(this);
    		   break;
    		case 'R':
    			objeto=new Roca(this);
    			break;
    		case 'w':
    			objeto=new AumentarDisparo(this);
    			break;
    		}
    }
    public ObjetoLogico getObject(){
    	return objeto;
    }
    public int getX()
    {
    	return x;
    }
    public int getY()
    {
    	return y;
    }
    public void setY(int Y){
    	y=Y;
    	
    }
    public void setX(int X)
    {
    	x=X;
    }
    public void setObject(ObjetoLogico o){
    	objeto=o;
    }
    public Celda getCelda(int x,int y)
    {
    	return map.getCelda(x,y);
    	
    }
    public void eliminarEnemigo(Enemigo E){
    	
    }
}
