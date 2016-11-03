package enemigo;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class EnemigoRun implements Runnable{
	private Enemigo e;
	private Thread t;
	private boolean parar=false;
       public EnemigoRun(Enemigo e){
    	   this.e=e;
    	   t=new Thread(this);
    	   t.start();
    	   
       }
       public void run(){
    	   try{
    	 Random rnd=new Random();
    	   int cont=0;
    	 boolean isRunnable=e.getIsRunning();
      	 while(isRunnable){
      		
            isRunnable=e.getIsRunning();
            
             if(isRunnable){
            	 if(!parar){
          	     		int r=rnd.nextInt(4);  
    		            e.mover(r);
    		            try{
        		        	Thread.sleep(100);  
        		          }
        		          catch (Exception e){;}
    		            if(cont%20==0)
    		            e.disparar();
    		            cont++;
            	 }else
            	 {
            		 Thread.sleep(5000);
            		 parar=false;
            	 }
             } 
                else{
                	JLabel grafico=e.getGrafico();
                	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/destruir1.png")));
                	Thread.sleep(80);
                	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/destruir2.png")));
                	Thread.sleep(80);
                	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/destruir3.png")));
                	Thread.sleep(80);
                	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/destruir4.png")));
                	Thread.sleep(80);
                	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/destruir5.png")));
                	Thread.sleep(80);
                	grafico.setIcon(null);
              	    t.interrupt();
                }
    	   

      		}
      	 
      	 }catch(InterruptedException e1){
       	   e1.printStackTrace();
      	 
    	   
       }
       }
       public void parar(){
    	   parar=true;
       }
       
       }

