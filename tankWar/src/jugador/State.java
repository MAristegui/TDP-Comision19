package jugador;
import javax.swing.*;
import obstaculos.Acero;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import disparo.Disparo;
import disparo.DisparoPlayer;
public abstract class State {
	protected int velocidad_jugador;
	protected int resistencia;
	protected int velocidad_disparo;
	protected int disparos_simultaneos;
	protected int disparos_en_ejecucion;
	protected Jugador jugador;
	
    public boolean impact(){
    	if(resistencia==1)
    		return true;
    	else{
    		resistencia--;
    		return false;
    	}
    }
    public void disparar(){
    	if(disparos_en_ejecucion<disparos_simultaneos){
    		/*try{
    	          URL url = State.class.getResource("/resources/burbuja.wav"); 
    	             AudioClip clip = Applet.newAudioClip(url);
    	             clip.play();
    	          }catch (Exception e){;}	*/
    	Disparo d=new DisparoPlayer(jugador.getCelda(),jugador,3,velocidad_disparo);
    	disparos_en_ejecucion++;
    	}
    }
    
    public int getVelocidad(){
    	return velocidad_jugador;
    }
    public abstract State lvlUp();
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    public abstract void setGraficos(Icon[] graficos, JLabel grafico);
    public abstract void daņarAcero(Acero a);
}
