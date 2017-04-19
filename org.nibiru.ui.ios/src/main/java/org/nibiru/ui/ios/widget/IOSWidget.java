package org.nibiru.ui.ios.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.impl.BaseControlWidget;

import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.foundation.NSString;
import apple.uikit.UIColor;
import apple.uikit.UIFont;
import apple.uikit.UIView;

abstract class IOSWidget<T extends UIView> extends BaseControlWidget<T> {
	IOSWidget(T control) {
		super(control);
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		// Not implemented on iOS
	}

	@Override
	public void applyStyle() {
		control.setBackgroundColor(colorToNative(getStyle().getBackgroundColor()));
	}

	protected UIColor colorToNative(Color color) {
		return UIColor.colorWithRedGreenBlueAlpha(colorToDouble(color.getRed()),
				colorToDouble(color.getGreen()),
				colorToDouble(color.getBlue()),
				colorToDouble(color.getAlpha()));
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		control.setFrame(new CGRect(control.frame().origin(), new CGSize(measuredWidth, measuredHeight)));
	}
	
	public Registration setClickHandler(ClickHandler clickHandler) {
		return TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(control, clickHandler);
	}
	
	CGSize sizeFromText(String text, UIFont font) {
		return NSString.stringWithString(Strings.isNullOrEmpty(text) ? "I" : text).sizeWithFont(font);
	}
}
