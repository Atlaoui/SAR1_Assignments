package srcs.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ServeurMultithread {

	private final int port;
	private final int MAX_SIZE;
	private final Class< ? extends Service> c;
	private Service avecEtat;
	private ExecutorService pool;
	public ServeurMultithread(int port , Class< ? extends Service> c) {
		this.port=port;
		this.c=c;
		MAX_SIZE = 100;
		pool = Executors.newFixedThreadPool(MAX_SIZE);
		try {
			for(Annotation a : c.getAnnotations()) 
				if(a instanceof EtatGlobal) 
					avecEtat = c.getConstructor().newInstance();
		} catch (SecurityException | NoSuchMethodException | InvocationTargetException  |InstantiationException  |IllegalArgumentException | IllegalAccessException  e) {
			e.printStackTrace();
		}
	}

	public ServeurMultithread(int port , Class< ? extends Service> c, int size) {
		this.port=port;
		this.c=c;
		MAX_SIZE = size;
		pool = Executors.newFixedThreadPool(MAX_SIZE);
		try {
			for(Annotation a : c.getAnnotations()) 
				if(a instanceof EtatGlobal) 
					avecEtat = c.getConstructor().newInstance();
		} catch (SecurityException | NoSuchMethodException | InvocationTargetException  |InstantiationException  |IllegalArgumentException | IllegalAccessException  e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		try (ServerSocket ecoute = new ServerSocket(port)){
			while(!Thread.currentThread().isInterrupted()) {		
				//pas sur du final dans le while
				Socket socket=ecoute.accept();
				Service s = getService(); 
				Runnable runnable2 = () -> {
					s.execute(socket);
					if (c.isAnnotationPresent(SansEtat.class))
						try {socket.close();} catch (IOException e) {e.printStackTrace();}  
				};
				pool.execute(runnable2);
			}

		}catch (SecurityException | NoSuchMethodException | InvocationTargetException  |InstantiationException |IllegalArgumentException | IllegalAccessException |IOException e) {
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}



	}

	private Service getService() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {	

		for(Annotation a : c.getAnnotations()) {
			if(a instanceof SansEtat) { 
				return c.getConstructor().newInstance();
			}
			if(a instanceof EtatGlobal) 
				return avecEtat;		
		}			
		throw new IllegalStateException("Aie");
	}
}
