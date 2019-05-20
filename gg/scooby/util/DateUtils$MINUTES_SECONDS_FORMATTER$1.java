package ru.gg.scooby.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateUtils.kt */
public final class DateUtils$MINUTES_SECONDS_FORMATTER$1 extends ThreadLocal<SimpleDateFormat> {
    DateUtils$MINUTES_SECONDS_FORMATTER$1() {
    }

    protected SimpleDateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }
}
