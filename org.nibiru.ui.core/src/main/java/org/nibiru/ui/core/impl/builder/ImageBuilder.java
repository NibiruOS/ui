package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Image;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

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
