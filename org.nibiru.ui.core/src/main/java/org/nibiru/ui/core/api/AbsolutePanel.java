package org.nibiru.ui.core.api;

public interface AbsolutePanel extends Container {
	interface Position {
		int getX();

		Position setX(int x);

		int getY();

		Position setY(int y);
	}
	
	Position getPosition(Widget child);
	
	void setNativeSize(int measuredWidth, int measuredHeight);
}
