package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: SmsCodeStatus.kt */
public final class SmsRequest {
    private final SmsRequestStatus status;
    private final long timeout;

    public SmsRequest(SmsRequestStatus smsRequestStatus, long j) {
        C0700j.m2715b(smsRequestStatus, "status");
        this.status = smsRequestStatus;
        this.timeout = j;
    }

    public final SmsRequestStatus getStatus() {
        return this.status;
    }

    public final long getTimeout() {
        return this.timeout;
    }
}
