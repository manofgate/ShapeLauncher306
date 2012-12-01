package shapelauncher;

import java.awt.Graphics;

public abstract class Shape {
	int x;
	int y;
	
	public abstract void draw(Graphics g);
	public abstract boolean contains(Missile m);
}
