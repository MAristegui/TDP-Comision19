package main;
import gui.GUI;
import jugador.Jugador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mapa.map;
public  class Juego {
	private Jugador jugador;
	private static GUI frame;
	private AudioClip clip;
	public static void main(String[] args) {
		new Juego();
		
	
}
   public Juego(){
	   jugador=new Jugador(null,1);
	   pantallaPrincipal();
	   
	   
	   
	  
	  
   }
   public void mover(int dir){
	   int direccion = 0;
		switch (dir){
			case KeyEvent.VK_UP : //Arriba
				direccion = 2;
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 1;
				break;
			case KeyEvent.VK_DOWN : //Abajo
				direccion = 0;
				break;	
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 3;
				break;
			case KeyEvent.VK_SPACE : //Espacio
				direccion=4;
				break;
		}
		jugador.mover(direccion);
   }
   public void ganar(int puntaje){
	   frame.dispose();
	   GUI.playSound("ganaste.wav");
	   final JFrame ganar=new JFrame("Battle City");
	   ganar.setVisible(true);
	   ganar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   ganar.setBounds(100, 100, 598, 618);
	   ganar.setLocationRelativeTo(null);
	   JLayeredPane contentPane=new JLayeredPane();
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   ganar.setContentPane(contentPane);
	   contentPane.setLayout(null);
	   JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/ganaste.gif")));
  	   fondo.setBounds(0, 0, 592, 592);
  	   ganar.add(fondo,new Integer(0));
  	   ganar.setVisible(true);
  	   ganar.setResizable(false);
  	   JLabel puntajeLabel=new JLabel();
  	   puntajeLabel.setText(""+puntaje);
  	   puntajeLabel.setBounds(370, 495, 200, 40);
  	   puntajeLabel.setFont(new Font("Serif", Font.PLAIN, 50));
	   puntajeLabel.setForeground(Color.white);
	   ganar.add(puntajeLabel,new Integer(1));
   }
   public void gameOver(){
	   frame.dispose();
	   final JFrame gameOver=new JFrame("Battle City");
	   gameOver.setVisible(true);
	   gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   gameOver.setBounds(100, 100, 598, 618);
	   gameOver.setLocationRelativeTo(null);
	   JLayeredPane contentPane=new JLayeredPane();
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   gameOver.setContentPane(contentPane);
	   contentPane.setLayout(null);
	   JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/gameOver.png")));
  	   fondo.setBounds(0, 0, 592, 592);
  	   gameOver.add(fondo,new Integer(0));
  	   gameOver.setVisible(true);
  	   gameOver.setResizable(false);
       JButton empezar=new JButton();
	   empezar.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_comenzar2.png")));
	   empezar.setBounds(180,240,235,37);
	   empezar.setVisible(true);
	   empezar.addActionListener(new ActionListener() { 
		   public void actionPerformed(ActionEvent e) { 
			 
			   GUI.playSound("BComenzar.wav");
		       gameOver.dispose();
			   new Juego();
			   
		   } 
		 } );
	   gameOver.add(empezar,new Integer(2));
	   JButton salir=new JButton();
	   salir.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_salir2.png")));
	   salir.setBounds(180,340,235,37);
	   salir.setVisible(true);
	   salir.addActionListener(new ActionListener() { 
		   public void actionPerformed(ActionEvent e) { 
			   GUI.playSound("BComenzar.wav");
			   gameOver.dispatchEvent(new WindowEvent(gameOver, WindowEvent.WINDOW_CLOSING));
		   } 
		 } );
	   gameOver.add(salir,new Integer(2));
	   
   }
   public void pantallaPrincipal(){
	   java.net.URL url = GUI.class.getResource("/resources/InicioS.wav"); 
       clip = Applet.newAudioClip(url);
       clip.loop();
	   final JFrame mainTitle=new JFrame("Battle City");
	   mainTitle.setVisible(true);
	   mainTitle.setResizable(false);
	   mainTitle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   mainTitle.setBounds(100, 100, 598, 618);
	   mainTitle.setLocationRelativeTo(null);
	   JLayeredPane contentPane=new JLayeredPane();
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   mainTitle.setContentPane(contentPane);
	   contentPane.setLayout(null);
	   final JButton empezar=new JButton();
	   empezar.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_comenzar.png")));
	   empezar.setBounds(215,240,130,40);
	   empezar.setVisible(true);
	   JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/Title_Screen.png")));
  	   fondo.setBounds(0, 0, 592, 592);
  	   mainTitle.add(fondo,new Integer(0));
	   empezar.addActionListener(new ActionListener() { 
		   public void actionPerformed(ActionEvent e) { 
			   clip.stop();
			   GUI.playSound("BComenzar.wav");
		       mainTitle.dispose();
			   crearGUI();
			   
		   } 
		 } );
	   mainTitle.add(empezar,new Integer(2));
	  
	   
	   
	   final JButton salir=new JButton();
	   salir.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_salir.png")));
	   salir.setBounds(215,340,130,40);
	   salir.setVisible(true);
	   salir.addActionListener(new ActionListener() { 
		   public void actionPerformed(ActionEvent e) { 
			   GUI.playSound("BComenzar.wav");
			   mainTitle.dispatchEvent(new WindowEvent(mainTitle, WindowEvent.WINDOW_CLOSING));
		   } 
		 } );
	   mainTitle.add(salir,new Integer(2));
	   
	   final JButton ayuda=new JButton();
	   ayuda.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_ayuda.png")));
	   ayuda.setBounds(215,290,130,40);
	   ayuda.setVisible(true);
	   ayuda.addActionListener(new ActionListener() { 
		   public void actionPerformed(ActionEvent e) { 
			   GUI.playSound("BComenzar.wav");
			   salir.setEnabled(false);
			   salir.setVisible(false);
			   empezar.setEnabled(false);
			   empezar.setVisible(false);
			   ayuda.setVisible(false);
			   ayuda.setEnabled(false);
			   final JLabel ayudaLabel=new JLabel();
			   ayudaLabel.setIcon(new ImageIcon(this.getClass().getResource("/resources/ayudaLabel.png")));
			   ayudaLabel.setBounds(140,140,314,393);
			   mainTitle.add(ayudaLabel,new Integer(3));
			   final JButton regresar=new JButton();
			   regresar.setIcon(new ImageIcon(this.getClass().getResource("/resources/boton_regresar.png")));
			   regresar.setBounds(180,470,235,37);
			   regresar.setVisible(true);
			   regresar.addActionListener(new ActionListener() { 
				   public void actionPerformed(ActionEvent e) { 
					   GUI.playSound("BComenzar.wav");
					   ayudaLabel.setVisible(false);
					   regresar.setEnabled(false);
					   regresar.setVisible(false);
					   ayuda.setVisible(true);
					   ayuda.setEnabled(true);
					   empezar.setEnabled(true);
					   empezar.setVisible(true);
					   salir.setEnabled(true);
					   salir.setVisible(true);
				   } 
				 } );
			   mainTitle.add(regresar, new Integer(5));
		   } 
		 } );
	   mainTitle.add(ayuda,new Integer(2));
   }
   public void crearGUI(){
	 
	   Random rnd=new Random();
	   int r=rnd.nextInt(2);
	   frame=new GUI(this);
	   new map(frame,r,0,jugador,this);
	   frame.setVisible(true);
   }
}
