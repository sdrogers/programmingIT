/**
 * Container class : add(Component c, location);
 * JPanel class : methods setBackground (Color c); add(Component c);
 * JLabel, JButton : setting the text
 * Demonstrates layout only - you can enter text or click the button
 * BUT the program does not respond
 */
import java.awt.*;
import javax.swing.*;

public class NestedLayoutGUI extends JFrame
{
	//instance variables are all the components 
	private JPanel top,left,right,bottom,middle;
	private JButton myButton;
	private JLabel myLabel;
	private JTextField myField;
	
	//The constructor does some initialisation 
	//adds all the components to the frame
	public NestedLayoutGUI ()
	{
		//when the user clicks on the close button, the program exits
		//if this line is omitted, the window is closed
		//BUT the program is still running (doing nothing)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set title and size
		setTitle("A sample GUI showing nested layout");
           	            setSize(400,300);

		//add components
		layoutComponents();
	}
	
	//adds each panel in turn to the content pane
	private void layoutComponents()
	{
		//create the left panel, set the color to be blue
		left = new JPanel();
		left.setBackground(Color.blue);
		//add the left panel to the content pane
		add(left,BorderLayout.WEST);
		
		//right panel is yellow
		right = new JPanel();
		right.setBackground(Color.yellow);
		add(right,BorderLayout.EAST);
		
		//top, middle and bottom panels
		layoutTop();
        layoutMiddle();
		layoutBottom();
	}
	
	//layout of top panel
	private void layoutTop()
	{
		//top panel is red and contains a label and a button
		top = new JPanel();
		top.setBackground(Color.red);
		//create the label and add it to the top panel
		myLabel = new JLabel("Click the Button");
		top.add(myLabel);
		//create the button and add it to the top panel
		myButton = new JButton("Click");
		top.add(myButton);
		
		//add a long label to the top panel
		//this is so long that it will not be shown 
		//unless the frame is big enough
		JLabel label1 = new JLabel("This is a very long label indeed to "
                                         + "demonstrate adding a label to a panel");
		top.add(label1);
		
		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);
	}

	// layout of middle panel
        private void layoutMiddle()
        {
                //middle panel is white and has a Border Layout, containing
                //contains two panels, namely middleTop and middleCenter
	        //middleTop is red and contains a JLabel
                //middleCenter has a Grid Layout with 2 rows and 3 columns,
                //each of which has a JButton
		middle = new JPanel();
                middle.setLayout(new BorderLayout());
		JPanel middleTop = new JPanel();
                JPanel middleCenter = new JPanel();
		middleTop.setBackground(Color.white);
                JLabel label = new JLabel("Grid of buttons below");
                middleTop.add(label);
                middleCenter.setLayout(new GridLayout(2,3));
                for (int i=1; i<=2; i++)
                    for (int j=1; j<=3; j++) {
		       myButton = new JButton(i+","+j);
                       middleCenter.add(myButton);
                    }
		middle.add(middleTop,BorderLayout.NORTH);
                middle.add(middleCenter,BorderLayout.CENTER);
		add(middle,BorderLayout.CENTER);
	}

	//layout of bottom panel
	private void layoutBottom()
	{
		//green bottom panel contains a text field of 20 characters
		bottom = new JPanel();
		bottom.setBackground(Color.green);
		myField = new JTextField(20);
		bottom.add(myField);
		add(bottom,BorderLayout.SOUTH);
	}
}
