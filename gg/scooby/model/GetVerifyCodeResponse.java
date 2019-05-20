package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: SmsCodeStatus.kt */
public final class GetVerifyCodeResponse {
    private final SmsRequest smsRequest;
    private final UserStatus userStatus;

    public GetVerifyCodeResponse(UserStatus userStatus, SmsRequest smsRequest) {
        C0700j.m2715b(userStatus, "userStatus");
        C0700j.m2715b(smsRequest, "smsRequest");
        this.userStatus = userStatus;
        this.smsRequest = smsRequest;
    }

    public final UserStatus getUserStatus() {
        return this.userStatus;
    }

    public final SmsRequest getSmsRequest() {
        return this.smsRequest;
    }
}
