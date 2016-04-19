package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class MatchTopWithTopRule  extends BaseRule {
    private final VertexKey sourceY;
    private final VertexKey targetY;
    private final VertexKey targetHeight;

    public MatchTopWithTopRule(Widget target,
                                 @Nullable Widget source,
                                 RelativePanel panel) {
        super(panel);
        addTarget(target, Y);
        addTarget(target, HEIGHT);
        sourceY = addSource(source, Y);
        targetY = addSource(target, Y);
        targetHeight = addSource(target, HEIGHT);
    }

    @Override
    public void apply() {
        setHeight(getValue(targetY)
                - getValue(sourceY)
                + getValue(targetHeight)
                - getTargetWidget().getStyle().getMarginTop());

        getPosition().setY(getValue(sourceY)
                + getTargetWidget().getStyle().getMarginTop());
    }
}