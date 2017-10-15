/**
 A simple class to show a single frame
*/

//import java classes for GUI components
import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame
{  
    private JButton button1, button2;
    private JLabel label1, label2;
    private JTextField textField;

    public ButtonFrame() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(300,300);
	setLocation(100,100);
	setTitle("JFrame with some components");
	button1 = new JButton("Ok");
	button2 = new JButton("Quit");
	label1 = new JLabel("Click a button");
	label2 = new JLabel("Enter some text");
	textField = new JTextField("initial text",10);

        // next 6 lines will be covered this afternoon!
	setLayout(new FlowLayout());
	this.add(label1);
	this.add(button1);
	this.add(button2);
	this.add(label2);
	this.add(textField);
    }
}
