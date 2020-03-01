package TME2.intpreter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import TME2.command.Command;
import TME2.command.Deploy;
import TME2.command.Echo;
import TME2.command.Exit;
import TME2.command.Undeploy;

public class Interpreteur {

	private Map<String,Command> commandes;
	private StringBuilder S = new StringBuilder();
	private OutputStreamWriter w = new OutputStreamWriter(System.out);
	private BufferedWriter bw = new BufferedWriter(w);

	public Interpreteur() {
		commandes = new  HashMap< String,Command>();
		commandes.put("exit", new Exit());
		commandes.put("echo", new Echo(this));
		commandes.put("deploy", new Deploy(this));
		commandes.put("undeploy",new Undeploy(this));
		commandes.put("save", new Save());
	}
	
	public Interpreteur(String nameFile) {
		commandes = new  HashMap< String,Command>();
		try (FileInputStream fout = new FileInputStream(nameFile);
			ObjectInputStream oot = new ObjectInputStream(fout);){
			int size = oot.readInt();
			String name ;
			Command c;
			for(int i =0;i<size;i++) {
				name = oot.readUTF();
				c = (Command) oot.readObject();
				commandes.put(name, c);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try (
				InputStreamReader  reader = new InputStreamReader(System.in); 
				BufferedReader br = new BufferedReader(reader);){
			String line[];
			//pk diff ?
			while(!br.ready()) {
				line = br.readLine().split(" ",2);
				if(line.length >=2)
					S.append(line[1]);
				if(line[0] !="") {
					if(commandes.containsKey(line[0])) {
						Command c =commandes.get(line[0]);
						c.execute();
					}
				}
				S.setLength(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				bw.close();
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected class Save implements Command {
		private String nameFile;
		public Save() {
		}

		@Override
		public void execute() {
			nameFile=S.toString();
			try {
				FileOutputStream fout = new FileOutputStream(new File(nameFile));
				ObjectOutputStream oot = new ObjectOutputStream(fout);
				 Iterator<Entry<String, Command>> it = commandes.entrySet().iterator();
				 oot.writeInt(commandes.size());
				while(it.hasNext()) {
					Entry<String, Command> e = it.next();
					oot.writeUTF(e.getKey());
					oot.writeObject(e.getValue());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
		
	
	

	public void removeCommand(String command) {
		if(commandes.containsKey(command)) {
			commandes.remove(command);
		}
	}
	public void addCommand(String command,Command c) {
		if(!commandes.containsKey(command)) {
			commandes.put(command, c);
		}
	}

	public StringBuilder getArgs() {
		return S;
	}
	public OutputStreamWriter getWriter() {
		return w;
	}
	public BufferedWriter getBufferWriter() {
		return bw;
	}
	public void remove(String name) {
		if(commandes.containsKey(name)) {
			commandes.remove(name);
		}
	}
}
