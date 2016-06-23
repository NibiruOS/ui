package org.nibiru.ui.android.style;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Field;

import org.nibiru.ui.core.api.Widget;

public class ReflectionStyleResolver implements StyleResolver {
	private final Class<?> sytleConstantClass;

	public ReflectionStyleResolver(Class<?> stleConstantClass) {
		this.sytleConstantClass = checkNotNull(stleConstantClass);
	}

	@Override
	public int resolveStyle(Enum<?> styleName) {
		checkNotNull(styleName);
		try {
			String fieldName = Widget.STYLE_NAME_PREFIX + styleName.name().toLowerCase();
			Field styleField = sytleConstantClass.getField(fieldName);
			return styleField.getInt(null);
		} catch (NoSuchFieldException e) {
			return StyleResolver.NO_STYLE;
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
