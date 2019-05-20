package ru.gg.scooby.util;

import android.graphics.Color;

/* compiled from: ColorUtils.kt */
public final class ColorUtils {
    public static final ColorUtils INSTANCE = new ColorUtils();
    public static final float LUMINOSITY_THRESHOLD = 128.0f;

    private ColorUtils() {
    }

    public final float getLuminance(int i) {
        return ((((float) Color.red(i)) * 0.299f) + (((float) Color.green(i)) * 0.587f)) + (((float) Color.blue(i)) * 1038710997);
    }

    public final boolean isLight(int i) {
        return getLuminance(i) > 1124073472;
    }
}
