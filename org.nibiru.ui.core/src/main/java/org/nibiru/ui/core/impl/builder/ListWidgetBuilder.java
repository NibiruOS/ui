package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.ListWidget;

import javax.inject.Inject;

public class ListWidgetBuilder
        extends BaseBuilder<ListWidget>
        implements WidgetBuilder<ListWidget, ListWidgetBuilder> {
    @Inject
    public ListWidgetBuilder(ListWidget control) {
        super(control);
    }
}
