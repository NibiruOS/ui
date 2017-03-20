package org.nibiru.ui.dotnet.widget;

import com.google.common.base.Strings;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;

public class DotNetTextBox
		extends DotNetValueWidget<cli.System.Windows.Controls.TextBox, String>
		implements TextBox {

	@Inject
	public DotNetTextBox() {
		this(new cli.System.Windows.Controls.TextBox());
	}

	public DotNetTextBox(cli.System.Windows.Controls.TextBox control) {
		super(control);
	}

	@Override
	Value<String> buildValue() {
		return new BaseValue<String>() {
			private String text;
			@Override
			public String get() {
				return Strings.nullToEmpty(text);
			}

			@Override
			protected void setValue(String value) {
				control.AddText(value);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	@Override
	protected int getNativeHeight() {
		return 25;
	}

	@Override
	protected int getNativeWidth() {
		return Strings.nullToEmpty(getValue().get()).length() * 8;
	}
}
