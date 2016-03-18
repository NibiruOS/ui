package com.aajtech.ui.core.api;

public interface AbsolutePanel extends Container {
	public interface Position {
		int getX();

		Position setX(int x);

		int getY();

		Position setY(int y);
	}
	
	public Position getPosition(Widget child);
	
	public void setNativeSize(int measuredWidth, int measuredHeight);
}
