package shapelauncher;

import java.awt.Graphics;

public class Environment {
	private Missile missle;
	private int wind;
	private Shape target;
	private int gravity;
	
	public void run(){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public Path calculatePath(int x, int y, int velocity){
		Path p = new Path();
		return p;
	}
	
	public void calculateRotation(){
		
	}

	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}
	
}
