package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class AlignRightRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey sourceWidth;
    private final VertexKey targetWidth;

    public AlignRightRule(Widget target,
                          @Nullable Widget source,
                          RelativePanel panel) {
        super(target, X, panel);
        sourceX = addSource(source, X);
        sourceWidth = addSource(source, WIDTH);
        targetWidth = addSource(target, WIDTH);
    }

    @Override
    public void apply() {
        getPosition().setX(getValue(sourceX)
                + getValue(sourceWidth)
                - getValue(targetWidth)
                - getTargetWidget().getStyle().getMarginRight());
    }
}