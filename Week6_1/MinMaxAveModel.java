public class MinMaxAveModel
{  
	private double minimum, maximum, average, total;
	private int count;

	public MinMaxAveModel() {
		resetFields();
	}

	public void enterNum(double num) {
		count++;
		total += num;
		if (count==1 || num < minimum)
			minimum = num;
		if (count==1 || num > maximum)
			maximum = num;
	}

	public void resetFields() {
		minimum = 0.0;
		maximum = 0.0;
		average = 0.0;
		total = 0.0;
		count = 0;
	}

	public double getMinimum() {
		return minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public double getAverage() {
		if (count>0)
			average = total / count;
		return average;
	}
}
