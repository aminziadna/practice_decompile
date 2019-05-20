package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: Pin.kt */
public final class Pin {
    private final String deviceUid;
    private final String pin;

    public Pin(String str, String str2) {
        C0700j.m2715b(str, "deviceUid");
        C0700j.m2715b(str2, "pin");
        this.deviceUid = str;
        this.pin = str2;
    }

    public final String getDeviceUid() {
        return this.deviceUid;
    }

    public final String getPin() {
        return this.pin;
    }
}
