package ru.gg.scooby.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: DateUtils.kt */
public final class DateUtils$IMAGE_NAME_FORMATTER$1 extends ThreadLocal<SimpleDateFormat> {
    DateUtils$IMAGE_NAME_FORMATTER$1() {
    }

    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss", Locale.US);
    }
}
