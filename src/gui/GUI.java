package gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;
import javax.swing.*;
import main.Juego;
import java.awt.event.*;


public class GUI extends JFrame implements Runnable{

	private JLayeredPane contentPane;
	private Juego j;
	private Thread t;
	private GUI frame;
	private boolean ganar;
	private boolean perder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					/*try{
		    	          URL url = State.class.getResource("/resources/musica_fondo.wav"); 
		    	             AudioClip clip = Applet.newAudioClip(url);
		    	             clip.loop();
		    	          }catch (Exception e){;}*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {			

		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 618);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*A�ado el fondo*/
		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/Fondo.png")));
		fondo.setBounds(0, 0, 592, 592);
		contentPane.add(fondo,new Integer(0));
		
		ganar=false;
		perder=false;
		j = new Juego(this);
		
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
	}
	protected void mover(KeyEvent key){
	j.mover(key.getKeyCode());

	}
	/**
	 * Metodo que se encarga de cerrar la ventana principal del juego.
	 */
	public void cerrar(){
		System.exit(1);
	}
	public void act(){
		Thread t=new Thread(this);
		t.start();
	}
	public void Victory(){
		ganar=true;
	}
	public void Finish(){
		perder=true;
	}
	/**
	 * Metodo que corrobora si el jugador gano o perdio el juego.
	 */
	public void run() {
		while (true){
			
		if(ganar){
			System.out.println("max carreado");
			cerrar();
		}
		if(perder){
			System.out.println("VAMOS GABY DALEEEEEEEEEEEEEE");
			cerrar();
			
		}
			
			try {
				t.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
   

}
