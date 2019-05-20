package ru.gg.scooby.model;

import ru.gg.scooby.util.DateUtils;

/* compiled from: SmsCodeStatus.kt */
public final class UserStatus {
    private final int code;
    private final String untilDate;

    public UserStatus(int i, String str) {
        this.code = i;
        this.untilDate = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getUntilDate() {
        return this.untilDate;
    }

    public final long getUntilDateLong() {
        String str = this.untilDate;
        return str != null ? DateUtils.INSTANCE.fromIso(str) : 0;
    }
}
