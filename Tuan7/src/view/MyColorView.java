package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MyColorListener;
import model.MyColorModel;

public class MyColorView  extends JFrame{
	
	private MyColorModel myColorModel;
	private JLabel jLabel;
	
	public MyColorView() {
		this.myColorModel = new MyColorModel();
		
		this.init();
		}

	private void init() {
		this.setTitle("My Color");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpanel = new JPanel();
		jLabel = new JLabel("Le Dac Dat DZ",JLabel.CENTER);
		Font font_text = new Font("Times new roman", Font.BOLD, 100);
		jLabel.setFont(font_text);
		jpanel.setLayout(new GridLayout(2,3));
		
		Font font = new Font("Times new roman", Font.BOLD, 40);
		
		MyColorListener ac = new MyColorListener(this);
		
		JButton jbtn_text_red = new JButton("Red text");
		jbtn_text_red.setFont(font);
		jbtn_text_red.setForeground(Color.RED);
		jbtn_text_red.addActionListener(ac);
		JButton jbtn_text_yellow = new JButton("Yellow text");
		jbtn_text_yellow.setFont(font);
		jbtn_text_yellow.setForeground(Color.YELLOW);
		jbtn_text_yellow.addActionListener(ac);
		JButton jbtn_text_green = new JButton("Green text");
		jbtn_text_green.setFont(font);
		jbtn_text_green.setForeground(Color.GREEN);
		jbtn_text_green.addActionListener(ac);
		JButton jbtn_back_red = new JButton("Red Back");
		jbtn_back_red.setFont(font);
		jbtn_back_red.setBackground(Color.RED);
		jbtn_back_red.setOpaque(true);
		jbtn_back_red.addActionListener(ac);
		JButton jbtn_back_yellow = new JButton("Yellow Back");
		jbtn_back_yellow.setFont(font);
		jbtn_back_yellow.setBackground(Color.YELLOW);
		jbtn_back_yellow.setOpaque(true);
		jbtn_back_yellow.addActionListener(ac);
		JButton jbtn_back_green = new JButton("Green Back");
		jbtn_back_green.setFont(font);
		jbtn_back_green.setBackground(Color.GREEN);
		jbtn_back_green.setOpaque(true);
		jbtn_back_green.addActionListener(ac);
		
		jpanel.add(jbtn_text_red);
		jpanel.add(jbtn_text_yellow);
		jpanel.add(jbtn_text_green);
		jpanel.add(jbtn_back_red);
		jpanel.add(jbtn_back_yellow);
		jpanel.add(jbtn_back_green);
		
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.NORTH);
		this.add(jpanel, BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
		
	}
	
	public void changeColorText(Color color) {
		this.jLabel.setForeground(color);
	}
	public void changeColorBack(Color color) {
		this.jLabel.setBackground(color);
		this.jLabel.setOpaque(true);
	}
	
	

}
