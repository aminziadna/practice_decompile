package ru.gg.scooby.presenter;

import android.location.Location;
import java.util.Comparator;
import p042b.p044b.C0684b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.presenter.MapPresenter.C4180d;

/* compiled from: Comparisons.kt */
/* renamed from: ru.gg.scooby.presenter.MapPresenter$loadParkingsForCurrentBounds$1$$special$$inlined$sortBy$1 */
public final class C2669x948c2509<T> implements Comparator<T> {
    final /* synthetic */ float[] $results$inlined;
    final /* synthetic */ C4180d this$0;

    public C2669x948c2509(C4180d c4180d, float[] fArr) {
        this.this$0 = c4180d;
        this.$results$inlined = fArr;
    }

    public final int compare(T t, T t2) {
        ParkingAdvert parkingAdvert = (ParkingAdvert) t;
        double lat = parkingAdvert.getParking().getLat();
        double lng = parkingAdvert.getParking().getLng();
        t = this.this$0.f12689a.getLastLocation();
        if (t == null) {
            C0700j.m2709a();
        }
        double latitude = t.getLatitude();
        t = this.this$0.f12689a.getLastLocation();
        if (t == null) {
            C0700j.m2709a();
        }
        Location.distanceBetween(lat, lng, latitude, t.getLongitude(), this.$results$inlined);
        Comparable valueOf = Float.valueOf(this.$results$inlined[0]);
        ParkingAdvert parkingAdvert2 = (ParkingAdvert) t2;
        double lat2 = parkingAdvert2.getParking().getLat();
        double lng2 = parkingAdvert2.getParking().getLng();
        t2 = this.this$0.f12689a.getLastLocation();
        if (t2 == null) {
            C0700j.m2709a();
        }
        double latitude2 = t2.getLatitude();
        t2 = this.this$0.f12689a.getLastLocation();
        if (t2 == null) {
            C0700j.m2709a();
        }
        Location.distanceBetween(lat2, lng2, latitude2, t2.getLongitude(), this.$results$inlined);
        return C0684b.m2689a(valueOf, Float.valueOf(this.$results$inlined[0]));
    }
}
