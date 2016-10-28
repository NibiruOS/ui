package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

public class AlignTopRule extends BaseRule {
    public AlignTopRule(Widget target,
                        @Nullable Widget source,
                        AbsolutePanel container,
                        int margin) {
        super(target,
                RelativePanel.Property.Y,
                source,
                new RelativePanel.Property[]{RelativePanel.Property.Y},
                container,
                margin);
    }

    @Override
    public void apply() {
        getPosition(getTargetWidget())
                .setY(getPosition(getSourceWidget())
                        .getY() + getMargin());
    }
}
