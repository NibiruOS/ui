package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.Widget;
import com.aajtech.ui.gwt.widget.Resources.Css;
import com.google.gwt.user.client.ui.PopupPanel;

public class GwtPopup implements Popup {
	private final PopupPanel popup;

	@Inject
	public GwtPopup(Resources resources) {
		this(buildPopupPanel(resources.css()));
	}

	private static PopupPanel buildPopupPanel(Css css) {
		PopupPanel popup = new PopupPanel();
		popup.setGlassEnabled(true);
		css.ensureInjected();
		popup.setGlassStyleName(css.popupGlass());
		return popup;
	}

	public GwtPopup(PopupPanel popup) {
		this.popup = checkNotNull(popup);
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		popup.clear();
		popup.add((com.google.gwt.user.client.ui.Widget) content.asNative());
	}

	@Override
	public void show() {
		popup.center();
		popup.show();
	}

	@Override
	public void hide() {
		popup.hide();
	}

	@Override
	public void setAutoHide(boolean autoHide) {
		popup.setAutoHideEnabled(autoHide);
	}
}
