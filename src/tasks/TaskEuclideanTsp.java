package tasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import api.Task;


public class TaskEuclideanTsp implements Task, Serializable {
	//just for testing
	double[][] CITIES;

	/**
	 * 
	 * Takes initialises the object with the problem as parameter
	 * @param cities The problem
	 */

	public TaskEuclideanTsp(double[][] cities) {
		this.CITIES = cities;
	}
	
	
	/**
	 * can only take in unvisited cities
	 * @param cities List of all cities to visit
	 * @param current the current city to move from
	 * @param visited list of all cities that have been visited
	 * @return the number that represents the closest city to move to
	 */
	public int findClosest(double[][] cities, int current, List<Integer> visited){
		int closest=0;
		double dist=1000;
		for (int i = 0; i < cities.length; i++) {

			if(i!= current){
				if(getDistance(cities, current, i)<dist && !visited.contains(i)){
					dist=getDistance(cities, current, i);
					closest = i;
				}
			}

		}

		return closest;
	}
	/**
	 * Finds the euclidian distance between two cities. 
	 * @param cities list of all cities 
	 * @param from The first city to find the distance from
	 * @param to The second city to find the distance to
	 * @return A double that is the distance between the cities. 
	 */

	double getDistance(double[][] cities, int from, int to){

		double dist = Math.sqrt(Math.pow(cities[from][0]-cities[to][0],2) + Math.pow(cities[from][1]-cities[to][1],2));
		return dist;

	}
	/**
	 * Runs the Tsp. 
	 * Starts at city 0 and uses a greedy algorithm to find the closes city to it. 
	 * It then chooses that city as next point and repeats through the whole list of cities. 
	 * It adds each visited city to path.
	 * Returner is just to make the returning object the expected type for the client
	 */

	public List<Integer> execute() {
		List<Integer> visited = new ArrayList<Integer>();
		int [] path= new int[CITIES.length];

		path[0]= 0;
		visited.add(0);

		for (int i = 1; i < CITIES.length; i++) {
			path[i]= findClosest(CITIES, path[i-1],visited);
			visited.add(path[i]);
		}
		
		List<Integer> returner = new ArrayList<Integer>();
		for (int i = 0; i < path.length; i++) {
			returner.add(path[i]);
			
		}
		return returner;
	}


}
