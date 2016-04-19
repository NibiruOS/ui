package org.nibiru.ui.core.impl.builder;

import javax.inject.Inject;

import org.nibiru.ui.core.api.style.Style;

public class StyleBuilder extends BaseStyleBuilder<Style, StyleBuilder> {
	@Inject
	public StyleBuilder() {
		super(new Style());
	}
}
