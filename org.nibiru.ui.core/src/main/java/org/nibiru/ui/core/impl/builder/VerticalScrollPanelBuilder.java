package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.VerticalScrollPanel;

import javax.inject.Inject;

public class VerticalScrollPanelBuilder
        extends BaseBuilder<VerticalScrollPanel>
        implements
        HasContentBuilder<VerticalScrollPanel, VerticalScrollPanelBuilder>,
        WidgetBuilder<VerticalScrollPanel, VerticalScrollPanelBuilder> {
    @Inject
    public VerticalScrollPanelBuilder(VerticalScrollPanel control) {
        super(control);
    }
}
