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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import TME2.annotation.DontSave;
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

	@SuppressWarnings("unchecked")
	public Interpreteur(String nameFile) {
		try (FileInputStream fout = new FileInputStream(nameFile);
				ObjectInputStream oot = new ObjectInputStream(fout);){
			commandes = (Map<String, Class<? extends Command>>) oot.readObject();		
		} catch (IOException | ClassNotFoundException e) {
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
				com = args.get(0);

				if (!this.commandes.containsKey(com))
					throw new IllegalArgumentException("Unknown command: " + com);
				Class<? extends Command> cls =commandes.get(com);
				Command c;
				if(cls.isMemberClass())
					c=cls.getConstructor(this.getClass(),List.class).newInstance(this,args);
				else
					c=cls.getConstructor(List.class).newInstance(args);
				if(c!=null)
					c.execute();
				}catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException  e) {
					e.printStackTrace();
				}

		} catch (IOException e) {
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
			this.com = args.get(1);

		}

		@Override
		public void execute() {
			commandes.remove(com);
			System.out.println("Rm command: " + com);
		}

	}

	class Deploy implements Command {
		//$HOME/SAR1_Assignments/SRCS/TME/Teste/src
		private static final long serialVersionUID = 1L;
		String nom;
		String path;
		String classname;
		public Deploy( List<String> args) {
			if (args.size() < 3)
				throw new IllegalArgumentException("Usage: deploy <name> <dir/jar> <class>");
			nom = args.get(1);
			path = args.get(2);
			classname =args.get(3);
		}

		@Override
		public void execute() {
			try (URLClassLoader loader =new URLClassLoader(new URL[] { new File("$HOME/SAR1_Assignments/SRCS/TME/Teste/bin/").toURI().toURL() })) {
				Class<? extends Command> c =  loader.loadClass(classname).asSubclass(Command.class); 
				commandes.put(nom, c);

				System.out.println("Added command: " + nom);

			} catch (IOException  |ClassNotFoundException | SecurityException   e) {
				e.printStackTrace();
			} 
		}
	}




	class Save implements Command {

		private static final long serialVersionUID = 1L;
		private String nameFile;
		public Save(List<String> args) {
			if (args.size() != 2) {
				throw new IllegalArgumentException("Usage: save <file>");
			}
			nameFile = args.get(1);
		}

		@Override
		public void execute() {
			try(FileOutputStream fout = new FileOutputStream(new File(nameFile));
					ObjectOutputStream oot = new ObjectOutputStream(fout);) {
				Iterator<Entry<String, Class<? extends Command>>> it = commandes.entrySet().iterator();
				Map<String,Class<? extends Command>> comma = new  HashMap< String,Class<? extends Command>>();
				while(it.hasNext()) {
					Entry<String, Class<? extends Command>> e = it.next();
					if(!e.getValue().isAnnotationPresent(DontSave.class)) {
						comma.put(e.getKey(), e.getValue());
					}
				}
				oot.writeObject(comma);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}






}
