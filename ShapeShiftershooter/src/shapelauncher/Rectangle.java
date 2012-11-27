package shapelauncher;

import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
	}
	int width;
	int height;
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
