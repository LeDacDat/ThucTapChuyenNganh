package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CalculatorListener;
import model.CalculatorModel;

public class CalculatorView extends JFrame{
	private CalculatorModel calculatoeModel;
	private JLabel jlabel_fisrt;
	private JLabel jlabel_second;
	private JLabel jlabel_result;
	private JTextField jtext_first;
	private JTextField jtext_second;
	private JTextField jtext_result;
	
	public CalculatorView() {
		this.calculatoeModel = new CalculatorModel();
		
		this.init();
	}

	private void init() {
		this.setTitle("My CalCulator");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpanelIO = new JPanel();
		jpanelIO.setLayout(new GridLayout(3,2));
		
		Font font = new Font("Times new roman",Font.BOLD,40);
		
		jlabel_fisrt = new JLabel("Value 1:");
		jlabel_fisrt.setFont(font);
		jtext_first = new JTextField(50);
		jtext_first.setFont(font);
		jlabel_second = new JLabel("Value 2:");
		jlabel_second.setFont(font);
		jtext_second = new JTextField(50);
		jtext_second.setFont(font);
		jlabel_result = new JLabel("Result:");
		jlabel_result.setFont(font);	
		jtext_result = new JTextField(50);
		jtext_result.setFont(font);
		
		jpanelIO.add(jlabel_fisrt);
		jpanelIO.add(jtext_first);
		jpanelIO.add(jlabel_second);
		jpanelIO.add(jtext_second);
		jpanelIO.add(jlabel_result);
		jpanelIO.add(jtext_result);
		
		JPanel jpanelButton = new JPanel();
		jpanelButton.setLayout(new GridLayout(2, 3));
		
		CalculatorListener ac = new CalculatorListener(this);
		
		JButton jbtn_plus = new JButton("+");
		jbtn_plus.setFont(font);
		jbtn_plus.addActionListener(ac);
		JButton jbtn_minus = new JButton("-");
		jbtn_minus.setFont(font);
		jbtn_minus.addActionListener(ac);
		JButton jbtn_mul = new JButton("*");
		jbtn_mul.setFont(font);
		jbtn_mul.addActionListener(ac);
		JButton jbtn_div = new JButton("/");
		jbtn_div.setFont(font);
		jbtn_div.addActionListener(ac);
		JButton jbtn_pow = new JButton("^");
		jbtn_pow.setFont(font);
		jbtn_pow.addActionListener(ac);
		JButton jbtn_mod = new JButton("%");
		jbtn_mod.setFont(font);
		jbtn_mod.addActionListener(ac);
		
		jpanelButton.add(jbtn_plus);
		jpanelButton.add(jbtn_minus);
		jpanelButton.add(jbtn_mul);
		jpanelButton.add(jbtn_div);
		jpanelButton.add(jbtn_pow);
		jpanelButton.add(jbtn_mod);
		
		
		this.setLayout(new BorderLayout());
		this.add(jpanelIO, BorderLayout.CENTER);
		this.add(jpanelButton, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public void plus() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.plus();
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}
	public void minus() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.minus();
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}
	public void mul() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.mul();
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}
	public void div() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.div();
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}
	public void pow() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.pow();;
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}
	public void mod() {
		double first_value = Double.valueOf(jtext_first.getText());
		double second_value = Double.valueOf(jtext_second.getText());
		this.calculatoeModel.setFirst_value(first_value);
		this.calculatoeModel.setSecond_value(second_value);
		this.calculatoeModel.mod();;
		this.jtext_result.setText(this.calculatoeModel.getResult()+"");
	}

}
