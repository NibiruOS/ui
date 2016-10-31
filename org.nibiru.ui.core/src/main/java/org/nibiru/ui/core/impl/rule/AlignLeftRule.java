package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class AlignLeftRule extends BaseRule {
    private final VertexKey sourceX;

    public AlignLeftRule(Widget target,
                         @Nullable Widget source,
                         AbsolutePanel container,
                         int margin) {
        super(target, X, container, margin);
        sourceX = addSource(source, X);
    }

    @Override
    public void apply() {
        getPosition().setX(getValue(sourceX) + getMargin());
    }
}
