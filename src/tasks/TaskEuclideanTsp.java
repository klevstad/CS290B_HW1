package tasks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import api.Task;


public class TaskEuclideanTsp implements Task, Serializable {
	//just for testing
	double[][] CITIES;


	public TaskEuclideanTsp(double[][] cities) {
		this.CITIES = cities;
	}
	
	//can only take in unvisited cities
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

	double getDistance(double[][] cities, int from, int to){

		double dist = Math.sqrt(Math.pow(cities[from][0]-cities[to][0],2) + Math.pow(cities[from][1]-cities[to][1],2));
		return dist;

	}

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


	public int[] swap(int[] list, int from, int to){

		int f = list[from];
		int t = list[to];

		list[from] = t;
		list[to] = f;

		return list;
	}

}
