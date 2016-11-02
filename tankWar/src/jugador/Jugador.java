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
    	 nivel=new Nivel1(this);
    	 graficos=new Icon[4];
    	 grafico=new JLabel();
    	 setGraficos();
    	 
     }
     public boolean Accept(Visitor V){
    	 return V.visitPlayer(this);
     }
     public void addPowerUp(){
    	 Mapa.addPwup();
     }
     public int getAlto(){
    	 return alto;
     }
     public int getAncho(){
    	 return ancho;
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
    		 destruir();
    		 cell=Mapa.getCelda(20, 25);
    		 grafico.setBounds(27+16*20, 118+16*25, 26, 26);
    		 dirActual=2;
    		 setState(new Nivel1(this));
    		 setGraficos();
    		 if(vidas==0)
    			 Mapa.gameOver();
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
	public void setInvulnerable() {
		Phantom n=new Phantom(this);
		n.act();
	}
	public void setI(){
		System.out.println("SOS GAY ");
		V=new VisitorInvulnerable(this);
	}
	public void setV(){
		V=new VisitorJugador(this);
		System.out.println("VOS TAMBIEN ROBERTO JAJAJA ");
	}
	public void mejorar() {
		Mapa.mejorar();
		
	}

}
