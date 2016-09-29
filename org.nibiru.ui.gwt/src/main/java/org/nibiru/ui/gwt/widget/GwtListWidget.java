package org.nibiru.ui.gwt.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtListWidget extends GwtContainer<VerticalPanel> implements ListWidget {
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

			while (control.getWidgetCount() > 0) {
				control.remove(0);
			}
			for (Widget child : value) {
				control.add((com.google.gwt.user.client.ui.Widget) child.asNative());
			}
		}
	};

	public GwtListWidget() {
		super(new VerticalPanel());
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}

	@Override
	public Iterable<Widget> getChildren() {
		return value.get();
	}

	@Override
	public void requestLayout() {
		// TODO Auto-generated method stub
	}
}
