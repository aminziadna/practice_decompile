package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: ParkingAdvert.kt */
public final class ParkingStatusResponse {
    private final String message;
    private final int status;

    public ParkingStatusResponse(int i, String str) {
        C0700j.m2715b(str, "message");
        this.status = i;
        this.message = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }
}
