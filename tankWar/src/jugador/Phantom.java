package jugador;

public class Phantom implements Runnable{
	
	private Jugador j;
	private Thread t;
	
	public Phantom(Jugador j){
		this.j=j;
		t=new Thread(this);
	}
	public void act(){
		t.start();
	}
	public void run() {
		j.setI();
		try {
			t.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.setV();
		
	}
	
}
