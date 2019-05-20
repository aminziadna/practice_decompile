package ru.gg.scooby.manager;

import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.BuildConfig;
import ru.gg.scooby.model.User;
import ru.tinkoff.acquiring.sdk.C2776q;
import ru.tinkoff.acquiring.sdk.ai;

/* compiled from: AcquiringCredentialsProvider.kt */
public final class AcquiringCredentialsProvider {
    private static final C2776q CHECK_TYPE = C2776q.THREE_DS;
    public static final AcquiringCredentialsProvider INSTANCE = new AcquiringCredentialsProvider();
    public static final boolean USE_CREDENTIALS_FROM_SDK = false;

    public final String getPASSWORD() {
        return BuildConfig.TINKOFF_PASSWORD;
    }

    public final String getPUBLIC_KEY() {
        return BuildConfig.TINKOFF_PUBLIC_KEY;
    }

    public final String getTERMINAL_KEY() {
        return BuildConfig.TINKOFF_TERMINAL_KEY;
    }

    static {
        ai.m11292a(false);
    }

    private AcquiringCredentialsProvider() {
    }

    public final C2776q getCHECK_TYPE() {
        return CHECK_TYPE;
    }

    public final String getCUSTOMER_ID() {
        if (C0700j.m2713a(getTERMINAL_KEY(), (Object) "TestSDK")) {
            return "testCustomerKey1@gmail.com";
        }
        User user = UserManager.INSTANCE.getUser();
        if (user == null) {
            C0700j.m2709a();
        }
        return user.getProfile().getUuid();
    }
}
