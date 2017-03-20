package org.nibiru.ui.dotnet.widget;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import cli.System.Windows.Controls.Canvas;
import cli.System.Windows.FrameworkElement;

public class DotNetAbsolutePanel extends DotNetContainer<Canvas> implements AbsolutePanel {
	@Inject
	public DotNetAbsolutePanel() {
		super(new Canvas());
	}

	@Override
	public Position getPosition(Widget child) {
		return new Position() {
			FrameworkElement view = (FrameworkElement) child.asNative();
			int x, y;

			@Override
			public Position setY(int y) {
				this.y = y;
				control.SetTop(view, y);
				return this;
			}
			
			@Override
			public Position setX(int x) {
				this.x = x;
				control.SetLeft(view, x);
				return this;
			}
			
			@Override
			public int getY() {
				return y;
			}
			
			@Override
			public int getX() {
				return x;
			}
		};
	}
	
	@Override
	public void requestLayout() {
	}

	@Override
	protected int getNativeHeight() {
		// TODO Fix value - add size computation
		return 1024;
	}

	@Override
	protected int getNativeWidth() {
		// TODO Fix value - add size computation
		return 1024;
	}
}
