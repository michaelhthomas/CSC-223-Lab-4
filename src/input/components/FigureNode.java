package input.components;

import org.json.JSONArray;
import org.json.JSONObject;

import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNodeDatabase;

/**
 * A basic figure consists of points, segments, and an optional description
 * 
 * Each figure has distinct points and segments (thus unique database objects).
 * 
 * @author Michael Leiby
 * 
 * @date 2/14/2023
 */
public class FigureNode implements ComponentNode {
	protected String _description;
	protected PointNodeDatabase _points;
	protected SegmentNodeDatabase _segments;

	public String getDescription() {
		return _description;
	}

	public PointNodeDatabase getPointsDatabase() {
		return _points;
	}

	public SegmentNodeDatabase getSegments() {
		return _segments;
	}

	public FigureNode(String description, PointNodeDatabase points, SegmentNodeDatabase segments) {
		_description = description;
		_points = points;
		_segments = segments;
	}

	@Override
	public void unparse(StringBuilder sb, int level) {
		// TODO
	}

	public static FigureNode fromJson(Object json) {
		JSONObject JSONfigure = (JSONObject) json;
		String description = JSONfigure.getString("Description");
		JSONArray JSONpoints = JSONfigure.getJSONArray("Points");
		JSONArray JSONsegments = JSONfigure.getJSONArray("Segments");
		PointNodeDatabase points = PointNodeDatabase.fromJson(JSONpoints);
		SegmentNodeDatabase segments = SegmentNodeDatabase.fromJson(JSONsegments, points);

		return new FigureNode(description, points, segments);
	}
}
