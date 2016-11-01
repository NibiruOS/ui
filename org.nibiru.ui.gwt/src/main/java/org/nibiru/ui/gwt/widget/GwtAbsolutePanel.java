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

			@Override
			public int getX() {
				return control.getWidgetLeft(gwtWidget);
			}

			@Override
			public Position setX(int x) {
				control.setWidgetPosition(gwtWidget, x, getY());
				return this;
			}

			@Override
			public int getY() {
				return control.getWidgetTop(gwtWidget);
			}

			@Override
			public Position setY(int y) {
				control.setWidgetPosition(gwtWidget, getX(), y);
				return this;
			}
		};
	}

	@Override
	public void requestLayout() {
	}
}
