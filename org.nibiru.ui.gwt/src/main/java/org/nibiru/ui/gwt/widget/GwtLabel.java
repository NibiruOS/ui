package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;

import com.google.gwt.user.client.ui.Label;

public class GwtLabel extends GwtClickableValueWidget<Label, String> implements org.nibiru.ui.core.api.Label {
	@Inject
	public GwtLabel() {
		this(new Label());
	}

	public GwtLabel(Label label) {
		super(label);
	}

	@Override
	Value<String> buildValue() {
		return new HasTextAdapter(control);
	}
}