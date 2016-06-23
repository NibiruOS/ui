package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.ListWidget;

public class ListWidgetBuilder extends BaseWidgetBuilder<ListWidget, ListWidgetBuilder> {
	@Inject
	public ListWidgetBuilder(ListWidget control) {
		super(control);
	}
}
