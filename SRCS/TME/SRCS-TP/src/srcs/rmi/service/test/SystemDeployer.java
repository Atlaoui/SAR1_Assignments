package srcs.rmi.service.test;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.junit.After;
import org.junit.Before;

import srcs.rmi.service.Host;
import srcs.rmi.service.HostImpl;


public class SystemDeployer {
	Registry registry ;
	String NameH1="host1",NameH2="host2";
	@Before
	public void before() {
		try {
			registry = LocateRegistry.createRegistry(1099);
			Host host1,host2;

			host1 = new HostImpl(NameH1);
			host2 = new HostImpl(NameH2);
			UnicastRemoteObject.exportObject(host1,0);	
			UnicastRemoteObject.exportObject(host2,0);
			registry.rebind ( NameH1 , host1 ) ;
			registry.rebind ( NameH2 , host2 ) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() {
		try {
			registry.unbind(NameH1);
			registry.unbind(NameH2);
			UnicastRemoteObject.unexportObject(registry, true);
			new  ProcessBuilder("killall", "-q",  "rmiregistry").start();
			Thread.sleep(500);
			
		} catch (IOException | InterruptedException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
