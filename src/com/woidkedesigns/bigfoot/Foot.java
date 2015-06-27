package com.woidkedesigns.bigfoot;

public class Foot {

	private int x, y;
	
	public static final String upState = "UP";
	public static final String downState = "DOWN";
	public static final String noState = "NO";
	
	private String state = upState;
	
	public Foot() {
		x = 0;
		y = 0;
	}
	
	public void update() {
		switch (state) {
			case Foot.upState:
				x = 0;
				y = 0;
			break;
			case Foot.downState:
				x = 0;
				y = (int)(BigFoot.stageHeight / 6);
			break;
			case Foot.noState:
			break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
