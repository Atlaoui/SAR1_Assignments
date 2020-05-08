package srcs.service.annuaire;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import srcs.service.AppelDistant;


public class AnnuaireAppelDistant implements AppelDistant , Annuaire{
	private Map< String,String> hm =   new ConcurrentHashMap< String,String>(); 
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
