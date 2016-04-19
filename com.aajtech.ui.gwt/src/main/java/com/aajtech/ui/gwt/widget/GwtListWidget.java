package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtListWidget extends GwtContainer<VerticalPanel>implements ListWidget {
	private final Value<Iterable<Widget>> value;

	public GwtListWidget() {
		super(new VerticalPanel());
		value = new BaseValue<Iterable<Widget>>() {
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
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
}
