package ru.tinkoff.acquiring.sdk;

import android.os.Bundle;

/* compiled from: ThreeDsBundlePacker */
public class bf {
    /* renamed from: a */
    public bg m11339a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!bundle.getBoolean("isThreeDsNeed")) {
            return bg.f8460a;
        }
        String string = bundle.getString("ascUrl");
        String string2 = bundle.getString("md");
        String string3 = bundle.getString("paReq");
        if (bundle.containsKey("paymentId")) {
            return new bg(Long.valueOf(bundle.getLong("paymentId")), string, string2, string3);
        }
        return new bg(bundle.getString("requestKey"), string, string2, string3);
    }

    /* renamed from: a */
    public Bundle m11338a(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Long a = bgVar.m11340a();
        if (a != null) {
            bundle.putLong("paymentId", a.longValue());
        } else {
            bundle.putString("requestKey", bgVar.m11341b());
        }
        bundle.putString("ascUrl", bgVar.m11342c());
        bundle.putString("md", bgVar.m11343d());
        bundle.putString("paReq", bgVar.m11344e());
        bundle.putBoolean("isThreeDsNeed", bgVar.m11345f());
        return bundle;
    }
}
