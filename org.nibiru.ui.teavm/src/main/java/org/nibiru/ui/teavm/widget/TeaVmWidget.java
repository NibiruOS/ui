package org.nibiru.ui.teavm.widget;

import com.google.common.base.Function;

import org.nibiru.model.core.api.Registration;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.HasClickHandler;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.impl.BaseControlWidget;
import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLBodyElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class TeaVmWidget<T extends HTMLElement> extends BaseControlWidget<T>
        implements HasClickHandler {
    private static String ON_CLICK_EVENT = "onClick";

    protected static <T extends JSObject> T createElement(String tagName) {
        return HTMLDocument.current().createElement(tagName).cast();
    }

    TeaVmWidget(T control) {
        super(control);
    }

    @Override
    public void setStyleName(Enum<?> styleName) {
        checkNotNull(styleName);
        control.setAttribute("style", STYLE_NAME_PREFIX + styleName.name().toLowerCase());
    }

    @Override
    public void applyStyle() {
        control.getStyle()
                .setProperty("background-color", colorToNative(getStyle().getBackgroundColor()));
    }

    protected String colorToNative(Color color) {
        return "rgba("
                + color.getRed() + ","
                + color.getGreen() + ","
                + color.getBlue() + ","
                + colorToDouble(color.getAlpha()) + ")";
    }

    @Override
    protected int getNativeHeight() {
        return doWithClone((HTMLElement e) -> e.getClientHeight());
    }

    @Override
    protected int getNativeWidth() {
        return doWithClone((HTMLElement e) -> e.getClientWidth());
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        control.getStyle().setProperty("width", measuredWidth + "px");
        control.getStyle().setProperty("height", measuredHeight + "px");
        control.getStyle().setProperty("overflow", "hidden");
    }

    @Override
    public Registration setClickHandler(ClickHandler clickHandler) {
        checkNotNull(clickHandler);
        return new ListenerAdapter(control, ON_CLICK_EVENT, (event) -> clickHandler.onClick());
    }

    private <X> X doWithClone(Function<HTMLElement, X> callback) {
        HTMLElement clon = (HTMLElement) control.cloneNode(true);
        clon.getStyle().setProperty("position", "absolute");
        clon.getStyle().removeProperty("padding");
        clon.getStyle().removeProperty("width");
        clon.getStyle().removeProperty("height");
        HTMLBodyElement body = Window.current().getDocument().getBody();
        body.appendChild(clon);
        X returnValue = callback.apply(clon);
        body.removeChild(clon);
        return returnValue;
    }
}
