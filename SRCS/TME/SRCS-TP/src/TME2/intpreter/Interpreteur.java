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
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import TME2.command.Command;
import TME2.command.Deploy;
import TME2.command.Echo;
import TME2.command.Exit;
import TME2.command.Undeploy;

public class Interpreteur {

	private Map<String,Class<? extends Command>> commandes;
	private StringBuilder S = new StringBuilder();
	private OutputStreamWriter w = new OutputStreamWriter(System.out);
	private BufferedWriter bw = new BufferedWriter(w);

	public Interpreteur() {
		commandes = new  HashMap< String,Class<? extends Command>>();
		commandes.put("exit", Exit.class);
		commandes.put("echo", Echo.class);
		commandes.put("deploy",Deploy.class);
		commandes.put("undeploy",Undeploy.class);
		commandes.put("save", Save.class);
	}
	
	public Interpreteur(String nameFile) {
		commandes = new  HashMap< String,Class<? extends Command>>();
		try (FileInputStream fout = new FileInputStream(nameFile);
			ObjectInputStream oot = new ObjectInputStream(fout);){
			int size = oot.readInt();
			String name ;
			Command c;
			for(int i =0;i<size;i++) {
				name = oot.readUTF();
				c = (Command) oot.readObject();
				commandes.put(name, c.getClass());
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
						Class<? extends Command> c =commandes.get(line[0]);
						//c.execute();
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
	
	
	
/*********************************Class********************************************/
	
	
	private class Undeploy implements Command {
	private static final long serialVersionUID = 1L;
		private String com ;
		
		private Undeploy (List<String> args) {
			this.com = args.get(0); 
		}

		@Override
		public void execute() {
			commandes.remove(com);
			System.out.println("Rm command: " + com);
		}
		
	}
	
	class Deploy implements Command {

		private static final long serialVersionUID = 1L;
		private Interpreteur inter;
		private String  path;
		private String nom;
		public Deploy( Interpreteur inter) {
			this.inter=inter;
		}
		
		@Override
		public void execute() {
			String[] l =inter.getArgs().toString().split(" ",2);
			for(String e : l)
				System.out.println(e);
			//System.out.println(l[0]);
			nom = l[0];
			path = l[1];
			URL [] ur = new URL[1]; 
			try {
				ur[0] = new File(path).toURI().toURL();
				URLClassLoader  classLoader = new URLClassLoader(ur);	
				Class<?> c =  classLoader.loadClass(nom); 
				List<String> args = new ArrayList<>();
				args.add("Add");
				args.add("1");
				args.add("2");
				Command com=(Command) c.getConstructor(List.class).newInstance(args);
				inter.addCommand(nom, com);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
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
				 Iterator<Entry<String, Class<? extends Command>>> it = commandes.entrySet().iterator();
				 oot.writeInt(commandes.size());
				while(it.hasNext()) {
					Entry<String, Class<? extends Command>> e = it.next();
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
	
		
	
	


}
