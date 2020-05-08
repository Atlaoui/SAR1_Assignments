import java.util.concurrent.ConcurrentLinkedQueue;

// =========================================================
// class Server (Java)
// =========================================================
public class Server{
	private boolean FirstCall = true;
	private boolean MustWait = false;
	private ConcurrentLinkedQueue<Color> listColor = new ConcurrentLinkedQueue<>();
	public synchronized Color Cooperation(IdCameleon x, Color C){
		Color result;
		if (FirstCall){
			listColor.add(C);
			FirstCall = false;
			while ( !FirstCall ){
				try{wait();} catch(InterruptedException e){}
			}
			MustWait = false;
			result = listColor.peek();
			notifyAll();
		}
		else{
			result = listColor.peek();
			listColor.add(C);
			FirstCall = true;
			notifyAll();
		}
		return result;
	}
}