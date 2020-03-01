package TME1.banque.persistance.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import TME1.banque.Compte;
import TME1.banque.persistance.PersistanceTools;
import TME1.banque.persistance.Sauvegardable;

public class testeMain {
	public static void main(String[] args) {
		Sauvegardable s = new Compte("mlfsd");
		Sauvegardable s2 ;
		try {
			PersistanceTools.save("/tmp/test", s);
			s2 = PersistanceTools.load("/tmp/test");
			System.out.println(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PersistanceTools.saveArrayInt("blabla.txt", tab);
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
