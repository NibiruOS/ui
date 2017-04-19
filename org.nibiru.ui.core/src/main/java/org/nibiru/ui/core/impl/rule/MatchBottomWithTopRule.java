package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class MatchBottomWithTopRule extends BaseRule {
    private final RelativePanel.VertexKey sourceY;
    private final RelativePanel.VertexKey targetY;

    public MatchBottomWithTopRule(Widget target,
                                  @Nullable Widget source,
                                  RelativePanel panel) {
        super(target, HEIGHT, panel);
        sourceY = addSource(source, Y);
        targetY = addSource(target, Y);
    }

    @Override
    public void apply() {
        setHeight(getValue(sourceY)
                - getValue(targetY)
                - getTargetWidget().getStyle().getMarginBottom());
    }
}