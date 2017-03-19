package org.nibiru.ui.dotnet.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import cli.System.Windows.Controls.StackPanel;
import cli.System.Windows.FrameworkElement;

public class DotNetAbsolutePanel extends DotNetContainer implements AbsolutePanel {
	@Inject
	public DotNetAbsolutePanel() {
		super(new StackPanel());
	}

	@Override
	public Position getPosition(Widget child) {
		final FrameworkElement view = (FrameworkElement) child.asNative();
		return new Position() {
			
			@Override
			public Position setY(int y) {
//				CGRect frame = view.frame();
//				view.setFrame(new CGRect(new CGPoint(frame.origin().x(), y), frame.size()));
				return this;
			}
			
			@Override
			public Position setX(int x) {
//				CGRect frame = view.frame();
//				view.setFrame(new CGRect(new CGPoint(x, frame.origin().y()), frame.size()));
				return this;
			}
			
			@Override
			public int getY() {
				//return (int) view.frame().origin().y();
				return 0;
			}
			
			@Override
			public int getX() {
//				return (int) view.frame().origin().x();
				return 0;
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
