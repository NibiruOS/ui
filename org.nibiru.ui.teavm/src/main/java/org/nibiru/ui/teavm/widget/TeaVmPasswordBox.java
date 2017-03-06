package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.PasswordBox;
import org.teavm.jso.dom.html.HTMLInputElement;

import javax.inject.Inject;

public class TeaVmPasswordBox extends TeaVmTextBox
		implements PasswordBox {
	@Inject
	public TeaVmPasswordBox() {
		super();
		control.setType("password");
	}

	public TeaVmPasswordBox(HTMLInputElement textBox) {
		super(textBox);
	}
}
