package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame {
	
	private CounterModel counterModel;
	
	private JButton jbtn_up,jbtn_down,jbtn_reset;
	private JLabel jlabel_value;
	
	public CounterView() {
		
		this.counterModel = new CounterModel();
		this.init();
		this.setVisible(true);
		
	}
	public void init() {
		this.setTitle("Counter");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ac = new CounterListener(this);
		
		jbtn_up = new JButton("UP");
		jbtn_up.addActionListener(ac);
		jbtn_down = new JButton("DOWN");
		jbtn_down.addActionListener(ac);
		jbtn_reset = new JButton("RESET");
		jbtn_reset.addActionListener(ac);
		jlabel_value = new JLabel(this.counterModel.getValue()+"",JLabel.CENTER);
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(jbtn_up, BorderLayout.WEST);
		jpanel.add(jbtn_down,BorderLayout.EAST);
		jpanel.add(jlabel_value,BorderLayout.CENTER);
		jpanel.add(jbtn_reset,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jpanel,BorderLayout.CENTER);
		
	}
	
	public void increment() {
		this.counterModel.increment();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	public void decrement() {
		this.counterModel.decrement();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	public void reset() {
		this.counterModel.reset();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}

}
