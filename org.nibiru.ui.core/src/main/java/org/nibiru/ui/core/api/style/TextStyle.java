package org.nibiru.ui.core.api.style;

import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;

public class TextStyle extends Style {
	public static final TextStyle DEFAULT = new TextStyle();

	private Color textColor;

	@Nullable
	public Color getTextColor() {
		return MoreObjects.firstNonNull(
				textColor != null ? textColor : (getParent() instanceof TextStyle ? ((TextStyle)getParent()).getTextColor() : null),
				Color.BLACK);
	}

	public void setTextColor(@Nullable Color textColor) {
		this.textColor = textColor;
	}
}
