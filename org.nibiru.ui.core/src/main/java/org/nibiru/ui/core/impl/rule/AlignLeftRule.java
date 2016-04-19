package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.X;

public class AlignLeftRule extends BaseRule {
    private final VertexKey sourceX;

    public AlignLeftRule(Widget target,
                         @Nullable Widget source,
                         RelativePanel panel) {
        super(target, X, panel);
        sourceX = addSource(source, X);
    }

    @Override
    public void apply() {
        getPosition().setX(getValue(sourceX)
                + getTargetWidget().getStyle().getMarginLeft());
    }
}
