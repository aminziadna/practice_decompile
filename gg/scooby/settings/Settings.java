package ru.gg.scooby.settings;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import io.card.payment.BuildConfig;
import java.util.List;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.model.SimpleAddress;
import ru.gg.scooby.model.User;

/* compiled from: Settings.kt */
public final class Settings extends BaseSettings {
    public static final Settings INSTANCE = new Settings();
    public static final String PREF_AVATAR_SIGNATURE = "PREF_AVATAR_SIGNATURE";
    public static final String PREF_FIRST_LAUNCH_DATE = "PREF_FIRST_LAUNCH_DATE";
    public static final String PREF_PHONE = "PREF_PHONE";
    public static final String PREF_PIN_SET = "PREF_PIN_SET";
    public static final String PREF_PRIMARY_CARD_ID = "PREF_PRIMARY_CARD_ID";
    public static final String PREF_RECENT_ADDRESS_SEARCHES = "PREF_RECENT_ADDRESS_SEARCHES";
    public static final String PREF_USER = "PREF_USER";

    private Settings() {
    }

    public SharedPreferences getPrefs() {
        Object defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ContextProvider.INSTANCE.getContext());
        C0700j.m2711a(defaultSharedPreferences, "PreferenceManager.getDef…(ContextProvider.context)");
        return defaultSharedPreferences;
    }

    public final String getPhone() {
        Object string = getPrefs().getString(PREF_PHONE, BuildConfig.FLAVOR);
        C0700j.m2711a(string, "prefs.getString(PREF_PHONE, \"\")");
        return string;
    }

    public final void setPhone(String str) {
        C0700j.m2715b(str, "value");
        getPrefs().edit().putString(PREF_PHONE, str).apply();
    }

    public final boolean getPinSet() {
        return getPrefs().getBoolean(PREF_PIN_SET, false);
    }

    public final void setPinSet(boolean z) {
        getPrefs().edit().putBoolean(PREF_PIN_SET, z).apply();
    }

    public final User getUser() {
        return (User) getObject(PREF_USER, User.class);
    }

    public final void setUser(User user) {
        putObject(PREF_USER, user);
    }

    public final List<SimpleAddress> getRecentAddresses() {
        return getList(PREF_RECENT_ADDRESS_SEARCHES, SimpleAddress.class);
    }

    public final void setRecentAddresses(List<SimpleAddress> list) {
        putList(PREF_RECENT_ADDRESS_SEARCHES, list, SimpleAddress.class);
    }

    public final String getPrimaryCardId() {
        Object string = getPrefs().getString(PREF_PRIMARY_CARD_ID, BuildConfig.FLAVOR);
        C0700j.m2711a(string, "prefs.getString(PREF_PRIMARY_CARD_ID, \"\")");
        return string;
    }

    public final void setPrimaryCardId(String str) {
        C0700j.m2715b(str, "value");
        getPrefs().edit().putString(PREF_PRIMARY_CARD_ID, str).apply();
    }

    public final long getFirstLaunchDate() {
        return getPrefs().getLong(PREF_FIRST_LAUNCH_DATE, 0);
    }

    public final void setFirstLaunchDate(long j) {
        getPrefs().edit().putLong(PREF_FIRST_LAUNCH_DATE, j).apply();
    }

    public final String getAvatarSignature() {
        Object string = getPrefs().getString(PREF_AVATAR_SIGNATURE, BuildConfig.FLAVOR);
        C0700j.m2711a(string, "prefs.getString(PREF_AVATAR_SIGNATURE, \"\")");
        return string;
    }

    public final void setAvatarSignature(String str) {
        C0700j.m2715b(str, "value");
        getPrefs().edit().putString(PREF_AVATAR_SIGNATURE, str).apply();
    }
}
