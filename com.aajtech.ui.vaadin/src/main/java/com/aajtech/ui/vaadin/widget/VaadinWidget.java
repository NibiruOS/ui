package com.aajtech.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.aajtech.ui.core.impl.BaseControlWidget;
import com.vaadin.ui.Component;

abstract class VaadinWidget<T extends Component> extends BaseControlWidget<T>implements Serializable {
	VaadinWidget(T component) {
		super(component);
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		control.addStyleName(STYLE_NAME_PREFIX + styleName.name().toLowerCase());
	}

	@Override
	public int getMeasuredHeight() {
		return 0;
	}

	@Override
	public void setHeight(int height) {
	}

	@Override
	public int getMeasuredWidth() {
		return 0;
	}

	@Override
	public void setWidth(int width) {
	}
}
