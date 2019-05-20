package ru.gg.scooby.model.geo;

import java.util.List;
import p042b.p047e.p049b.C0700j;

/* compiled from: GeocoderResponse.kt */
public final class GeocoderResponse {
    private final List<GeocoderFeature> features;

    public GeocoderResponse(List<GeocoderFeature> list) {
        C0700j.m2715b(list, "features");
        this.features = list;
    }

    public final List<GeocoderFeature> getFeatures() {
        return this.features;
    }
}
