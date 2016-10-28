package org.nibiru.ui.core.api;

import javax.annotation.Nullable;

public interface RelativePanel extends Container {
    void addRule(Rule rule);

    AbsolutePanel getContainer();

    enum Property {
        X, Y, WIDTH, HEIGHT
    }

    interface Rule {
        Widget getTargetWidget();

        Property getTargetProperty();

        // If this returns null, the rule is relative to the parent.
        @Nullable
        Widget getSourceWidget();

        Property[] getSourceProperties();

        void apply();
    }

    interface RuleFactory {
        Rule alignTop(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);

        Rule alignLeft(Widget target, @Nullable Widget source, AbsolutePanel container, int margin);
    }
}
