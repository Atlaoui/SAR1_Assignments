package srcs.rmi.service;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface Host extends Remote{

	
	<P extends Serializable,R extends Serializable>FunctionService<P,R > deployNewService(String nameservice, Class<? extends FunctionService<P, R>> c) throws RemoteException;

	 List<String> getServices() throws RemoteException;

	<P extends Serializable,R extends Serializable> Boolean undeployService(String nameservice) throws RemoteException;

	 <P extends Serializable,R extends Serializable>FunctionService<P,R > deployExistingService(FunctionService<P, R> serv) throws RemoteException;
}
