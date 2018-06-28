package org.nibiru.ui.ios.widget;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import apple.uikit.UIView;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class IOSContainer extends IOSWidget<UIView> implements Container {
    private final List<Widget> children = Lists.newArrayList();

    IOSContainer() {
        super(UIView.alloc().init());
    }

    @Override
    public void add(Widget child) {
        checkNotNull(child);
        control.addSubview((UIView) child.asNative());
        children.add(child);
        child.setParent(this);
        requestLayout();
    }

    @Override
    public void remove(Widget child) {
        checkNotNull(child);
        ((UIView) child.asNative()).removeFromSuperview();
        children.remove(child);
        child.setParent(null);
        requestLayout();
    }

    @Override
    public Iterable<Widget> getChildren() {
        return children;
    }

    Iterable<Widget> getVisibleChildren() {
        return Iterables.filter(children, (w) -> w.getVisible().get());
    }

    @Override
    public void clear() {
        for (UIView child : control.subviews()) {
            child.removeFromSuperview();
        }
        for (Widget child : children) {
            child.setParent(null);
        }
        children.clear();
    }
}
