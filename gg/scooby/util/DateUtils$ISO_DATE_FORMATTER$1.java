package ru.gg.scooby.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateUtils.kt */
public final class DateUtils$ISO_DATE_FORMATTER$1 extends ThreadLocal<SimpleDateFormat> {
    DateUtils$ISO_DATE_FORMATTER$1() {
    }

    protected SimpleDateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC+0"));
        return simpleDateFormat;
    }
}
