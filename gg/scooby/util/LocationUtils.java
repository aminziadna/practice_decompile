package ru.gg.scooby.util;

import androidx.core.content.C0318b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.skooby.R;

/* compiled from: LocationUtils.kt */
public final class LocationUtils {
    public static final LocationUtils INSTANCE = new LocationUtils();

    private LocationUtils() {
    }

    public final boolean isLocationPermissionGranted() {
        return C0318b.m1289a(ContextProvider.INSTANCE.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public final String formatDistance(float f) {
        if (f >= 1000.0f) {
            Object string = ContextProvider.INSTANCE.getContext().getString(R.string.distance_in_km, new Object[]{Float.valueOf(f / 1000.0f)});
            C0700j.m2711a(string, "ContextProvider.context.…n_km, distance / 1000.0f)");
            return string;
        }
        string = ContextProvider.INSTANCE.getContext().getString(R.string.distance_in_meters, new Object[]{Integer.valueOf((int) f)});
        C0700j.m2711a(string, "ContextProvider.context.…meters, distance.toInt())");
        return string;
    }
}
