package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.Rule;
import org.nibiru.ui.core.api.RelativePanel.RuleFactory;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class RelativePanelBuilder extends BaseContainerBuilder<RelativePanel, RelativePanelBuilder> {
    private final RuleFactory ruleFactory;

    @Inject
    public RelativePanelBuilder(RelativePanel relativePanel, RuleFactory ruleFactory) {
        super(relativePanel);
        this.ruleFactory = checkNotNull(ruleFactory);
    }

    public RelativePanelBuilder addRule(Rule rule) {
        checkNotNull(rule);
        object.addRule(rule);
        return this;
    }

    public RuleBuilder prepare(Widget widget) {
        checkNotNull(widget);
        return new RuleBuilder(widget);
    }

    public class RuleBuilder {
        private final Widget target;

        private RuleBuilder(Widget target) {
            this.target = target;
        }

        public RuleBuilder above(int margin) {
            addRule(ruleFactory.above(target, null, object, margin));
            return this;
        }

        public RuleBuilder above(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.above(target, source, object, margin));
            return this;
        }

        public RuleBuilder alignBottom(int margin) {
            addRule(ruleFactory.alignBottom(target, null, object, margin));
            return this;
        }

        public RuleBuilder alignBottom(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.alignBottom(target, source, object, margin));
            return this;
        }

        public RuleBuilder alignLeft(int margin) {
            addRule(ruleFactory.alignLeft(target, null, object, margin));
            return this;
        }

        public RuleBuilder alignLeft(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.alignLeft(target, source, object, margin));
            return this;
        }

        public RuleBuilder alignRight(int margin) {
            addRule(ruleFactory.alignRight(target, null, object, margin));
            return this;
        }

        public RuleBuilder alignRight(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.alignRight(target, source, object, margin));
            return this;
        }

        public RuleBuilder alignTop(int margin) {
            addRule(ruleFactory.alignTop(target, null, object, margin));
            return this;
        }

        public RuleBuilder alignTop(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.alignTop(target, source, object, margin));
            return this;
        }

        public RuleBuilder below(int margin) {
            addRule(ruleFactory.below(target, null, object, margin));
            return this;
        }

        public RuleBuilder below(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.below(target, source, object, margin));
            return this;
        }

        public RuleBuilder centerHorizontally(int margin) {
            addRule(ruleFactory.centerHorizontally(target, null, object, margin));
            return this;
        }

        public RuleBuilder centerHorizontally(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.centerHorizontally(target, source, object, margin));
            return this;
        }

        public RuleBuilder centerVertically(int margin) {
            addRule(ruleFactory.centerVertically(target, null, object, margin));
            return this;
        }

        public RuleBuilder centerVertically(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.centerVertically(target, source, object, margin));
            return this;
        }

        public RuleBuilder matchBottom(int margin) {
            addRule(ruleFactory.matchBottom(target, null, object, margin));
            return this;
        }

        public RuleBuilder matchBottom(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.matchBottom(target, source, object, margin));
            return this;
        }

        public RuleBuilder matchHeight(int margin) {
            addRule(ruleFactory.matchHeight(target, null, object, margin));
            return this;
        }

        public RuleBuilder matchHeight(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.matchHeight(target, source, object, margin));
            return this;
        }

        public RuleBuilder matchRight(int margin) {
            addRule(ruleFactory.matchRight(target, null, object, margin));
            return this;
        }

        public RuleBuilder matchRight(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.matchRight(target, source, object, margin));
            return this;
        }

        public RuleBuilder matchWidth(int margin) {
            addRule(ruleFactory.matchWidth(target, null, object, margin));
            return this;
        }

        public RuleBuilder matchWidth(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.matchWidth(target, source, object, margin));
            return this;
        }

        public RuleBuilder toLeftOf(int margin) {
            addRule(ruleFactory.toLeftOf(target, null, object, margin));
            return this;
        }

        public RuleBuilder toLeftOf(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.toLeftOf(target, source, object, margin));
            return this;
        }


        public RuleBuilder toRightOf(int margin) {
            addRule(ruleFactory.toRightOf(target, null, object, margin));
            return this;
        }

        public RuleBuilder toRightOf(Widget source, int margin) {
            checkNotNull(source);
            addRule(ruleFactory.toRightOf(target, source, object, margin));
            return this;
        }

        public RelativePanelBuilder add() {
            RelativePanelBuilder.this.add(target);
            return RelativePanelBuilder.this;
        }
    }
}
