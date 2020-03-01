package TME4.TD;

public class Tampon {
	private Thread [] pool;
	public Tampon(int Taille) {
		pool = new Thread[Taille];
		for(int i = 0 , len = pool.length;i<len;i++) {
			pool[i]=new Thread();
		}
	}
	
	public void add_job(Runnable r) {
		
	}
}
