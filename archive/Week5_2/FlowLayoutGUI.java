/**
 * Container class : add(Component c, location);
 * JPanel class : methods setBackground (Color c); add(Component c);
 * JLabel, JButton : setting the text
 * Demonstrates layout only - you can enter text or click the button
 * BUT the program does not respond
 */

import java.awt.*;
import javax.swing.*;

public class FlowLayoutGUI extends JFrame
{
	//instance variables are all the components 
        private JPanel blueBox, blackBox, yellowBox, middle, bottom;
	private JButton myButton;
	private JLabel myLabel;
	private JTextField myField;
	
	//The constructor does some initialisation 
	//adds all the components to the frame
	public FlowLayoutGUI ()
	{
		//when the user clicks on the close button, the program exits
		//if this line is omitted, the window is closed
		//BUT the program is still running (doing nothing)
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set title
		this.setTitle("A sample GUI showing flow layout");
		
                this.setLayout(new FlowLayout());
		//add components
		this.layoutComponents();
	}
	
	//adds each panel in turn to the content pane
	private void layoutComponents()
	{
		//create the left panel, set the color to be blue
	        blueBox = new JPanel();
		blueBox.setBackground(Color.blue);
		//add the left panel to the content pane
		this.add(blueBox);
		
		//middle panel is black
		blackBox = new JPanel();
		blackBox.setBackground(Color.black);
		this.add(blackBox);
		
		//right panel is yellow
		yellowBox = new JPanel();
		yellowBox.setBackground(Color.yellow);
		this.add(yellowBox);
		
		//middle and bottom panels
		this.layoutMiddle();
		this.layoutBottom();
	}
	
	//layout of middle panel
	private void layoutMiddle()
	{
		//middle panel is white and contains a label and a button
		middle = new JPanel();
		middle.setBackground(Color.white);
		//create the label and add it to the middle panel
		myLabel = new JLabel("Click the Button");
		middle.add(myLabel);
		//create the button and add it to the middle panel
		myButton = new JButton("Click");
		middle.add(myButton);
		
		//add a long label to the middle panel
		//this is so long that it will not be shown 
		//unless the frame is big enough
		JLabel label1 = new JLabel("This is a very long label indeed to "
                                         + "demonstrate adding a label to a panel");
		middle.add(label1);
		
		//add the middle panel to the content pane
		this.add(middle);
	}
	
	//layout of bottom panel
	private void layoutBottom()
	{
		//green bottom panel contains a text field of 20 characters
		bottom = new JPanel();
		bottom.setBackground(Color.green);
		myField = new JTextField(20);
                myField.setText("this is a test");
		bottom.add(myField);
		this.add(bottom);
	}
}
