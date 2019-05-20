package ru.gg.scooby.network;

import okhttp3.C2651u;
import okhttp3.C2651u.C2650a;
import okhttp3.ac;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.network.ApiManager.ApiException;

/* compiled from: ErrorInterceptor.kt */
public final class ErrorInterceptor implements C2651u {

    /* compiled from: ErrorInterceptor.kt */
    public static final class ReAuthRequiredEvent {
        public static final ReAuthRequiredEvent INSTANCE = new ReAuthRequiredEvent();

        private ReAuthRequiredEvent() {
        }
    }

    /* compiled from: ErrorInterceptor.kt */
    public static final class UpdateRequiredEvent {
        public static final UpdateRequiredEvent INSTANCE = new UpdateRequiredEvent();

        private UpdateRequiredEvent() {
        }
    }

    public ac intercept(C2650a c2650a) {
        C0700j.m2715b(c2650a, "chain");
        Object a = c2650a.mo1829a(c2650a.mo1828a());
        int b = a.m10576b();
        if (b != 426) {
            if (b == 401 && UserManager.INSTANCE.getUser() != null) {
                if (UserManager.INSTANCE.getPinSet()) {
                    UserManager.INSTANCE.setLoggedIn(false);
                    Bus.INSTANCE.send(ReAuthRequiredEvent.INSTANCE);
                    throw ((Throwable) new ApiException(b, null, 2, null));
                }
            }
            C0700j.m2711a(a, "response");
            return a;
        }
        Bus.INSTANCE.send(UpdateRequiredEvent.INSTANCE);
        throw ((Throwable) new ApiException(b, null, 2, null));
    }
}
