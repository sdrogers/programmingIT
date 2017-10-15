/**
 A simple class to show a single frame
 */

//import java classes for GUI components
import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame
{  
	private JButton button1, button2;
	private JLabel label1, label2, label3, label4;
	private JTextField textField;
	private JPanel panel1, panel2;

	public ButtonFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320,300);
		setLocation(100,100);
		setTitle("JFrame with some components");
		this.layoutComponents();
	}

	private void layoutComponents() {
		label1 = new JLabel("This is the North area");
		this.add(label1,BorderLayout.NORTH);

		label2 = new JLabel("West area");
		this.add(label2,BorderLayout.WEST);

		panel1 = new JPanel();
		panel1.setBackground(Color.red);
		button1 = new JButton("Ok");
		button2 = new JButton("Quit");
		panel1.add(button1);
		panel1.add(button2);
		this.add(panel1,BorderLayout.CENTER);

		label3 = new JLabel("East area");
		this.add(label3,BorderLayout.EAST);

		panel2 = new JPanel();
		panel2.setBackground(Color.green);
		label4 = new JLabel("Enter some text");
		textField = new JTextField("initial text",10);
		panel2.add(textField);
		panel2.add(label4);
		this.add(panel2,BorderLayout.SOUTH);
	}
}
