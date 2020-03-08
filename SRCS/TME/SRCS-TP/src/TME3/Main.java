package TME3;

import TME3.req.PrintRequestHTTP;
import TME3.req.ProcessRequestGet;

public class Main {
	public static void main (String args[]) throws Exception {
		//new Serveur(4343, PrintRequestHTTP.class).listen();
		new Serveur(4343, ProcessRequestGet.class).listen();
	}
}
