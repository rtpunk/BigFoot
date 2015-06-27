package com.woidkedesigns.bigfoot;

public class ItemToStomp {
	
	private int x, y;
	private boolean isSquishable;

	public ItemToStomp() {
		x = (int)BigFoot.stageWidth / 2 - 20;
		y = (int)BigFoot.stageHeight / 3 * 2;
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
	
	public boolean getIsSquishable() {
		return isSquishable;
	}
	
	public void setIsSquishable(boolean isSquishable) {
		this.isSquishable = isSquishable;
	}
	
}
