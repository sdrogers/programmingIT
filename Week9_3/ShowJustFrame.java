/**
 A simple class to show a single frame
*/

//import java classes for GUI components
import javax.swing.*;

public class ShowJustFrame
{  //you would NEVER actually do this, it is useless
	public static void main(String [] args)
	{
		JFrame justAFrame = new JFrame();
		justAFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		justAFrame.setSize(300,300);
		justAFrame.setLocation(100,100);
		justAFrame.setTitle("Just a JFrame");
		justAFrame.setVisible(true);
	}
}
