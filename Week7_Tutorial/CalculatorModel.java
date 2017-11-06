
public class CalculatorModel {
	private long firstNumber;
	private long secondNumber;
	private int operation;

	
	public static final int ADD = 0;
	public static final int SUBTRACT = 1;
	public static final int MULTIPLY = 2;
	public static final int DIVIDE = 3;
	
		
	public void setFirstNumber(long f) { this.firstNumber = f; }
	public void setSecondNumber(long f) { this.secondNumber = f;}
	public void setOperation(int o) { this.operation = o;}

	public long evaluate() {
		switch(this.operation){
		case ADD:
			return firstNumber + secondNumber;
		case SUBTRACT:
			return firstNumber - secondNumber;
		case MULTIPLY:
			return firstNumber * secondNumber;
		case DIVIDE:
			return firstNumber / secondNumber;
		default:
			return 0;
		}
			
	}	

	public static void main(String[] args) {
		CalculatorModel c = new CalculatorModel();
		c.setFirstNumber(10);
		c.setOperation(CalculatorModel.ADD);
		c.setSecondNumber(20);
		System.out.println(c.evaluate());
	}
	
}
