package TME1.banque.persistance.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import TME1.banque.Banque;
import TME1.banque.Client;
import TME1.banque.Compte;
import TME1.banque.persistance.PersistanceTools;
import TME1.banque.persistance.Sauvegardable;



public class BanqueCompteJoinTest {

	@Test
	public void test() {
				
		Client cli1 = new Client("client1", new Compte("cpt1"));
		Client cli2 = new Client("client2", cli1.getCompte());
				
		Banque banque = new Banque();
		banque.addNewClient(cli1);
		banque.addNewClient(cli2);
		banque.getClient("client1").getCompte().crediter(10);
		banque.getClient("client2").getCompte().debiter(2);
		assertEquals(8,banque.getClient("client1").getCompte().getSolde(),0);
		assertTrue(banque.getClient("client2").getCompte().getSolde() == banque.getClient("client1").getCompte().getSolde());
		assertEquals(2,banque.nbClients());
		assertEquals(1,banque.nbComptes());
		String fichier="/tmp/banque";
		try {
			PersistanceTools.save(fichier, banque);
			Sauvegardable s  = PersistanceTools.load(fichier); 
			assertTrue(s instanceof Banque);
			System.out.println(1);
			banque = (Banque) s;
			assertEquals(8,banque.getClient("client1").getCompte().getSolde(),0);
			assertTrue(banque.getClient("client2").getCompte().getSolde() == banque.getClient("client1").getCompte().getSolde());
			assertEquals(2,banque.nbClients());
			assertEquals(1,banque.nbComptes());
			banque.getClient("client1").getCompte().crediter(10);
			assertEquals(18,banque.getClient("client1").getCompte().getSolde(),0);
			assertTrue(banque.getClient("client2").getCompte().getSolde() == banque.getClient("client1").getCompte().getSolde());
			
		} catch (IOException | ReflectiveOperationException e) {
			assertTrue(false);
			e.printStackTrace();
	}
				
	}

}
