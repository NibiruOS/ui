package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.HorizontalPanel;

import javax.inject.Inject;

public class HorizontalPanelBuilder
        extends BaseBuilder<HorizontalPanel>
        implements ContainerBuilder<HorizontalPanel, HorizontalPanelBuilder> {
    @Inject
    public HorizontalPanelBuilder(HorizontalPanel horizontalPanel) {
        super(horizontalPanel);
    }
}
