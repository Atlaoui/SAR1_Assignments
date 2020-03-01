package TME3;

public class Main {
	public static void main (String args[]) throws Exception {
		new Serveur(4343, PrintRequestHTTP.class).listen();
	}
}
