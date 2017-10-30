import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalculatorView extends JFrame {
	private CalculatorModel calc;
	private CalculatorController cont;
	private JTextField intField;
	public JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private JPanel buttonPanel,bottomPanel;
	public JButton aC,plus,minus,divide,multiply,equals;
	
	public CalculatorView(CalculatorModel calc,CalculatorController cont) {
		
		this.cont = cont;
		this.calc = calc;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,300);
		setLocation(100,100);
		intField = new JTextField(20);
		this.add(intField,BorderLayout.NORTH);
		buttonPanel = new JPanel();
		bottomPanel = new JPanel();
		this.add(buttonPanel,BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		addButtons();
		
		this.setVisible(true);
		
		
	}
	public String getIntField() {
		return intField.getText();
	}
	
	public void setIntField(String i) {
		intField.setText(i);
	}
	private void addButtons() {
		
		b0 = new JButton("0");
		b0.addActionListener(cont);
		buttonPanel.add(b0);
		b1 = new JButton("1");
		b1.addActionListener(cont);
		buttonPanel.add(b1);
		b2 = new JButton("2");
		b2.addActionListener(cont);
		buttonPanel.add(b2);
		b3 = new JButton("3");
		b3.addActionListener(cont);
		buttonPanel.add(b3);
		b4 = new JButton("4");
		b4.addActionListener(cont);
		buttonPanel.add(b4);
		b5 = new JButton("5");
		b5.addActionListener(cont);
		buttonPanel.add(b5);
		b6 = new JButton("6");
		b6.addActionListener(cont);
		buttonPanel.add(b6);
		b7 = new JButton("7");
		b7.addActionListener(cont);
		buttonPanel.add(b7);
		b8 = new JButton("8");
		b8.addActionListener(cont);
		buttonPanel.add(b8);
		b9 = new JButton("9");
		b9.addActionListener(cont);
		buttonPanel.add(b9);
		
		aC = new JButton("AC");
		aC.addActionListener(cont);
		bottomPanel.add(aC);
		
		plus = new JButton("+");
		plus.addActionListener(cont);
		bottomPanel.add(plus);
		
		minus = new JButton("-");
		minus.addActionListener(cont);
		bottomPanel.add(minus);
		
		multiply = new JButton("x");
		multiply.addActionListener(cont);
		bottomPanel.add(multiply);
		
		divide = new JButton("/");
		divide.addActionListener(cont);
		bottomPanel.add(divide);
		
		equals = new JButton("=");
		equals.addActionListener(cont);
		bottomPanel.add(equals);
		

	}
	
	public static void main(String[] args) {
		CalculatorModel c = new CalculatorModel();
		CalculatorController co = new CalculatorController(c);
		CalculatorView v = new CalculatorView(c,co);
		co.setView(v);
	}
}
