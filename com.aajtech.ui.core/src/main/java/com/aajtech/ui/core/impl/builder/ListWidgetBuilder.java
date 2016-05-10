package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.ListWidget;

public class ListWidgetBuilder extends BaseWidgetBuilder<ListWidget, ListWidgetBuilder> {
	@Inject
	private static Provider<ListWidgetBuilder> listWidgetBuilderProvider;

	public static ListWidgetBuilder list() {
		return listWidgetBuilderProvider.get();
	}

	@Inject
	public ListWidgetBuilder(ListWidget control) {
		super(control);
	}
}