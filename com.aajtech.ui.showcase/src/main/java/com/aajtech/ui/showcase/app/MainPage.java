package com.aajtech.ui.showcase.app;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Widget;
import com.aajtech.ui.core.impl.builder.UiBuilder;
import com.aajtech.ui.core.impl.builder.UiModule;

public class MainPage extends UiModule {
	@Inject
	public MainPage(UiBuilder uiBuilder) {
		super(uiBuilder);
	}

	@Override
	public Widget buildUi() {
		return verticalPanel()
				.add(label("Goodbye Xamarin Forms - !!!"))
				.add(horizontalPanel()
						.add(label("First Name: "))
						.add(textBox(""))
						.build())
				.add(horizontalPanel()
						.add(label("Last Name: "))
						.add(textBox(""))
						.build())
				.build();
	}
}
