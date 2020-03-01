package TME1.banque.persistance.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import TME1.banque.persistance.PersistanceTools;
public class TableauIntTest {

	
	@Test
	public void testTableauInt() {
		try {
			String fichier = "/tmp/tab";
			int[] test = new int[] {0,4,5,6};
			PersistanceTools.saveArrayInt(fichier, test);
			int[] tab = PersistanceTools.loadArrayInt(fichier);
			assertArrayEquals(test, tab);			
		}catch(IOException e) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testTableauInt2() {
		try {
			String fichier = "/tmp/tab";
			int[] test = new int[] {0,4,5,6,8,9,0,19};
			PersistanceTools.saveArrayInt(fichier, test);
			int[] tab = PersistanceTools.loadArrayInt(fichier);
			assertArrayEquals(test, tab);			
		}catch(IOException e) {
			assertTrue(false);
		}
		
	}
}
