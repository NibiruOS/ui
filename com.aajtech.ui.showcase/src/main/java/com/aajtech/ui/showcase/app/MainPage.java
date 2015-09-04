package com.aajtech.ui.showcase.app;

import javax.inject.Inject;

import com.aajtech.model.core.impl.bind.Bind;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.TextBox;
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
		Person person = new Person();
		
		TextBox firstName = textBox("");
		TextBox lastName = textBox("");
		
		Bind.on(firstName.getValue())
			.to(person.firstName);
		
		Bind.on(lastName.getValue())
			.to(person.lastName);

		Label upper = label("");
		Label lower = label("");

		Bind.on(person.firstName)
			.map((String value) -> value.toUpperCase())
			.to(upper.getValue());

		Bind.on(person.lastName)
			.map((String value) -> value.toLowerCase())
			.to(lower.getValue());

		return verticalPanel()
				.add(label("Goodbye Xamarin Forms - !!!"))
				.add(horizontalPanel()
						.add(label("First Name: "))
						.add(firstName)
						.build())
				.add(horizontalPanel()
						.add(label("Last Name: "))
						.add(lastName)
						.build())
				.add(horizontalPanel()
						.add(upper)
						.add(label(" - "))
						.add(lower)
						.build())
				.build();
	}
}
