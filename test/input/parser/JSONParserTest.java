package input.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.ComponentNode;
import input.components.FigureNode;
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

		StringBuilder sb = new StringBuilder();
		node.unparse(sb, 0);
		System.out.println(sb.toString());
	}
}
