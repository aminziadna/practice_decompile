package ru.gg.scooby.settings;

import android.content.SharedPreferences;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.BuildConfig;
import ru.gg.scooby.ContextProvider;

/* compiled from: DevSettings.kt */
public final class DevSettings extends BaseSettings {
    public static final DevSettings INSTANCE = new DevSettings();
    public static final String PREF_ENVIRONMENT = "PREF_ENVIRONMENT";
    public static final String PREF_REDUCED_PRICES = "PREF_REDUCED_PRICES";

    private DevSettings() {
    }

    public SharedPreferences getPrefs() {
        Object sharedPreferences = ContextProvider.INSTANCE.getContext().getSharedPreferences("dev_settings", 0);
        C0700j.m2711a(sharedPreferences, "ContextProvider.context.…s\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final Environment getEnvironment() {
        Enum valueOf;
        String str = PREF_ENVIRONMENT;
        Object obj = BuildConfig.DEFAULT_ENVIRONMENT;
        C0700j.m2711a(obj, "BuildConfig.DEFAULT_ENVIRONMENT");
        Enum enumR = (Enum) obj;
        str = getPrefs().getString(str, enumR.name());
        if (str != null) {
            valueOf = Environment.valueOf(str);
            if (valueOf != null) {
                return (Environment) valueOf;
            }
        }
        valueOf = enumR;
        return (Environment) valueOf;
    }

    public final void setEnvironment(Environment environment) {
        C0700j.m2715b(environment, "value");
        putEnum(PREF_ENVIRONMENT, environment);
    }

    public final boolean getReducedPrices() {
        return getPrefs().getBoolean(PREF_REDUCED_PRICES, false);
    }

    public final void setReducedPrices(boolean z) {
        getPrefs().edit().putBoolean(PREF_REDUCED_PRICES, z).apply();
    }
}
