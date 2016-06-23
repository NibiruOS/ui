package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

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
	protected void setValue(@Nullable String value) {
		element.setInnerText(value);
	}

	@Override
	@Nullable
	public String get() {
		return element.getInnerText();
	}

	@Override
	public Type<String> getType() {
		return JavaType.STRING;
	}
}
