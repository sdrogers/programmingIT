/*
 * Demonstrates fonts and event handling
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonGUI extends JFrame implements ActionListener
{
	//instance variables are all the components 
	private JPanel top, middle;
	private JButton courierButton, serifButton;
	private JLabel myLabel;
	private Font courierFont = new Font("Courier", Font.PLAIN,14);
	private Font serifFont = new Font("Serif", Font.BOLD,16);
	
	//The constructor adds all the components to the frame
	public ButtonGUI()
	{
		//when the user clicks on the close button, the program exits
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,150);
		setTitle("Font selector");
		//set layout
		layoutComponents();
	}
	
	private void layoutComponents()
	{
		//top panel is white and contains 2 buttons
		top = new JPanel();
		top.setBackground(Color.white);
		
		//create 2 buttons with listeners and add  to the top panel
		courierButton = new JButton("Change to courier");
		courierButton.addActionListener(this);
		top.add(courierButton);
		
		serifButton = new JButton("Change to serif");
		serifButton.addActionListener(this);
		top.add(serifButton);
		
		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);
		
		//middle panel is green and contains a label
		//initially with the Courier font
		middle = new JPanel();
		middle.setBackground(Color.green);
		
		myLabel = new JLabel("This text will change font");
		myLabel.setFont(courierFont);
		middle.add(myLabel);
		add(middle,BorderLayout.CENTER);
	}
	
	//handle button events
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == courierButton)
		{
			changeToCourier();
		}
		else if (e.getSource() == serifButton)
		{
			changeToSerif();
		}
	}
	
	//action if courier font requested
	private void changeToCourier()
	{
		if (myLabel.getFont() ==  courierFont)
			myLabel.setText("font is unchanged from Courier");
		else
		{
			myLabel.setFont(courierFont);
			myLabel.setText("font has been changed to " + myLabel.getFont().getName());
		}
		
	}
	
	//action if serif font requested
	private void changeToSerif()
	{
		if (myLabel.getFont() ==  serifFont)
			myLabel.setText("font is unchanged from Serif");
		else
		{
			myLabel.setFont(serifFont);
			myLabel.setText("font has been changed to " + myLabel.getFont().getName());
		}
	}
}
