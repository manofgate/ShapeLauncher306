package shapelauncher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class GameScreen extends JFrame{
	Environment environment;
	
	public GameScreen() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		environment = new Environment();
		add(environment, BorderLayout.CENTER);
	}
	
	/*@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		Path path = new Path(100, 45, 25, 0);
		g.setColor(Color.BLACK);
		for(Point p : path.getPoints()) {
			g.fillOval(p.x, 500 - p.y, 5, 5);
		}
	}
	*/
	public static void main(String[] args) {
		new GameScreen().setVisible(true);
	}
}
