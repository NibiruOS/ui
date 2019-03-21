package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.Spinner;

import javax.inject.Inject;
import javax.swing.JPanel;


// TODO: Implement spinner!!!
public class SwingSpinner extends SwingWidget<JPanel> implements Spinner {
    @Inject
    public SwingSpinner() {
        super(new JPanel());
    }

    @Override
    protected int getNativeHeight() {
        return 32;
    }

    @Override
    protected int getNativeWidth() {
        return 32;
    }
}
