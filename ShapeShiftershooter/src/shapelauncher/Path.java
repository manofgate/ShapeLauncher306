package shapelauncher;

import java.awt.Point;
import java.util.List;

public class Path {
	List<Point> points;

	public Path(List<Point> points) {
		super();
		this.points = points;
	}

	public Path() {
		super();
	}

	public List<Point> getPoints() {
		return points;
	} 
	
}
