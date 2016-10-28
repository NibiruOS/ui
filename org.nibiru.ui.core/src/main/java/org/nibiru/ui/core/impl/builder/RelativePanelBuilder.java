package org.nibiru.ui.core.impl.builder;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class RelativePanelBuilder extends BaseContainerBuilder<RelativePanel, RelativePanelBuilder> {
    private final RelativePanel.RuleFactory ruleFactory;
    private final List<Runnable> pendingRules;

    @Inject
    public RelativePanelBuilder(RelativePanel relativePanel, RelativePanel.RuleFactory ruleFactory) {
        super(relativePanel);
        this.ruleFactory = checkNotNull(ruleFactory);
        pendingRules = Lists.newArrayList();
    }

    public RelativePanelBuilder addRule(RelativePanel.Rule rule) {
        checkNotNull(rule);
        object.addRule(rule);
        return this;
    }

    public RuleBuilder prepare(Widget widget) {
        checkNotNull(widget);
        return new RuleBuilder(widget);
    }

    @Override
    public RelativePanel build() {
        for (Runnable pendingRule : pendingRules) {
            pendingRule.run();
        }
        pendingRules.clear();
        return super.build();
    }

    public class RuleBuilder {
        private final Widget target;

        public RuleBuilder(Widget target) {
            this.target = target;
        }

        public RuleBuilder alignTop(int margin) {
            return alignTop(Suppliers.ofInstance(null), margin);
        }

        public RuleBuilder alignTop(Supplier<Widget> source, int margin) {
            checkNotNull(source);
            pendingRules.add(() -> {
                addRule(ruleFactory.alignTop(target, source.get(), object.getContainer(), margin));
            });
            return this;
        }

        public RuleBuilder alignLeft(int margin) {
            return alignLeft(Suppliers.ofInstance(null), margin);
        }

        public RuleBuilder alignLeft(Supplier<Widget> source, int margin) {
            checkNotNull(source);
            pendingRules.add(() -> {
                addRule(ruleFactory.alignLeft(target, source.get(), object.getContainer(), margin));
            });
            return this;
        }

        public RelativePanelBuilder add() {
            RelativePanelBuilder.this.add(target);
            return RelativePanelBuilder.this;
        }
    }
}
