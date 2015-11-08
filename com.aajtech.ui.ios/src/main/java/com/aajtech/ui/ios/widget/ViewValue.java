package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIView;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;

abstract class ViewValue<T extends UIView> extends BaseValue<String> {
	final T view;

	ViewValue(T control) {
		this.view = checkNotNull(control);
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}
