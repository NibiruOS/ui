package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;

public class MatchHeightRule extends BaseRule {
    private final VertexKey sourceHeight;

    public MatchHeightRule(Widget target,
                           @Nullable Widget source,
                           RelativePanel panel) {
        super(target, HEIGHT, panel);
        sourceHeight = addSource(source, HEIGHT);
    }

    @Override
    public void apply() {
        setHeight(getValue(sourceHeight)
                - getTargetWidget().getStyle().getMarginTop()
                - getTargetWidget().getStyle().getMarginBottom());
    }
}