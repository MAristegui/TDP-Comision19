package jugador;



public class Phantom implements Runnable{
    private Jugador j;
    private Thread t;
	public Phantom(Jugador jugador) {
		j=jugador;
		t=new Thread(this);
		t.start();
	}

	
	public void run() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		j.setV();
		
		t.interrupt();
	}

}
