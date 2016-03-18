package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import com.google.common.collect.Lists;
import com.google.gwt.user.client.ui.Panel;

abstract class GwtContainer<T extends Panel> extends GwtWidget<T> implements Container {
	private final List<Widget> children;

	GwtContainer(T panel) {
		super(panel);
		children = Lists.newArrayList();
	}

	@Override
	public void add(Widget child) {
		checkNotNull(child);
		control.add((com.google.gwt.user.client.ui.Widget) child.asNative());
		children.add(child);
		child.setParent(this);
	}

	@Override
	public Iterable<Widget> getChildren() {
		return children;
	}

	@Override
	public void clear() {
		control.clear();
		for (Widget child : children) {
			child.setParent(null);
		}
		children.clear();
	}
}
