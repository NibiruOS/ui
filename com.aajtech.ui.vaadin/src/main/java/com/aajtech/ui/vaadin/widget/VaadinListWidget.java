package com.aajtech.ui.vaadin.widget;

import java.util.List;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.model.core.impl.java.TypeLiteral;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class VaadinListWidget extends VaadinWidget<VerticalLayout>implements ListWidget {
	private final Value<List<Widget>> value;

	public VaadinListWidget() {
		super(new VerticalLayout());
		value = new BaseValue<List<Widget>>() {
			private List<Widget> value;

			@Override
			public List<Widget> get() {
				return value;
			}

			@Override
			public Type<List<Widget>> getType() {
				return JavaType.of(new TypeLiteral<List<Widget>>(){});
			}

			@Override
			protected void setValue(List<Widget> value) {
				this.value = value;
				component.removeAllComponents();
				for (Widget widget : value) {
					component.addComponent((Component) widget.asNative());
				}
			}
		};
	}

	@Override
	public Value<List<Widget>> getValue() {
		return value;
	}
}
