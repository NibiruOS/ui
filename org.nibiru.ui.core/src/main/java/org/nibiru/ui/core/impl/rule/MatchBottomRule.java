package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class MatchBottomRule extends BaseRule {
    private final VertexKey sourceY;
    private final VertexKey sourceHeight;
    private final VertexKey targetY;

    public MatchBottomRule(Widget target,
                           @Nullable Widget source,
                           AbsolutePanel container,
                           int margin) {
        super(target, HEIGHT, container, margin);
        sourceY = addSource(source, Y);
        sourceHeight = addSource(source, HEIGHT);
        targetY = addSource(target, Y);
    }

    @Override
    public void apply() {
        getTargetWidget().setHeight(Size.exactly(getValue(sourceY)
                + getValue(sourceHeight)
                - getValue(targetY)
                - getMargin()));
    }
}
