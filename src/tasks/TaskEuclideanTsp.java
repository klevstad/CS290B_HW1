

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

	
	/**
	 * Runs the Tsp. 
	 * Starts at city 0 and uses a greedy algorithm to find the closes city to it. 
	 * It then chooses that city as next point and repeats through the whole list of cities. 
	 * It adds each visited city to path.
	 * Returner is just to make the returning object the expected type for the client
	 */

	public List<Integer> execute() {
		
		return solve();
		
	}
	
	 public  List<Integer> solve(){
			int[] length = new int[CITIES.length];
			for (int i = 0; i < CITIES.length; i++) {
				length[i] = i;
				
			}
			
			ArrayList<ArrayList<Integer>> allPerm= permute(length);
			//System.out.println(allPerm.size());
			
			double best= Double.MAX_VALUE;
			List<Integer> bestpath= new ArrayList<Integer>();
			//System.out.println(allPerm);
			for (int i = 0; i < allPerm.size(); i++) {
				
				List<Integer> current = allPerm.get(i);
				//System.out.println("trying "+current);
				
				
				//System.out.print("  distance was "+findTotalDist(current));
				
				if(findTotalDist(current)<best){
					best= findTotalDist(current);
					bestpath = current;
					//System.out.println("is now best");
				}
				
				
			}
			//System.out.println("best distance "+best);
			//System.out.println("best path ");
			for (int i = 0; i < bestpath.size(); i++) {
				//System.out.println(bestpath.get(i));
				
			}
			return bestpath;
			
			
		}
	 
	 double getDistance(double[][] cities, int from, int to){

			double dist = Math.sqrt(Math.pow(cities[from][0]-cities[to][0],2) + Math.pow(cities[from][1]-cities[to][1],2));
			return dist;

		}
	 
	 double findTotalDist(List<Integer> current){
			double total= 0;
			for (int i = 0; i < current.size(); i++) {
				
				total +=getDistance(CITIES, current.get(i), current.get((i+1)%current.size()));
				
			}
			
			return total;
			
			
			
		}
	 
	 ArrayList<ArrayList<Integer>> permute(int[] num) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			permute(num, 0, result);
			return result;
		}
	 
	 void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
		 
			if (start >= num.length) {
				ArrayList<Integer> item = convertArrayToList(num);
				result.add(item);
			}
		 
			for (int j = start; j <= num.length - 1; j++) {
				swap(num, start, j);
				permute(num, start + 1, result);
				swap(num, start, j);
			}
		}
	 
	 ArrayList<Integer> convertArrayToList(int[] num) {
			ArrayList<Integer> item = new ArrayList<Integer>();
			for (int h = 0; h < num.length; h++) {
				item.add(num[h]);
			}
			return item;
		}
	 
	 void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}}