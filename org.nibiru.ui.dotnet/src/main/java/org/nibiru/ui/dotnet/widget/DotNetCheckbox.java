package org.nibiru.ui.dotnet.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Checkbox;

import javax.inject.Inject;

import cli.System.Windows.Controls.CheckBox;

public class DotNetCheckbox extends DotNetValueWidget<CheckBox, Boolean> implements Checkbox {
	private static final int MARGIN = 5;
//	private final UISwitch check;
//	private final UILabel label;
	private final Value<String> labelValue;

	@Inject
	public DotNetCheckbox() {
		this(new CheckBox());
	}

	public DotNetCheckbox(CheckBox control) {
		super(control);
//		label = UILabel.alloc().init();
//		check = UISwitch.alloc().init();
		labelValue = new BaseValue<String>() {
			@Override
			public String get() {
				//return label.text();
				return "checkbox";
			}

			@Override
			protected void setValue(String value) {
//				label.setText(value);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
//		check.addTargetActionForControlEvents((UISwitch check, long flags) -> {
//			getValue().set(!check.isOn());
//		}, UIControlEvents.ValueChanged);
//		label.setUserInteractionEnabled(true);
//		TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(label, () -> {
//			getValue().set(!getValue().get());
//		});
//		control.addSubview(check);
//		control.addSubview(label);
	}

	@Override
	public Value<String> getTextLabel() {
		return labelValue;
	}

	@Override
	Value<Boolean> buildValue() {
		return new BaseValue<Boolean>() {
			@Override
			public Boolean get() {
//				return check.isOn();
				return false;
			}

			@Override
			protected void setValue(Boolean value) {
//				check.setOn(Boolean.TRUE.equals(value));
			}

			@Override
			public Type<Boolean> getType() {
				return JavaType.BOOLEAN;
			}
		};
	}

	@Override
	protected int getNativeHeight() {
		return 25;
	}

	@Override
	protected int getNativeWidth() {
		return 25;
	}
}
