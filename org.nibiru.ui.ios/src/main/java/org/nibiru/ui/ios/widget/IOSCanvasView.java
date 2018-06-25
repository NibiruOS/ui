package org.nibiru.ui.ios.widget;

import com.google.common.collect.Lists;

import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import java.util.List;

import apple.coregraphics.opaque.CGContextRef;
import apple.coregraphics.struct.CGRect;
import apple.uikit.UIView;

import static apple.uikit.c.UIKit.UIGraphicsGetCurrentContext;

class IOSCanvasView extends UIView {
    private final List<ContextConsumer> operations = Lists.newArrayList();

    @Selector("alloc")
    public static native IOSCanvasView alloc();

    @Override
    public IOSCanvasView init() {
        return (IOSCanvasView) super.init();
    }

    protected IOSCanvasView(Pointer peer) {
        super(peer);
    }

    @Override
    public void drawRect(CGRect cgRect) {
        CGContextRef context = UIGraphicsGetCurrentContext();
        for (ContextConsumer operation : operations) {
            operation.accept(context);
        }
    }

    void addOperation(ContextConsumer operation) {
        operations.add(operation);
        setNeedsDisplay();
    }

    public void clearOperations() {
        operations.clear();
    }

    interface ContextConsumer {
        void accept(CGContextRef value);
    }
}
