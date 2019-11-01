package swingExercises;
// Ex4
// Add panels containing labels with string "NORTH", "EAST", "SOUTH", "WEST" to a JFrame with Border Layout
// use of JPanels 
// use GridBagLayout for East, West, Center
// add borders

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory; //this is new
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border; // this is new
import java.awt.Color;   // this is new

public class Ex4 extends JFrame {

	public Ex4() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		Border blackline = BorderFactory.createLineBorder(Color.black); // this is new
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		JLabel leftLabel = new JLabel("WEST");
		leftPanel.add(leftLabel);
		leftPanel.setBorder(blackline); // this is new
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		JLabel rightLabel = new JLabel("EAST");
		rightPanel.add(rightLabel);
		rightPanel.setBorder(blackline); // this is new
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("NORTH");
		topPanel.add(topLabel);
		topPanel.setBorder(blackline); // this is new
		
		JPanel bottomPanel = new JPanel();
		JLabel bottomLabel = new JLabel("SOUTH");
		bottomPanel.add(bottomLabel);
		bottomPanel.setBorder(blackline); // this is new
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		JLabel centerLabel = new JLabel("CENTER");
		centerPanel.add(centerLabel);
		
		
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

		Ex4 gui = new Ex4();
		gui.setVisible(true);
	}
}
