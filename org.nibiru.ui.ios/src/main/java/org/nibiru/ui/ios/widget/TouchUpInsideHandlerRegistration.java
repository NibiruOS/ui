package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;

import com.intel.moe.natj.objc.SEL;
import com.intel.moe.natj.objc.ann.Selector;

import ios.uikit.UIControl;
import ios.uikit.UIGestureRecognizer;
import ios.uikit.UITapGestureRecognizer;

public class TouchUpInsideHandlerRegistration implements Registration {
	private final UIControl control;
	private final UIGestureRecognizer gestureRecognizer;
	private final ClickHandler clickHandler;

	public TouchUpInsideHandlerRegistration(UIControl control, ClickHandler clickHandler) {
		this.control = checkNotNull(control);
		this.clickHandler = checkNotNull(clickHandler);
		try {			
			gestureRecognizer = UITapGestureRecognizer.alloc().init();
			gestureRecognizer.initWithTargetAction(this, new SEL(TouchUpInsideHandlerRegistration.class.getMethod("onClick")));
			control.addGestureRecognizer(gestureRecognizer);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove() {
		control.removeGestureRecognizer(gestureRecognizer);
	}
	
    @Selector("onClick")
	public void onClick() {
    	clickHandler.onClick();
    }
}
