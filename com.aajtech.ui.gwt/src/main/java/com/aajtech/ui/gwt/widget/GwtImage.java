package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;

public class GwtImage extends GwtWidget<Image>implements com.aajtech.ui.core.api.Image {
	private final Value<String> value;

	public GwtImage() {
		this(new Image());
	}

	public GwtImage(Image widget) {
		super(widget);
		value = new BaseValue<String>() {
			@Override
			public String get() {
				String url = widget.getUrl();
				String prefix = GWT.getModuleBaseURL();
				return url != null && url.startsWith(prefix) ? url.substring(prefix.length()) : url;
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				widget.setUrl(GWT.getModuleBaseURL() + checkNotNull(value));
			}
		};
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
