package org.nibiru.ui.gwt.widget;

import com.google.gwt.dom.client.Element;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

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
