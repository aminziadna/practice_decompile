package ru.gg.scooby.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: DateUtils.kt */
public final class DateUtils$TIME_FORMATTER$1 extends ThreadLocal<SimpleDateFormat> {
    DateUtils$TIME_FORMATTER$1() {
    }

    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("HH:mm", Locale.US);
    }
}
