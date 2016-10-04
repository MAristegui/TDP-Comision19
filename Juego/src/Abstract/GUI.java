package Abstract;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import javax.swing.*;
import java.awt.event.*;

import Mapa.Mapa;
import resources.*;
import java.awt.event.KeyEvent;
import java.util.Random;
// Commit hola b
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
	private Juego j;
	// private boolean BORRARESTAVARIABLE2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
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
		setBounds(100, 100, 655, 742);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
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
   

}

