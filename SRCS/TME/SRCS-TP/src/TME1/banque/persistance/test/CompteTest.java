package TME1.banque.persistance.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import TME1.banque.Compte;
import TME1.banque.persistance.PersistanceTools;

public class CompteTest {
	
	@Test
	public void testCompte() {
		try {
			String fichier = "/tmp/compte";
			Compte cpt = new Compte("cpt1");
			cpt.crediter(5);
			cpt.debiter(2);		
			assertEquals(3,cpt.getSolde(),0);
			PersistanceTools.saveCompte(fichier, cpt);			
			Compte bis = PersistanceTools.loadCompte(fichier);
			//System.out.println(11);
			assertEquals(cpt, bis);
			assertEquals(3,bis.getSolde(),0);
		}catch(IOException e) {
			assertTrue(false);
		}
	}
}
