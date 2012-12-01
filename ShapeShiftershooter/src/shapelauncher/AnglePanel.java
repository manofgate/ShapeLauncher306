package shapelauncher;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AnglePanel extends JPanel{
	public double angle;
	public JPanel panel;
	public JTextField inputedAngle;
	
	public AnglePanel(){
		panel = new JPanel();
		setPreferredSize(new Dimension(150, 350));
		setLayout(new GridLayout(0,1));
		
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
		add(set);
		
		add(panel);
	}
}
