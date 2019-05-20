package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: AdvFilter.kt */
public final class FilterLocation {
    private final String latitude;
    private final String longitude;

    public FilterLocation(String str, String str2) {
        C0700j.m2715b(str, "latitude");
        C0700j.m2715b(str2, "longitude");
        this.latitude = str;
        this.longitude = str2;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final String getLongitude() {
        return this.longitude;
    }
}
