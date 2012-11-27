package tests;

import java.awt.Point;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import shapelauncher.Environment;
import shapelauncher.Missile;
import shapelauncher.Path;

public class EnvironmentTests {

	Environment environ;

	@Before
	public void setupEnvironment() {
		environ = new Environment();
	}

//	@Test
//	public void calcPath() {
//		environ.setWind(0);
//		Path path = environ.calculatePath(2, 2, 10, 45);
//		// checks starting point
//		Assert.assertEquals(path.getPoints().contains(new Point(2, 2)), true);
//	}
//
//	@Test
//	public void calcPath2() {
//		environ.setWind(0);
//		Path path = environ.calculatePath(2, 2, 10, 45);
//		// checks middle point
//		Assert.assertEquals(path.getPoints().contains(new Point(12, 2)), true);
//	}
	
	@Test
	public void testLaunchMissile() {
		environ.launchMissile(10, 45);
		Assert.assertEquals(environ.getMissile().getVelocityX(), (int)(Math.cos(Math.toRadians(45)) * 10));
		Assert.assertEquals(environ.getMissile().getVelocityY(), (int)(Math.sin(Math.toRadians(45)) * 10));
	}
	
	@Test
	public void testRun() {
		environ.setGravity(5);
		environ.launchMissile(20, 90);
		environ.run();
		environ.run();
		environ.run();
		environ.run();
		Missile missile = environ.getMissile();
		Assert.assertEquals(missile.getVelocityX(), 0);
		Assert.assertEquals(missile.getVelocityY(), 0);
	}
}
