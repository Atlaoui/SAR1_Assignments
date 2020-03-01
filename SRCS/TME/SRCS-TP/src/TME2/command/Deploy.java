package TME2.command;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import TME2.intpreter.Interpreteur;

public class Deploy implements Command {
	/**
	 * 
	 */
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
