package ru.gg.scooby.service;

import android.location.Location;
import com.google.android.gms.location.C1475d;
import com.google.android.gms.location.LocationResult;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.ApplicationHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.UserLocationRequest;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.network.ApiManager.ApiException;
import ru.gg.scooby.util.DateUtils;
import ru.gg.scooby.util.LocationUtilsKt;
import ru.gg.scooby.util.Log;

/* compiled from: ParkingService.kt */
public final class ParkingService$locationCallback$1 extends C1475d {
    final /* synthetic */ ParkingService this$0;

    /* compiled from: ParkingService.kt */
    /* renamed from: ru.gg.scooby.service.ParkingService$locationCallback$1$a */
    static final class C4615a extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ ParkingService$locationCallback$1 this$0;

        C4615a(ParkingService$locationCallback$1 parkingService$locationCallback$1) {
            this.this$0 = parkingService$locationCallback$1;
            super(1);
        }

        /* renamed from: a */
        public final void m20481a(Throwable th) {
            C0700j.m2715b(th, "it");
            if (th instanceof ApiException) {
                this.this$0.this$0.cancelLocationReportingTask();
                Log log = Log.INSTANCE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error code = ");
                ApiException apiException = (ApiException) th;
                stringBuilder.append(apiException.getCode());
                stringBuilder.append(" error = ");
                stringBuilder.append(apiException.getError());
                log.m11183d(stringBuilder.toString());
            }
            Log.e$default(Log.INSTANCE, th, false, 2, null);
        }
    }

    ParkingService$locationCallback$1(ParkingService parkingService) {
        this.this$0 = parkingService;
    }

    public void onLocationResult(LocationResult locationResult) {
        super.onLocationResult(locationResult);
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("result = ");
        stringBuilder.append(locationResult);
        log.dTrace(stringBuilder.toString());
        if (locationResult != null) {
            Location a = locationResult.m19593a();
            if (!(a == null || !LocationUtilsKt.isValidLocation(a) || ParkingManager.INSTANCE.getActiveParking() == null)) {
                ApiManager apiManager = ApiManager.INSTANCE;
                ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
                if (activeParking == null) {
                    C0700j.m2709a();
                }
                Long id = activeParking.getParking().getId();
                if (id == null) {
                    C0700j.m2709a();
                }
                long longValue = id.longValue();
                double latitude = a.getLatitude();
                double longitude = a.getLongitude();
                String toIso = DateUtils.INSTANCE.toIso(a.getTime());
                locationResult = UserManager.INSTANCE.getUser();
                if (locationResult == null) {
                    C0700j.m2709a();
                }
                Object a2 = apiManager.sendBuyerLocation(new UserLocationRequest(longValue, toIso, latitude, longitude, locationResult.getProfile().getUuid())).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a2, "ApiManager.sendBuyerLoca…dSchedulers.mainThread())");
                C2517a.m10349a(a2, (C0690b) new C4615a(this), null, null, 6, null);
            }
        }
        if (ApplicationHelper.INSTANCE.isAppInForeground() == null) {
            this.this$0.removeLocationUpdates();
            this.this$0.scheduleLocationReportingTask();
        }
        this.this$0.releaseBackgroundLocationWakelock();
    }
}
