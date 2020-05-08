package srcs.rmi.service;

import java.io.Serializable;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface FunctionService <P extends Serializable,R extends Serializable> extends Remote,Serializable{

	 R invoke(P plus)throws RemoteException;

	 FunctionService<P, R> migrateTo(Host s2)throws RemoteException;

	String getName() throws RemoteException,NoSuchObjectException;

}
