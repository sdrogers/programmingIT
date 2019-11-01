package swingExercises;
// Ex2
// Add panels containing labels with string "NORTH", "EAST", "SOUTH", "WEST" to a JFrame with Border Layout
// use of JPanels (and default FlowLayout) centers things horizontally, but not vertically!
// Use 

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex2 extends JFrame {

	public Ex2() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		JLabel leftLabel = new JLabel("WEST");
		leftPanel.add(leftLabel);
		
		JPanel rightPanel = new JPanel();
		JLabel rightLabel = new JLabel("EAST");
		rightPanel.add(rightLabel);
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("NORTH");
		topPanel.add(topLabel);
		
		JPanel bottomPanel = new JPanel();
		JLabel bottomLabel = new JLabel("SOUTH");
		bottomPanel.add(bottomLabel);
		
		
		JPanel centerPanel = new JPanel();
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

		Ex2 gui = new Ex2();
		gui.setVisible(true);
	}
}
