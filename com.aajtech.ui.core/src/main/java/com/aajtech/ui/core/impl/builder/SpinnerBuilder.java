package com.aajtech.ui.core.impl.builder;

import javax.inject.Inject;
import javax.inject.Provider;

import com.aajtech.ui.core.api.Spinner;

public class SpinnerBuilder extends BaseBuilder<Spinner> {
	@Inject
	private static Provider<SpinnerBuilder> spinnerBuilderProvider;

	public static SpinnerBuilder spinner() {
		return spinnerBuilderProvider.get();
	}

	@Inject
	public SpinnerBuilder(Spinner object) {
		super(object);
	}
}
