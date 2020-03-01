package TME4.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import TME4.Interfaces.Calculatrice;
import TME4.Interfaces.Service;
import TME4.Interfaces.Calculatrice.ResDiv;
import TME4.annotation.SansEtat;
import TME4.exception.MyProtocolException;
@SansEtat
public class CalculatriceService implements Calculatrice,Service{

	@Override
	public void execute(Socket connexion) {
		try(ObjectOutputStream oos = new ObjectOutputStream(connexion.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(connexion.getInputStream())){	
			String name = ois.readUTF();
			int a = ois.readInt();
			int b = ois.readInt();
			
			switch (name) {
			case "add":
				oos.writeObject(add(a,b));
				break;
			case "sous":
				oos.writeObject(sous(a,b));
				break;
			case "div":
				oos.writeObject(div(a,b));
				break;
			case "mult":
				oos.writeObject(mult(a,b));
				break;
			default:
				oos.writeObject(new MyProtocolException());
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Integer add(Integer a, Integer b) {
		return a+b;
	}

	@Override
	public Integer sous(Integer a, Integer b) {
		return a-b;
	}

	@Override
	public Integer mult(Integer a, Integer b) {
		return a*b;
	}

	@Override
	public ResDiv div(Integer a, Integer b) {
		return new ResDiv(a%b,a/b);
	}
}
