package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.loop.Looper;

public class ListWidgetImpl extends VerticalPanelImpl implements ListWidget {
	private final Value<Iterable<Widget>> value = new BaseValue<Iterable<Widget>>() {
		private Iterable<Widget> value;

		@Override
		public Iterable<Widget> get() {
			return value;
		}

		@Override
		public Type<Iterable<Widget>> getType() {
			return JavaType.ofIterable(Widget.class);
		}

		@Override
		protected void setValue(Iterable<Widget> value) {
			this.value = value;

			clear();
			for (Widget child : value) {
				add(child);
			}
		}
	};

	@Inject
	public ListWidgetImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
		super(panel, viewport, looper);
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
}