package com.aajtech.ui.vaadin.widget;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.Style;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class VaadinListWidget extends VaadinWidget<VerticalLayout>implements ListWidget {
	private final Value<Iterable<Widget>> value;

	public VaadinListWidget() {
		super(new VerticalLayout());
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
				component.removeAllComponents();
				for (Widget widget : value) {
					component.addComponent((Component) widget.asNative());
				}
			}
		};
		setStyle(Style.DEFAULT);
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
}
