package TME3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

import TME3.interfaces.Request;

public class Serveur {
	private final int port;
	private final Class< ? extends Request> c;
	private Request inst_c;
	private ServerSocket ecoute ;
	public Serveur(int port , Class< ? extends Request> c) {
		this.port=port;
		this.c=c;
	}
	//lsof -i:4343 pour les soucis de port
	public void listen() {
		Socket s = null;
		try {
			inst_c = c.getConstructor().newInstance();
			ecoute = new ServerSocket(port);
			
			while(true) {
				s=ecoute.accept();
				inst_c.execute(s);	
			}
		} catch (SecurityException | NoSuchMethodException | InvocationTargetException  |InstantiationException 
				|IllegalArgumentException | IllegalAccessException |IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if(s!=null)
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
