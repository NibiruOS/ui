package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class MatchRightWithRightRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey sourceWidth;
    private final VertexKey targetX;

    public MatchRightWithRightRule(Widget target,
                                   @Nullable Widget source,
                                   RelativePanel panel) {
        super(target, WIDTH, panel);
        sourceX = addSource(source, X);
        sourceWidth = addSource(source, WIDTH);
        targetX = addSource(target, X);
    }

    @Override
    public void apply() {
        setWidth(getValue(sourceX)
                + getValue(sourceWidth)
                - getValue(targetX)
                - getTargetWidget().getStyle().getMarginRight());
    }
}