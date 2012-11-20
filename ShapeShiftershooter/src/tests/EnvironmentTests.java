package tests;

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
		Path path = environ.calculatePath(2, 2, 2);
		Assert.assertEquals(path, new Path());
	}

}
