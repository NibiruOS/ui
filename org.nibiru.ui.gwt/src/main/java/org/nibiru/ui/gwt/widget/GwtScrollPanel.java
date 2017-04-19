package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.ScrollPanel;

import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class GwtScrollPanel extends GwtWidget<ScrollPanel>implements org.nibiru.ui.core.api.ScrollPanel {
	private Widget content;

	@Inject
	public GwtScrollPanel() {
		this(new ScrollPanel());
	}

	public GwtScrollPanel(ScrollPanel control) {
		super(control);
	}

	@Override
	public void setContent(Widget content) {
		checkNotNull(content);
		if (this.content != null) {
			this.content.setParent(null);
		}
		this.content = content;
		control.clear();
		control.add((com.google.gwt.user.client.ui.Widget) content.asNative());
		content.setParent(this);
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
