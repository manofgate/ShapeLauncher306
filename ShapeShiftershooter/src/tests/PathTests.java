package tests;

import java.awt.Point;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import shapelauncher.Path;

public class PathTests {

	@Test
	public void testPath1() {
		Path path = new Path(5, 90, 5, 0);
		List<Point> points = path.getPoints();
		Assert.assertTrue(points.contains(new Point(0, 0)));
		Assert.assertTrue(points.contains(new Point(0, 5)));
		Assert.assertEquals(points.size(), 4);
	}
	
	@Test
	public void testPath2() {
		Path path = new Path(20, 45, 14, -14);
		List<Point> points = path.getPoints();
		Assert.assertTrue(points.contains(new Point(0, 0)));
		Assert.assertTrue(points.contains(new Point(14, 14)));
		Assert.assertEquals(points.size(), 4);
	}

}
