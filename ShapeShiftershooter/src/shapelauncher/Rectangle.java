package shapelauncher;

import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	int width;
	int height;
	@Override
	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);
		
	}
	@Override
	public boolean contains(Missile m) {
		if(x-width < m.getXPosition() && x+width > m.getXPosition() && y-height < m.getYPosition() && y+height > m.getYPosition())
			return true;
		return false;
	}
}
