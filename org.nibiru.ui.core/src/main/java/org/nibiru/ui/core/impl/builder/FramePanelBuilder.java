package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.FramePanel;

import javax.inject.Inject;

public class FramePanelBuilder
        extends BaseContainerBuilder<FramePanel, FramePanelBuilder> {
    @Inject
    public FramePanelBuilder(FramePanel widget) {
        super(widget);
    }
}
