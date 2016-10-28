package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.Widget;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class RuleFactoryImpl implements RelativePanel.RuleFactory {
    @Inject
    public RuleFactoryImpl() {
    }

    @Override
    public RelativePanel.Rule alignTop(Widget target, @Nullable Widget source, AbsolutePanel container, int margin) {
        return new AlignTopRule(target, source, container, margin);
    }

    @Override
    public RelativePanel.Rule alignLeft(Widget target, @Nullable Widget source, AbsolutePanel container, int margin) {
        return new AlignLeftRule(target, source, container, margin);
    }
}
