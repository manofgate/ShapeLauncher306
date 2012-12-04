package shapelauncher;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AnglePanel extends JPanel {
	public double angle = 0;
	public final JPanel panel;
	int x = 25;
	int y = 360;
	int size = 100;
	AngleComponent anglePart;
	public final JSlider magnitudeSlider;
	private JSlider angleSlider;
	private JLabel angleDisplay;
	private JLabel magnitudeDisplay;
	
	
	//Panel to represent the angle controls on the left of the screen.
	public AnglePanel(final Environment environment){
		panel = new JPanel();
		setPreferredSize(new Dimension(150, 500));
		setLayout(new GridLayout(0,1));
		super.
		setBorder(new TitledBorder(new EtchedBorder(), "Choose your angle:"));

		JButton set = new JButton("Fire");
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					angle = angleSlider.getValue();
					environment.launchMissile(magnitudeSlider.getValue(), (int) angleSlider.getValue());
//					environment.run();
					environment.calculatePath(magnitudeSlider.getValue(), (int) angleSlider.getValue());
					environment.checkCollision();
				} catch(NumberFormatException nfe){ }
			}
			
		});
		
		anglePart = new AngleComponent(x, y, 50, 45);
		
		JLabel angleLabel = new JLabel("Choose Angle:");
		
		angleSlider = new JSlider(0, 90);
		angleSlider.setValue(45);
		angleSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				anglePart.setTheta(angleSlider.getValue());
				angleDisplay.setText("" + angleSlider.getValue() + " degrees");
			}
		});
		
		angleDisplay = new JLabel("45 degrees");

		JLabel magnitudeLabel = new JLabel("Choose Magnitude:");
		
		magnitudeSlider = new JSlider(0, 50);
		magnitudeSlider.setValue(10);
		
		magnitudeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				magnitudeDisplay.setText("" + magnitudeSlider.getValue() + " m/s");
			}
		});
		
		magnitudeDisplay = new JLabel("10 m/s");
		
		JLabel gravity = new JLabel("Gravity: " + environment.getGravity());
		JLabel wind = new JLabel("Wind: " + environment.getWind());
		
		//Other options that we could have here: A launch button and a magnitude/set magnitide pair
		add(set);
		add(gravity);
		add(wind);
//		add(panel);
        add(angleLabel);
        add(angleSlider);
        add(angleDisplay);
		add(anglePart);
        add(magnitudeLabel);
		add(magnitudeSlider);
		add(magnitudeDisplay);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(anglePart != null){
			System.out.println(anglePart.theta);
			anglePart.paintComponent(g);
		}
	}
}
