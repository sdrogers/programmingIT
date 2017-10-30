import java.awt.event.*;

public class CalculatorController implements ActionListener {
	private CalculatorModel calc;
	private CalculatorView view;
	public CalculatorController(CalculatorModel calc) {
		this.calc = calc;
	}
	
	public void setView(CalculatorView view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.aC) {
			view.setIntField("");
		}else if(e.getSource() == view.plus) {
			sendFirstNumber();
			calc.setOperation(CalculatorModel.ADD);
		}else if(e.getSource() == view.minus) {
			sendFirstNumber();
			calc.setOperation(CalculatorModel.SUBTRACT);
		}else if(e.getSource() == view.multiply) {
			sendFirstNumber();
			calc.setOperation(CalculatorModel.MULTIPLY);
		}else if(e.getSource() == view.divide) {
			sendFirstNumber();
			calc.setOperation(CalculatorModel.DIVIDE);			
		}else if(e.getSource() == view.equals) {
			calc.setSecondNumber((long)Integer.parseInt(view.getIntField()));
			long a = calc.evaluate();
			view.setIntField(""+a);
		}else{
			appendText(e.getActionCommand());
		}
	}
	private void sendFirstNumber() {
		calc.setFirstNumber((long)Integer.parseInt(view.getIntField()));
		view.setIntField("");
	}
	private void appendText(String t) {
		String te = view.getIntField();
		te += t;
		view.setIntField(te);
	}
}
