package TME1.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import TME1.banque.persistance.Sauvegardable;

public class Compte implements Sauvegardable{



	private final String id;
	private double solde;


	public Compte(String id) {
		this.id=id;	
		this.solde=0.0;
	}

	/* Ajouter */
	public Compte(InputStream in) throws IOException {
		DataInputStream data = new DataInputStream(in);
		this.solde=data.readDouble();
		this.id=data.readUTF();
		System.out.println(id);
		data.close();

	}

	/* Ajouter */
	@Override
	public void save(OutputStream out) throws IOException {
		DataOutputStream data = new DataOutputStream(out);
		data.writeDouble(solde);
		data.writeUTF(id);
		data.close();
	}

	public String getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void debiter(double montant) {
		solde -= montant;
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Compte other= (Compte) o;
		return other.id.equals(id);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}



}
