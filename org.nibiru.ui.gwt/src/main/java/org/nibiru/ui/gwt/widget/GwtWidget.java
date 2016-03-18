package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.impl.BaseControlWidget;

import com.google.common.base.Function;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

abstract class GwtWidget<T extends Widget> extends BaseControlWidget<T> {
	GwtWidget(T control) {
		super(control);
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		control.addStyleName(STYLE_NAME_PREFIX + styleName.name().toLowerCase());
	}

	@Override
	protected int getNativeHeight() {
		return doWithClone((Element e) -> {
			return e.getOffsetHeight();
		});
	}

	@Override
	protected int getNativeWidth() {
		return doWithClone((Element e) -> {
			return e.getOffsetWidth();
		});
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
}
