package shapelauncher;

import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int radius;

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Missile m) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
