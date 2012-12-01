package shapelauncher;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Path {
	List<Point> points;
	
	public Path(List<Point> points) {
		super();
		this.points = points;
	}

	public Path(int magnitude, int angle, int gravity, int wind) {
		points = new ArrayList<Point>();
		Missile missile = new Missile();
		points.add(new Point(0, 0));
		missile.accelerateAngle(magnitude, angle);
		missile.run();
		while(true) {
			points.add(new Point(missile.getXPosition(), missile.getYPosition()));
			if(missile.getYPosition() == 0) break;
			missile.accelerate(wind, -gravity);
			missile.run();
		}
		System.out.println(points);
	}

	public List<Point> getPoints() {
		return points;
	} 
	public void draw(Graphics g){
		for(Point p : points){
			g.fillOval(p.x, p.y, 2, 2);
		}
	}
}
