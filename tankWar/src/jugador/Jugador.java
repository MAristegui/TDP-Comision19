package jugador;
import mapa.celda;
import obstaculos.Acero;
import mapa.map;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.*;

import main.Unidad;
import main.Visitor;
public class Jugador extends Unidad{
     protected int vidas;
     private map Mapa;
     private State nivel;
     private int alto;
     private int ancho;
     public Jugador(celda c,int prof,map Mapa){
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 this.Mapa=Mapa;
    	 V=new VisitorJugador(this);
    	 cell=c;
    	 vidas=3;
    	 nivel=new Nivel1(this,0);
    	 graficos=new Icon[4];
    	 grafico=new JLabel();
    	 setGraficos();
    	 
     }
     public boolean Accept(Visitor V){
    	 return V.visitPlayer(this);
     }
     public int getAlto(){
    	 return alto;
     }
     public int getAncho(){
    	 return ancho;
     }
     public void sumarPuntaje(int i){
    	 Mapa.aumentarPuntaje(i);
     }
     public void setVidas(int v){
    	 vidas=v;
    	 Mapa.cambiarVidas(vidas);
    	 if(vidas==0){

    	 }
     }
     public int getVidas(){
    	 return vidas;
     }
     public int getVelocidad(){
    	 return nivel.getVelocidad();
     }
     public void disparar(){
    	 nivel.disparar();
     }
     public void impact(){
    	 if(nivel.impact()){
    		 setIsRunning(false);
    		 t1.interrupt(); //Detiene el hilo del movimiento para que no se mueva graficamente cuando respawnea
    		 destruir();
    		 cell=Mapa.getCelda(20, 25);
    		 grafico.setBounds(25+16*20, 114+16*25, 30, 30);
    		 dirActual=2;
    		 setState(new Nivel1(this,nivel.getDisparosEnEjecucion()));
    		 setGraficos();
    		 setVidas(vidas-1);
    		 isRunning=true;
    	 }
     }
     public void setState(State s){
    	 nivel=s;
     }
     public void lvlUp(){
/*    	 try{
	          URL url = State.class.getResource("/resources/Power_up.wav"); 
	             AudioClip clip = Applet.newAudioClip(url);
	             clip.play();
	          }catch (Exception e){;}
*/    	 State s=nivel.lvlUp();
    	 if(s!=null){
    		 nivel=s;
    		 setGraficos();
    	 }
     }
     public void dañarAcero(Acero a){
    	 nivel.dañarAcero(a);
     }
     public void detenerTiempo(){
    	 cell.detenerTiempo();
     }
     public void eliminarEnemigos(){
    	 cell.eliminarEnemigos();
     }
     public void restarDisparosEnEjecucion(){
    	 nivel.restarDisparosEnEjecucion();
     }
     public void setGraficos(){
    	 nivel.setGraficos(graficos,grafico);
     }

}
