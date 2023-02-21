package input.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.exception.ParseException;

/**
 * TODO: WRITE THE DESCRIPTION
 * 
 * @author Michael Leiby
 * 
 * @date 2/14/2023
 */

class JSONParserTest {
	public static ComponentNode runFigureParseTest(String filename) {
		JSONParser parser = new JSONParser();

		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filename);

		return parser.parse(figureStr);
	}

	@Test
	void emptyJsonStringTest() {
		JSONParser parser = new JSONParser();

		assertThrows(ParseException.class, () -> {
			parser.parse("{}");
		});
	}

	@Test
	void singleTriangleTest() {
		ComponentNode node = JSONParserTest.runFigureParseTest("testFiles/single_triangle.json");

		assertTrue(node instanceof FigureNode);
		FigureNode figNode = (FigureNode) node;

		StringBuilder sb = new StringBuilder();
		node.unparse(sb, 0);

		// TODO: ask Dr. Alvin abt this
		System.out.println(sb.toString());

		List<PointNode> trianglePoints = List.of(
				new PointNode(0, 0),
				new PointNode(1, 1),
				new PointNode(1, 0));

		assertEquals("Right Triangle in the first quadrant.", figNode.getDescription());
		for (PointNode p : trianglePoints)
			assertTrue(figNode.getPointsDatabase().contains(p));
		assertEquals(3, figNode.getSegments().asUniqueSegmentList().size());
	}
}
