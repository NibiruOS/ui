package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Registration;
import com.aajtech.ui.core.api.HasClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

abstract class GwtClickableValueWidget<W extends Widget & HasClickHandlers, V> extends GwtValueWidget<W, V>
		implements HasClickHandler {
	private HasClickHandlersAdapter hasClickHandlersAdapter;

	GwtClickableValueWidget(W control) {
		super(control);
		hasClickHandlersAdapter = new HasClickHandlersAdapter(control);
	}

	@Override
	public Registration setClickHandler(com.aajtech.ui.core.api.ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		return hasClickHandlersAdapter.setClickHandler(clickHandler);
	}
}
