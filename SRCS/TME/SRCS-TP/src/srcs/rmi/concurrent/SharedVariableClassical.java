package srcs.rmi.concurrent;

import java.io.Serializable;
import java.rmi.RemoteException;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedVariableClassical<T extends Serializable> implements SharedVariable<T>{
	private T objet;
	private boolean jeton = true;
	private final ReentrantLock lock = new ReentrantLock(true);
	private Condition cond_jeton=lock.newCondition();
	public SharedVariableClassical(T ob)  throws RemoteException {
		objet = ob;
	}


	@Override
	public  T obtenir() throws RemoteException {
		try {
			lock.lock();
			while(!jeton)
				cond_jeton.await();
			jeton=false;
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
			objet=x;
			jeton=true;
			cond_jeton.signal();
		}finally {
			lock.unlock();
		}

	}



}