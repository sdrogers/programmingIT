<<<<<<< HEAD
//import java classes for GUI components
import javax.swing.*;
import java.awt.event.*;

public class MinMaxAveController implements ActionListener
{  
	private MinMaxAveView viewObject;
	private MinMaxAveModel modelObject;

	public MinMaxAveController(MinMaxAveModel model) {
		modelObject = model;
		// Alternatively...
		// viewObject = MinMaxAveView(modelObject, this);
	}

	public void setView(MinMaxAveView view) {
		viewObject = view;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==viewObject.enterField) {
			String numString = viewObject.enterField.getText().trim();
			try {
				double num = Double.parseDouble(numString);
				modelObject.enterNum(num);
				viewObject.updateTextFields();
			}
			catch (NumberFormatException nfx) {
				JOptionPane.showMessageDialog(viewObject, "Enter a double", "Result summary", JOptionPane.ERROR_MESSAGE);
				viewObject.enterField.setText("");
			}
		}
		else if (e.getSource()==viewObject.clearButton) {
			modelObject.resetFields();
			viewObject.resetTextFields();
		}
		else if (e.getSource()==viewObject.quitButton)
			System.exit(0);
	}
}
=======
//import java classes for GUI components
import javax.swing.*;
import java.awt.event.*;

public class MinMaxAveController implements ActionListener
{  
	private MinMaxAveView viewObject;
	private MinMaxAveModel modelObject;

	public MinMaxAveController(MinMaxAveModel model) {
		modelObject = model;
		// Alternatively...
//		 viewObject = MinMaxAveView(modelObject, this);
	}

	public void setView(MinMaxAveView view) {
		viewObject = view;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==viewObject.enterField) {
			String numString = viewObject.enterField.getText().trim();
			try {
				double num = Double.parseDouble(numString);
				modelObject.enterNum(num);
				viewObject.updateTextFields();
			}
			catch (NumberFormatException nfx) {
				JOptionPane.showMessageDialog(viewObject, "Enter a double", "Result summary", JOptionPane.ERROR_MESSAGE);
				viewObject.enterField.setText("");
			}
		}
		else if (e.getSource()==viewObject.clearButton) {
			modelObject.resetFields();
			viewObject.resetTextFields();
		}
		else if (e.getSource()==viewObject.quitButton)
			System.exit(0);
	}
}
>>>>>>> pr/4
