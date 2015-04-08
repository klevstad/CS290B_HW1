package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Computer extends Remote{
	public int PORT = 1099;
	public String SERVICE_NAME = "hw1";
	public <T> T execute(Task<T> task) throws RemoteException;
}
