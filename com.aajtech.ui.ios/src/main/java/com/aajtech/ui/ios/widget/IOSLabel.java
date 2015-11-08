package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UILabel;

import com.aajtech.ui.core.api.Label;

public class IOSLabel extends IOSValueWidget<UILabel> implements Label {
	public IOSLabel() {
		super(new ViewValue<UILabel>(new UILabel(new CGRect(0, 0, 120, 30))) {
			@Override
			public String get() {
				return view.getText();
			}

			@Override
			protected void setValue(String value) {
				view.setText(value);
			}
		});
	}
}
