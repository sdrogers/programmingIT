package swingExercises;
// Ex5
// Add panels containing labels with string "NORTH", "EAST", "SOUTH", "WEST" to a JFrame with Border Layout
// use of JPanels 
// use GridBagLayout for East, West, Center
// add borders
// change font of labels

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Font; // this is new
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;   

public class Ex5 extends JFrame {

	public Ex5() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		Border blackline = BorderFactory.createLineBorder(Color.black); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("TimesRoman", Font.PLAIN, 24); // this is new
		
		 
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		JLabel leftLabel = new JLabel("WEST");
		leftPanel.add(leftLabel);
		leftPanel.setBorder(blackline); 
		leftLabel.setFont(f);  // this is new
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		JLabel rightLabel = new JLabel("EAST");
		rightPanel.add(rightLabel);
		rightPanel.setBorder(blackline);
		rightLabel.setFont(f); // this is new
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("NORTH");
		topPanel.add(topLabel);
		topPanel.setBorder(blackline); 
		topLabel.setFont(f); // this is new
		
		JPanel bottomPanel = new JPanel();
		JLabel bottomLabel = new JLabel("SOUTH");
		bottomPanel.add(bottomLabel);
		bottomPanel.setBorder(blackline); 
        bottomLabel.setFont(f); // this is new
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		JLabel centerLabel = new JLabel("CENTER");
		centerPanel.add(centerLabel);
		centerLabel.setFont(f); // this is new
		
		
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);		

	}

	/*
	 * Main method -- creates the BorderFrame object
	 */
	public static void main(String[] args) {

		Ex5 gui = new Ex5();
		gui.setVisible(true);
	}
}
