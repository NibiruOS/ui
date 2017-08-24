package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HorizontalScrollPanel;

import javax.inject.Inject;

public class HorizontalScrollPanelBuilder extends BaseContentWidgetBuilder<HorizontalScrollPanel, HorizontalScrollPanelBuilder> {
    @Inject
    public HorizontalScrollPanelBuilder(HorizontalScrollPanel control) {
        super(control);
    }
}
