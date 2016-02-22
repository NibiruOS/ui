package com.aajtech.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ResourcesBasePath;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;

public class VaadinImage extends VaadinWidget<Image>implements com.aajtech.ui.core.api.Image {
	private final String basePath;

	@Inject
	public VaadinImage(@ResourcesBasePath String basePath) {
		this(new Image(), basePath);
	}

	public VaadinImage(Image component, String basePath) {
		super(component);
		this.basePath = checkNotNull(basePath);
	}

	@Override
	public Value<String> getValue() {
		return new BaseValue<String>() {
			String value;

			@Override
			public String get() {
				return value;
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}

			@Override
			protected void setValue(String value) {
				this.value = checkNotNull(value);
				component.setSource(new ClassResource(basePath + value));
			}
		};
	}
}
