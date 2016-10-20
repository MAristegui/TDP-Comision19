package unidades;

public class DisparoRun implements Runnable{
     private Disparo d;
     private int dirActual;
     private Thread t;
     private boolean moviendo=false;
     public DisparoRun(Disparo d, int dir){
    	 this.d=d;
    	 dirActual=dir;
    	 t=new Thread(this);
    	 t.start();
     }
     
     public void run(){
    	 
    	 boolean isRunnable=d.getIsRunning();
    	 while(isRunnable){
    		 
          isRunnable=d.getIsRunning();
          
           if(isRunnable)
        	   if (!moviendo){
        		  
  		            d.mover(dirActual);
  		          try{
  		        	Thread.sleep(4);  
  		          }
  		          catch (Exception e){;}
  		            }
              else
            	   t.interrupt();
  	   }
    	 
     }
}
