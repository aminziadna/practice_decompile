package ru.gg.scooby.model;

import com.google.gson.p141a.C1687c;
import p042b.p047e.p049b.C0700j;

/* compiled from: Parking.kt */
public final class ParkingForSell {
    private String address;
    private long carId;
    @C1687c(a = "latitude")
    private double lat;
    @C1687c(a = "longitude")
    private double lng;
    private long price;
    private final String time;

    public ParkingForSell(double d, double d2, long j, String str, long j2, String str2) {
        C0700j.m2715b(str, "time");
        C0700j.m2715b(str2, "address");
        this.lat = d;
        this.lng = d2;
        this.price = j;
        this.time = str;
        this.carId = j2;
        this.address = str2;
    }

    public final double getLat() {
        return this.lat;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final double getLng() {
        return this.lng;
    }

    public final void setLng(double d) {
        this.lng = d;
    }

    public final long getPrice() {
        return this.price;
    }

    public final void setPrice(long j) {
        this.price = j;
    }

    public final String getTime() {
        return this.time;
    }

    public final long getCarId() {
        return this.carId;
    }

    public final void setCarId(long j) {
        this.carId = j;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.address = str;
    }
}
