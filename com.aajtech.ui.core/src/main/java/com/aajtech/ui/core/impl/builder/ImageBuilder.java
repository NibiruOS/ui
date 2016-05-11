package com.aajtech.ui.core.impl.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Image;

public class ImageBuilder extends BaseClickableValueBuilder<Image, String, ImageBuilder> {
	@Inject
	private static Provider<ImageBuilder> imageBuilderProvider;

	public static ImageBuilder image() {
		return imageBuilderProvider.get();
	}

	public static Image image(String path) {
		checkNotNull(path);
		return image().value(path).build();
	}

	@Inject
	public ImageBuilder(Image image) {
		super(image);
	}
}
