package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.user.client.ui.CheckBox;

public class GwtCheckbox extends GwtHasValueWidget<CheckBox, Boolean> implements org.nibiru.ui.core.api.Checkbox {
	Value<String> labelText;
	
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

}
