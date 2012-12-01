package shapelauncher;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Environment extends JPanel {
	private Missile missile;
	private int wind;
	private Shape target;
	private int gravity;
	private Path path;
	Random rand = new Random();
	public Environment(){
		missile = new Missile();
		if(missile.getShape() instanceof Circle ){
			target = new Circle(300, 450, 15);
		}
		else if(missile.getShape() instanceof Rectangle){
			target = new Rectangle(200, 450, 15, 15);
		}
		else{
			target = new Triangle(200, 450, 200-15, 450+15, 200+15, 450+15);
		}
		wind = rand.nextInt(3);
		gravity = rand.nextInt(3) + 5;
	}
	
	public void run(){
		if(missile != null) {
			missile.run();
			missile.accelerate(0, -gravity);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		missile.getShape().draw(g);
		target.draw(g);
		if(path != null){
			path.draw(g);
		}
	}
	
	public void calculateRotation(){
		
	}
	
	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}

	public void launchMissile(int magnitude, int angle) {
		this.missile = new Missile();
		this.missile.accelerateAngle(magnitude, angle);
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
	
}
