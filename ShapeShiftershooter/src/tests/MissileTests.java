package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import shapelauncher.Missile;

public class MissileTests {

	Missile m;
	@Before
	public void setUpMissle(){
		m = new Missile();
	}
	
	@Test
	public void testMovement() {
		m.move(1, 1);
		Assert.assertEquals(m.getXPosition(),1);
		Assert.assertEquals(m.getYPosition(), 1);
	}
	@Test
	public void testMovement2() {
		m.move(1, -6000);
		//checks for not going under the ground.
		Assert.assertEquals(m.getXPosition(),1);
		Assert.assertEquals(m.getYPosition(), 0);
	}
	@Test
	public void testRotation(){
		m.rotate(1);
		Assert.assertEquals(1, m.getTheta());
	}
	@Test 
	public void testIsWithin(){
		
	}
}
