package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.CheckBox;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;

import javax.inject.Inject;

public class GwtCheckbox
		extends GwtHasEnabledHasValueWidget<CheckBox, Boolean>
		implements org.nibiru.ui.core.api.Checkbox {
	// TODO: Fix this "magic".
	private static int MAGIC_PADDING = 2;

	private Value<String> labelText;
	
	@Inject
	public GwtCheckbox() {
		this(new CheckBox());
	}
	
	public GwtCheckbox(CheckBox checkbox) {
		super(checkbox, JavaType.BOOLEAN);
	}
	
	@Override
	public Value<String> getTextLabel() {
		if (labelText == null) {
			labelText = new HasTextAdapter(control);
		}
		return labelText;
	}

	@Override
	protected int getNativeWidth() {
		return super.getNativeWidth() + MAGIC_PADDING;
	}
}
