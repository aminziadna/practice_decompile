package ru.gg.scooby.helper;

import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.changehandler.MapVerticalChangeHandler;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.controller.BuyCanceledController;
import ru.gg.scooby.ui.controller.ControllerExKt;
import ru.gg.scooby.ui.controller.SellCanceledController;
import ru.gg.scooby.ui.input.validator.ValidationCode;

/* compiled from: TripFinishHelper.kt */
public final class TripFinishHelper {
    private final C0809d controller;

    /* compiled from: TripFinishHelper.kt */
    /* renamed from: ru.gg.scooby.helper.TripFinishHelper$a */
    static final class C4596a extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ TripFinishHelper this$0;

        C4596a(TripFinishHelper tripFinishHelper) {
            this.this$0 = tripFinishHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20443a(C2342r<Void> c2342r) {
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                ParkingManager.refreshParkingStatus$default(ParkingManager.INSTANCE, false, new C0689a<C0727n>() {
                    /* renamed from: a */
                    public /* synthetic */ Object mo2120a() {
                        m20441b();
                        return C0727n.f2066a;
                    }

                    /* renamed from: b */
                    public final void m20441b() {
                        ControllerExKt.hideProgress$default(this.this$0.getController(), null, 1, null);
                    }
                }, 1, null);
                return;
            }
            ControllerExKt.hideProgress$default(this.this$0.getController(), null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0.getController(), ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: TripFinishHelper.kt */
    /* renamed from: ru.gg.scooby.helper.TripFinishHelper$b */
    static final class C4597b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ TripFinishHelper this$0;

        C4597b(TripFinishHelper tripFinishHelper) {
            this.this$0 = tripFinishHelper;
            super(1);
        }

        /* renamed from: a */
        public final void m20445a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0.getController(), null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0.getController(), ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public TripFinishHelper(C0809d c0809d) {
        C0700j.m2715b(c0809d, "controller");
        this.controller = c0809d;
    }

    public final C0809d getController() {
        return this.controller;
    }

    public final void finishTrip() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null) {
                Long id = parking.getId();
                if (id != null) {
                    long longValue = id.longValue();
                    ControllerExKt.showProgress$default(this.controller, null, 1, null);
                    Analytics analytics = Analytics.INSTANCE;
                    ParkingAdvert activeParking2 = ParkingManager.INSTANCE.getActiveParking();
                    if (activeParking2 == null) {
                        C0700j.m2709a();
                    }
                    Parking parking2 = activeParking2.getParking();
                    ParkingAdvert activeParking3 = ParkingManager.INSTANCE.getActiveParking();
                    if (activeParking3 == null) {
                        C0700j.m2709a();
                    }
                    analytics.finishTrip(parking2, activeParking3.getType());
                    Object a = ApiManager.INSTANCE.finishParking(longValue).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                    C0700j.m2711a(a, "ApiManager.finishParking…dSchedulers.mainThread())");
                    C2517a.m10349a(a, new C4597b(this), null, new C4596a(this), 2, null);
                }
            }
        }
    }

    public final void cancelTrip() {
        BaseController buyCanceledController;
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking == null || activeParking.getType() != 1) {
            buyCanceledController = new BuyCanceledController();
        } else {
            buyCanceledController = new SellCanceledController();
        }
        C0809d parentController = this.controller.getParentController();
        if (parentController != null) {
            C0818i router = parentController.getRouter();
            if (router != null) {
                router.m3151b(C0820k.m3183a((C0809d) buyCanceledController).m3189b(new MapVerticalChangeHandler()).m3184a((C0814e) new MapVerticalChangeHandler()));
            }
        }
    }
}
