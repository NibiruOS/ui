package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.uikit.UIView;

public class IOSAbsolutePanel extends IOSContainer implements AbsolutePanel {
	@Inject
	public IOSAbsolutePanel() {
	}

	@Override
	public Position getPosition(Widget child) {
		final UIView view = (UIView) child.asNative();
		return new Position() {
			
			@Override
			public Position setY(int y) {
				CGRect frame = view.frame();
				view.setFrame(new CGRect(new CGPoint(frame.origin().x(), y), frame.size()));
				return this;
			}
			
			@Override
			public Position setX(int x) {
				CGRect frame = view.frame();
				view.setFrame(new CGRect(new CGPoint(x, frame.origin().y()), frame.size()));
				return this;
			}
			
			@Override
			public int getY() {
				return (int) view.frame().origin().y();
			}
			
			@Override
			public int getX() {
				return (int) view.frame().origin().x();
			}
		};
	}
	
	@Override
	public void requestLayout() {
	}

	@Override
	protected int getNativeHeight() {
		// TODO Fix value - add size computation
		return 480;
	}

	@Override
	protected int getNativeWidth() {
		// TODO Fix value - add size computation
		return 320;
	}
}
