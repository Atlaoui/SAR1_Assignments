package TME3.req;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

import TME3.interfaces.Request;

public class ProcessRequestGet implements Request {
	private String path = "$HOME/SAR1_Assignments/SRCS/TME/SRCS-TP";
	@Override
	public void execute(Socket connexion) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
			 PrintWriter out =new PrintWriter(connexion.getOutputStream());){
			String line;
            line = in.readLine();
            String[] req = line.split(" ");
            if(!req[0].equals("GET")) {
            	out.write("HTTP/1.0 400 Bad Request");
				out.flush();
				return;
            }
          
            String currentUsersHomeDir = System.getProperty("user.dir");
            System.out.println(currentUsersHomeDir+req[1]);
            try(BufferedReader fi = new BufferedReader(new FileReader(currentUsersHomeDir+req[1]))){
            	 out.write("HTTP/1.0 200 OK");
                 out.write("Content-Type: text/html; charset=utf-8");
                 out.write("Server: MINISERVER");
                 // this blank line signals the end of the headers
                 out.write("");
                 // Send the HTML page
                 String fline=fi.readLine();
                 while(fline !=null){
                	 fline=fi.readLine();
                	 out.write(fline);
                 }
                	
                 out.flush();
            }catch(FileNotFoundException e) {
            	e.printStackTrace();
            	out.println("HTTP/1.0 404 File not found");
				out.flush();
				return;
            }
           // Arrays.asList(req).stream().forEach(s-> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
