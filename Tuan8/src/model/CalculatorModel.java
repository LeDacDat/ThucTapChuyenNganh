package model;

public class CalculatorModel {
	
	private double first_value;
	private double second_value;
	private double result;
	
	public CalculatorModel() {
	}

	public CalculatorModel(double first_value, double second_value, double result) {
		this.first_value = first_value;
		this.second_value = second_value;
		this.result = result;
	}

	public double getFirst_value() {
		return first_value;
	}

	public void setFirst_value(double first_value) {
		this.first_value = first_value;
	}

	public double getSecond_value() {
		return second_value;
	}

	public void setSecond_value(double second_value) {
		this.second_value = second_value;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public void plus() {
		this.result = this.first_value + this.second_value;
	}
	public void minus() {
		this.result = this.first_value - this.second_value;
	}
	public void mul() {
		this.result = this.first_value * this.second_value;
	}
	public void div() {
		this.result = this.first_value / this.second_value;
	}
	public void pow() {
		this.result = Math.pow(this.first_value, this.second_value);
	}
	public void mod() {
		this.result = this.first_value % this.second_value;
	}

}
