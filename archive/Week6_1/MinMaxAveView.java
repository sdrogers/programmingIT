//import java classes for GUI components
import javax.swing.*;
import java.awt.*;

public class MinMaxAveView extends JFrame
{  
	public JButton clearButton, quitButton;
	public JTextField enterField;
	private JTextField minField, maxField, aveField;
	private MinMaxAveController controllerObject;
	private MinMaxAveModel modelObject;

	public MinMaxAveView(MinMaxAveModel model, MinMaxAveController controller) {
		controllerObject = controller;
		modelObject = model;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,150);
		setLocation(100,100);
		setTitle("Minimum Maximum Average");
		setLayout(new GridLayout(5,2));
		layoutComponents();
	}

	private void layoutComponents() {
		clearButton = new JButton("Clear");
		clearButton.addActionListener(controllerObject);
		quitButton = new JButton("Quit");
		quitButton.addActionListener(controllerObject);

		JLabel enterLabel = new JLabel("Enter a Number");
		JLabel minLabel = new JLabel("Minimum");
		JLabel maxLabel = new JLabel("Maximum");
		JLabel aveLabel = new JLabel("Average");

		enterField = new JTextField("");
		enterField.addActionListener(controllerObject);
		minField = new JTextField("");
		maxField = new JTextField("");
		aveField = new JTextField("");
		enterField.setEditable(true);
		minField.setEditable(false);
		maxField.setEditable(false);
		aveField.setEditable(false);

		this.add(clearButton);
		this.add(quitButton);
		this.add(enterLabel);
		this.add(enterField);
		this.add(minLabel);
		this.add(minField);
		this.add(maxLabel);
		this.add(maxField);
		this.add(aveLabel);
		this.add(aveField);
	}

	public void resetTextFields() {
		enterField.setText("");
		minField.setText("");
		maxField.setText("");
		aveField.setText("");
	}

	public void updateTextFields() {
		enterField.setText("");
		minField.setText(""+modelObject.getMinimum());
		maxField.setText(""+modelObject.getMaximum());
		aveField.setText(""+modelObject.getAverage());
	}
}
