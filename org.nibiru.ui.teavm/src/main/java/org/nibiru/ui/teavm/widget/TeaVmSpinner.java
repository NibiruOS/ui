package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.Spinner;
import org.teavm.jso.dom.html.HTMLElement;

import javax.inject.Inject;

public class TeaVmSpinner extends TeaVmWidget<HTMLElement> implements Spinner {
	@Inject
	public TeaVmSpinner() {
		super(createElement("div"));
	}

	public TeaVmSpinner(HTMLElement control) {
		super(control);
	}
}
