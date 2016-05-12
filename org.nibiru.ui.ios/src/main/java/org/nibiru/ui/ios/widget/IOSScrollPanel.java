package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

public class IOSScrollPanel extends IOSContainer implements ScrollPanel {
	@Inject
	public IOSScrollPanel() {
	}

	@Override
	public void setContent(Widget content) {
		final IOSWidget<?> widget = (IOSWidget<?>) content;
		// TODO Remove all subviews
		control.addSubview(widget.control);

	}

	@Override
	void layout() {

	}

}
