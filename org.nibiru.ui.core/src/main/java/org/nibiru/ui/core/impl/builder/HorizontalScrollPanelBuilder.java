package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HorizontalScrollPanel;

import javax.inject.Inject;

public class HorizontalScrollPanelBuilder
        extends BaseBuilder<HorizontalScrollPanel>
        implements
        HasContentBuilder<HorizontalScrollPanel, HorizontalScrollPanelBuilder>,
        WidgetBuilder<HorizontalScrollPanel, HorizontalScrollPanelBuilder> {
    @Inject
    public HorizontalScrollPanelBuilder(HorizontalScrollPanel control) {
        super(control);
    }
}
