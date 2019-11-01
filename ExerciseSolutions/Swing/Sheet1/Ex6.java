package swingExercises;
// Ex6
// Add panels containing labels with string "NORTH", "EAST", "SOUTH", "WEST" to a JFrame with Border Layout
// use of JPanels 
// use GridBagLayout for East, West, Center
// add borders
// change font of labels
// change East and West labels to run vertically

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Font; // this is new
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;   

public class Ex6 extends JFrame {

	public Ex6() {
		this.setTitle("Border layout for JFrame");
		final int WIDTH = 400;
		this.setSize(WIDTH, WIDTH);
		Border blackline = BorderFactory.createLineBorder(Color.black); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("TimesRoman", Font.PLAIN, 24); 
		
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout()); // next line is new
		JLabel leftLabel = new JLabel("<html> &nbsp W &nbsp <br> &nbsp E "
				+ "&nbsp <br>&nbsp S &nbsp<br> &nbsp T &nbsp </html>");
		//JLabel leftLabel = new JLabel("<html> W <br> E <br> S <br> T </html>"); 
		leftPanel.add(leftLabel);
		leftPanel.setBorder(blackline); 
		leftLabel.setFont(f);  
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout()); // next line is new
		JLabel rightLabel = new JLabel("<html>&nbsp E &nbsp<br>&nbsp A &nbsp<br>&nbsp S &nbsp<br>&nbsp T &nbsp</html>");
		rightPanel.add(rightLabel);
		rightPanel.setBorder(blackline);
		rightLabel.setFont(f); 
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("NORTH");
		topPanel.add(topLabel);
		topPanel.setBorder(blackline); 
		topLabel.setFont(f); 
		
		JPanel bottomPanel = new JPanel();
		JLabel bottomLabel = new JLabel("SOUTH");
		bottomPanel.add(bottomLabel);
		bottomPanel.setBorder(blackline); 
        bottomLabel.setFont(f); 
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		JLabel centerLabel = new JLabel("CENTER");
		centerPanel.add(centerLabel);
		centerLabel.setFont(f); 
		
		
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

		Ex6 gui = new Ex6();
		gui.setVisible(true);
	}
}
