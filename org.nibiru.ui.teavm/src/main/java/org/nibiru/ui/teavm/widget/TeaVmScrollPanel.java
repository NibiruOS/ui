package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.Widget;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.xml.Node;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class TeaVmScrollPanel extends TeaVmWidget<HTMLElement> implements org.nibiru.ui.core.api.ScrollPanel {
	private Widget content;

	@Inject
	public TeaVmScrollPanel() {
		this(createElement("div"));
	}

	public TeaVmScrollPanel(HTMLElement control) {
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
		control.appendChild((Node) content.asNative());
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
