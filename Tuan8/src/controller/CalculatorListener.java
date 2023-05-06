package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CalculatorView;

public class CalculatorListener implements ActionListener {
	
	private CalculatorView calculatorView;

	public CalculatorListener(CalculatorView calculatorView) {
		this.calculatorView = calculatorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("+")) {
			this.calculatorView.plus();
		}
		else if(button.equals("-")) {
			this.calculatorView.minus();
		}
		else if(button.equals("*")) {
			this.calculatorView.mul();;
		}
		else if(button.equals("/")) {
			this.calculatorView.div();
		}
		else if(button.equals("^")) {
			this.calculatorView.pow();
		}
		else if(button.equals("%")) {
			this.calculatorView.mod();
		}
		
	}
	

}
