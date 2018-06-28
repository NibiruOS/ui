package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

public class AbsolutePanelBuilder
        extends BaseBuilder<AbsolutePanel>
        implements WidgetBuilder<AbsolutePanel, AbsolutePanelBuilder> {

    @Inject
    public AbsolutePanelBuilder(AbsolutePanel control) {
        super(control);
    }

    public AbsolutePanelBuilder add(int x, int y, Widget child) {
        object.add(child);
        object.getPosition(child).setX(x).setY(y);
        return this;
    }
}
