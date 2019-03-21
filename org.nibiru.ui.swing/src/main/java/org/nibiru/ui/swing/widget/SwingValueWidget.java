package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.ValueWidget;

import javax.swing.JComponent;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class SwingValueWidget<T extends JComponent, V>
		extends SwingWidget<T>
		implements ValueWidget<V> {
	private final Value<V> value;

	SwingValueWidget(T control) {
		super(control);
		this.value = checkNotNull(buildValue());
	}

	abstract Value<V> buildValue();
	
	@Override
	public Value<V> getValue() {
		return value;
	}
}
