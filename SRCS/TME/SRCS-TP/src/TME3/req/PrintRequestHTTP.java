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

