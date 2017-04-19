package org.nibiru.ui.ios.widget;

import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;
import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;

import apple.NSObject;
import apple.foundation.c.Foundation;
import apple.uikit.UIGestureRecognizer;
import apple.uikit.UITapGestureRecognizer;
import apple.uikit.UIView;

import static com.google.common.base.Preconditions.checkNotNull;


class TouchUpInsideHandlerRegistration extends NSObject implements Registration {
	private static final String ON_CLICK_SELECTOR = "onClick";

	@Selector("alloc")
	public static native TouchUpInsideHandlerRegistration alloc();

	private UIView control;
	private UIGestureRecognizer gestureRecognizer;
	private ClickHandler clickHandler;

	protected TouchUpInsideHandlerRegistration(Pointer peer) {
		super(peer);
	}

	public TouchUpInsideHandlerRegistration initWithControlAndClickHandler(UIView control,
			ClickHandler clickHandler) {
		init();
		this.control = checkNotNull(control);
		this.clickHandler = checkNotNull(clickHandler);
		control.setUserInteractionEnabled(true);
		gestureRecognizer = UITapGestureRecognizer.alloc().initWithTargetAction(this,
				Foundation.NSSelectorFromString(ON_CLICK_SELECTOR));
		control.addGestureRecognizer(gestureRecognizer);
		return this;
	}

	@Override
	public void remove() {
		control.removeGestureRecognizer(gestureRecognizer);
	}

	@Selector(ON_CLICK_SELECTOR)
	public void onClick() {
		clickHandler.onClick();
	}
}
