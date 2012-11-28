package shapelauncher;

import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends Shape {
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1);
		vertex1 = new Point(x2, y2);
		vertex2 = new Point(x3, y3);
	}
	Point vertex1;
	Point vertex2;
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
