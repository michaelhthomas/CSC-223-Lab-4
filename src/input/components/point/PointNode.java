package input.components.point;

import utilities.math.MathUtilities;

/**
 * A 2D Point (x, y).
 *
 * @author Michael Thomas
 * @author Jake Shore
 * @date 1/26/2022
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y) {
		this(ANONYMOUS, x, y);
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y) {
		_name = name;
		_x = x;
		_y = y;
	}

	@Override
	public int hashCode() {
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	
		PointNode other = (PointNode) obj;
		return 
			MathUtilities.doubleEquals(_x, other._x) &&
			MathUtilities.doubleEquals(_y, other._y);
	}

	@Override
	public String toString() {
		String point = "(" + MathUtilities.removeLessEpsilon(_x) + ", " + MathUtilities.removeLessEpsilon(_y) + ")";
		if (_name != null && !_name.equals(ANONYMOUS))
			return _name + point;
		return point;
	}
}
