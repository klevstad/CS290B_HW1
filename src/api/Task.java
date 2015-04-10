package api;

public interface Task<T> {
	
	/**
	 * Performs the execute method on the task object and returns an object of type T
	 * @return T
	 */
	public T execute();

}
