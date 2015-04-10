package system;

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
	
	/**
	 * Main method for starting a computer instance. 
	 * @param args Obsolete
	 */
	public static void main(String[] args) {
		
		// Creates a security manager
	    if (System.getSecurityManager() == null) {
	        System.setSecurityManager(new SecurityManager());
	    }
	    try {
	        Computer computer = new ComputerImpl();
	        
	        // Creates a remote object for receiving incoming calls
	        Computer stub = (Computer) UnicastRemoteObject.exportObject(computer, 0);
	        
	        // Creates a registry
	        Registry registry = LocateRegistry.createRegistry( PORT );

	        // Binds the service name and remote object with the registry
	        registry.rebind(SERVICE_NAME, stub);
	        System.out.println("ComputerImpl bound");
	    } catch (Exception e) {
	        System.err.println("ComputerImpl exception:");
	        e.printStackTrace();
	    }
	}
}
	
