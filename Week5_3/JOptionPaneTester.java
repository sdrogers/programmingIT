/**
 Class to demonstrate possible usages of JOptionPane
 */

import javax.swing.*;

public class JOptionPaneTester
{
	public static void main(String[] args)
	{
		// Create a JOptionPane with a yes/no answer
		int result1 = JOptionPane.showConfirmDialog(null, "Do you want to proceed?");
		if (result1 == JOptionPane.YES_OPTION) {
			// if user wants to proceed, prompt for some data
			String result = JOptionPane.showInputDialog(null, "Enter some data");
			// if some data entered, report it back to user
			if (result != null)
				JOptionPane.showMessageDialog(null, "You entered \"" + result + "\"", 
						"Result summary", JOptionPane.INFORMATION_MESSAGE);
			// otherwise give an error message
			else JOptionPane.showMessageDialog(null, "No data provided", 
					"Result summary", JOptionPane.ERROR_MESSAGE);
		}
		// if the user did not want to proceed, confirm the choice
		else
			JOptionPane.showMessageDialog(null, "Ok, no input requested",
					"Result summary", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
