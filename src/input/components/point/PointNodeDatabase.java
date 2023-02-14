

package input.components.point;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A database of 2D points
 *
 * @author Michael Thomas
 * @author Jake Shore
 * @date 1/26/2022
 */
public class PointNodeDatabase {

	Set<PointNode> _points;
	
	/**
	 * Constructs a new empty PointNodeDatabase.
	 */
	public PointNodeDatabase() {
		_points = new LinkedHashSet<>();
	}
	
	/**
	 * Constructs a new PointNodeDatabase, inserting all PointNodes in the given collection.
	 * @param list List of PointNodes to initialize the database with.
	 */
	public PointNodeDatabase(List<PointNode> list) {
		_points = new LinkedHashSet<>(list);
	}
	
	/**
	 * Adds the given point to the database.
	 * @param point Point to add.
	 */
	public void put(PointNode point) {
		_points.add(point);
	}
	
	/**
	 * Checks if the given point is present in the database.
	 * @param point
	 * @return true if the point is present, else false.
	 */
	public boolean contains(PointNode point) {
		return _points.contains(point);
	}
	
	/**
	 * Checks if there is a point with the given coordinates in the database.
	 * @param x
	 * @param y
	 * @return true if the point is present, else false.
	 */
	public boolean contains(double x, double y) {
		return _points.contains(new PointNode(x, y));
	}
	
	/**
	 * Returns the name of the point in the database with the same coordinates 
	 * as the given point.
	 * @param point Point whose name should be located.
	 * @return the name of the given point if it is present in the database, else null.
	 */
	public String getName(PointNode point) {
		PointNode found = getPoint(point);
		return found != null ? found._name : null;
	}
	
	/**
	 * Returns the name of the point with the given coordinates in the database.
	 * @param x coordinate
	 * @param y coordinate
	 * @return the name of the given point if it is present in the database, else null.
	 */
	public String getName(double x, double y) {
		return getName(new PointNode(x, y));
	}
	
	/**
	 * Gets the point in the database with the same coordinates as the given point.
	 * @param point Point to locate.
	 * @return the point equal to the given point in the database if it exists, 
	 * else null.
	 */
	public PointNode getPoint(PointNode point) {
		for (PointNode p : _points) {
			if (p.equals(point))
				return p;
		}
		return null;
	}
	
	/**
	 * Gets the point in the database with the given coordinates.
	 * @param x coordinate
	 * @param y coordinate
	 * @return	the point with the given coordinates the database if it exists, else null.
	 */
	public PointNode getPoint(double x, double y) {
		return getPoint(new PointNode(x, y));
	}

}
