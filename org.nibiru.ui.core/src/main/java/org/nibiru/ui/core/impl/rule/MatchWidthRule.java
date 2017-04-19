package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;

public class MatchWidthRule extends BaseRule {
    private final VertexKey sourceWidth;

    public MatchWidthRule(Widget target,
                          @Nullable Widget source,
                          RelativePanel panel) {
        super(target, WIDTH, panel);
        sourceWidth = addSource(source, WIDTH);
    }

    @Override
    public void apply() {
        setWidth(getValue(sourceWidth)
                - getTargetWidget().getStyle().getMarginTop()
                - getTargetWidget().getStyle().getMarginBottom());
    }
}