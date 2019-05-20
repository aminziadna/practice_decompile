package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: SmsCodeStatus.kt */
public final class PostVerifyCodeResponse {
    private final VerifiedCodeResult result;
    private final UserStatus userStatus;

    public PostVerifyCodeResponse(UserStatus userStatus, VerifiedCodeResult verifiedCodeResult) {
        C0700j.m2715b(userStatus, "userStatus");
        C0700j.m2715b(verifiedCodeResult, "result");
        this.userStatus = userStatus;
        this.result = verifiedCodeResult;
    }

    public final UserStatus getUserStatus() {
        return this.userStatus;
    }

    public final VerifiedCodeResult getResult() {
        return this.result;
    }
}
