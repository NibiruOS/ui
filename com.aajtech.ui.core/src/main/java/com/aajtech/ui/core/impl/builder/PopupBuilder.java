package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.Widget;

public class PopupBuilder extends BaseBuilder<Popup> {
	@Inject
	public PopupBuilder(Popup widget) {
		super(widget);
	}

	public PopupBuilder content(Widget content) {
		object.setContent(content);
		return this;
	}

	public PopupBuilder autoHide(boolean autoHide) {
		object.setAutoHide(autoHide);
		return this;
	}
}
