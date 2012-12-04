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
	private int numStage =0;
	private int size = 20;
	Random rand = new Random();
	public Environment(){
		//missile = new Missile(numStage%3);
		int rx = rand.nextInt()%300 + 300;
		int ry = rand.nextInt()%40 + 400;
		wind = rand.nextInt(3);
		gravity = rand.nextInt(2) + 2;
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
		if(missile != null) {
			while(true){
				missile.run();
				missile.accelerate(0, -gravity);
				System.out.println(missile.getYPosition());
				if(missile.getYPosition() == 0) break;
				repaint();
				for(int i = 100000; i>0; --i){
					i=i;
				}
				
			
			}
		}
	}
	
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
	
	public void calcuclatepath(int mag, int angle){
		path = new Path(mag, angle, gravity, 0 ,numStage);
		repaint();
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
		this.missile = new Missile(numStage%3);
		System.out.println(magnitude + ": mag it is");
		this.missile.accelerateAngle(magnitude, angle);
		repaint();
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
