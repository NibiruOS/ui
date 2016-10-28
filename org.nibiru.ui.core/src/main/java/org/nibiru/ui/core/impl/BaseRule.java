package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseRule implements RelativePanel.Rule {
    private final Widget targetWidget;
    private final RelativePanel.Property targetProperty;
    private final Widget sourceWidget;
    private final RelativePanel.Property[] sourceProperties;
    private final AbsolutePanel container;
    private final int margin;

    public BaseRule(Widget targetWidget,
                    RelativePanel.Property targetProperty,
                    @Nullable Widget sourceWidget,
                    RelativePanel.Property[] sourceProperties,
                    AbsolutePanel container,
                    int margin) {
        this.targetWidget = checkNotNull(targetWidget);
        this.targetProperty = checkNotNull(targetProperty);
        this.sourceWidget = sourceWidget;
        this.sourceProperties = checkNotNull(sourceProperties);
        this.container = checkNotNull(container);
        this.margin = margin;
    }

    @Override
    public Widget getTargetWidget() {
        return targetWidget;
    }

    @Override
    public RelativePanel.Property getTargetProperty() {
        return targetProperty;
    }

    @Nullable
    @Override
    public Widget getSourceWidget() {
        return sourceWidget;
    }

    @Override
    public RelativePanel.Property[] getSourceProperties() {
        return sourceProperties;
    }

    public int getMargin() {
        return margin;
    }

    public AbsolutePanel.Position getPosition(@Nullable Widget widget) {
        if (widget != null) {
            return container.getPosition(widget);
        } else {
            return new AbsolutePanel.Position() {
                @Override
                public int getX() {
                    return 0;
                }

                @Override
                public AbsolutePanel.Position setX(int x) {
                    return this;
                }

                @Override
                public int getY() {
                    return 0;
                }

                @Override
                public AbsolutePanel.Position setY(int y) {
                    return this;
                }
            };
        }
    }
}
