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
	int y = 500;
	int size = 100;
	AngleComponent anglePart;
	public final JSlider magnitudeSlider;
	private JSlider angleSlider;
	
	public AnglePanel(final Environment environment){
		panel = new JPanel();
		setPreferredSize(new Dimension(150, 500));
		setLayout(new GridLayout(0,1));
		super.
		setBorder(new TitledBorder(new EtchedBorder(), "Choose your angle:"));

		JButton set = new JButton("Set Angle");
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					angle = angleSlider.getValue();
					environment.launchMissile(magnitudeSlider.getValue(), (int) angleSlider.getValue());
					environment.run();
					environment.calculatePath(magnitudeSlider.getValue(), (int) angle);
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
			}
		});

		JLabel magnitudeLabel = new JLabel("Choose Magnitude:");
		
		magnitudeSlider = new JSlider(0, 50);
		magnitudeSlider.setValue(10);
		
		//Other options that we could have here: A launch button and a magnitude/set magnitide pair
		add(set);
		add(panel);
        add(angleLabel);
        add(angleSlider);
        add(magnitudeLabel);
		add(magnitudeSlider);
		add(anglePart);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(anglePart != null){
			System.out.println(anglePart.theta);
			anglePart.paintComponent(g);
		}
	}
}
