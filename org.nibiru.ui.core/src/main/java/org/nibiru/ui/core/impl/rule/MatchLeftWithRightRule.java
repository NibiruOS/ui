package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class MatchLeftWithRightRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey sourceWidth;
    private final VertexKey targetX;
    private final VertexKey targetWidth;

    public MatchLeftWithRightRule(Widget target,
                                  @Nullable Widget source,
                                  RelativePanel panel) {
        super(panel);
        addTarget(target, X);
        addTarget(target, WIDTH);
        sourceX = addSource(source, X);
        sourceWidth = addSource(source, WIDTH);
        targetX = addSource(target, X);
        targetWidth = addSource(target, WIDTH);
    }

    @Override
    public void apply() {
        setWidth(getValue(targetX)
                + getValue(targetWidth)
                - getValue(sourceX)
                - getValue(sourceWidth)
                - getTargetWidget().getStyle().getMarginLeft());

        getPosition().setX(getValue(sourceX)
                + getValue(sourceWidth)
                + getTargetWidget().getStyle().getMarginLeft());
    }
}
