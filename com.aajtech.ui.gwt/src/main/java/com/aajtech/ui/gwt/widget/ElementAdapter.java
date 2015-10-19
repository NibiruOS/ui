package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.dom.client.Element;

public class ElementAdapter extends BaseValue<String> {
	private final Element element;

	public ElementAdapter(Element element) {
		this.element = checkNotNull(element);
	}

	@Override
	public void set(String value) {
		checkNotNull(value);
		element.setInnerText(value);
	}

	@Override
	public String get() {
		return element.getInnerText();
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}
