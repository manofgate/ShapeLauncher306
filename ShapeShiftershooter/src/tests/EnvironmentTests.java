package tests;

import java.awt.Point;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import shapelauncher.Environment;
import shapelauncher.Path;

public class EnvironmentTests {
	
	Environment environ;
	@Before
	public void setupEnvironment(){
		environ = new Environment();
	}
	
	@Test
	public void calcPath(){
		environ.setWind(0);
		Path path = environ.calculatePath(2, 2, 10, 45);
		//checks starting point
		Assert.assertEquals(path.getPoints().contains(new Point(2,2)), true);
	}
	@Test
	public void calcPath2(){
		environ.setWind(0);
		Path path = environ.calculatePath(2, 2, 10, 45);
		//checks middle point
		Assert.assertEquals(path.getPoints().contains(new Point(12,2)), true);
	}
}
