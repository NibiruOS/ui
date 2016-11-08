package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;
import static org.nibiru.ui.core.api.RelativePanel.Property.X;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class MatchBottomWithTopRule extends BaseRule {
    private final RelativePanel.VertexKey sourceY;
    private final RelativePanel.VertexKey targetY;

    public MatchBottomWithTopRule(Widget target,
                                  @Nullable Widget source,
                                  RelativePanel panel,
                                  int margin) {
        super(target, HEIGHT, panel, margin);
        sourceY = addSource(source, Y);
        targetY = addSource(target, Y);
    }

    @Override
    public void apply() {
        getTargetWidget().setHeight(Size.exactly(getValue(sourceY)
                - getValue(targetY)
                - getMargin()));
    }
}