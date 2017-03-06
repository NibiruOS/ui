package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TeaVmPopup implements Popup {
	private Widget content;

	@Inject
	public TeaVmPopup() {
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		if (this.content != null) {
			this.content.setParent(null);
		}
		this.content = content;
//		popup.clear();
//		popup.add((com.google.gwt.user.client.ui.Widget) content.asNative());
		content.setParent(this);
	}

	@Override
	public void show() {
//		popup.center();
//		popup.show();
	}

	@Override
	public void hide() {
//		popup.hide();
	}

	@Override
	public void setAutoHide(boolean autoHide) {
//		popup.setAutoHideEnabled(autoHide);
	}

	@Override
	public void requestLayout() {
		// TODO Auto-generated method stub
	}

	@Override
	public void scheduleLayout() {
		// TODO Auto-generated method stub
	}
}
