package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;

public class GwtImage extends GwtClickableValueWidget<Image, String> implements com.aajtech.ui.core.api.Image {
	@Inject
	public GwtImage() {
		this(new Image());
	}

	public GwtImage(Image control) {
		super(control);
	}

	@Override
	Value<String> buildValue() {
		return  new BaseValue<String>() {
			@Override
			public String get() {
				String url = control.getUrl();
				String prefix = GWT.getModuleBaseURL();
				return url != null && url.startsWith(prefix) ? url.substring(prefix.length()) : url;
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				control.setUrl(GWT.getModuleBaseURL() + checkNotNull(value));
			}
		};
	}
}
