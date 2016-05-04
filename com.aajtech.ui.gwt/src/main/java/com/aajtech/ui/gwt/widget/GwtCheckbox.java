package com.aajtech.ui.gwt.widget;

import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.user.client.ui.CheckBox;

public class GwtCheckbox extends GwtHasValueWidget<CheckBox, Boolean> implements com.aajtech.ui.core.api.Checkbox {
	Value<String> labelText;
	
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

}
