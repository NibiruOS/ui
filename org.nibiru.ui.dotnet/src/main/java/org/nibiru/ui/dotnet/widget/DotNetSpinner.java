package org.nibiru.ui.dotnet.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.Spinner;

import cli.System.Windows.Controls.Label;

public class DotNetSpinner extends DotNetWidget<Label> implements Spinner {
	@Inject
	public DotNetSpinner() {
		super(new Label());
		control.AddText("O");
	}

	@Override
	protected int getNativeHeight() {
		// TODO Fix value - add size computation
		return 30;
	}

	@Override
	protected int getNativeWidth() {
		// TODO Fix value - add size computation
		return 30;
	}
}
