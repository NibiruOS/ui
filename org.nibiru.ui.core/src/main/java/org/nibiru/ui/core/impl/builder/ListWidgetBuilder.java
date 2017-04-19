package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;

import javax.inject.Inject;

public class ListWidgetBuilder extends BaseWidgetBuilder<ListWidget, ListWidgetBuilder> {
	@Inject
	public ListWidgetBuilder(ListWidget control) {
		super(control);
	}
}
