package TME3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import TME3.req.ProcessRequestGet;
import TME3.req.ProcessRequestGetPut;

public class Main {
	public static void main (String args[]) throws Exception {
		//new Serveur(4343, PrintRequestHTTP.class).listen();
		int port=4343;
		Runnable runnable2 = () -> {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try (Socket s = new Socket("localhost",port);
				PrintWriter out =new PrintWriter(s.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));){	
				out.write("PUT /coucou.html HTTP/1.1");
				out.write("Host: localhost:4343");
				out.write("User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:73.0) Gecko/20100101 Firefox/73.0");
				out.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				out.write("Accept-Language: en-US,en;q=0.5");
				out.write("Accept-Encoding: gzip, deflate");
				out.flush();
				
				//lecture
				String line;
				System.out.println("Clien recois");
				while ((line = in.readLine()) != null ) {
				    System.out.println(line);
				}
				
			} catch (IOException e) {e.printStackTrace();}  
		};
		new Thread(runnable2).start();
		System.out.println(1);
		new Serveur(port, ProcessRequestGetPut.class).listen();
		System.out.println(1);
	}
}
