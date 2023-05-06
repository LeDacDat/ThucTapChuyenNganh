package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyColorView;

public class MyColorListener implements ActionListener {
	private MyColorView myColorView;

	public MyColorListener(MyColorView myColorView) {
		this.myColorView = myColorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Red text")) {
			this.myColorView.changeColorText(Color.RED);
		}
		else if(src.equals("Yellow text")) {
			this.myColorView.changeColorText(Color.YELLOW);
		}
		else if(src.equals("Green text")) {
			this.myColorView.changeColorText(Color.GREEN);
		}
		else if(src.equals("Red Back")) {
			this.myColorView.changeColorBack(Color.RED);
		}
		else if(src.equals("Yellow Back")) {
			this.myColorView.changeColorBack(Color.YELLOW);
		}
		else if(src.equals("Green Back")) {
			this.myColorView.changeColorBack(Color.GREEN);
		}
		
	}
	

}
