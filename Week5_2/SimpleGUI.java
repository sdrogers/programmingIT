import java.awt.*;
import javax.swing.*;

public class SimpleGUI extends JFrame
{
	//instance variables are all the components 
	private JButton myButton;
	private JLabel westLabel, centerLabel, eastLabel;
	private JTextField myField;
	
	//The constructor does some initialisation 
	//adds all the components to the frame
        public SimpleGUI () {
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setTitle("A sample GUI showing border layout");
	        setSize(400,300);
		this.layoutComponents();
	}
	
	//adds each component in turn to the content pane
	private void layoutComponents()
	{
    		myButton = new JButton("North");
		this.add(myButton, BorderLayout.NORTH);

		westLabel = new JLabel("West");
		this.add(westLabel, BorderLayout.WEST);

		centerLabel = new JLabel("Center");
		this.add(centerLabel, BorderLayout.CENTER);

		eastLabel = new JLabel("East");
		this.add(eastLabel, BorderLayout.EAST);

		myField = new JTextField("South", 10);
		this.add(myField, BorderLayout.SOUTH);
	}
}
