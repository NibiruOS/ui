package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Checkbox;

import apple.coregraphics.struct.CGPoint;
import apple.coregraphics.struct.CGRect;
import apple.coregraphics.struct.CGSize;
import apple.foundation.NSString;
import apple.uikit.UILabel;
import apple.uikit.UISwitch;
import apple.uikit.UIView;
import apple.uikit.enums.UIControlEvents;

public class IOSCheckbox extends IOSValueWidget<UIView, Boolean> implements Checkbox {
	private static final int MARGIN = 5;
	private final UISwitch check;
	private final UILabel label;
	private final Value<String> labelValue;

	@Inject
	public IOSCheckbox() {
		super(UIView.alloc().init());
		label = UILabel.alloc().init();
		check = UISwitch.alloc().init();
		labelValue = new BaseValue<String>() {
			@Override
			public String get() {
				return label.text();
			}

			@Override
			protected void setValue(String value) {
				label.setText(value);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
		check.addTargetActionForControlEvents((UISwitch check, long flags) -> {
			getValue().set(!check.isOn());
		}, UIControlEvents.ValueChanged);
		label.setUserInteractionEnabled(true);
		TouchUpInsideHandlerRegistration.alloc().initWithControlAndClickHandler(label, () -> {
			getValue().set(!getValue().get());
		});
		control.addSubview(check);
		control.addSubview(label);
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
				return check.isOn();
			}

			@Override
			protected void setValue(Boolean value) {
				check.setOn(Boolean.TRUE.equals(value));
			}

			@Override
			public Type<Boolean> getType() {
				return JavaType.BOOLEAN;
			}
		};
	}

	@Override
	protected int getNativeHeight() {
		return (int) Math.max(labelSize().height(), check.frame().size().height());
	}

	@Override
	protected int getNativeWidth() {
		return (int) (check.frame().size().width() + MARGIN + labelSize().width());
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		super.setNativeSize(measuredWidth, measuredHeight);
		int auxWidth = (int) check.frame().size().width();
		check.setFrame(new CGRect(new CGPoint(0, 0), new CGSize(auxWidth, measuredHeight)));
		auxWidth += MARGIN;
		label.setFrame(new CGRect(new CGPoint(auxWidth, 0), new CGSize(measuredWidth - auxWidth, measuredHeight)));
	}

	private CGSize labelSize() {
		return label.text() != null ? NSString.stringWithString(label.text()).sizeWithFont(label.font())
				: new CGSize(0, 0);
	}
}
