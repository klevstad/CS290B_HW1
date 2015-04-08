package tasks;

import java.io.Serializable;

import api.Task;

@SuppressWarnings({ "serial", "rawtypes" })
public final class TaskMandelbrotSet implements Task, Serializable
{
	private double _lowerLeftX;
	private double _lowerLeftY;
	private double _edgeLength;
	private int _nSquares;
	private int _iterationLimit;
	
	public TaskMandelbrotSet(double lowerLeftX, double lowerLeftY, double edgeLength, int nSquares, int iterationLimit)
	{
		set_lowerLeftX(lowerLeftX);
		set_lowerLeftY(lowerLeftY);
		set_edgeLength(edgeLength);
		set_nSquares(nSquares);
		set_iterationLimit(iterationLimit);
	}

	//@Override
	public Integer[][] execute()
	{
		Integer[][] count = new Integer[get_nSquares()][get_nSquares()];
		double c_x = get_lowerLeftX(); // Get start x coordinate
		double c_y = get_lowerLeftY(); // Get start y coordinate
		double root_x = c_x; // Stores the x coordinate to begin at the same position for every row
		double step = get_edgeLength() / get_nSquares(); // Ninjatriks.
		
		for (int i = 0; i < get_nSquares(); i++)
		{
			for (int j = 0; j < get_nSquares(); j++)
			{
            	count[j][i] = computeZK(c_x, c_y);
            	c_x += step; // moves right for the next computation
			}
			c_y += step; // moves down for the next row
			c_x = root_x; // places the x at the beginning of the row
		}
		
		return count;
	}
	
	
    private int computeZK(double c_x, double c_y)
    {
        double x = 0;
        double y = 0;
        int iteration = 0;
        
        // Returns the largest of Zk > 2 and the iteration limit
        while ((x * x + y * y < 4) && iteration < get_iterationLimit() )
        {
        	// zK = (zK-1)^2 + c
        	double temp = Math.pow(x, 2) - Math.pow(y, 2) + c_x;
        	y = 2 * x * y + c_y;
        	x = temp;

        	iteration++;
        }
        return iteration;
    }
	
	public double get_lowerLeftX()
	{
		return _lowerLeftX;
	}

	private void set_lowerLeftX(double _lowerLeftX)
	{
		this._lowerLeftX = _lowerLeftX;
	}

	public double get_lowerLeftY()
	{
		return _lowerLeftY;
	}

	private void set_lowerLeftY(double _lowerLeftY)
	{
		this._lowerLeftY = _lowerLeftY;
	}

	public double get_edgeLength()
	{
		return _edgeLength;
	}

	private void set_edgeLength(double _edgeLength)
	{
		this._edgeLength = _edgeLength;
	}

	public int get_nSquares()
	{
		return _nSquares;
	}

	private void set_nSquares(int _nSquares)
	{
		this._nSquares = _nSquares;
	}

	public int get_iterationLimit()
	{
		return _iterationLimit;
	}

	private void set_iterationLimit(int _iterationLimit)
	{
		this._iterationLimit = _iterationLimit;
	}

}
