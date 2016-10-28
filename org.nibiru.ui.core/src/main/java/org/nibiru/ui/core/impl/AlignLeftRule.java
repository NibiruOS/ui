package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

public class AlignLeftRule extends BaseRule {
    public AlignLeftRule(Widget target,
                         @Nullable Widget source,
                         AbsolutePanel container,
                         int margin) {
        super(target,
                RelativePanel.Property.X,
                source,
                new RelativePanel.Property[]{RelativePanel.Property.X},
                container,
                margin);
    }

    @Override
    public void apply() {
        getPosition(getTargetWidget())
                .setX(getPosition(getSourceWidget())
                        .getX() + getMargin());
    }
}
