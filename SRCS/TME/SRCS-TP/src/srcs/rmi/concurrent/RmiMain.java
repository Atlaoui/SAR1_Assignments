package srcs.rmi.concurrent;


import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiMain {

	public static void main(String[] args) {
		SharedVariable<Integer> var;
		Integer i = 0;
		try {
			
			Registry registry;
			LocateRegistry.createRegistry(1099);
			var = new SharedVariableClassical<Integer>(i);
			UnicastRemoteObject.exportObject(var,0);
			
			registry = LocateRegistry.getRegistry("localhost");
			registry.rebind ( "variableIntegerClassical" , var ) ;
			
			//gestion de la terminaison
			Runtime.getRuntime().addShutdownHook( new Thread(() -> { 
				try { Runtime.getRuntime().exec("killall -q rmiregistry");} catch (IOException e) {e.printStackTrace();}
				try {
						System.out.println("Shuting down");
						UnicastRemoteObject.unexportObject(var, true);
				} catch (NoSuchObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
