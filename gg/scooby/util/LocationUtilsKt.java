package ru.gg.scooby.util;

import android.location.Location;
import com.mapbox.mapboxsdk.geometry.LatLng;

/* compiled from: LocationUtils.kt */
public final class LocationUtilsKt {
    public static final boolean isValidLocation(Location location) {
        return (location == null || location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? null : true;
    }

    public static final boolean isValidLocation(LatLng latLng) {
        return (latLng == null || latLng.m7217a() == 0.0d || latLng.m7220b() == 0.0d) ? null : true;
    }
}
