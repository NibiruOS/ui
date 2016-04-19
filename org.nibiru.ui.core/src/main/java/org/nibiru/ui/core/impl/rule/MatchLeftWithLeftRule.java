package org.nibiru.ui.core.impl.rule;


import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class MatchLeftWithLeftRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey targetX;
    private final VertexKey targetWidth;

    public MatchLeftWithLeftRule(Widget target,
                                 @Nullable Widget source,
                                 RelativePanel panel) {
        super(panel);
        addTarget(target, X);
        addTarget(target, WIDTH);
        sourceX = addSource(source, X);
        targetX = addSource(target, X);
        targetWidth = addSource(target, WIDTH);
    }

    @Override
    public void apply() {
        setWidth(getValue(targetX)
                - getValue(sourceX)
                + getValue(targetWidth)
                - getTargetWidget().getStyle().getMarginLeft());

        getPosition().setX(getValue(sourceX)
                + getTargetWidget().getStyle().getMarginLeft());
    }
}