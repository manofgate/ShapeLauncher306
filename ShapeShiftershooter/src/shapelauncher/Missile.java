package shapelauncher;

import java.util.Random;

public class Missile {
	private int x;
	private int y;
	private int velocityX, velocityY;
	private int theta;
	private Shape shape;
	int which;
	Random rand = new Random();
	public Missile() {
		x = 10;
		y = 450;
		velocityX = 0;
		velocityY = 0;
		theta = 0;
		//rand.setSeed(rand.nextLong());
		 which = rand.nextInt() %3;
		if(which == 0){
			shape = new Circle(x,y,10);
		}
		else if(which == 1){
			shape = new Rectangle(x, y, 10, 10);
		}
		else{
			shape = new Triangle(x, y, x-10, y+10, x+10, y+10);
		}
	}

	public void accelerateAngle(int magnitude, int angle) {
		int dx = (int) (Math.cos(Math.toRadians(angle)) * magnitude);
		int dy = (int) (Math.sin(Math.toRadians(angle)) * magnitude);
		accelerate(dx, dy);
	}

	public void accelerate(int dx, int dy) {
		velocityX += dx;
		velocityY += dy;
	}

	public void run() {
		move(velocityX, velocityY);

	}

	public void stop() {
		velocityX = 0;
		velocityY = 0;
	}

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
		if (y < 0)
			y = 0;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXPosition() {
		return x;
	}

	public int getYPosition() {
		return y;
	}

	public int getTheta() {
		return theta;
	}

	public void rotate(int dtheta) {
		this.theta += dtheta;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void calcAngle() {
		this.theta = (int) Math.toDegrees(Math.atan(velocityY / velocityX));
	}
	public Shape getShape(){
		return shape;
	}
}
