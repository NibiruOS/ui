package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.VerticalPanel;

import javax.inject.Inject;

public class VerticalPanelBuilder
        extends BaseBuilder<VerticalPanel>
        implements ContainerBuilder<VerticalPanel, VerticalPanelBuilder> {
    @Inject
    public VerticalPanelBuilder(VerticalPanel verticalPanel) {
        super(verticalPanel);
    }
}
