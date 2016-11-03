package gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameOver extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
     public GameOver(){
    	getContentPane().setLayout(null);	
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		setBounds(100, 100, 598, 618);
 		setLocationRelativeTo(null);
 		setResizable(false);
 		contentPane = new JLayeredPane();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(contentPane);
 		contentPane.setLayout(null);
 		
 		/*Añado el fondo*/
 		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/gameOver.png")));
 		fondo.setBounds(0, 0, 592, 592);
 		contentPane.add(fondo,new Integer(0));
 		setVisible(true);
    	 
     }
}
