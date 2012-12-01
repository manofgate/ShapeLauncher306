package shapelauncher;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AnglePanel extends JPanel{
	public double angle = 0;
	public JPanel panel;
	public JTextField inputedAngle;
	int x = 25;
	int y = 500;
	int size = 100;
	AngleComponent anglePart;
	
	public AnglePanel(Environment environment){
		panel = new JPanel();
		setPreferredSize(new Dimension(150, 500));
		setLayout(new GridLayout(0,1));
		super.
		setBorder(new TitledBorder(new EtchedBorder(), "Choose your angle:"));
		inputedAngle = new JTextField("Angle");
		add(inputedAngle);

		JButton set = new JButton("Set Angle");
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					angle = Double.parseDouble(inputedAngle.getText());
				} catch(NumberFormatException nfe){
					inputedAngle.setText("Sorry, I can't read that.");
				}
			}
			
		});	
		
		JButton display = new JButton("Display angle");
		display.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				angle = Double.parseDouble(inputedAngle.getText());
				if(anglePart == null){
					anglePart = new AngleComponent(x,y,size,(int)angle);
					add(anglePart);
					validate();
				}
				else{
					anglePart.setTheta((int) angle);
				}
				repaint(); // repaint the board
			}
		});
		
		//Other options that we could have here: A launch button and a magnitude/set magnitide pair
		add(display);
		add(set);
		add(panel);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(anglePart != null){
			System.out.println(anglePart.theta);
			anglePart.paintComponent(g);
		}
	}
}
