package computer;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import api.Computer;
import api.Task;

@SuppressWarnings("serial")
public class ComputerImpl implements api.Computer, Serializable{

	public ComputerImpl()
	{
		super();
	}

	@Override
	public <T> T execute(Task<T> task) {
		return task.execute();
	}
	
	public static void main(String[] args) {
	    if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }
	    try {
	        Computer computer = new ComputerImpl();
	        Computer stub = (Computer) UnicastRemoteObject.exportObject(computer, 0);
	        Registry registry = LocateRegistry.createRegistry( PORT );

	        registry.rebind(SERVICE_NAME, stub);
	        System.out.println("ComputerImpl bound");
	    } catch (Exception e) {
	        System.err.println("ComputerImpl exception:");
	        e.printStackTrace();
	    }
	}
}
	
