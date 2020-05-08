package srcs.rmi.service;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class HostImpl implements Host{
	private List<FunctionService> serviceDeployd = new ArrayList<>();
	private List<FunctionService> serviceNotDeployd = new ArrayList <>();

	private String HostName;

	public HostImpl(String Name){
		HostName=Name;
	}

	@Override
	public <P extends Serializable,R extends Serializable>FunctionService<P,R >  deployNewService(String nameservice, Class<? extends FunctionService<P,R> > c)
			throws RemoteException {
		if(exist(nameservice))
			throw new RemoteException();
		try {
			FunctionService<P,R > f = c.getConstructor(String.class).newInstance(nameservice);
			serviceDeployd.add(f);
			UnicastRemoteObject.exportObject(f,0);
			return f;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException  e) {
			System.out.println("COUCOU");
			e.printStackTrace();
			throw new RemoteException();
		}
		
	}

	@Override
	public List<String> getServices() throws RemoteException {
		List<String> retService = new ArrayList<>();
		for(FunctionService s : serviceDeployd) {
			retService.add(s.getName());
		}
		return retService;
	}

	@Override
	public  <P extends Serializable,R extends Serializable> Boolean undeployService(String nameservice) throws RemoteException {
		for(FunctionService<P,R> s : serviceDeployd) {
			if(s.getName().equals(nameservice)) {
				serviceNotDeployd.add(s);
				serviceDeployd.remove(s);
				UnicastRemoteObject.unexportObject(s,true);
				return true;
			}
		}
		return false;
	}

	@Override
	public <P extends Serializable,R extends Serializable>FunctionService<P,R >  deployExistingService(FunctionService<P, R> serv)
			throws RemoteException {
		//if(exist(serv.getName()))
		//	throw new RemoteException();
		serviceDeployd.add(serv);
		UnicastRemoteObject.exportObject(serv,0);
		return serv;
	}

	
	
	private boolean exist(String nameservice) throws NoSuchObjectException, RemoteException {
		if(is_in(nameservice,serviceDeployd))
				return true;
		if(is_in(nameservice,serviceNotDeployd))
				return true;		
		return false;
	}
	
	private boolean is_in(String nameservice,List<FunctionService> service) throws NoSuchObjectException, RemoteException {
		for(FunctionService s : service)
			if(s.getName().equals(nameservice)) 
				return true;
		return false;
	}

}
