package shapelauncher;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class Environment extends JPanel {
	
	private Missile missile;
	private int wind;
	private Shape target;
	private int gravity;
	private Path path;
	private int numStage = 0;
	private int size = 20;
	Random rand = new Random();
	private int frame;
	
	public Environment(){
		//missile = new Missile(numStage%3);
		setAccelerations();
		createTarget();
		frame = 0;
	}
	
	//Generate random values for wind and gravity
	private void setAccelerations() {
		wind = rand.nextInt(3);
		gravity = rand.nextInt(2) + 1;
	}

	//Generate a randomly placed target to shoot for
	private void createTarget() {
		int rx = rand.nextInt()%300 + 300;
		int ry = rand.nextInt()%40 + 400;
		if(numStage%3 ==0){
			target = new Circle(rx, ry, size);
		}
		else if(numStage%3 == 1){
			target = new Rectangle(rx, ry, size, size);
		}
		else{
			target = new Triangle(rx, ry, rx-size, ry+size, rx+size, ry+size);
		}
	}

	public void run(){
//		if(missile != null) {
//			while(true){
//				missile.run();
//				missile.accelerate(0, -gravity);
//				System.out.println(missile.getYPosition());
//				if(missile.getYPosition() == 0) break;
//				repaint();
//			
//			}
//		}
	}
	
	//re paint missile and target and path
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(missile != null)
			missile.getShape().draw(g);
		target.draw(g);
		if(path != null){
			path.draw(g);
		}
		//repaint();
	}
	
	//create a path object based on the curret magnitude and angle
	public void calculatePath(int mag, int angle){
		path = new Path(mag, angle, gravity, wind, numStage);
		repaint();
	}
	
	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}

	//create a missile object and animate it in  a thread.
	public void launchMissile(int magnitude, int angle) {
		this.missile = new Missile(numStage%3);
		System.out.println(magnitude + ": mag it is");
		this.missile.accelerateAngle(magnitude, angle);
		repaint();
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				missile.accelerate(wind, -gravity);
				missile.run();
				repaint();
				
				//while the missile hasn't yet hit the ground, continue animation
				while(missile.getYPosition() > 0) {
					System.out.println("Run");
					missile.accelerate(wind, -gravity);
					missile.run();
					checkCollision();
					repaint();
					try {
						Thread.sleep(32);
					} catch (Exception e) {}
				}
			}
			
		});
		thread.start();
	}

	public Missile getMissile() {
		return missile;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	//check if the missile has hit the target
    public void checkCollision() {
    	System.out.println("" + target.contains(missile) + missile.getXPosition() + " "  + target.x);
    	System.out.println(missile.getYPosition() + ": "+ target.y);
		if(target.contains(missile)) {
			System.out.println("word");
			numStage++;
			missile = null;
			createTarget();
//			setAccelerations();
		}
	}
	
}
