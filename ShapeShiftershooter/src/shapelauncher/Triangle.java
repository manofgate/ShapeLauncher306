package shapelauncher;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Triangle extends Shape {
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x = x1; 
		this.y = y1;
		vertex1 = new Point(x2, y2);
		vertex2 = new Point(x3, y3);
	}
	Point vertex1;
	Point vertex2;
	Polygon p = new Polygon();
	@Override
	public void draw(Graphics g) {
		p.reset();
		p.addPoint(x, y);
		p.addPoint(vertex1.x, vertex1.y);
		p.addPoint(vertex2.x, vertex2.y);
		g.drawPolygon(p);
		g.fillPolygon(p);
		
	}
	@Override
	public boolean contains(Missile m) {
		int realX = m.getXPosition() +10;
		int realY = 450 - m.getYPosition();
		return p.contains(realX, realY);
	}
}
