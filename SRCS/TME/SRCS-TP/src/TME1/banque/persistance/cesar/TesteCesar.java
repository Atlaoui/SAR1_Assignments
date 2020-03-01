package TME1.banque.persistance.cesar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import TME1.banque.persistance.PersistanceTools;

public class TesteCesar {

	public static void main(String[] args) {
		String Fichier = "Cesar";
		try {
			System.out.println("Hello");
			OutputStream os = new FileOutputStream(Fichier);
			PersistanceTools.bind(System.in, os);
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	
}
