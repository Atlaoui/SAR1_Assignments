package TME4.Interfaces;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import TME4.exception.MyProtocolException;

public abstract class ClientProxy {
	private final int port;
	private final String nom;
	
	public ClientProxy(String nom, int portCalculatrice) {
		this.nom=nom;
		this.port=portCalculatrice;
	}
	
	public Object invokeService(String name, Object[] params) throws MyProtocolException {
		try(Socket s = new Socket(nom, port)){
			try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
				try(ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
					for( Object ob : params)
							oos.writeObject(ob);
					Object o = ois.readObject();
					if(o instanceof MyProtocolException)
						throw new MyProtocolException();
					else
						return o;
				}
			}
		} catch (ClassNotFoundException | IOException  e) {
			e.printStackTrace();
		}
		throw new MyProtocolException();
	}
	
}
