package shapelauncher;

import java.awt.Graphics;
import java.util.Random;

public class Missile {
	private int x;
	private int y;
	private int velocityX, velocityY;
	private int theta;
	private Shape shape;
	Random rand = new Random();
	private int size = 15;
	int xDisp;
	int yDisp;
	
	//Missile class to represent a missile that has been fired. nStage is the shape.
	public Missile(int nStage) {
		x = 0;
		y = 0;
		velocityX = 0;
		velocityY = 0;
		theta = 0;
		xDisp = x+10;
		yDisp = 450-y;
		//rand.setSeed(rand.nextLong());
		if(nStage == 0){
			shape = new Circle(xDisp,yDisp,size);
		}
		else if(nStage == 1){
			shape = new Rectangle(xDisp, yDisp, size, size);
		}
		else{
			shape = new Triangle(xDisp, yDisp, xDisp-size, yDisp+size, xDisp+size, yDisp+size);
		}
	}

	//Change the velocity of this missile based on an angle and magnitude
	public void accelerateAngle(int magnitude, int angle) {
		int dx = (int) (Math.cos(Math.toRadians(angle)) * magnitude);
		int dy = (int) (Math.sin(Math.toRadians(angle)) * magnitude);
		accelerate(dx, dy);
	}

	//Change the velocity of this missile
	public void accelerate(int dx, int dy) {
		velocityX += dx;
		velocityY += dy;
	}

	//Move the missile given its current velocity.
	public void run() {
		move(velocityX, velocityY);
		
		shape.x = x+ 10;
		shape.y = 450-y;
		
	if((shape instanceof Triangle)){
			((Triangle) shape).vertex1.x = x+10-size;
			((Triangle) shape).vertex2.x = x +10+size;
			((Triangle) shape).vertex2.y = 450-y +size;
			((Triangle) shape).vertex1.y = 450 -y + size;
		}
	}

	public void stop() {
		velocityX = 0;
		velocityY = 0;
	}

	//move
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
