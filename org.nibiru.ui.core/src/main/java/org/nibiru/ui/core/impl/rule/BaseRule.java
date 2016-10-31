package org.nibiru.ui.core.impl.rule;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.AbsolutePanel.Position;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.Property;
import org.nibiru.ui.core.api.RelativePanel.VertexKey;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseRule implements RelativePanel.Rule {
    private final List<VertexKey> target;
    private final List<VertexKey> source;
    private final AbsolutePanel container;
    private final int margin;
    private Widget targetWidget;

    public BaseRule(AbsolutePanel container,
                    int margin) {
        this.container = checkNotNull(container);
        this.margin = margin;
        target = Lists.newArrayList();
        source = Lists.newArrayList();
        targetWidget = null;
    }

    public BaseRule(Widget targetWidget,
                    Property targetProperty,
                    AbsolutePanel container,
                    int margin) {
        this(container, margin);
        addTarget(targetWidget, targetProperty);
    }

    @Override
    public Iterable<VertexKey> getTarget() {
        return target;
    }

    @Override
    public Iterable<VertexKey> getSource() {
        return source;
    }

    protected VertexKey addTarget(Widget widget, Property property) {
        // For target, null widget is not valid
        checkNotNull(widget);
        VertexKey vertex = new VertexKey(widget, property);
        target.add(vertex);
        // targetWidget is used as shortcut only when a unique widget is modified
        targetWidget = widget;
        return vertex;
    }

    protected VertexKey addSource(@Nullable Widget widget, Property property) {
        VertexKey vertex = new VertexKey(widget, property);
        source.add(vertex);
        return vertex;
    }

    protected int getMargin() {
        return margin;
    }

    protected int getValue(VertexKey vertex) {
        if (vertex.getWidget() != null) {
            switch (vertex.getProperty()) {
                case X:
                    return container.getPosition(vertex.getWidget()).getX();
                case Y:
                    return container.getPosition(vertex.getWidget()).getY();
                case WIDTH:
                    return vertex.getWidget().getMeasuredWidth();
                case HEIGHT:
                    return vertex.getWidget().getMeasuredHeight();
                default:
            }
        } else {
            switch (vertex.getProperty()) {
                case X:
                case Y:
                    return 0;
                case WIDTH:
                    return container.getMeasuredWidth();
                case HEIGHT:
                    return container.getMeasuredHeight();
                default:
            }
        }
        throw new IllegalArgumentException("Invalid vertex property: " + vertex.getProperty());
    }

    public Widget getTargetWidget() {
        checkNotNull(targetWidget, "Target widget is not set.");
        return targetWidget;
    }

    protected Position getPosition() {
        return container.getPosition(getTargetWidget());
    }
}
