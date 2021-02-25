package srcs.rmi.concurrent.test;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;
import srcs.rmi.concurrent.SharedVariable;
import srcs.rmi.concurrent.SharedVariableClassical;
import srcs.rmi.concurrent.SharedVariableReliable;

class SystemDeployer implements Remote{

	Registry registry;

	@Before
	public void before() throws IOException, InterruptedException {
		
		registry = LocateRegistry.createRegistry(1099);

		SharedVariable<Integer> var,var_reliable;
		var = new SharedVariableClassical<Integer>(0);
		var_reliable = new SharedVariableReliable<Integer>(0);



		UnicastRemoteObject.exportObject(var,0);
		UnicastRemoteObject.exportObject(var_reliable,0);

		registry.rebind ( "variableIntegerClassical" , var ) ;
		registry.rebind ( "variableIntegerReliable" , var_reliable ) ;

	}
	@SuppressWarnings("unchecked")
	@After
	public void after() throws NotBoundException, IOException, InterruptedException {	
		registry.unbind("variableIntegerClassical");
		registry.unbind("variableIntegerReliable");
		UnicastRemoteObject.unexportObject(registry, true);
		new  Proces	sBuilder("killall", "-q",  "rmiregistry").start();
		Thread.sleep(500);
	}
}


/*	try {
	p = new  ProcessBuilder("java", "-cp", System.getProperty("user.dir")+"/bin", "srcs.rmi.concurrent.test.SystemDeployer").start();
} catch (IOException e) {
	e.printStackTrace();
}
 */
