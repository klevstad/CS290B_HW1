

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
	
	
	


	public List<Integer> execute() {
		
		return solve();
		
	}
	
	/**
	 * Uses the list of cities, finds all permutations of those.
	 * 
	 * Then goes through every permutations and finds the distance of that path. 
	 * It keeps the best path with smallest distance and when has gone through all
	 *  it returns the best path
	 * @return it returns the best path
	 */
	
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
			
			
			return bestpath;
			
			
		}
	 /**
	  * find the euclidian distance between two positions.
	  * 
	  * @param cities all cities
	  * @param from the from city
	  * @param to the to city
	  * @return
	  */
	 
	 double getDistance(double[][] cities, int from, int to){

			double dist = Math.sqrt(Math.pow(cities[from][0]-cities[to][0],2) + Math.pow(cities[from][1]-cities[to][1],2));
			return dist;

		}
	 /**
	  *  Adds up the distances between cities in a path
	  *  
	  * @param current the path to calculate distance for
	  * @return the total distance 
	  */
	 
	 double findTotalDist(List<Integer> current){
			double total= 0;
			for (int i = 0; i < current.size(); i++) {
				
				total +=getDistance(CITIES, current.get(i), current.get((i+1)%current.size()));
				
			}
			
			return total;
			
			
			
		}
	 
	 /**
	  * This code is from here and out is from:
	  * 
	  * http://www.programcreek.com/2013/02/leetcode-permutations-java/
	  * part: Java solution 2
	  * 
	  * It takes in a list and returns all possible permutations of positions in that list.
	  *
	  * 
	  * @param num list to find all premutations on
	  * @return a list containing all permutations
	  */
	 
	 ArrayList<ArrayList<Integer>> permute(int[] num) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			permute(num, 0, result);
			return result;
		}
	 
	/**
	 * recursively goes through to find all permutations
	 * 
	 * @param num
	 * @param start
	 * @param result
	 */
	 
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