package shapelauncher;

public class Missile {
	private int x;
	private int y;
	private int velocityX, velocityY;
	private int theta;
	private Shape shape;

	public Missile() {
		x = 0;
		y = 0;
		velocityX = 0;
		velocityY = 0;
		theta = 0;
	}
	
	public void accelerateAngle(int magnitude, int angle) {
		
	}
	
	public void accelerate(int dx, int dy) {
		velocityX += dx;
		velocityY += dy;
	}
	
	public void run() {
		x += velocityX;
		y += velocityY;
	}
	
	public void stop() {
		velocityX = 0;
		velocityY = 0;
	}

	public void move(int dx, int dy) {

	}

	public void moveTo(int x, int y) {

	}

	public boolean isWithin(Shape target) {
		return false;
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

	}

	public int getVelocityX() {
		return velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}
	
	public void calcAngle() {
		
	}
}
