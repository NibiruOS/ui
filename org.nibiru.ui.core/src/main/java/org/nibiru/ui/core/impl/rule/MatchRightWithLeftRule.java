package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class MatchRightWithLeftRule extends BaseRule {
    private final VertexKey sourceX;
    private final VertexKey targetX;

    public MatchRightWithLeftRule(Widget target,
                                  @Nullable Widget source,
                                  RelativePanel panel,
                                  int margin) {
        super(target, WIDTH, panel, margin);
        sourceX = addSource(source, X);
        targetX = addSource(target, X);
    }

    @Override
    public void apply() {
        getTargetWidget().setWidth(Size.exactly(getValue(sourceX)
                - getValue(targetX)
                - getMargin()));
    }
}