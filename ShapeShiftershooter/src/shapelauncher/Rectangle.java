package shapelauncher;

import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
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
		int realX = m.getXPosition() +10;
		int realY = 450 - m.getYPosition() ;
		if(x-width/2 -5 < realX && x+width/2 +5> realX
				&& y+height/2 +5> realY && y-height/2 -5< realY)
			return true;
		return false;
	}
}
