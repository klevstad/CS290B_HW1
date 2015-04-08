package computer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import api.Computer;
import api.Task;

public class ComputerImpl implements api.Computer{

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
	        String name = "Computer";
	        Computer engine = new ComputerImpl();
	        Computer stub =
	            (Computer) UnicastRemoteObject.exportObject(engine, 0);
	        //Registry registry = LocateRegistry.getRegistry();
	        Registry registry = LocateRegistry.createRegistry( 1099 );

	        registry.rebind(name, stub);
	        System.out.println("ComputerImpl bound");
	    } catch (Exception e) {
	        System.err.println("ComputerImpl exception:");
	        e.printStackTrace();
	    }
	}
}
	
