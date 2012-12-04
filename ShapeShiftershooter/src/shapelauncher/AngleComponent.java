package shapelauncher;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class AngleComponent extends JComponent implements MouseListener, MouseMotionListener{
	float x;
	float y;
	float dx;
	float dy;
	float theta;
	float magnitude;
	
	/**
	 * 
	 * @param x: x-position to start drawing the angle
	 * @param y: y-position to start drawing the angle
	 * @param magnitude: magnitude, how big we wantthe angle to appear
	 * @param theta: theta for this angle
	 */
	public AngleComponent(float x, float y, float magnitude, float theta){
		this.x = x;
		this.y = y;
		this.magnitude = magnitude;
		this.theta = theta;
		this.dy = (float) (magnitude*Math.sin(Math.toRadians(theta)))*-1;
		this.dx = (float) (magnitude*Math.cos(Math.toRadians(theta)));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		//super.pafloatComponent(g);
		int x = (int) this.x;
		int y = (int) this.y;
		int magnitude = (int) this.magnitude;
		int dx = (int) this.dx;
		int dy = (int) this.dy;
		g.drawLine(x, y, x + magnitude, y);
		g.drawLine(x, y, x + dx, y + dy);		
	}
	
	public void setTheta(float theta){
		System.out.println(theta);
		this.theta = theta;
		this.dy = (float) (magnitude*Math.sin(Math.toRadians(theta)))*-1;
		this.dx = (float) (magnitude*Math.cos(Math.toRadians(theta)));
		repaint();
	}
	
	public void setTheta(float dx, float dy) {
		this.theta = (float) Math.toDegrees(Math.atan(dx / dy));
		this.dx = dx;
		this.dy = dy;
		System.out.println(dx);
		System.out.println(dy);
		repaint();
	}
	
	public void calcTheta(MouseEvent e) {
		dx = e.getX() - x;
		dy = y - e.getY();
		setTheta(dx, dy);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		calcTheta(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		calcTheta(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
