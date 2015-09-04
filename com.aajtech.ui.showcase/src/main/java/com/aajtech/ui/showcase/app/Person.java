package com.aajtech.ui.showcase.app;

import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.model.core.impl.java.JavaValue;

public class Person {
	public final Value<String> firstName = JavaValue.of(JavaType.STRING);
	public final Value<String> lastName = JavaValue.of(JavaType.STRING);

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String newFirstName) {
		firstName.set(newFirstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String newLastName) {
		lastName.set(newLastName);
	}
}
