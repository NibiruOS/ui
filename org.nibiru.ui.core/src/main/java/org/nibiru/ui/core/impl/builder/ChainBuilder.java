package org.nibiru.ui.core.impl.builder;

public interface ChainBuilder<B> {
    @SuppressWarnings("unchecked")
    default B getThis() {
        return (B) this;
    }
}
