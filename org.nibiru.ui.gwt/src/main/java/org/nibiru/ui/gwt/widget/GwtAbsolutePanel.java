package org.nibiru.ui.gwt.widget;


import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Widget;

import com.google.gwt.user.client.ui.AbsolutePanel;

public class GwtAbsolutePanel extends GwtContainer<AbsolutePanel> implements org.nibiru.ui.core.api.AbsolutePanel {
	@Inject
	public GwtAbsolutePanel() {
		this(new AbsolutePanel());
	}

	public GwtAbsolutePanel(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	public Position getPosition(Widget child) {
		checkNotNull(child);
		final com.google.gwt.user.client.ui.Widget gwtWidget = (com.google.gwt.user.client.ui.Widget) child.asNative();
		return new Position() {
			private int x;
			private int y;

			@Override
			public int getX() {
				return x;
			}

			@Override
			public Position setX(int x) {
				this.x = x;
				control.setWidgetPosition(gwtWidget, x, y);
				return this;
			}

			@Override
			public int getY() {
				return y;
			}

			@Override
			public Position setY(int y) {
				this.y = y;
				control.setWidgetPosition(gwtWidget, x, y);
				return this;
			}
		};
	}

	@Override
	public void requestLayout() {
	}
}
