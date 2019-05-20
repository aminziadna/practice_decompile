package ru.gg.scooby.settings;

import android.content.SharedPreferences;
import io.card.payment.BuildConfig;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;

/* compiled from: DeviceSettings.kt */
public final class DeviceSettings extends BaseSettings {
    public static final DeviceSettings INSTANCE = new DeviceSettings();
    public static final String PREF_DEVICE_ID = "PREF_DEVICE_ID";
    public static final String PREF_ONBOARDING_SHOWN = "PREF_ONBOARDING_SHOWN";

    private DeviceSettings() {
    }

    public SharedPreferences getPrefs() {
        Object sharedPreferences = ContextProvider.INSTANCE.getContext().getSharedPreferences("device_settings", 0);
        C0700j.m2711a(sharedPreferences, "ContextProvider.context.…s\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final String getDeviceId() {
        Object string = getPrefs().getString(PREF_DEVICE_ID, BuildConfig.FLAVOR);
        C0700j.m2711a(string, "prefs.getString(PREF_DEVICE_ID, \"\")");
        return string;
    }

    public final void setDeviceId(String str) {
        C0700j.m2715b(str, "value");
        getPrefs().edit().putString(PREF_DEVICE_ID, str).apply();
    }

    public final boolean getOnboardingShown() {
        return getPrefs().getBoolean(PREF_ONBOARDING_SHOWN, false);
    }

    public final void setOnboardingShown(boolean z) {
        getPrefs().edit().putBoolean(PREF_ONBOARDING_SHOWN, z).apply();
    }
}
