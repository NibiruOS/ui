package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class AlignTopRule extends BaseRule {
    private final VertexKey sourceY;

    public AlignTopRule(Widget target,
                        @Nullable Widget source,
                        AbsolutePanel container,
                        int margin) {
        super(target, Y, container, margin);
        sourceY = addSource(source, Y);
    }

    @Override
    public void apply() {
        getPosition().setY(getValue(sourceY) + getMargin());
    }
}
