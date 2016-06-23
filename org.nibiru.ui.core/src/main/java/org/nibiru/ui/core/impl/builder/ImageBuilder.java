package org.nibiru.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Image;

public class ImageBuilder extends BaseClickableValueBuilder<Image, String, ImageBuilder> {
	@Inject
	public ImageBuilder(Image image) {
		super(image);
	}

	public Image build(String path) {
		checkNotNull(path);
		return value(path).build();
	}
}
