package ru.gg.scooby.presenter;

import com.mapbox.android.p149a.p150a.C1743d;
import com.mapbox.android.p149a.p150a.C1749i;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p049b.C0700j;

/* compiled from: MapPresenter.kt */
public final class MapPresenter$getLastLocation$2 implements C1743d<C1749i> {
    final /* synthetic */ C0689a $onSuccess;
    final /* synthetic */ MapPresenter this$0;

    public void onFailure(Exception exception) {
        C0700j.m2715b(exception, "exception");
    }

    MapPresenter$getLastLocation$2(MapPresenter mapPresenter, C0689a c0689a) {
        this.this$0 = mapPresenter;
        this.$onSuccess = c0689a;
    }

    public void onSuccess(C1749i c1749i) {
        this.this$0.setLastLocation(c1749i != null ? c1749i.m6506a() : null);
        this.$onSuccess.mo2120a();
    }
}
