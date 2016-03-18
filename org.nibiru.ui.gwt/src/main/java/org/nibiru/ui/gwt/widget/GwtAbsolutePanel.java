package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Widget;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class GwtAbsolutePanel extends GwtContainer<AbsolutePanel>implements org.nibiru.ui.core.api.AbsolutePanel {
	private final Scheduler scheduler;

	@Inject
	public GwtAbsolutePanel(Scheduler scheduler) {
		this(new AbsolutePanel(), scheduler);
	}

	public GwtAbsolutePanel(AbsolutePanel panel, Scheduler scheduler) {
		super(panel);
		this.scheduler = checkNotNull(scheduler);
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
				scheduler.scheduleDeferred(() -> {
					int right = x + gwtWidget.getOffsetWidth();
					if (control.getOffsetWidth() < right) {
						control.setWidth(right + "px");
					}
				});
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
				Scheduler.get().scheduleDeferred(() -> {
					int bottom = y + gwtWidget.getOffsetHeight();
					if (control.getOffsetHeight() < bottom) {
						control.setHeight(bottom + "px");
					}
				});
				return this;
			}
		};
	}

	@Override
	public void requestLayout() {
	}
}
