package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import com.google.gwt.user.client.ui.Panel;

class GwtContainer<T extends Panel> extends GwtWidget<T>implements Container {
	GwtContainer(T panel) {
		super(panel);
	}

	@Override
	public void add(Widget child) {
		checkNotNull(child);
		control.add((com.google.gwt.user.client.ui.Widget) child.asNative());
	}

	@Override
	public void clear() {
		control.clear();
	}
}
