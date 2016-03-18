package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.user.client.ui.Image;

public class GwtImage extends GwtClickableValueWidget<Image, String> implements org.nibiru.ui.core.api.Image {
	private boolean dirty;

	@Inject
	public GwtImage() {
		this(new Image());
		control.addLoadHandler((LoadEvent event) -> {
			if (dirty && getParent() != null) {
				getParent().scheduleLayout();
			}
		});
	}

	public GwtImage(Image control) {
		super(control);
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		super.setNativeSize(measuredWidth, measuredHeight);
		dirty = (measuredWidth == 0 && measuredHeight == 0);
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
