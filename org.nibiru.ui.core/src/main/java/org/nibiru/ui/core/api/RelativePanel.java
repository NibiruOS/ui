package org.nibiru.ui.core.api;

import com.google.common.base.Objects;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public interface RelativePanel extends Container {
    void addRule(Rule rule);

    AbsolutePanel getContainer();

    enum Property {
        X, Y, WIDTH, HEIGHT
    }

    interface Rule {
        Iterable<VertexKey> getTarget();

        Iterable<VertexKey> getSource();

        void apply();
    }

    void addAbove(Widget target, @Nullable Widget source, int margin);

    void addAlignBottom(Widget target, @Nullable Widget source, int margin);

    void addAlignLeft(Widget target, @Nullable Widget source, int margin);

    void addAlignRight(Widget target, @Nullable Widget source, int margin);

    void addAlignTop(Widget target, @Nullable Widget source, int margin);

    void addBelow(Widget target, @Nullable Widget source, int margin);

    void addCenterHorizontally(Widget target, @Nullable Widget source, int margin);

    void addCenterVertically(Widget target, @Nullable Widget source, int margin);

    void addMatchBottom(Widget target, @Nullable Widget source, int margin);

    void addMatchHeight(Widget target, @Nullable Widget source, int margin);

    void addMatchRight(Widget target, @Nullable Widget source, int margin);

    void addMatchWidth(Widget target, @Nullable Widget source, int margin);

    void addToLeftOf(Widget target, @Nullable Widget source, int margin);

    void addToRightOf(Widget target, @Nullable Widget source, int margin);

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
