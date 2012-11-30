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
		g.fillOval(x, y, radius, radius);
		
	}

	@Override
	public boolean contains(Missile m) {
		if(x-radius >m.getXPosition() && x+radius < m.getXPosition()
				&& y+radius< m.getYPosition() && y-radius > m.getYPosition())
			return true;
		return false;
	}
	
}
