package ru.gg.scooby.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.skooby.R;

/* compiled from: DateUtils.kt */
public final class DateUtils {
    private static final long DAY = TimeUnit.DAYS.toMillis(1);
    private static final long HOUR = TimeUnit.HOURS.toMillis(1);
    private static final DateUtils$IMAGE_NAME_FORMATTER$1 IMAGE_NAME_FORMATTER = new DateUtils$IMAGE_NAME_FORMATTER$1();
    public static final DateUtils INSTANCE = new DateUtils();
    private static final DateUtils$ISO_DATE_FORMATTER$1 ISO_DATE_FORMATTER = new DateUtils$ISO_DATE_FORMATTER$1();
    private static final long MINUTE = TimeUnit.MINUTES.toMillis(1);
    private static final DateUtils$MINUTES_SECONDS_FORMATTER$1 MINUTES_SECONDS_FORMATTER = new DateUtils$MINUTES_SECONDS_FORMATTER$1();
    private static final DateUtils$TIME_FORMATTER$1 TIME_FORMATTER = new DateUtils$TIME_FORMATTER$1();

    private DateUtils() {
    }

    public final long getDAY() {
        return DAY;
    }

    public final long getHOUR() {
        return HOUR;
    }

    public final long getMINUTE() {
        return MINUTE;
    }

    public final String toMinutesSeconds(long j) {
        Object obj = MINUTES_SECONDS_FORMATTER.get();
        C0700j.m2711a(obj, "MINUTES_SECONDS_FORMATTER.get()");
        return to((DateFormat) obj, j);
    }

    private final String to(DateFormat dateFormat, long j) {
        Object format = dateFormat.format(new Date(j));
        C0700j.m2711a(format, "dateFormat.format(Date(timestamp))");
        return format;
    }

    private final long from(DateFormat dateFormat, String str) {
        try {
            Object parse = dateFormat.parse(str);
            C0700j.m2711a(parse, "dateFormat.parse(isoString)");
            return parse.getTime();
        } catch (DateFormat dateFormat2) {
            Log.e$default(Log.INSTANCE, (Throwable) dateFormat2, false, 2, null);
            return -1;
        }
    }

    public final String toImageName(long j) {
        return ((SimpleDateFormat) IMAGE_NAME_FORMATTER.get()).format(Long.valueOf(j));
    }

    public final String toIso(long j) {
        Object obj = ISO_DATE_FORMATTER.get();
        C0700j.m2711a(obj, "ISO_DATE_FORMATTER.get()");
        return to((DateFormat) obj, j);
    }

    public final long fromIso(String str) {
        C0700j.m2715b(str, "isoString");
        Object obj = ISO_DATE_FORMATTER.get();
        C0700j.m2711a(obj, "ISO_DATE_FORMATTER.get()");
        return from((DateFormat) obj, str);
    }

    public final String toTime(long j) {
        Object obj = TIME_FORMATTER.get();
        C0700j.m2711a(obj, "TIME_FORMATTER.get()");
        return to((DateFormat) obj, j);
    }

    public final Calendar timeRoundedByMinutes(int i) {
        Object instance = Calendar.getInstance();
        int i2 = instance.get(12) % i;
        if (i2 != 0) {
            i -= i2;
        }
        instance.add(12, i);
        C0700j.m2711a(instance, "calendar");
        return instance;
    }

    public final Calendar todayOrTomorrowByHourAndMinutes(int i, int i2) {
        Object instance = Calendar.getInstance();
        if (i < instance.get(11) || (i == instance.get(11) && i2 < instance.get(12))) {
            instance.add(5, 1);
        }
        instance.set(11, i);
        instance.set(12, i2);
        C0700j.m2711a(instance, "calendar");
        return instance;
    }

    public final boolean isToday(long j) {
        return android.text.format.DateUtils.isToday(j);
    }

    public final boolean isTomorrow(long j) {
        return android.text.format.DateUtils.isToday(j - DAY);
    }

    public final String relativeStringDate(long j) {
        if (isTomorrow(j)) {
            Object string = ContextProvider.INSTANCE.getContext().getString(R.string.tomorrow);
            C0700j.m2711a(string, "ContextProvider.context.…String(R.string.tomorrow)");
            return string;
        }
        j -= System.currentTimeMillis();
        long j2 = HOUR;
        if (j > j2) {
            int i = (int) ((j + j2) / j2);
            j = ContextProvider.INSTANCE.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = ContextProvider.INSTANCE.getContext().getResources().getQuantityString(R.plurals.hours_count, i, new Object[]{Integer.valueOf(i)});
            string = j.getString(R.string.time_in, objArr);
            C0700j.m2711a(string, "ContextProvider.context.…urs_count, hours, hours))");
            return string;
        }
        j2 = (long) 5;
        long j3 = MINUTE;
        if (j > j2 * j3) {
            i = (int) ((j + j3) / j3);
            j = ContextProvider.INSTANCE.getContext();
            objArr = new Object[1];
            objArr[0] = ContextProvider.INSTANCE.getContext().getResources().getQuantityString(R.plurals.minutes_count, i, new Object[]{Integer.valueOf(i)});
            string = j.getString(R.string.time_in, objArr);
            C0700j.m2711a(string, "ContextProvider.context.…count, minutes, minutes))");
            return string;
        }
        string = ContextProvider.INSTANCE.getContext().getString(R.string.now);
        C0700j.m2711a(string, "ContextProvider.context.getString(R.string.now)");
        return string;
    }
}
