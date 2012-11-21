package tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import shapelauncher.Circle;
import shapelauncher.Missile;
import shapelauncher.Rectangle;
import shapelauncher.Shape;

public class MissileTests {

	Missile m;

	@Before
	public void setUpMissle() {
		m = new Missile();
	}

	@Test
	public void testMovement() {
		m.move(1, 1);
		Assert.assertEquals(m.getXPosition(), 1);
		Assert.assertEquals(m.getYPosition(), 1);
	}

	@Test
	public void testMovement2() {
		m.move(1, -6000);
		// checks for not going under the ground.
		Assert.assertEquals(m.getXPosition(), 1);
		Assert.assertEquals(m.getYPosition(), 0);
	}

	@Test
	public void testRotation() {
		m.rotate(1);
		Assert.assertEquals(1, m.getTheta());
	}

	@Test
	public void testIsWithin() {
		m.moveTo(0, 0);
		Rectangle rect1 = new Rectangle(-1, -1, 1, 1);
		Rectangle rect2 = new Rectangle(50, 50, 52, 52);

		Assert.assertTrue(m.isWithin(rect1));
		Assert.assertFalse(m.isWithin(rect2));

		Circle circle1 = new Circle(0, 0, 1);
		Circle circle2 = new Circle(50, 50, 1);

		Assert.assertTrue(m.isWithin(circle1));
		Assert.assertFalse(m.isWithin(circle2));
	}
	
	@Test
	public void testRun() {
		m.moveTo(0, 0);
		m.accelerate(1, -10);
		m.run();
		Assert.assertEquals(m.getXPosition(), 1);
		Assert.assertEquals(m.getYPosition(), -10);

		m.accelerate(-1, 5);
		m.run();
		Assert.assertEquals(m.getXPosition(), 1);
		Assert.assertEquals(m.getYPosition(), -15);
	}
	
	@Test
	public void testStop() {
		m.moveTo(0, 0);
		m.accelerate(1, -10);
		m.run();
		m.stop();
		m.run();
		m.run();
		m.run();
		Assert.assertEquals(m.getXPosition(), 1);
		Assert.assertEquals(m.getYPosition(), -10);
	}
	
	@Test
	public void testAccelerateAngle() {
		m.moveTo(0, 0);
		m.stop();
		m.accelerateAngle(10, 45);
		Assert.assertEquals(m.getVelocityX(), Math.cos(Math.toRadians(45)) * 10);
		Assert.assertEquals(m.getVelocityY(), Math.sin(Math.toRadians(45)) * 10);
	}
	
	@Test
	public void testCalcAngle() {
		m.moveTo(0, 0);
		m.stop();
		m.accelerate(10, 10);
		m.calcAngle();
		Assert.assertEquals(m.getTheta(), 45);
	}
}
