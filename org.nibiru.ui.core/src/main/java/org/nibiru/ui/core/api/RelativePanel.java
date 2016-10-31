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

    interface RuleFactory {
        Rule above(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule alignBottom(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule alignLeft(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule alignRight(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule alignTop(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule below(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule centerHorizontally(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule centerVertically(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule matchBottom(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule matchHeight(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule matchRight(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule matchWidth(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule toLeftOf(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule toRightOf(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);
    }

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
