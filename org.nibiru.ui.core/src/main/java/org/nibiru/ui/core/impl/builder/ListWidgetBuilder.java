package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.ListWidget;

public class ListWidgetBuilder extends BaseWidgetBuilder<ListWidget, ListWidgetBuilder> {
	@Inject
	public ListWidgetBuilder(ListWidget control) {
		super(control);
	}
}
