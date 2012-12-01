package shapelauncher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameScreen extends JFrame{
	Environment environment;
	AnglePanel anglePanel;
	
	public GameScreen() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shape Shifting Shooter");
		
		environment = new Environment();
		anglePanel = new AnglePanel(environment);
		
		add(environment, BorderLayout.CENTER);
		add(anglePanel, BorderLayout.WEST);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(createFileMenu());
	}
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File"); 
		menu.add(createFileExitItem());
		return menu;
	}
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
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
