package org.nibiru.ui.core.impl.rule;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.RelativePanel.Rule;
import org.nibiru.ui.core.api.RelativePanel.RuleFactory;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.impl.rule.AlignLeftRule;
import org.nibiru.ui.core.impl.rule.AlignTopRule;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class RuleFactoryImpl implements RuleFactory {
    @Inject
    public RuleFactoryImpl() {
    }

    @Override
    public Rule above(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new AboveRule(target, source, panel, margin);
    }

    @Override
    public Rule alignBottom(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new AlignBottomRule(target, source, panel, margin);
    }

    @Override
    public Rule alignLeft(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new AlignLeftRule(target, source, panel, margin);
    }

    @Override
    public Rule alignRight(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new AlignRightRule(target, source, panel, margin);
    }

    @Override
    public Rule alignTop(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new AlignTopRule(target, source, panel, margin);
    }

    @Override
    public Rule below(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new BelowRule(target, source, panel, margin);
    }

    @Override
    public Rule centerHorizontally(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new CenterHorizontallyRule(target, source, panel, margin);
    }

    @Override
    public Rule centerVertically(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new CenterVerticallyRule(target, source, panel, margin);
    }

    @Override
    public Rule matchBottom(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new MatchBottomRule(target, source, panel, margin);
    }

    @Override
    public Rule matchHeight(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new MatchHeightRule(target, source, panel, margin);
    }

    @Override
    public Rule matchRight(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new MatchRightRule(target, source, panel, margin);
    }

    @Override
    public Rule matchWidth(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new MatchWidthRule(target, source, panel, margin);
    }

    @Override
    public Rule toLeftOf(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new ToLeftOfRule(target, source, panel, margin);
    }

    @Override
    public Rule toRightOf(Widget target, @Nullable Widget source, RelativePanel panel, int margin) {
        return new ToRightOfRule(target, source, panel, margin);
    }
}