/*
 * Demonstrates text fields and event handling
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrintTextGUI extends JFrame implements ActionListener
{
	//instance variables are all the components 
	private JPanel top, middle, bottom;
	private JTextField text;
	private JLabel label;
	private JButton printButton, clearButton;

	//The constructor adds all the components to the frame
	public PrintTextGUI()
	{
		//when the user clicks on the close button, the program exits
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A sample GUI with two buttons");
		setSize(400,150);
		setLocation(100,100);

		//set layout
		layoutComponents();
	}

	private void layoutComponents()
	{
		//top panel is white and contains a button
		top = new JPanel();
		top.setBackground(Color.white);

		//create button with listener and add to the top panel
		printButton = new JButton("Print text");
		printButton.addActionListener(this);
		top.add(printButton);

		clearButton = new JButton("Clear text");
		clearButton.addActionListener(this);
		top.add(clearButton);

		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);

		//middle panel is green and contains a label and a text field
		middle = new JPanel();
		middle.setBackground(Color.green);

		//add a label and a text field to the middle panel
		JLabel enterLabel = new JLabel("Enter text here: ");
		middle.add(enterLabel);
		text = new JTextField(10);
		middle.add(text);
		add(middle, BorderLayout.CENTER);

		bottom = new JPanel();
		bottom.setBackground(Color.yellow);
		label = new JLabel("");
		bottom.add(label);
		add(bottom, BorderLayout.SOUTH);
	}

	//handle button events

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==printButton)
			printText();
		else if (e.getSource()==clearButton)
			clearText();
	}

	//action if print button pressed
	private void printText()
	{
		String s = text.getText();
		label.setText("You entered: \""+s+"\"");
		text.setText("");
	}

	//action if clear button pressed
	private void clearText()
	{
		label.setText("");
		text.setText("");
	}
}
