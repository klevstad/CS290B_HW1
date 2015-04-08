package tasks;

import java.io.Serializable;

import api.Task;

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

	@Override
	public Integer[][] execute()
	{
		Integer[][] count = new Integer[get_nSquares()][get_nSquares()];
		
		// z0
		double c_x = get_lowerLeftX(); 
		double c_y = get_lowerLeftY();
		
		
		double z0 = polarForm(c_x, c_y);
		double zPrev = z0;
		
		
		for (int i = 0; i < get_nSquares(); i++) {
            for (int j = 0; j < get_nSquares(); j++) {
                double c_re = c_x - get_edgeLength() / 2 + get_edgeLength() * i / get_nSquares();
                double c_im = c_y - get_edgeLength() / 2 + get_edgeLength() * j / get_nSquares();
                
                double zK = mand(zPrev, z0);
                
                zPrev = polarForm(c_re, c_im);
                
                count[i][j] = (int) zK;
              
		    }
		}
		
		return count;
		//return null;
	}
	
	// Find the absolute value of the real and imaginary part of a complex number	
	public double polarForm(double real, double imaginary)
	{
		return Math.sqrt((Math.pow(real, 2) + Math.pow(imaginary, 2)));
	}
	
    public int mand(double z, double z0) {

        for (int t = 0; t < get_iterationLimit(); t++) {
        	if (z < 2.0) { return t; }
            z = z * z + z0;
        }
        return get_iterationLimit();
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
