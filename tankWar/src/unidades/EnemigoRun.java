package unidades;
import java.util.Random;
public class EnemigoRun implements Runnable{
	private Enemigo e;
	private Thread t;
       public EnemigoRun(Enemigo e){
    	   this.e=e;
    	   t=new Thread(this);
    	   t.start();
    	   
       }
       public void run(){
    	   Random rnd=new Random();
    	   
    	   boolean isRunnable=e.getIsRunnable();
      	 while(isRunnable){
      		 
            isRunnable=e.getIsRunnable();
            
             if(isRunnable){
          	     		int r=rnd.nextInt(4);  
    		            e.mover(r);
    		            try{
        		        	Thread.sleep(1000);  
        		          }
        		          catch (Exception e){;}
    		            e.mover(5);
    		          try{
    		        	Thread.sleep(500);  
    		          }
    		          catch (Exception e){;}
             } 
                else
              	   t.interrupt();
    	   }
      	 
       }
}
