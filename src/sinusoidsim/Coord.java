package sinusoidsim;

import java.awt.geom.Rectangle2D;

@SuppressWarnings("serial")
class Coord extends Rectangle2D.Double
{
	Coord(double x, double y, int size)
	{
		setFrame(translateX(x), translateY(y), size, size);
	}
	
	public double translateX(double oldx)
	{
		double newx = 0d;
		
		newx = oldx + 250;
		
		return newx;
	}
	
	public double translateY(double oldy)
	{
		double newy = 0d;
		
		newy = 250 - oldy;
		
		return newy;
	}
}