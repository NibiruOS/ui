package org.nibiru.ui.ios.widget;

import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.foundation.NSArray;
import apple.uikit.UIApplication;
import apple.uikit.UIColor;
import apple.uikit.UIView;
import apple.uikit.enums.UIViewAutoresizing;

class Overlay extends UIView {
    private boolean autoHide;

    @Selector("alloc")
    public static native Overlay alloc();

    private UIView content;

    protected Overlay(Pointer peer) {
        super(peer);
    }

    public static Overlay create() {
        return create(UIColor.blackColor());
    }

    public static Overlay create(UIColor color) {
        return Overlay.alloc().init(color);
    }

    private Overlay init(UIColor color) {
        initWithFrame(rootView().frame());
        setBackgroundColor(color);
        setAlpha(0.75);
        setAutoresizingMask(UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleHeight);
        TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(this, () -> {
            if (autoHide) {
                hide();
            }
        });
        return this;
    }

    void setContent(UIView content) {
        if (this.content != null) {
            this.content.removeFromSuperview();
        }
        this.content = content;
        addSubview(content);
    }

    void centerContent() {
        if (content != null) {
            content.setFrame(new CGRect(
                    new CGPoint((frame().size().width() - content.frame().size().width()) / 2,
                            (frame().size().height() - content.frame().size().height()) / 2),
                    content.frame().size()));
        }
    }

    void show() {
        rootView().addSubview(this);
    }

    void hide() {
        UIView.animateWithDurationAnimationsCompletion(0.5, // duration
                () -> {
                    setAlpha(0);
                }, (boolean b) -> {
                    removeFromSuperview();
                    setAlpha(0.75);
                });
    }

    public void setAutoHide(boolean autoHide) {
        this.autoHide = autoHide;
    }

    private static UIView rootView() {
        NSArray<? extends UIView> views = UIApplication.sharedApplication().keyWindow().subviews();
        return views.objectAtIndex(views.size() - 1);
    }
}
