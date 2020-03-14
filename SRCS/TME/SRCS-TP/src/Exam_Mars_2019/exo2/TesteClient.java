package Exam_Mars_2019.exo2;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;


public class TesteClient {
	public static int port=4234;
	//Q5)
	@Test
	public void Client2Object() throws InterruptedException, UnknownHostException, IOException, ClassNotFoundException {
		Thread thread_serveur = new Thread(()->	{
			try {
				new ServeurT(port).listen();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread_serveur.start();
		Thread.sleep(200);
		Socket sock = new Socket("localhost", port);
		ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
		oos.writeInt(2);
		oos.writeObject("Blabla");
		oos.writeObject("Blabl2");
		int i = (int) ois.readObject();
		System.out.println("Resultat = "+i);
		ois.close();
		oos.close();
		sock.close();
		assertTrue(true);
	}
}
