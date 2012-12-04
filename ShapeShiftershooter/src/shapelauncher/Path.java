package shapelauncher;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Path {
	List<Point> points;
	private int stage;
	public Path(List<Point> points, int stage) {
		super();
		this.stage = stage;
		this.points = points;
	}

	//Creates a new missile object, then runs it until it hits the ground to generate a set of points where the missile will go.
	public Path(int magnitude, int angle, int gravity, int wind, int numStage) {
		points = new ArrayList<Point>();
		Missile missile = new Missile(numStage%3);
		points.add(new Point(0,0));
		missile.accelerateAngle(magnitude, angle);
		missile.run();
		while(true) {
			points.add(new Point(missile.getXPosition(), missile.getYPosition()));
			if(missile.getYPosition() == 0 ) break;
			missile.accelerate(wind, -gravity);
			missile.run();
		}
		System.out.println(points);
	}

	public List<Point> getPoints() {
		return points;
	} 
	public void draw(Graphics g){
		for(int i = 0; i < points.size(); i++){
			Point p = points.get(i);
			g.fillOval(p.x +10,450 - p.y, 4, 4);
		}
	}
}
