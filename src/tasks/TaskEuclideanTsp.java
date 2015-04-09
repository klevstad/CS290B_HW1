package tasks;

import api.Task;

public class TaskEuclideanTsp implements Task {
	
	private double[][] _cities;

	public TaskEuclideanTsp(double[][] cities) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] execute() {
		double[][] cities = _cities;
		
		
		for (int i = 0; i < cities.length; i++)
		{
			for (int j = 0; j < cities[0].length; j++)
			{
				
			}
		}
		
		double start_x = 0;
		double start_y = 0;
		
		int[] tour = new int[cities.length];
		
		
		
		return tour;
	}
	
	private int getDistanceBetweenCities(int origin_x, int origin_y, int destination_x, int destination_y)
	{
		return (int) Math.sqrt(Math.pow(origin_x - destination_x, 2) + Math.pow(origin_y - destination_y, 2));
	}

}
