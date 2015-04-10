package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Computer extends Remote
{
	public int PORT = 1099;
	public String SERVICE_NAME = "hw1";
	/**
	 * @param task The method takes a task of type T
	 * @return T The return value is of the type T specified by the input task
	 * @throws RemoteException Communication related exception that may occur during the execution of a remote method call
	 */
	public <T> T execute(Task<T> task) throws RemoteException;
}
