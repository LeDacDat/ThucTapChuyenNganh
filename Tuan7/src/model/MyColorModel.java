package model;

import java.awt.Color;

public class MyColorModel {
	
	private Color foreGround;
	private Color backGround;
	private boolean opaque;
	
	
	
	public MyColorModel() {
	}

	public MyColorModel(Color foreGround, Color backGround, boolean opaque) {
		this.foreGround = Color.BLACK;
		this.backGround = Color.WHITE;
		this.opaque = true;
	}

	public Color getForeGround() {
		return foreGround;
	}

	public void setForeGround(Color foreGround) {
		this.foreGround = foreGround;
	}

	public Color getBackGround() {
		return backGround;
	}

	public void setBackGround(Color backGround) {
		this.backGround = backGround;
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}
	
	
	
	

}
