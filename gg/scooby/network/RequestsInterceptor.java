package ru.gg.scooby.network;

import okhttp3.C2651u;
import okhttp3.C2651u.C2650a;
import okhttp3.ac;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.AppUtils;

/* compiled from: RequestsInterceptor.kt */
public final class RequestsInterceptor implements C2651u {
    public ac intercept(C2650a c2650a) {
        C0700j.m2715b(c2650a, "chain");
        Object a = c2650a.mo1829a(c2650a.mo1828a().m10545e().m10539b("platform", "android").m10539b("version", AppUtils.INSTANCE.getVersionName()).m10537a());
        C0700j.m2711a(a, "chain.proceed(request)");
        return a;
    }
}
