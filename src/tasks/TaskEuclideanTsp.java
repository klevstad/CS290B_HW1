package tasks;

import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import api.Task;


public class TaskEuclideanTsp implements Task, Serializable {
	//just for testing
	double[][] CITIES;


	public TaskEuclideanTsp(double[][] cities) {
		// TODO Auto-generated constructor stub
		this.CITIES = cities;
	}
	
	//can only take in unvisited cities
	public int findClosest(double[][] cities, int current, List visited){
		int current2 = 0;
		int closest=0;
		double dist=1000;
		for (int i = 0; i < cities.length; i++) {

			if(i!= current){
				//System.out.println("current closest is "+closest+" and distance is "+getDistance(cities, current2, i));

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
		List<Integer> visited = new ArrayList();
		int [] path= new int[CITIES.length];
		//System.out.println(t.findClosest(CITIES, 0,visited));

		path[0]= 0;
		visited.add(0);

		for (int i = 1; i < CITIES.length; i++) {

			path[i]= findClosest(CITIES, path[i-1],visited);
			visited.add(path[i]);
			System.out.println("hello");


		}
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
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



	
	public static void main(String[] args) {
		final double[][] CITIES = 
		    {
		        { 6, 3 },
		        { 2, 2 },
		        { 5, 8 },
		        { 1, 5 },
		        { 1, 6 },
		        { 2, 7 },
		        { 2, 8 },
		        { 6, 5 },
		        { 1, 3 },
		        { 6, 6 }
		    };
		
		

		TaskEuclideanTsp t = new TaskEuclideanTsp(CITIES);
		List visited = new ArrayList();
		int[] path= new int[CITIES.length];
		//System.out.println(t.findClosest(CITIES, 0,visited));

		path[0]= 0;
		visited.add(0);

		for (int i = 1; i < CITIES.length; i++) {

			path[i]= t.findClosest(CITIES, path[i-1],visited);
			visited.add(path[i]);


		}

		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}
		



		
		}

}
