package ru.gg.scooby.manager;

import io.p181b.C2518g;
import io.p181b.C4006c;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p187d.C2480b;
import io.p181b.p187d.C2482d;
import io.p181b.p187d.C2483e;
import io.p181b.p187d.C2485g;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.concurrent.TimeUnit;
import p042b.C0727n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.ApplicationHelper.ApplicationStartEvent;
import ru.gg.scooby.Bus;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.manager.UserManager.UserLoggedOutEvent;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.DealCompleteStatus;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingStatus;
import ru.gg.scooby.model.UserLocationResponse;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.service.ParkingService;
import ru.gg.scooby.service.ParkingService.Companion;
import ru.gg.scooby.util.Log;

/* compiled from: ParkingManager.kt */
public final class ParkingManager {
    public static final ParkingManager INSTANCE;
    public static final long LOCATION_UPDATES_INTERVAL = 5;
    public static final long PARKING_STATUS_UPDATE_INTERVAL = 10;
    private static ParkingAdvert activeParking;
    private static Integer advType;
    private static ParkingAdvert lastKnownParking;
    private static AdvStatus lastNotifiedStatus;
    private static ParkingAdvert parkingBeforeAppClosed;

    /* compiled from: ParkingManager.kt */
    public interface ParkingEvent {
    }

    /* compiled from: ParkingManager.kt */
    public static final class StatusDisposable {
        private final C2468b disposable;
        private final int initialStatus;

        public StatusDisposable(C2468b c2468b, int i) {
            C0700j.m2715b(c2468b, "disposable");
            this.disposable = c2468b;
            this.initialStatus = i;
        }

        public final C2468b getDisposable() {
            return this.disposable;
        }

