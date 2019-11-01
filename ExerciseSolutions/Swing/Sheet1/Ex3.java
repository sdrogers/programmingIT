package swingExercises;
// Ex3
// Add panels containing labels with string "NORTH", "EAST", "SOUTH", "WEST" to a JFrame with Border Layout
//use of JPanels 
//use GridBagLayout for East, West, Center

import java.awt.BorderLayout;

import java.awt.GridBagLayout; // this is new
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3 extends JFrame {

	public Ex3() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout()); // this is new
		JLabel leftLabel = new JLabel("WEST");
		leftPanel.add(leftLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout()); // this is new
		JLabel rightLabel = new JLabel("EAST");
		rightPanel.add(rightLabel);
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("NORTH");
		topPanel.add(topLabel);
		
		JPanel bottomPanel = new JPanel();
		JLabel bottomLabel = new JLabel("SOUTH");
		bottomPanel.add(bottomLabel);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout()); // this is new
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

		Ex3 gui = new Ex3();
		gui.setVisible(true);
	}
}
