package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.Rule;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class RelativePanelBuilder extends BaseContainerBuilder<RelativePanel, RelativePanelBuilder> {
    @Inject
    public RelativePanelBuilder(RelativePanel relativePanel) {
        super(relativePanel);
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

    public interface RuleProvider {
        Rule getRule(Widget target, RelativePanel container);
    }

    public class RuleBuilder {
        private final Widget target;

        private RuleBuilder(Widget target) {
            this.target = target;
        }

        public RuleBuilder above() {
            object.addAbove(target, null);
            return this;
        }

        public RuleBuilder above(Widget source) {
            checkNotNull(source);
            object.addAbove(target, source);
            return this;
        }

        public RuleBuilder alignBottom() {
            object.addAlignBottom(target, null);
            return this;
        }

        public RuleBuilder alignBottom(Widget source) {
            checkNotNull(source);
            object.addAlignBottom(target, source);
            return this;
        }

        public RuleBuilder alignLeft() {
            object.addAlignLeft(target, null);
            return this;
        }

        public RuleBuilder alignLeft(Widget source) {
            checkNotNull(source);
            object.addAlignLeft(target, source);
            return this;
        }

        public RuleBuilder alignRight() {
            object.addAlignRight(target, null);
            return this;
        }

        public RuleBuilder alignRight(Widget source) {
            checkNotNull(source);
            object.addAlignRight(target, source);
            return this;
        }

        public RuleBuilder alignTop() {
            object.addAlignTop(target, null);
            return this;
        }

        public RuleBuilder alignTop(Widget source) {
            checkNotNull(source);
            object.addAlignTop(target, source);
            return this;
        }

        public RuleBuilder below() {
            object.addBelow(target, null);
            return this;
        }

        public RuleBuilder below(Widget source) {
            checkNotNull(source);
            object.addBelow(target, source);
            return this;
        }

        public RuleBuilder centerHorizontally() {
            object.addCenterHorizontally(target, null);
            return this;
        }

        public RuleBuilder centerHorizontally(Widget source) {
            checkNotNull(source);
            object.addCenterHorizontally(target, source);
            return this;
        }

        public RuleBuilder centerVertically() {
            object.addCenterVertically(target, null);
            return this;
        }

        public RuleBuilder centerVertically(Widget source) {
            checkNotNull(source);
            object.addCenterVertically(target, source);
            return this;
        }

        public RuleBuilder matchBottomWithBottom() {
            object.addMatchBottomWithBottom(target, null);
            return this;
        }

        public RuleBuilder matchBottomWithBottom(Widget source) {
            checkNotNull(source);
            object.addMatchBottomWithBottom(target, source);
            return this;
        }

        public RuleBuilder matchBottomWithTop() {
            object.addMatchBottomWithTop(target, null);
            return this;
        }

        public RuleBuilder matchBottomWithTop(Widget source) {
            checkNotNull(source);
            object.addMatchBottomWithTop(target, source);
            return this;
        }

        public RuleBuilder matchHeight() {
            object.addMatchHeight(target, null);
            return this;
        }

        public RuleBuilder matchHeight(Widget source) {
            checkNotNull(source);
            object.addMatchHeight(target, source);
            return this;
        }

        public RuleBuilder matchLeftWithLeft() {
            object.addMatchLeftWithLeft(target, null);
            return this;
        }

        public RuleBuilder matchLeftWithLeft(Widget source) {
            checkNotNull(source);
            object.addMatchLeftWithLeft(target, source);
            return this;
        }

        public RuleBuilder matchLeftWithRight() {
            object.addMatchLeftWithRight(target, null);
            return this;
        }

        public RuleBuilder matchLeftWithRight(Widget source) {
            checkNotNull(source);
            object.addMatchLeftWithRight(target, source);
            return this;
        }

        public RuleBuilder matchRightWithLeft() {
            object.addMatchRightWithLeft(target, null);
            return this;
        }

        public RuleBuilder matchRightWithLeft(Widget source) {
            checkNotNull(source);
            object.addMatchRightWithLeft(target, source);
            return this;
        }

        public RuleBuilder matchRightWithRight() {
            object.addMatchRightWithRight(target, null);
            return this;
        }

        public RuleBuilder matchRightWithRight(Widget source) {
            checkNotNull(source);
            object.addMatchRightWithRight(target, source);
            return this;
        }

        public RuleBuilder matchTopWithBottom() {
            object.addMatchTopWithBottom(target, null);
            return this;
        }

        public RuleBuilder matchTopWithBottom(Widget source) {
            checkNotNull(source);
            object.addMatchTopWithBottom(target, source);
            return this;
        }

        public RuleBuilder matchTopWithTop() {
            object.addMatchTopWithTop(target, null);
            return this;
        }

        public RuleBuilder matchTopWithTop(Widget source) {
            checkNotNull(source);
            object.addMatchTopWithTop(target, source);
            return this;
        }

        public RuleBuilder matchWidth() {
            object.addMatchWidth(target, null);
            return this;
        }

        public RuleBuilder matchWidth(Widget source) {
            checkNotNull(source);
            object.addMatchWidth(target, source);
            return this;
        }

        public RuleBuilder toLeftOf() {
            object.addToLeftOf(target, null);
            return this;
        }

        public RuleBuilder toLeftOf(Widget source) {
            checkNotNull(source);
            object.addToLeftOf(target, source);
            return this;
        }

        public RuleBuilder toRightOf() {
            object.addToRightOf(target, null);
            return this;
        }

        public RuleBuilder toRightOf(Widget source) {
            checkNotNull(source);
            object.addToRightOf(target, source);
            return this;
        }

        public RuleBuilder custom(RuleProvider ruleProvider) {
            checkNotNull(ruleProvider);
            object.addRule(ruleProvider.getRule(target, object));
            return this;
        }

        public RelativePanelBuilder add() {
            RelativePanelBuilder.this.add(target);
            return RelativePanelBuilder.this;
        }
    }
}
