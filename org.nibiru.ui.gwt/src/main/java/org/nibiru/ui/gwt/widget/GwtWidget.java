package org.nibiru.ui.gwt.widget;

import com.google.common.base.Function;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.impl.BaseControlWidget;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class GwtWidget<T extends Widget> extends BaseControlWidget<T> {
	GwtWidget(T control) {
		super(control);
	}

	@Override
	public void applyStyle() {
		applyStyle(control, getStyle());
	}

	static void applyStyle(Widget control, org.nibiru.ui.core.api.style.Style style) {
		control.getElement()
				.getStyle()
				.setBackgroundColor(colorToNative(style.getBackgroundColor()));
	}

	@Override
	protected int getNativeHeight() {
		return doWithClone((Element e) -> e.getOffsetHeight());
	}

	@Override
	protected int getNativeWidth() {
		return doWithClone((Element e) -> e.getOffsetWidth());
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		control.setWidth(measuredWidth + "px");
		control.setHeight(measuredHeight + "px");
		control.getElement().getStyle().setOverflow(Style.Overflow.HIDDEN);
	}

	private <X> X doWithClone(Function<Element, X> callback) {
		Element clon = DOM.clone(control.getElement(), true);
		clon.getStyle().setPosition(Position.ABSOLUTE);
		clon.getStyle().clearPadding();
		clon.getStyle().clearWidth();
		clon.getStyle().clearHeight();
		Document.get().getBody().appendChild(clon);
		X returnValue = callback.apply(clon);
		clon.removeFromParent();
		return returnValue;
	}

	protected static String colorToNative(Color color) {
		return "rgba("
				+ color.getRed() + ","
				+ color.getGreen() + ","
				+ color.getBlue() + ","
				+ colorToDouble(color.getAlpha()) + ")";
	}

	protected static Style.TextAlign alignmentToTextAlign(Alignment alignment) {
		switch (alignment) {
			case END:
				return Style.TextAlign.RIGHT;
			case CENTER:
				return Style.TextAlign.CENTER;
			default:
				return Style.TextAlign.LEFT;
		}
	}
}
