package ru.gg.scooby.model;

import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import p042b.p047e.p049b.C0700j;

/* compiled from: AdvFilter.kt */
public final class AdvFilter {
    public static final Companion Companion = new Companion();
    private final FilterLocation northWest;
    private final FilterLocation southEast;

    /* compiled from: AdvFilter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AdvFilter fromLatLngBounds(LatLngBounds latLngBounds) {
            C0700j.m2715b(latLngBounds, "bounds");
            Object f = latLngBounds.m7240f();
            C0700j.m2711a(f, "bounds.northWest");
            String valueOf = String.valueOf(f.m7217a());
            Object f2 = latLngBounds.m7240f();
            C0700j.m2711a(f2, "bounds.northWest");
            FilterLocation filterLocation = new FilterLocation(valueOf, String.valueOf(f2.m7220b()));
            f2 = latLngBounds.m7239e();
            C0700j.m2711a(f2, "bounds.southEast");
            String valueOf2 = String.valueOf(f2.m7217a());
            Object e = latLngBounds.m7239e();
            C0700j.m2711a(e, "bounds.southEast");
            return new AdvFilter(filterLocation, new FilterLocation(valueOf2, String.valueOf(e.m7220b())));
        }
    }

    public AdvFilter(FilterLocation filterLocation, FilterLocation filterLocation2) {
        C0700j.m2715b(filterLocation, "northWest");
        C0700j.m2715b(filterLocation2, "southEast");
        this.northWest = filterLocation;
        this.southEast = filterLocation2;
    }

    public final FilterLocation getNorthWest() {
        return this.northWest;
    }

    public final FilterLocation getSouthEast() {
        return this.southEast;
    }
}
