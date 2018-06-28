package org.nibiru.ui.core.impl.format;

import org.nibiru.ui.core.api.format.DateFormatType;
import org.nibiru.ui.core.api.format.Format;
import org.nibiru.ui.core.api.format.FormatFactory;

import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class JavaFormatFactory implements FormatFactory {
    @Inject
    public JavaFormatFactory() {
    }

    @Override
    public Format<Date> getDate(DateFormatType type) {
        checkNotNull(type);
        return new JavaDateFormat(convertDateFormat(type));
    }

    private DateFormat convertDateFormat(DateFormatType type) {
        int style = convertStyle(type);
        switch (type) {
            case DATE_FULL:
            case DATE_LONG:
            case DATE_MEDIUM:
            case DATE_SHORT:
                return DateFormat.getDateInstance(style);
            case DATE_TIME_FULL:
            case DATE_TIME_LONG:
            case DATE_TIME_MEDIUM:
            case DATE_TIME_SHORT:
                return DateFormat.getDateTimeInstance(style, style);
            case TIME_FULL:
            case TIME_LONG:
            case TIME_MEDIUM:
            case TIME_SHORT:
                return DateFormat.getTimeInstance(style);
            default:
                throw new IllegalArgumentException("Invalid DateFormatType: " + type);
        }
    }

    private int convertStyle(DateFormatType type) {
        switch (type) {
            case DATE_FULL:
            case DATE_TIME_FULL:
            case TIME_FULL:
                return DateFormat.FULL;
            case DATE_LONG:
            case DATE_TIME_LONG:
            case TIME_LONG:
                return DateFormat.LONG;
            case DATE_MEDIUM:
            case DATE_TIME_MEDIUM:
            case TIME_MEDIUM:
                return DateFormat.MEDIUM;
            case DATE_SHORT:
            case DATE_TIME_SHORT:
            case TIME_SHORT:
                return DateFormat.SHORT;
            default:
                throw new IllegalArgumentException("Invalid DateFormatType for style: " + type);
        }
    }
}
