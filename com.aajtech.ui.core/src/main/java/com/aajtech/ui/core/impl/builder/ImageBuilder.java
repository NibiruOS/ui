package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Image;

public class ImageBuilder extends BaseValueBuilder<Image, String, ImageBuilder> {
	@Inject
	public ImageBuilder(Image image) {
		super(image);
	}
}
