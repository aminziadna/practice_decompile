package ru.gg.scooby.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Log.kt */
public final class Log$LOG_TIME_FORMATTER$1 extends ThreadLocal<SimpleDateFormat> {
    Log$LOG_TIME_FORMATTER$1() {
    }

    protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    }
}
