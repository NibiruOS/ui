package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;

import org.nibiru.model.core.api.Registration;
import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ClickHandler;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.ResourcesBasePath;
import com.google.common.base.Throwables;
import com.google.common.io.ByteSource;

public class IOSImage extends IOSValueWidget<UIImageView, String> implements Image {
	private final String basePath;

	@Inject
	public IOSImage(@ResourcesBasePath String basePath) {
		this(new UIImageView(new CGRect(0, 0, 50, 50)), basePath);
	}

	public IOSImage(UIImageView imageView, final String basePath) {
		super(imageView);
		this.basePath = checkNotNull(basePath);
	}

	@Override
	Value<String> buildValue() {
		// TODO Auto-generated method stub
		return new BaseValue<String>() {
			private String value;

			@Override
			public String get() {
				return value;
			}

			@Override
			protected void setValue(String value) {
				this.value = checkNotNull(value);
				try {
					ByteSource source = new ByteSource() {
						@Override
						public InputStream openStream() throws IOException {
							return getClass().getClassLoader().getResourceAsStream(basePath + value);
						}
					};
					UIImage image = new UIImage(new NSData(source.read()));
					control.setImage(image);
					updateSize((int)image.getSize().getWidth(), (int)image.getSize().getHeight());
				} catch (IOException e) {
					Throwables.propagate(e);
				}
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	@Override
	public Registration setClickHandler(ClickHandler clickHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
