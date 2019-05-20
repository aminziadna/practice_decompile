package ru.gg.scooby.model;

import java.util.List;
import p042b.p047e.p049b.C0700j;

/* compiled from: ParkingAdvert.kt */
public final class ParkingsResponse {
    private final List<ParkingAdvert> advList;

    public ParkingsResponse(List<ParkingAdvert> list) {
        C0700j.m2715b(list, "advList");
        this.advList = list;
    }

    public final List<ParkingAdvert> getAdvList() {
        return this.advList;
    }
}
