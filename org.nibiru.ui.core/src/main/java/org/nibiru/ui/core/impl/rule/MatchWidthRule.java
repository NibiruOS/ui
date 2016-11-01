package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.Size;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.WIDTH;

public class MatchWidthRule extends BaseRule {
    private final VertexKey sourceWidth;

    public MatchWidthRule(Widget target,
                          @Nullable Widget source,
                          RelativePanel panel,
                          int margin) {
        super(target, WIDTH, panel, margin);
        sourceWidth = addSource(source, WIDTH);
    }

    @Override
    public void apply() {
        getTargetWidget().setWidth(Size.exactly(getValue(sourceWidth)
                + getMargin()));
    }
}