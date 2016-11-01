package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static org.nibiru.ui.core.api.RelativePanel.Property.HEIGHT;
import static org.nibiru.ui.core.api.RelativePanel.Property.Y;

public class AboveRule extends BaseRule {
    private final VertexKey sourceY;
    private final VertexKey targetHeight;

    public AboveRule(Widget target,
                     @Nullable Widget source,
                     RelativePanel panel,
                     int margin) {
        super(target, Y, panel, margin);
        sourceY = addSource(source, Y);
        targetHeight = addSource(target, HEIGHT);
    }

    @Override
    public void apply() {
        getPosition().setY(getValue(sourceY)
                - getValue(targetHeight)
                - getMargin());
    }
}
