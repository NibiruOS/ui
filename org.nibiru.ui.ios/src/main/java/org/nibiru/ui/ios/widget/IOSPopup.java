package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;

import apple.uikit.UIView;

public class IOSPopup implements Popup {
	private final Overlay overlay;
	private Widget content;

	@Inject
	public IOSPopup() {
		overlay = Overlay.create();
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		if (this.content != null) {
			this.content.setParent(null);
		}
		this.content = content;
		overlay.setContent((UIView) content.asNative());
		overlay.centerContent();
		content.setParent(this);
		content.layout();
	}

	@Override
	public void show() {
		overlay.show();
	}

	@Override
	public void hide() {
		overlay.hide();
	}

	@Override
	public void setAutoHide(boolean autoHide) {
		overlay.setAutoHide(autoHide);
	}

	@Override
	public void requestLayout() {
		overlay.centerContent();
	}

	@Override
	public void scheduleLayout() {
		requestLayout();
	}



}
