package Mapa;
import resources.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.File;
public class Mapa {
    private Celda[][] celdas;
      
    public Mapa(int cantFilas, int cantCol){
    	
    	celdas=new Celda[cantFilas][cantCol];
    	try{
    	inicializarMapa();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(IOException e){
    		System.out.println("Error inesperado");
    	}
    }
    public Celda[][] getCeldas(){
    	return celdas;
    }
    public Celda getCelda(int x,int y){
    	if (celdas[x][y]==null)
    		System.out.println("ACA ENTRAMOS CON NULO E:E");
    	return celdas[x][y];
    }
    public void inicializarMapa() throws FileNotFoundException, IOException{
    String sCurrentLine="";
    FileReader f=new FileReader(this.getClass().getResource("/resources/map1.txt").getFile());

    BufferedReader b = new BufferedReader(f);
  
    int j=0;
    while ((sCurrentLine = b.readLine()) != null) {
    	
    	for (int x=0;x<sCurrentLine.length();x++){
    		if(sCurrentLine.charAt(x)!='Z'){
    		celdas[x][j]=new Celda(sCurrentLine.charAt(x),this);
    		celdas[x][j].setX(x);
    		celdas[x][j].setY(j);
    		
    		}else
    			celdas[x][j]=null;
    		
    		}
    	 j++;
    }
   b.close();
   
}
}