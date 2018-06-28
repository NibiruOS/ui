package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class MatchRightWithLeftRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey targetX;

    public MatchRightWithLeftRule(Widget target,
                                  @Nullable Widget source,
                                  RelativePanel panel) {
        super(target, WIDTH, panel);
        sourceX = addSource(source, X);
        targetX = addSource(target, X);
    }

    @Override
    public void apply() {
        setWidth(getValue(sourceX)
                - getValue(targetX)
                - getTargetWidget().getStyle().getMarginRight());
    }
}