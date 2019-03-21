package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AbsolutePanelBuilder
        extends BaseBuilder<AbsolutePanel>
        implements WidgetBuilder<AbsolutePanel, AbsolutePanelBuilder> {

    @Inject
    public AbsolutePanelBuilder(AbsolutePanel control) {
        super(control);
    }

    public AbsolutePanelBuilder add(int x,
                                    int y,
                                    Widget child) {
        checkNotNull(child);
        object.add(child);
        object.getPosition(child).setX(x).setY(y);
        return this;
    }

    public AbsolutePanelBuilder add(int x,
                                    int y,
                                    Builder<? extends Widget> child) {
        checkNotNull(child);
        return add(x, y, child.build());
    }
}
