package TME4.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import TME4.Interfaces.Annuaire;
import TME4.Interfaces.Service;
import TME4.annotation.EtatGlobal;
import TME4.exception.VoidResponse;
@EtatGlobal
public class AnnuaireService implements Annuaire ,Service{
	private Map< String,String> hm =   new ConcurrentHashMap< String,String>(); 
	@Override
	public void execute(Socket connexion) {
		try(ObjectOutputStream oos = new ObjectOutputStream(connexion.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(connexion.getInputStream())){	
			String name_func = ois.readUTF();
			String name = ois.readUTF();
			//
			switch (name_func) {
			case "lookup":
				oos.writeObject(lookup(name));
				break;
			case "unbind":
				unbind(name);
				oos.writeObject(new VoidResponse());
				break;		
			case "bind":
				bind(name,ois.readUTF());
				oos.writeObject(new VoidResponse());
				break;

			default:
				break;
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String lookup(String nom) {
		if(hm.containsKey(nom))
			return hm.get(nom);
		return "";
	}

	@Override
	public void bind(String nom, String valeur) {
		if(!hm.containsKey(nom))
			hm.put(nom, valeur);
		
		
	}

	@Override
	public void unbind(String nom) {
		if(hm.containsKey(nom))
			hm.remove(nom);
		
	}

}
