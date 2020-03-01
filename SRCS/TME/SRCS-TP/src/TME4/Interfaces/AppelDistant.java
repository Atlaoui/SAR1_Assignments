package TME4.Interfaces;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;



public interface AppelDistant extends Service{
	default public void execute(Socket connexion) {
		try(ObjectOutputStream oos = new ObjectOutputStream(connexion.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(connexion.getInputStream())){	
			String name = ois.readUTF();
			
			int i,len;			
			for(Method m : this.getClass().getMethods()) {				
				if(m.getName().equals(name)) {
					len = m.getParameterCount();
					Object[] objs = new Object[len];
					for(i=0;i<len;i++) {
						objs[i] = ois.readObject();
					}
					oos.writeObject(m.invoke(this, objs));
					break;
				}
			}
		} catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | IOException  e) {
			e.printStackTrace();
		}
	}

	
}
