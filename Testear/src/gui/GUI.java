package gui;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;
import javax.swing.*;
import main.Juego;


public class GUI extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
    private Thread t;
	protected boolean keyBoardUpPressed;

	protected boolean keyBoardDownPressed;

	protected boolean keyBoardLeftPressed;

	protected boolean keyBoardRightPressed;
	
	
	private static Juego j;

	public GUI(final Juego j) {	
		super("Battle City 2016");
       addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_UP){
					keyBoardUpPressed=true;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
						keyBoardDownPressed=true;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
							keyBoardLeftPressed=true;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
								keyBoardRightPressed=true;
							}
							
			}
			public void keyReleased(KeyEvent arg0){
				if(arg0.getKeyCode()==KeyEvent.VK_UP){
					keyBoardUpPressed=false;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
						keyBoardDownPressed=false;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
							keyBoardLeftPressed=false;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
								keyBoardRightPressed=false;
							}
							else
								if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
									j.mover(KeyEvent.VK_SPACE);
							
							
			}
			
				
    });
        
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 618);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		t=new Thread(this);
		t.start();
		this.j=j;
		
		
	}
	


public void run() {
	while(true){
        if(keyBoardLeftPressed){
      	  j.mover(KeyEvent.VK_LEFT);
        }
        else
      	  if(keyBoardRightPressed){
      		  j.mover(KeyEvent.VK_RIGHT);
            }
            else
          	  if(keyBoardDownPressed){
          		  j.mover(KeyEvent.VK_DOWN);
                }
                else
              	  if(keyBoardUpPressed){
              		  j.mover(KeyEvent.VK_UP);
                    }
              		  
                   
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}
}

