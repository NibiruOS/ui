package com.aajtech.ui.showcase.vaadin.ioc;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;

import javax.inject.Inject;

import com.google.inject.TypeLiteral;

public class SerializableProvider<T> implements Serializable {
	private static final long serialVersionUID = 1759393991849129200L;
	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	@Inject
	public SerializableProvider(TypeLiteral<T> typeLiteral) {
		this.clazz = (Class<T>) requireNonNull(typeLiteral).getRawType();
	}

	public T get() {
		return ContextListener.injector.getInstance(clazz);
	}
}
