package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.gwt.resource.Resources;

import com.google.gwt.user.client.ui.PopupPanel;

public class GwtPopup implements Popup {
	private final PopupPanel popup;

	@Inject
	public GwtPopup(Resources resources) {
		this(new PopupPanel());
		popup.setGlassEnabled(true);
		resources.css().ensureInjected();
		popup.setGlassStyleName(resources.css().popupGlass());
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
