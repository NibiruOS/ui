package org.nibiru.ui.core.impl.rule;


import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class ToLeftOfRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey targetWidth;

    public ToLeftOfRule(Widget target,
                        @Nullable Widget source,
                        RelativePanel panel,
                        int margin) {
        super(target, X, panel, margin);
        sourceX = addSource(source, X);
        targetWidth = addSource(target, WIDTH);
    }

    @Override
    public void apply() {
        getPosition().setX(getValue(sourceX)
                - getValue(targetWidth)
                - getMargin());
    }
}