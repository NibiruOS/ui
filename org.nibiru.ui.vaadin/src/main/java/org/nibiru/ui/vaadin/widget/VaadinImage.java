package org.nibiru.ui.vaadin.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.ResourcesBasePath;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.Image;

public class VaadinImage extends VaadinWidget<Image>implements org.nibiru.ui.core.api.Image {
	private final Value<String> value;

	@Inject
	public VaadinImage(@ResourcesBasePath String basePath) {
		this(new Image(), basePath);
	}

	public VaadinImage(Image component, final String basePath) {
		super(component);
		checkNotNull(basePath);
		value = new BaseValue<String>() {
			private String value;

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
				component.setSource(new ClassResource("/" + basePath + value));
			}
		};
	}

	@Override
	public Value<String> getValue() {
		return value;
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
