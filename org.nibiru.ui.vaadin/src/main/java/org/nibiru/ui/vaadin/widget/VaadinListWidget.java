package org.nibiru.ui.vaadin.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.Widget;

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
				control.removeAllComponents();
				for (Widget widget : value) {
					control.addComponent((Component) widget.asNative());
				}
			}
		};
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
}
