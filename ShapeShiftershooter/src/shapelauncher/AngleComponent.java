package shapelauncher;

import java.awt.Graphics;

import javax.swing.JComponent;

public class AngleComponent extends JComponent {
	int x;
	int y;
	int dx;
	int dy;
	int theta;
	int magnitude;
	
	/**
	 * 
	 * @param x: x-position to start drawing the angle
	 * @param y: y-position to start drawing the angle
	 * @param magnitude: magnitude, how big we wantthe angle to appear
	 * @param theta: theta for this angle
	 */
	public AngleComponent(int x, int y, int magnitude, int theta){
		this.x = x;
		this.y = y;
		this.magnitude = magnitude;
		this.theta = theta;
		this.dy = (int) (magnitude*Math.sin(Math.toRadians(theta)))*-1;
		this.dx = (int) (magnitude*Math.cos(Math.toRadians(theta)));
	}
	
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		g.drawLine(x, y, x + magnitude, y);
		g.drawLine(x, y, x + dx, y + dy);		
	}
	
	public void setTheta(int theta){
		this.theta = theta;
		this.dy = (int) (magnitude*Math.sin(Math.toRadians(theta)))*-1;
		this.dx = (int) (magnitude*Math.cos(Math.toRadians(theta)));
	}
}
