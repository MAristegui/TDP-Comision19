package jugador;
import mapa.celda;
import obstaculos.Acero;
import javax.swing.*;

import gui.GUI;
import main.Unidad;
import main.Visitor;
public class Jugador extends Unidad{
     protected int vidas;
     private State nivel;
     private int alto;
     private int ancho;
     public Jugador(celda c,int prof){
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
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
    	 cell.aumentarPuntaje(i);
     }
     public void setVisitor(Visitor v){
    	 V=v;
     }

     public void setVidas(int v){
    	 vidas=v;
    	 cell.cambiarVidas(vidas);
    	 if(vidas==0){
            cell.gameOver();
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
     public void setInvulnerable(){
    	 setVisitor(new VisitorJugadorInvulnerable(this));
    	 invulnerable.setIcon(new ImageIcon(this.getClass().getResource("/resources/invulnerable.gif")));
    	 invulnerable.setBounds(grafico.getX(),grafico.getY(),30,30);
    	 new Phantom(this);
     }
     public void impact(){
    	 if(invulnerable.getIcon()==null)
    	 if(nivel.impact()){
    		 GUI.playSound("matarEnemigo.wav");
    		 setIsRunning(false);
    		 if(t1!=null)
    		 t1.interrupt(); //Detiene el hilo del movimiento para que no se mueva graficamente cuando respawnea
    		 destruir();
    		 cell=cell.getCelda(20, 24);
    		 grafico.setBounds(25+16*20, 114+16*24, 30, 30);
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
    	 State s=nivel.lvlUp();
    	 if(s!=null){
    		 nivel=s;
    		 GUI.playSound("evolucionar.wav");
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

     public void setV(){
    	 setVisitor(new VisitorJugador(this));
 		 getGraficoInvulnerable().setIcon(null);
     }
	public JLabel getGraficoInvulnerable() {
		return invulnerable;
	}
     

}
