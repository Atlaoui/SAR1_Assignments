package TME3.req;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import TME3.interfaces.Request;

public class PrintRequestHTTP implements Request {

	@Override
	public void execute(Socket connexion) {	
		
		try (
			BufferedReader in = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
			PrintWriter out =new PrintWriter(connexion.getOutputStream());)
		{
			 String newLine="\r\n";
			String userInput = in.readLine();
			String [] lineParsed = userInput.split(" ");
			//si ce n'est pas du get ont return surplace
			if (!lineParsed[0].equals("GET")) {
				//out.print("HTTP/1.0 400 Bad Request"+newLine+newLine);
				out.write("HTTP/1.0 400 Bad Request"+newLine+newLine);
				out.flush();
				return;
			}
			
			while ((userInput = in.readLine()) != null && (userInput.length() != 0) ) {
			    System.out.println(userInput);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/*
 * GET /coucou.html HTTP/1.1
Host: localhost:4343
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:73.0) Gecko/20100101 Firefox/73.0
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*///*;q=0.8
//Accept-Language: en-US,en;q=0.5
//Accept-Encoding: gzip, deflate
//DNT: 1
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
