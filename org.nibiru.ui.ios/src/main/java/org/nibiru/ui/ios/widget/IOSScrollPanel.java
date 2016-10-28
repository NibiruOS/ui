package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

import apple.uikit.UIView;
import dagger.internal.Preconditions;

public class IOSScrollPanel extends IOSContainer implements ScrollPanel {
	@Inject
	public IOSScrollPanel() {
	}

	@Override
	public void setContent(Widget content) {
		Preconditions.checkNotNull(content);
		clear();
		control.addSubview((UIView) content.asNative());
	}

	@Override
	public void requestLayout() {
	}

	@Override
	protected int getNativeHeight() {
		// TODO Fix value - add size computation
		return 480;
	}

	@Override
	protected int getNativeWidth() {
		// TODO Fix value - add size computation
		return 320;
	}
}
