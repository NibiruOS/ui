package org.nibiru.ui.teavm.widget;

import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.xml.Node;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class TeaVmContainer extends TeaVmWidget<HTMLElement> implements Container {
    private final List<Widget> children;

    TeaVmContainer(HTMLElement panel) {
        super(panel);
        children = Lists.newArrayList();
    }

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        control.appendChild((Node) child.asNative());
        children.add(child);
        child.setParent(this);
    }

    @Override
    public Iterable<Widget> getChildren() {
        return children;
    }

    @Override
    public void clear() {
        control.clear();
        for (Widget child : children) {
            child.setParent(null);
        }
        children.clear();
    }
}
