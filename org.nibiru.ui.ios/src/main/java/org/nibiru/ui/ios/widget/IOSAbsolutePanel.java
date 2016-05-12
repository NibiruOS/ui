package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;

public class IOSAbsolutePanel extends IOSContainer implements AbsolutePanel {
	@Inject
	public IOSAbsolutePanel() {
	}

	@Override
	public Position getPosition(Widget child) {
		final IOSWidget<?> widget = (IOSWidget<?>) child;
		return new Position() {
			
			@Override
			public Position setY(int y) {
				CGRect frame = widget.control.frame();
				widget.control.setFrame(new CGRect(new CGPoint(frame.origin().x(), y), frame.size()));
				return this;
			}
			
			@Override
			public Position setX(int x) {
				CGRect frame = widget.control.frame();
				widget.control.setFrame(new CGRect(new CGPoint(x, frame.origin().y()), frame.size()));
				return this;
			}
			
			@Override
			public int getY() {
				return (int) widget.control.frame().origin().y();
			}
			
			@Override
			public int getX() {
				return (int) widget.control.frame().origin().x();
			}
		};
	}

	@Override
	void layout() {
		updateSize(400, 400);
		
	}


}
