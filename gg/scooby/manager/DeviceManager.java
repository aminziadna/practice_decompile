package ru.gg.scooby.manager;

import io.card.payment.BuildConfig;
import java.util.UUID;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.settings.DeviceSettings;

/* compiled from: DeviceManager.kt */
public final class DeviceManager {
    public static final DeviceManager INSTANCE = new DeviceManager();
    private static String deviceId;

    static {
        deviceId = BuildConfig.FLAVOR;
        deviceId = DeviceSettings.INSTANCE.getDeviceId();
    }

    private DeviceManager() {
    }

    private final void setDeviceId(String str) {
        deviceId = str;
    }

    public final String getDeviceId() {
        if ((((CharSequence) deviceId).length() == 0 ? 1 : null) != null) {
            Object uuid = UUID.randomUUID().toString();
            C0700j.m2711a(uuid, "UUID.randomUUID().toString()");
            deviceId = uuid;
            DeviceSettings.INSTANCE.setDeviceId(deviceId);
        }
        return deviceId;
    }
}
