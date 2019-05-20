package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: Car.kt */
public final class Model {
    private final String brand;
    private final String model;

    public Model(String str, String str2) {
        C0700j.m2715b(str, "brand");
        C0700j.m2715b(str2, "model");
        this.brand = str;
        this.model = str2;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getModel() {
        return this.model;
    }
}
