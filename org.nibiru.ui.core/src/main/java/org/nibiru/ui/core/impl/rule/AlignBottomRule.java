package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class AlignBottomRule extends BaseRule {
    private final VertexKey sourceY;
    private final VertexKey sourceHeight;
    private final VertexKey targetHeight;

    public AlignBottomRule(Widget target,
                           @Nullable Widget source,
                           RelativePanel panel) {
        super(target, Y, panel);
        sourceY = addSource(source, Y);
        sourceHeight = addSource(source, HEIGHT);
        targetHeight = addSource(target, HEIGHT);
    }

    @Override
    public void apply() {
        getPosition().setY(getValue(sourceY)
                + getValue(sourceHeight)
                - getValue(targetHeight)
                - getTargetWidget().getStyle().getMarginBottom());
    }
}