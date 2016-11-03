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


public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
	private Juego j;


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
		
		/*Añado el fondo*/
		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/Fondo.png")));
		fondo.setBounds(0, 0, 592, 592);
		contentPane.add(fondo,new Integer(0));
		
		
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
   
  public void gameOver(){
	  contentPane=new JLayeredPane();
	  contentPane.setBorder(new EmptyBorder(5,5,5,5));
		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/gameOver.png")));
		fondo.setBounds(0, 0, 592, 592);
		contentPane.add(fondo,new Integer(0));
	  
  }
}

