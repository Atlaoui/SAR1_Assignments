package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Timer;

public class SharedVariableReliable <T extends Serializable> implements SharedVariable<T>{
	private T objet;
	//private ConcurrentLinkedQueue<Object> queue_mutex = new ConcurrentLinkedQueue<>();
	private boolean jeton = true;
	private final ReentrantLock lock = new ReentrantLock(true);
	private Condition cond_jeton=lock.newCondition();
	private long timeOut = 2000;
	
	private Timer timer = new Timer();
	
	public SharedVariableReliable(T ob)  throws RemoteException {
		objet = ob;
	}

	public SharedVariableReliable(T ob ,long timeOut)  throws RemoteException {
		objet = ob;
		this.timeOut=timeOut;
	}
	
	@Override
	public  T obtenir() throws RemoteException {
		try {
			lock.lock();
			while(!jeton)
				cond_jeton.await();
			jeton=false;
			timer.schedule(new TimedRelease(), timeOut);
			return objet;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			lock.unlock();
		}

	}


	@Override
	public  void relacher(T x) throws RemoteException {
		try {
			lock.lock();
			timer.cancel();
			timer = new Timer();
			objet=x;
			jeton=true;
			cond_jeton.signal();
		}finally {
			lock.unlock();
		}

	}
	
	
	private class TimedRelease extends TimerTask {
		@Override
		public void run() {
			try {
				lock.lock();
				jeton=true;
				cond_jeton.signalAll();
			}finally {
				lock.unlock();
			}
			
		}
		
	}
	
	
}