package TME1.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import TME1.banque.persistance.Sauvegardable;

public class Client implements Sauvegardable{

	
	private final String nom;
	private final Compte compte;

	
	public Client(String nom, Compte compte) {
		this.nom=nom;
		this.compte=compte;

	}
	
	public Client(InputStream in) throws IOException {
		DataInputStream data = new DataInputStream(in);
		nom = data.readUTF();
		data.readUTF();// pour virer le nom du compte
		compte = new Compte(in);
		data.close();
	}
	
		
	public String getNom() {
		return nom;
	}


	public Compte getCompte() {
		return compte;
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Client other= (Client) o;
		return other.nom.equals(nom);
	}

	@Override
	public void save(OutputStream out) throws IOException {
		DataOutputStream data = new DataOutputStream(out);
		data.writeUTF(this.getClass().getCanonicalName());
		data.writeUTF(nom);
		compte.save(out);
		data.close();
	}
	
}
