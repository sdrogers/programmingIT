import java.awt.*; //Needed for BorderLayout
import java.awt.event.*; //Needed for Action Listeners etc
import javax.swing.*; //Needed for JFrame and JButton

public class EasyButton extends JFrame implements ActionListener {
	private JButton button;
	
	// Constructor: set standard JFrame things and make button
	public EasyButton() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Simplest Button ever");
		setSize(400,150);
		setLocation(100,100);
		
		// Make button
		button = new JButton("Press me");
		
		// Add button to the frame (this)
		this.add(button,BorderLayout.NORTH);
		
		// Add this object (the EasyButton object)
		// as the actionlistener for the button.
		// i.e. when the button is pressed, EasyButton 
		// should process the event
		button.addActionListener(this);
		
		// Make the frame visible
		this.setVisible(true);
		
	}
	
	// This method has to be written if we're
	// implementing the ActionListener interface
	// It is called by any component (when e.g. clicked) 
	// which has EasyButton assigned as its listener 
	public void actionPerformed(ActionEvent e) {
		System.out.println("Press me!");
	}
	
	// Main method within the class just creates the EasyButton object
	public static void main(String[] args) {
		new EasyButton();
	}
}
