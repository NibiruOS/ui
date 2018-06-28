package org.nibiru.ui.core.api.format;

import java.util.Date;

public interface FormatFactory {
    Format<Date> getDate(DateFormatType type);
}