        public final int getInitialStatus() {
            return this.initialStatus;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class BuyerFoundEvent implements ParkingEvent {
        public static final BuyerFoundEvent INSTANCE = new BuyerFoundEvent();

        private BuyerFoundEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class BuyerLocationUpdatedEvent implements ParkingEvent {
        private final double latitude;
        private final double longitude;

        public BuyerLocationUpdatedEvent(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class DeleteParkingEvent implements ParkingEvent {
        private final ParkingAdvert parking;

        public DeleteParkingEvent(ParkingAdvert parkingAdvert) {
            C0700j.m2715b(parkingAdvert, "parking");
            this.parking = parkingAdvert;
        }

        public final ParkingAdvert getParking() {
            return this.parking;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class DisputeEvent implements ParkingEvent {
        private final ParkingStatus parkingStatus;
        private final int type;

        public DisputeEvent(int i, ParkingStatus parkingStatus) {
            C0700j.m2715b(parkingStatus, "parkingStatus");
            this.type = i;
            this.parkingStatus = parkingStatus;
        }

        public final ParkingStatus getParkingStatus() {
            return this.parkingStatus;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingActive implements ParkingEvent {
        public static final ParkingActive INSTANCE = new ParkingActive();

        private ParkingActive() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingDisabledEvent implements ParkingEvent {
        public static final ParkingDisabledEvent INSTANCE = new ParkingDisabledEvent();

        private ParkingDisabledEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingFreeEvent implements ParkingEvent {
        public static final ParkingFreeEvent INSTANCE = new ParkingFreeEvent();

        private ParkingFreeEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingInactive implements ParkingEvent {
        public static final ParkingInactive INSTANCE = new ParkingInactive();

        private ParkingInactive() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingPaidEvent implements ParkingEvent {
        public static final ParkingPaidEvent INSTANCE = new ParkingPaidEvent();

        private ParkingPaidEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingReservedEvent implements ParkingEvent {
        public static final ParkingReservedEvent INSTANCE = new ParkingReservedEvent();

        private ParkingReservedEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class ParkingUpdated implements ParkingEvent {
        public static final ParkingUpdated INSTANCE = new ParkingUpdated();

        private ParkingUpdated() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class PublishParkingEvent implements ParkingEvent {
        private final ParkingAdvert parking;

        public PublishParkingEvent(ParkingAdvert parkingAdvert) {
            C0700j.m2715b(parkingAdvert, "parking");
            this.parking = parkingAdvert;
        }

        public final ParkingAdvert getParking() {
            return this.parking;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class TripCanceledEvent implements ParkingEvent {
        private final ParkingStatus parkingStatus;
        private final int type;

        public TripCanceledEvent(int i, ParkingStatus parkingStatus) {
            C0700j.m2715b(parkingStatus, "parkingStatus");
            this.type = i;
            this.parkingStatus = parkingStatus;
        }

        public final ParkingStatus getParkingStatus() {
            return this.parkingStatus;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class TripSuccessEvent implements ParkingEvent {
        private final long price;
        private final int type;

        public TripSuccessEvent(int i, long j) {
            this.type = i;
            this.price = j;
        }

        public final long getPrice() {
            return this.price;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class UpdateParkingEvent implements ParkingEvent {
        private final ParkingAdvert parking;

        public UpdateParkingEvent(ParkingAdvert parkingAdvert) {
            C0700j.m2715b(parkingAdvert, "parking");
            this.parking = parkingAdvert;
        }

        public final ParkingAdvert getParking() {
            return this.parking;
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class WaitingBuyerPayEvent implements ParkingEvent {
        public static final WaitingBuyerPayEvent INSTANCE = new WaitingBuyerPayEvent();

        private WaitingBuyerPayEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class WaitingConfirmFromMeEvent implements ParkingEvent {
        public static final WaitingConfirmFromMeEvent INSTANCE = new WaitingConfirmFromMeEvent();

        private WaitingConfirmFromMeEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    public static final class WaitingConfirmFromOtherSideEvent implements ParkingEvent {
        public static final WaitingConfirmFromOtherSideEvent INSTANCE = new WaitingConfirmFromOtherSideEvent();

        private WaitingConfirmFromOtherSideEvent() {
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$b */
    static final class C4149b<T, R> implements C2483e<T, C2518g<? extends U>> {
        /* renamed from: a */
        final /* synthetic */ Integer f12655a;
        /* renamed from: b */
        final /* synthetic */ boolean f12656b;

        C4149b(Integer num, boolean z) {
            this.f12655a = num;
            this.f12656b = z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final io.p181b.C4050f<? extends java.lang.Object> m18102a(p165d.C2342r<ru.gg.scooby.model.ParkingStatus> r5) {
            /*
            r4 = this;
            r0 = "response";
            p042b.p047e.p049b.C0700j.m2715b(r5, r0);
            r0 = r5.m9826c();
            if (r0 == 0) goto L_0x00a7;
        L_0x000b:
            r0 = r5.m9827d();
            if (r0 == 0) goto L_0x00a7;
        L_0x0011:
            r5 = r5.m9827d();
            r5 = (ru.gg.scooby.model.ParkingStatus) r5;
            r0 = ru.gg.scooby.util.Log.INSTANCE;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "currentStatus = ";
            r1.append(r2);
            r2 = r4.f12655a;
            r1.append(r2);
            r2 = "  activeParking?.parking?.status = ";
            r1.append(r2);
            r2 = ru.gg.scooby.manager.ParkingManager.INSTANCE;
            r2 = r2.getActiveParking();
            r3 = 0;
            if (r2 == 0) goto L_0x0045;
        L_0x0036:
            r2 = r2.getParking();
            if (r2 == 0) goto L_0x0045;
        L_0x003c:
            r2 = r2.getStatus();
            r2 = java.lang.Integer.valueOf(r2);
            goto L_0x0046;
        L_0x0045:
            r2 = r3;
        L_0x0046:
            r1.append(r2);
            r2 = " statusResponse = ";
            r1.append(r2);
            if (r5 == 0) goto L_0x0059;
        L_0x0050:
            r2 = r5.getStatus();
            r2 = java.lang.Integer.valueOf(r2);
            goto L_0x005a;
        L_0x0059:
            r2 = r3;
        L_0x005a:
            r1.append(r2);
            r1 = r1.toString();
            r0.m11183d(r1);
            r0 = r4.f12655a;
            r1 = 1;
            if (r0 == 0) goto L_0x00a0;
        L_0x0069:
            r2 = r4.f12656b;
            if (r2 == 0) goto L_0x00a0;
        L_0x006d:
            r2 = ru.gg.scooby.manager.ParkingManager.INSTANCE;
            r2 = r2.getActiveParking();
            if (r2 == 0) goto L_0x0084;
        L_0x0075:
            r2 = r2.getParking();
            if (r2 == 0) goto L_0x0084;
        L_0x007b:
            r2 = r2.getStatus();
            r2 = java.lang.Integer.valueOf(r2);
            goto L_0x0085;
        L_0x0084:
            r2 = r3;
        L_0x0085:
            r0 = p042b.p047e.p049b.C0700j.m2713a(r0, r2);
            if (r0 == 0) goto L_0x00a7;
        L_0x008b:
            if (r5 == 0) goto L_0x0096;
        L_0x008d:
            r5 = r5.getStatus();
            r5 = java.lang.Integer.valueOf(r5);
            goto L_0x0097;
        L_0x0096:
            r5 = r3;
        L_0x0097:
            r0 = r4.f12655a;
            r5 = p042b.p047e.p049b.C0700j.m2713a(r5, r0);
            r5 = r5 ^ r1;
            if (r5 == 0) goto L_0x00a7;
        L_0x00a0:
            r5 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r5 = ru.gg.scooby.network.ApiManager.getUser$default(r5, r3, r1, r3);
            return r5;
        L_0x00a7:
            r5 = 0;
            r5 = java.lang.Boolean.valueOf(r5);
            r5 = io.p181b.C4050f.m17704a(r5);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.manager.ParkingManager.b.a(d.r):io.b.f<? extends java.lang.Object>");
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$c */
    static final class C4150c<T1, T2, R> implements C2480b<T, U, R> {
        /* renamed from: a */
        public static final C4150c f12657a = new C4150c();

        C4150c() {
        }

        /* renamed from: a */
        public final C2342r<ParkingStatus> m18104a(C2342r<ParkingStatus> c2342r, Object obj) {
            C0700j.m2715b(c2342r, "t1");
            C0700j.m2715b(obj, "t2");
            return c2342r;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$d */
    static final class C4151d<T> implements C2485g<C2342r<ParkingStatus>> {
        /* renamed from: a */
        final /* synthetic */ Integer f12658a;
        /* renamed from: b */
        final /* synthetic */ boolean f12659b;

        C4151d(Integer num, boolean z) {
            this.f12658a = num;
            this.f12659b = z;
        }

        /* renamed from: a */
        public final boolean m18106a(C2342r<ParkingStatus> c2342r) {
            C0700j.m2715b(c2342r, "it");
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("filter it.body = ");
            ParkingStatus parkingStatus = (ParkingStatus) c2342r.m9827d();
            Object obj = null;
            stringBuilder.append(parkingStatus != null ? Integer.valueOf(parkingStatus.getStatus()) : null);
            stringBuilder.append(" currentStatus = ");
            stringBuilder.append(this.f12658a);
            stringBuilder.append(" waitStatusChange = ");
            stringBuilder.append(this.f12659b);
            log.m11183d(stringBuilder.toString());
            if (c2342r.m9827d() != null) {
                ParkingStatus parkingStatus2 = (ParkingStatus) c2342r.m9827d();
                if (parkingStatus2 != null) {
                    obj = Integer.valueOf(parkingStatus2.getStatus());
                }
                if ((C0700j.m2713a(obj, this.f12658a) ^ 1) != null) {
                    return true;
                }
                if (this.f12659b == null) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$e */
    static final class C4152e<T> implements C2482d<C2342r<ParkingStatus>> {
        /* renamed from: a */
        final /* synthetic */ Integer f12660a;
        /* renamed from: b */
        final /* synthetic */ C0689a f12661b;

        C4152e(Integer num, C0689a c0689a) {
            this.f12660a = num;
            this.f12661b = c0689a;
        }

        /* renamed from: a */
        public final void m18108a(C2342r<ParkingStatus> c2342r) {
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Order status changed lastNotifiedStatus = ");
            stringBuilder.append(ParkingManager.INSTANCE.getLastNotifiedStatus());
            stringBuilder.append(' ');
            log.m11183d(stringBuilder.toString());
            Object obj = (ParkingStatus) c2342r.m9827d();
            if (obj != null) {
                Object byCode;
                C0700j.m2711a(obj, "it.body() ?: return@subscribe");
                c2342r = Log.INSTANCE;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Order status changed. New status = ");
                stringBuilder2.append(obj.getStatusEnum());
                stringBuilder2.append(" currentStatus = ");
                Integer num = this.f12660a;
                if (num != null) {
                    byCode = AdvStatus.Companion.byCode(num.intValue());
                } else {
                    byCode = null;
                }
                stringBuilder2.append(byCode);
                c2342r.m11183d(stringBuilder2.toString());
                this.f12661b.mo2120a();
                if (ParkingManager.INSTANCE.getLastNotifiedStatus() != obj.getStatusEnum()) {
                    AdvStatus advStatus;
                    ParkingManager.INSTANCE.setLastNotifiedStatus(obj.getStatusEnum());
                    ParkingManager parkingManager = ParkingManager.INSTANCE;
                    c2342r = this.f12660a;
                    if (c2342r != null) {
                        c2342r = AdvStatus.Companion.byCode(((Number) c2342r).intValue());
                        if (c2342r != null) {
                            advStatus = c2342r;
                            ParkingManager.sendEventForStatus$default(parkingManager, obj, advStatus, null, 4, null);
                        }
                    }
                    advStatus = AdvStatus.ADV_UNKNOWN;
                    ParkingManager.sendEventForStatus$default(parkingManager, obj, advStatus, null, 4, null);
                }
            }
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$f */
    static final class C4153f<T> implements C2482d<Throwable> {
        /* renamed from: a */
        public static final C4153f f12662a = new C4153f();

        C4153f() {
        }

        /* renamed from: a */
        public final void m18111a(Throwable th) {
            Log log = Log.INSTANCE;
            C0700j.m2711a((Object) th, "it");
            log.m11189e(th, false);
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$j */
    static final class C4154j<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4154j f12663a = new C4154j();

        C4154j() {
        }

        /* renamed from: a */
        public final C4050f<C2342r<UserLocationResponse>> m18112a(Long l) {
            C0700j.m2715b(l, "it");
            l = ParkingManager.INSTANCE.getActiveParking();
            if (l != null) {
                l = l.getParking();
                if (l != null) {
                    l = l.getId();
                    if (l != null) {
                        return ApiManager.INSTANCE.getBuyerLocation(l.longValue()).m17729b(C2527a.m10359b());
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$m */
    static final class C4155m<T> implements C2485g<Long> {
        /* renamed from: a */
        final /* synthetic */ int f12664a;

        C4155m(int i) {
            this.f12664a = i;
        }

        /* renamed from: a */
        public final boolean m18114a(Long l) {
            C0700j.m2715b(l, "it");
            l = this.f12664a;
            ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
            if (activeParking != null) {
                Parking parking = activeParking.getParking();
                if (parking != null && l == parking.getStatus()) {
                    return true;
                }
            }
            return null;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$n */
    static final class C4156n<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4156n f12665a = new C4156n();

        C4156n() {
        }

        /* renamed from: a */
        public final C4050f<C2342r<ParkingStatus>> m18116a(Long l) {
            C0700j.m2715b(l, "it");
            l = ParkingManager.INSTANCE.getActiveParking();
            if (l != null) {
                l = l.getParking();
                if (l != null) {
                    l = l.getId();
                    if (l != null) {
                        return ApiManager.INSTANCE.getParkingById(l.longValue());
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$a */
    static final class C4599a extends C3038k implements C0689a<C0727n> {
        /* renamed from: a */
        public static final C4599a f14112a = new C4599a();

        C4599a() {
            super(0);
        }

        /* renamed from: b */
        public final void m20449b() {
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20449b();
            return C0727n.f2066a;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$g */
    static final class C4600g extends C3038k implements C0689a<C0727n> {
        /* renamed from: a */
        public static final C4600g f14113a = new C4600g();

        C4600g() {
            super(0);
        }

        /* renamed from: b */
        public final void m20451b() {
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20451b();
            return C0727n.f2066a;
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$h */
    static final class C4601h extends C3038k implements C0690b<C2342r<ParkingStatus>, C0727n> {
        /* renamed from: a */
        public static final C4601h f14114a = new C4601h();

        C4601h() {
            super(1);
        }

        /* renamed from: a */
        public final void m20453a(C2342r<ParkingStatus> c2342r) {
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                Object obj = (ParkingStatus) c2342r.m9827d();
                if (obj != null) {
                    C0700j.m2711a(obj, "it.body() ?: return@subscribeBy");
                    if (obj.getStatusEnum().getFinal() != null) {
                        ParkingManager.sendEventForStatus$default(ParkingManager.INSTANCE, obj, null, ParkingManager.INSTANCE.getParkingBeforeAppClosed(), 2, null);
                    }
                    ParkingManager.INSTANCE.setParkingBeforeAppClosed((ParkingAdvert) null);
                }
            }
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$i */
    static final class C4602i extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4602i f14115a = new C4602i();

        C4602i() {
            super(1);
        }

        /* renamed from: a */
        public final void m20455a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.e$default(Log.INSTANCE, th, false, 2, null);
            ParkingManager.INSTANCE.setParkingBeforeAppClosed((ParkingAdvert) null);
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$k */
    static final class C4603k extends C3038k implements C0690b<C2342r<UserLocationResponse>, C0727n> {
        /* renamed from: a */
        public static final C4603k f14116a = new C4603k();

        C4603k() {
            super(1);
        }

        /* renamed from: a */
        public final void m20457a(C2342r<UserLocationResponse> c2342r) {
            if (c2342r.m9824a() == 200) {
                UserLocationResponse userLocationResponse = (UserLocationResponse) c2342r.m9827d();
                if (userLocationResponse != null) {
                    Bus.INSTANCE.send(new BuyerLocationUpdatedEvent(userLocationResponse.getLatitude(), userLocationResponse.getLongitude()));
                }
            }
        }
    }

    /* compiled from: ParkingManager.kt */
    /* renamed from: ru.gg.scooby.manager.ParkingManager$l */
    static final class C4604l extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4604l f14117a = new C4604l();

        C4604l() {
            super(1);
        }

        /* renamed from: a */
        public final void m20459a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.INSTANCE.m11189e(th, false);
        }
    }

    static {
        ParkingManager parkingManager = new ParkingManager();
        INSTANCE = parkingManager;
        Bus.INSTANCE.register(parkingManager);
    }

    private ParkingManager() {
    }

    public final ParkingAdvert getLastKnownParking() {
        return lastKnownParking;
    }

    public final void setLastKnownParking(ParkingAdvert parkingAdvert) {
        lastKnownParking = parkingAdvert;
    }

    public final AdvStatus getLastNotifiedStatus() {
        return lastNotifiedStatus;
    }

    public final void setLastNotifiedStatus(AdvStatus advStatus) {
        lastNotifiedStatus = advStatus;
    }

    public final ParkingAdvert getParkingBeforeAppClosed() {
        return parkingBeforeAppClosed;
    }

    public final void setParkingBeforeAppClosed(ParkingAdvert parkingAdvert) {
        parkingBeforeAppClosed = parkingAdvert;
    }

    public final ParkingAdvert getActiveParking() {
        return activeParking;
    }

    private final void setActiveParking(ParkingAdvert parkingAdvert) {
        if (activeParking == null && parkingAdvert != null && parkingAdvert.getParking().getStatus() >= AdvStatus.ADV_FREE.getCode()) {
            activeParking = parkingAdvert;
            Bus.INSTANCE.send(ParkingActive.INSTANCE);
        } else if (activeParking == null || parkingAdvert != null) {
            activeParking = parkingAdvert;
        } else {
            activeParking = parkingAdvert;
            Bus.INSTANCE.send(ParkingInactive.INSTANCE);
        }
        Bus.INSTANCE.send(ParkingUpdated.INSTANCE);
    }

    public final void setAdvType(Integer num) {
        advType = num;
    }

    public final Integer getAdvType() {
        ParkingAdvert parkingAdvert = lastKnownParking;
        return parkingAdvert != null ? Integer.valueOf(parkingAdvert.getType()) : null;
    }

    public final void onParkingLoaded(ParkingAdvert parkingAdvert) {
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parking = ");
        stringBuilder.append(parkingAdvert);
        log.dTrace(stringBuilder.toString());
        setActiveParking(parkingAdvert);
        parkingAdvert = activeParking;
        if (parkingAdvert != null) {
            lastKnownParking = parkingAdvert;
        }
    }

    public final void onCachedParkingLoaded(ParkingAdvert parkingAdvert) {
        parkingBeforeAppClosed = parkingAdvert;
    }

    public final void retrieveCachedParkingStateAndNotify() {
        ParkingAdvert parkingAdvert = parkingBeforeAppClosed;
        if (parkingAdvert != null) {
            Parking parking = parkingAdvert.getParking();
            if (parking != null && !parking.getStatusEnum().getFinal()) {
                ApiManager apiManager = ApiManager.INSTANCE;
                Long id = parking.getId();
                if (id == null) {
                    C0700j.m2709a();
                }
                Object a = apiManager.getParkingById(id.longValue()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a, "ApiManager.getParkingByI…dSchedulers.mainThread())");
                C2517a.m10349a(a, C4602i.f14115a, null, C4601h.f14114a, 2, null);
            }
        }
    }

    public final void publishParking() {
        ParkingAdvert parkingAdvert = activeParking;
        if (parkingAdvert != null) {
            Bus.INSTANCE.send(new PublishParkingEvent(parkingAdvert));
        }
    }

    public final void updateParking() {
        ParkingAdvert parkingAdvert = activeParking;
        if (parkingAdvert != null) {
            Bus.INSTANCE.send(new UpdateParkingEvent(parkingAdvert));
        }
    }

    public final void deleteParking() {
        Bus bus = Bus.INSTANCE;
        ParkingAdvert parkingAdvert = activeParking;
        if (parkingAdvert == null) {
            C0700j.m2709a();
        }
        bus.send(new DeleteParkingEvent(parkingAdvert));
        setActiveParking((ParkingAdvert) null);
    }

    public final StatusDisposable startListenParkingStatus() {
        ParkingAdvert parkingAdvert = activeParking;
        if (parkingAdvert == null) {
            C0700j.m2709a();
        }
        int status = parkingAdvert.getParking().getStatus();
        Object a = C4006c.m17555a(10, TimeUnit.SECONDS).m17563b(Long.valueOf(0)).m17560a((C2485g) new C4155m(status)).m17566d().m17568f().m17716a((C2483e) C4156n.f12665a);
        C0700j.m2711a(a, "Flowable.interval(PARKIN…      }\n                }");
        return new StatusDisposable(handleStatusUpdate$default(this, a, false, Integer.valueOf(status), null, 5, null), status);
    }

    public final C2468b startListenLocationUpdates() {
        Object a = C4006c.m17555a(5, TimeUnit.SECONDS).m17563b(Long.valueOf(0)).m17566d().m17568f().m17729b(C2527a.m10359b()).m17716a((C2483e) C4154j.f12663a).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "Flowable.interval(LOCATI…dSchedulers.mainThread())");
        return C2517a.m10349a(a, C4604l.f14117a, null, C4603k.f14116a, 2, null);
    }

    public static /* synthetic */ C2468b handleStatusUpdate$default(ParkingManager parkingManager, C4050f c4050f, boolean z, Integer num, C0689a c0689a, int i, Object obj) {
        if ((i & 1) != null) {
            z = true;
        }
        if ((i & 2) != null) {
            num = null;
        }
        if ((i & 4) != 0) {
            c0689a = C4599a.f14112a;
        }
        return parkingManager.handleStatusUpdate(c4050f, z, num, c0689a);
    }

    public final C2468b handleStatusUpdate(C4050f<C2342r<ParkingStatus>> c4050f, boolean z, Integer num, C0689a<C0727n> c0689a) {
        C0700j.m2715b(c4050f, "receiver$0");
        C0700j.m2715b(c0689a, "orderChangedCallback");
        Object a = c4050f.m17717a((C2483e) new C4149b(num, z), (C2480b) C4150c.f12657a).m17722a((C2485g) new C4151d(num, z)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17726b(1).m17708a((C2482d) new C4152e(num, c0689a), (C2482d) C4153f.f12662a);
        C0700j.m2711a(a, "flatMap({ response: Resp…false)\n                })");
        return a;
    }

    public static /* synthetic */ void sendEventForStatus$default(ParkingManager parkingManager, ParkingStatus parkingStatus, AdvStatus advStatus, ParkingAdvert parkingAdvert, int i, Object obj) {
        if ((i & 2) != null) {
            advStatus = AdvStatus.ADV_UNKNOWN;
        }
        if ((i & 4) != 0) {
            parkingAdvert = lastKnownParking;
        }
        parkingManager.sendEventForStatus(parkingStatus, advStatus, parkingAdvert);
    }

    public final void sendEventForStatus(ParkingStatus parkingStatus, AdvStatus advStatus, ParkingAdvert parkingAdvert) {
        C0700j.m2715b(parkingStatus, "parkingStatus");
        C0700j.m2715b(advStatus, "currentStatus");
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("currentStatus = ");
        stringBuilder.append(advStatus);
        stringBuilder.append(" newStatus = ");
        stringBuilder.append(parkingStatus.getStatusEnum());
        stringBuilder.append(" activeParking = ");
        stringBuilder.append(activeParking);
        log.dTrace(stringBuilder.toString());
        switch (parkingStatus.getStatusEnum()) {
            case ADV_FREE:
                Bus.INSTANCE.send(ParkingFreeEvent.INSTANCE);
                return;
            case ADV_DISABLED:
                Bus.INSTANCE.send(ParkingDisabledEvent.INSTANCE);
                return;
            case ADV_RESERVED:
                parkingStatus = activeParking;
                if (parkingStatus == null || parkingStatus.getType() != 1) {
                    Bus.INSTANCE.send(ParkingReservedEvent.INSTANCE);
                    return;
                }
                Bus.INSTANCE.send(BuyerFoundEvent.INSTANCE);
                Bus.INSTANCE.send(WaitingBuyerPayEvent.INSTANCE);
                return;
            case ADV_PAID:
                if (advStatus == AdvStatus.ADV_FREE) {
                    Bus.INSTANCE.send(BuyerFoundEvent.INSTANCE);
                }
                Bus.INSTANCE.send(ParkingPaidEvent.INSTANCE);
                return;
            case ADV_DEAL_DECLINED:
                if (parkingAdvert != null) {
                    Bus.INSTANCE.send(new TripCanceledEvent(parkingAdvert.getType(), parkingStatus));
                    return;
                }
                return;
            case ADV_WAIT_CONFIRM_BUYER:
                parkingStatus = getAdvType();
                if (parkingStatus != null) {
                    if (parkingStatus.intValue() == 1) {
                        Bus.INSTANCE.send(WaitingConfirmFromOtherSideEvent.INSTANCE);
                        return;
                    }
                }
                if (parkingStatus != null) {
                    if (parkingStatus.intValue() == null) {
                        Bus.INSTANCE.send(WaitingConfirmFromMeEvent.INSTANCE);
                        return;
                    }
                    return;
                }
                return;
            case ADV_WAIT_CONFIRM_SELLER:
                advStatus = getAdvType();
                if (advStatus != null) {
                    if (advStatus.intValue() == 1) {
                        Bus.INSTANCE.send(WaitingConfirmFromMeEvent.INSTANCE);
                        return;
                    }
                }
                if (advStatus != null) {
                    if (advStatus.intValue() != null) {
                        return;
                    }
                    if (parkingStatus.getDealCompleteBuyer() == DealCompleteStatus.CANCELED) {
                        parkingAdvert = getAdvType();
                        if (parkingAdvert == null) {
                            C0700j.m2709a();
                        }
                        advStatus = new TripCanceledEvent(parkingAdvert.intValue(), parkingStatus);
                        return;
                    }
                    Bus.INSTANCE.send(WaitingConfirmFromOtherSideEvent.INSTANCE);
                    return;
                }
                return;
            case ADV_DISPUTE:
                setActiveParking((ParkingAdvert) null);
                advStatus = getAdvType();
                if (advStatus != null) {
                    Bus.INSTANCE.send(new DisputeEvent(((Number) advStatus).intValue(), parkingStatus));
                    return;
                }
                return;
            case ADV_DEAL_COMPLETE:
                if (parkingAdvert != null) {
                    Bus.INSTANCE.send(new TripSuccessEvent(parkingAdvert.getType(), parkingAdvert.getParking().getPrice()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static /* synthetic */ void refreshParkingStatus$default(ParkingManager parkingManager, boolean z, C0689a c0689a, int i, Object obj) {
        if ((i & 1) != null) {
            z = true;
        }
        if ((i & 2) != 0) {
            c0689a = C4600g.f14113a;
        }
        parkingManager.refreshParkingStatus(z, c0689a);
    }

    public final void refreshParkingStatus(boolean z, C0689a<C0727n> c0689a) {
        C0700j.m2715b(c0689a, "orderChangedCallback");
        ParkingAdvert parkingAdvert = activeParking;
        if ((parkingAdvert != null ? parkingAdvert.getParking() : null) != null) {
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("waitStatusChange = ");
            stringBuilder.append(z);
            log.dTrace(stringBuilder.toString());
            parkingAdvert = activeParking;
            if (parkingAdvert == null) {
                C0700j.m2709a();
            }
            int status = parkingAdvert.getParking().getStatus();
            ApiManager apiManager = ApiManager.INSTANCE;
            ParkingAdvert parkingAdvert2 = activeParking;
            if (parkingAdvert2 == null) {
                C0700j.m2709a();
            }
            Long id = parkingAdvert2.getParking().getId();
            if (id == null) {
                C0700j.m2709a();
            }
            handleStatusUpdate(apiManager.getParkingById(id.longValue()), z, Integer.valueOf(status), c0689a);
        }
    }

    public final void onEvent(UserLoggedOutEvent userLoggedOutEvent) {
        C0700j.m2715b(userLoggedOutEvent, "event");
        setActiveParking((ParkingAdvert) null);
    }

    public final void onEvent(ParkingActive parkingActive) {
        C0700j.m2715b(parkingActive, "event");
        Companion.startService$default(ParkingService.Companion, ContextProvider.INSTANCE.getContext(), null, 2, null);
    }

    public final void onEvent(ParkingInactive parkingInactive) {
        C0700j.m2715b(parkingInactive, "event");
        ParkingService.Companion.stopService(ContextProvider.INSTANCE.getContext());
    }

    public final void onEvent(ApplicationStartEvent applicationStartEvent) {
        C0700j.m2715b(applicationStartEvent, "event");
        if (activeParking != null) {
            refreshParkingStatus$default(INSTANCE, false, null, 3, null);
        }
    }
}
