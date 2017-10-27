package org.nibiru.ui.gwt.format;

import com.google.gwt.i18n.shared.DateTimeFormat;

import org.nibiru.ui.core.api.format.Format;

import java.util.Date;

class GwtDateFormat implements Format<Date> {
    private final DateTimeFormat format;

    GwtDateFormat(DateTimeFormat format) {
        this.format = format;
    }

    @Override
    public String format(Date data) {
        return format.format(data);
    }

    @Override
    public Date parse(String data) {
        return format.parse(data);
    }
}
