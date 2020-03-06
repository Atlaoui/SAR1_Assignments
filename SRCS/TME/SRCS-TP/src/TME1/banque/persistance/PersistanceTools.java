package TME1.banque.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


import TME1.banque.Banque;
import TME1.banque.Client;
import TME1.banque.Compte;


public class PersistanceTools {



	public static void saveArrayInt(String f, int[] tab) throws IOException{
		DataOutputStream writer = new DataOutputStream(new FileOutputStream(f));
		for(int i =0,len = tab.length;i<len;i++) {
			writer.writeInt(tab[i]);
		}
		writer.flush();
		writer.close();
	}


	public static int[] loadArrayInt(String fichier) throws IOException{

		DataInputStream data = new DataInputStream(new FileInputStream(fichier)); 
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(data.available() > 0) {
			int g = data.readInt();
			arr.add(g);
		}
		data.close();
		int [] tab = new int[arr.size()];
		for(int i=0,len=tab.length;i<len;i++) {
			tab[i]=arr.get(i);
		}
		return tab;	

	}

	public static void saveCompte(String f, Compte e) throws IOException {
		OutputStream os = new FileOutputStream(f);
		e.save(os);
		os.flush();
		os.close();
	}

	public static Compte loadCompte(String f)throws IOException{
		InputStream os = new FileInputStream(f);
		System.out.println(1);
		Compte c = new Compte(os);
		os.close();
		return c;
	}

	public static void save(String fichier, Sauvegardable s) throws IOException {
		OutputStream os = new FileOutputStream(fichier);
		DataOutputStream data = new DataOutputStream(os);
		data.writeUTF(s.getClass().getCanonicalName());
		s.save(os);
		os.flush();
		os.close();
	}

	public static Sauvegardable load(String fichier) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		InputStream os = new FileInputStream(fichier);
		DataInputStream data = new DataInputStream(os);
		String name ;
		Class<? extends Sauvegardable> s;
		name = data.readUTF();
		//System.out.println(name);
		s = Class.forName(name).asSubclass(Sauvegardable.class);		
		 //On récupère le constructeur avec les deux paramètres
	    Constructor ct = s.getConstructor(InputStream.class);      
	    //On instancie l'objet avec le constructeur surchargé !
	    Sauvegardable o2 = (Sauvegardable) ct.newInstance(os);
		
		return o2;
	}

	//TD 1 Q1
	public static void bind(InputStream in, OutputStream out) throws IOException {
	//	out.write(in.readAllBytes());
		out.flush();
	}
	public static void bind(InputStream in, OutputStream out ,int max) throws IOException {
	//	out.write(in.readNBytes(max));
		out.flush();

	}

	//Q2 bind(System.in,System.out)

	//Q3

	//Exo 2 
	//Q1


}

