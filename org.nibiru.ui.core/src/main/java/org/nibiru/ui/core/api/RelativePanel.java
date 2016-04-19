package org.nibiru.ui.core.api;

import com.google.common.base.Objects;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public interface RelativePanel extends Container {
    void addRule(Rule rule);

    AbsolutePanel getContainer();

    void setHeight(Widget target, int height);

    void setWidth(Widget target, int width);


    enum Property {
        X, Y, WIDTH, HEIGHT
    }

    interface Rule {
        Iterable<VertexKey> getTarget();

        Iterable<VertexKey> getSource();

        void apply();
    }

    void addAbove(Widget target, @Nullable Widget source);

    void addAlignBottom(Widget target, @Nullable Widget source);

    void addAlignLeft(Widget target, @Nullable Widget source);

    void addAlignRight(Widget target, @Nullable Widget source);

    void addAlignTop(Widget target, @Nullable Widget source);

    void addBelow(Widget target, @Nullable Widget source);

    void addCenterHorizontally(Widget target, @Nullable Widget source);

    void addCenterVertically(Widget target, @Nullable Widget source);

    void addMatchBottomWithBottom(Widget target, @Nullable Widget source);

    void addMatchBottomWithTop(Widget target, @Nullable Widget source);

    void addMatchHeight(Widget target, @Nullable Widget source);

    void addMatchLeftWithLeft(Widget target, @Nullable Widget source);

    void addMatchLeftWithRight(Widget target, @Nullable Widget source);

    void addMatchRightWithLeft(Widget target, @Nullable Widget source);

    void addMatchRightWithRight(Widget target, @Nullable Widget source);

    void addMatchTopWithBottom(Widget target, @Nullable Widget source);

    void addMatchTopWithTop(Widget target, @Nullable Widget source);

    void addMatchWidth(Widget target, @Nullable Widget source);

    void addToLeftOf(Widget target, @Nullable Widget source);

    void addToRightOf(Widget target, @Nullable Widget source);

    class VertexKey {
        private final Widget widget;
        private final Property property;

        // Null widgets means the container.
        public VertexKey(@Nullable Widget widget, Property property) {
            this.widget = widget;
            this.property = checkNotNull(property);
        }

        public Widget getWidget() {
            return widget;
        }

        public Property getProperty() {
            return property;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VertexKey vertexKey = (VertexKey) o;
            return Objects.equal(this.widget, vertexKey.widget) && Objects.equal(this.property, vertexKey.property);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(widget, property);
        }
    }

}
