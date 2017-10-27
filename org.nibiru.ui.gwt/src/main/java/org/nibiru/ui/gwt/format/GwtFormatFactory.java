package org.nibiru.ui.gwt.format;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat;

import org.nibiru.ui.core.api.format.DateFormatType;
import org.nibiru.ui.core.api.format.Format;
import org.nibiru.ui.core.api.format.FormatFactory;

import java.util.Date;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class GwtFormatFactory implements FormatFactory {
    @Inject
    public GwtFormatFactory() {
    }

    @Override
    public Format<Date> getDate(DateFormatType type) {
        checkNotNull(type);
        return new GwtDateFormat(DateTimeFormat.getFormat(convertFormat(type)));
    }

    private PredefinedFormat convertFormat(DateFormatType type) {
        switch (type) {
            case DATE_FULL:
                return PredefinedFormat.DATE_FULL;
            case DATE_LONG:
                return PredefinedFormat.DATE_LONG;
            case DATE_MEDIUM:
                return PredefinedFormat.DATE_MEDIUM;
            case DATE_SHORT:
                return PredefinedFormat.DATE_SHORT;
            case DATE_TIME_FULL:
                return PredefinedFormat.DATE_TIME_FULL;
            case DATE_TIME_LONG:
                return PredefinedFormat.DATE_TIME_LONG;
            case DATE_TIME_MEDIUM:
                return PredefinedFormat.DATE_TIME_MEDIUM;
            case DATE_TIME_SHORT:
                return PredefinedFormat.DATE_TIME_SHORT;
            case TIME_FULL:
                return PredefinedFormat.TIME_FULL;
            case TIME_LONG:
                return PredefinedFormat.TIME_LONG;
            case TIME_MEDIUM:
                return PredefinedFormat.TIME_MEDIUM;
            case TIME_SHORT:
                return PredefinedFormat.TIME_SHORT;
            default:
                throw new IllegalArgumentException("Invalid DateFormatType: " + type);
        }
    }
}
