package srcs.rmi.service;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public abstract  class AbstractFunctionService<P extends Serializable,R extends Serializable> implements FunctionService<P, R>{
	private String Name;
	private boolean is_migrated = false;
	private FunctionService<P, R> migrated_version = null;

	
	public AbstractFunctionService(String name) {
		Name=name;
	}
	
	@Override
	public R invoke(P plus) throws RemoteException {
		if(is_migrated && migrated_version!=null)
			return migrated_version.invoke(plus);
		return perform(plus);
	}


	@Override
	public FunctionService<P, R> migrateTo(Host s2) throws RemoteException {
		if(is_migrated)
			throw new RemoteException("");
			migrated_version = s2.deployExistingService(this.Copy_stream());
			is_migrated=true;
			//System.out.println(this.equals(migrated_version));
		return migrated_version;
	}

	@Override
	public String getName() throws RemoteException {
		return Name;
	}

	protected abstract R perform(P param);
	
	@Override
	public String toString() {
		return "[Service Name :"+Name+" Migrated :"+is_migrated;
	}


	protected FunctionService<P, R> Copy() {
		AbstractFunctionService<P, R> copy= null;
		try {
			copy = this.getClass().getConstructor(String.class).newInstance(Name);
			System.out.println(Arrays.toString(copy.getClass().getClasses()));
			for(Field f : copy.getClass().getDeclaredFields()) {
				if(!Modifier.isStatic(f.getModifiers())) {
					f.setAccessible(true);
					if(f.getType().toString().equals("int")) {
						Field fd = this.getClass().getDeclaredField(f.getName());
						fd.setAccessible(true);
						f.set(f.get(copy),fd.get(this));
					}
					f.set(f.get(copy), f.get(this));
				}
			}
		} catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		return copy;
	}

	private FunctionService<P, R> Copy_stream(){
		FunctionService<P, R> copy= null;
		String fileName = "tmp";
		try(FileOutputStream file1 = new FileOutputStream(fileName);
			FileInputStream file2 = new FileInputStream(fileName);
			ObjectOutputStream in = new ObjectOutputStream(file1);
			ObjectInputStream out = new ObjectInputStream(file2)){
			in.flush();
			in.writeObject(this);

			copy = (FunctionService<P, R>) out.readObject();

			Files.deleteIfExists(Paths.get(fileName));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return copy;

	}
}
