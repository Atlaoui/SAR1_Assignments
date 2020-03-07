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
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import TME2.command.Command;
import TME2.command.Echo;
import TME2.command.Exit;

public class Interpreteur {

	private Map<String,Class<? extends Command>> commandes;
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
		try (InputStreamReader  reader = new InputStreamReader(System.in); 
				BufferedReader br = new BufferedReader(reader);){
			List<String> args;
			String com = null ;
			//pk diff ?
			while(!br.ready())
				try{args =Arrays.asList( br.readLine().split(" "));
				if(args.size() >=2)
					System.out.println(args.toString());
					com = args.get(0);
					System.out.println(com);
					
				if (!this.commandes.containsKey(com))
					throw new IllegalArgumentException("Unknown command: " + com);
				Class<? extends Command> cls =commandes.get(com);
				Command c;
				if(cls.isMemberClass())
					c=cls.getConstructor(this.getClass(),List.class).newInstance(this,args);
				else
					c=cls.getConstructor(List.class).newInstance(args);
				c.execute();
				}catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException  e) {
					e.printStackTrace();
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


	 class Undeploy implements Command {
		private static final long serialVersionUID = 1L;
		private String com ;

		public Undeploy (List<String> args) {
			if(args.size()==0)
				throw new IllegalArgumentException("Erreur Args");
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
		String nom;
		String path;
		String classname;
		public Deploy( List<String> args) {
			if (args.size() < 3)
				throw new IllegalArgumentException("Usage: deploy <name> <dir/jar> <class>");
			nom = args.get(0);
			path = args.get(1);
			classname =args.get(2);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void execute() {
			URL [] ur = new URL[1]; 
			try (URLClassLoader  classLoader = new URLClassLoader(ur);) {
				ur[0] = new File(path).toURI().toURL();
					
				Class<? >c =  classLoader.loadClass(classname); 
				
				if(c.isAssignableFrom(Command.class))
					commandes.put(nom, (Class<? extends Command>) c);
				else
					throw new IllegalArgumentException("Class must be a Command class");
				
				System.out.println("Added command: " + nom);
				
			} catch (IOException  |ClassNotFoundException | SecurityException  | IllegalArgumentException  e) {
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
