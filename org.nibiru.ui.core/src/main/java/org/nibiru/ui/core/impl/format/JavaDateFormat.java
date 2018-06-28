package org.nibiru.ui.core.impl.format;


import org.nibiru.ui.core.api.format.Format;
import org.nibiru.ui.core.api.format.ParseException;

import java.text.DateFormat;
import java.util.Date;

class JavaDateFormat implements Format<Date> {
    private final DateFormat format;

    JavaDateFormat(DateFormat format) {
        this.format = format;
    }

    @Override
    public String format(Date data) {
        return format.format(data);
    }

    @Override
    public Date parse(String data) {
        try {
            return format.parse(data);
        } catch (java.text.ParseException e) {
            throw new ParseException(e);
        }
    }
}
