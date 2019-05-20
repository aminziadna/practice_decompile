package ru.gg.scooby.analytics;

import java.util.HashMap;
import java.util.Map;
import p042b.C0715h;
import p042b.C0723j;
import p042b.p043a.ac;
import p042b.p043a.ad;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ApplicationHelper.ApplicationStartEvent;
import ru.gg.scooby.ApplicationHelper.ApplicationStopEvent;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.CancelReason;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.util.DateUtils;

/* compiled from: Analytics.kt */
public final class Analytics {
    public static final Analytics INSTANCE = new Analytics();

    /* compiled from: Analytics.kt */
    public static final class AnalyticsEvent {
        private final String name;
        private final Map<String, Object> props;

        public AnalyticsEvent(String str, Map<String, ? extends Object> map) {
            C0700j.m2715b(str, "name");
            this.name = str;
            this.props = map;
        }

        public /* synthetic */ AnalyticsEvent(String str, Map map, int i, C0697g c0697g) {
            if ((i & 2) != 0) {
                map = null;
            }
            this(str, map);
        }

        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> getProps() {
            return this.props;
        }
    }

    /* compiled from: Analytics.kt */
    public static final class AnalyticsRevenueEvent {
        private final double price;

        public AnalyticsRevenueEvent(double d) {
            this.price = d;
        }

        public final double getPrice() {
            return this.price;
        }
    }

    private Analytics() {
    }

    public final void init() {
        Bus.INSTANCE.register(this);
    }

    public final void firstLaunch() {
        sendEvent$default(this, "FIRST_LAUNCH", null, 2, null);
    }

    public final void onboardingOk(long j) {
        sendEvent("ONBOARDING_OK", ac.m13041a(C0723j.m2744a("time", Long.valueOf(j))));
    }

    public final void registration() {
        sendEvent$default(this, "REGISTRATION", null, 2, null);
    }

    public final void pinCodeSet() {
        sendEvent$default(this, "PIN_CODE_SET", null, 2, null);
    }

    public final void profileInfoAdd(String str, Car car) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(car, "car");
        String str2 = "PROFILE_INFO_ADD";
        C0715h[] c0715hArr = new C0715h[5];
        c0715hArr[0] = C0723j.m2744a("user_name", str);
        c0715hArr[1] = C0723j.m2744a("car_brand", car.getBrand());
        c0715hArr[2] = C0723j.m2744a("car_model", car.getModel());
        c0715hArr[3] = C0723j.m2744a("car_number", car.getNumber());
        str = "car_color";
        car = car.getColor();
        c0715hArr[4] = C0723j.m2744a(str, car != null ? car.getName() : null);
        sendEvent(str2, ad.m18898a(c0715hArr));
    }

    public final void authPin(boolean z) {
        sendEvent("AUTH_PIN", ac.m13041a(C0723j.m2744a("success", Boolean.valueOf(z))));
    }

    public final void sellNew(Parking parking) {
        C0700j.m2715b(parking, "parking");
        for (Object next : UserManager.INSTANCE.getCars()) {
            Object obj;
            Long id = ((Car) next).getId();
            long carId = parking.getCarId();
            if (id != null) {
                if (id.longValue() == carId) {
                    obj = 1;
                    continue;
                    if (obj != null) {
                        break;
                    }
                }
            }
            obj = null;
            continue;
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        sendEvent("SELL_NEW", parkingProps(parking, (Car) next2));
    }

    public final void sellUpdate(Parking parking) {
        C0700j.m2715b(parking, "parking");
        for (Object next : UserManager.INSTANCE.getCars()) {
            Object obj;
            Long id = ((Car) next).getId();
            long carId = parking.getCarId();
            if (id != null) {
                if (id.longValue() == carId) {
                    obj = 1;
                    continue;
                    if (obj != null) {
                        break;
                    }
                }
            }
            obj = null;
            continue;
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        sendEvent("SELL_UPDATE", parkingProps(parking, (Car) next2));
    }

    public final void deleteParking(Parking parking) {
        C0700j.m2715b(parking, "parking");
        for (Object next : UserManager.INSTANCE.getCars()) {
            Object obj;
            Long id = ((Car) next).getId();
            long carId = parking.getCarId();
            if (id != null) {
                if (id.longValue() == carId) {
                    obj = 1;
                    continue;
                    if (obj != null) {
                        break;
                    }
                }
            }
            obj = null;
            continue;
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        sendEvent("SELL_DELETE", parkingProps(parking, (Car) next2));
    }

    public final void buyParking(Parking parking, Car car) {
        C0700j.m2715b(parking, "parking");
        sendEvent("BUY_NEW", parkingProps(parking, car));
    }

    public final void cancelTrip(Parking parking, int i, CancelReason cancelReason) {
        C0700j.m2715b(parking, "parking");
        C0700j.m2715b(cancelReason, "reason");
        sendEvent(i == 1 ? "SELL_RESULT" : "BUY_RESULT", ad.m18897a((Map) parkingProps$default(this, parking, null, 2, null), (Map) ad.m18898a(C0723j.m2744a("result", "trouble"), C0723j.m2744a("trouble_type", cancelReason.getAnalyticsId()))));
    }

    public final void finishTrip(Parking parking, int i) {
        C0700j.m2715b(parking, "parking");
        sendEvent(i == 1 ? "SELL_RESULT" : "BUY_RESULT", ad.m18897a((Map) parkingProps$default(this, parking, null, 2, null), ac.m13041a(C0723j.m2744a("result", "success"))));
    }

    public final void profileEdit() {
        sendEvent$default(this, "PROFILE_EDIT", null, 2, null);
    }

    public final void profileFinance() {
        sendEvent$default(this, "PROFILE_FINANCE", null, 2, null);
    }

    public final void profileFinanceOut(long j, double d) {
        sendEvent("PROFILE_FINANCE_OUT", ad.m18898a(C0723j.m2744a("template_id", Long.valueOf(j)), C0723j.m2744a("sum", Double.valueOf(d))));
    }

    public final void profileCards() {
        sendEvent$default(this, "PROFILE_CARDS", null, 2, null);
    }

    public final void profileCars() {
        sendEvent$default(this, "PROFILE_AUTOS", null, 2, null);
    }

    public final void addCar(Car car) {
        C0700j.m2715b(car, "car");
        sendEvent("PROFILE_AUTO_ADD", carProps(car));
    }

    public final void deleteCar(Car car) {
        C0700j.m2715b(car, "car");
        sendEvent("PROFILE_AUTO_DEL", carProps(car));
    }

    public final void updateCar(Car car) {
        C0700j.m2715b(car, "car");
        sendEvent("PROFILE_AUTO_UPDATE", carProps(car));
    }

    public final void profileChat(String str) {
        C0700j.m2715b(str, "chatType");
        sendEvent("PROFILE_CHAT", ac.m13041a(C0723j.m2744a("type", str)));
    }

    public final void profileTerms() {
        sendEvent$default(this, "PROFILE_TERMS", null, 2, null);
    }

    public final void profileExit() {
        sendEvent$default(this, "PROFILE_EXIT", null, 2, null);
    }

    public final void reportRevenue(double d) {
        Bus.INSTANCE.send(new AnalyticsRevenueEvent(d));
    }

    private final Map<String, Object> commonProps() {
        HashMap hashMap = new HashMap();
        hashMap.put("signed_up", Boolean.valueOf(UserManager.INSTANCE.getUser() != null));
        hashMap.put("logged_in", Boolean.valueOf(UserManager.INSTANCE.getLoggedIn()));
        hashMap.put("first_launch_date", DateUtils.INSTANCE.toIso(Settings.INSTANCE.getFirstLaunchDate()));
        return hashMap;
    }

    static /* synthetic */ Map parkingProps$default(Analytics analytics, Parking parking, Car car, int i, Object obj) {
        if ((i & 2) != 0) {
            car = null;
        }
        return analytics.parkingProps(parking, car);
    }

    private final Map<String, Object> parkingProps(Parking parking, Car car) {
        long currentTimeMillis = System.currentTimeMillis();
        return ad.m18897a((Map) ad.m18898a(C0723j.m2744a("parking_id", parking.getId()), C0723j.m2744a("parking_status_int", Integer.valueOf(parking.getStatus())), C0723j.m2744a("parking_status", Integer.valueOf(AdvStatus.Companion.byCode(parking.getStatus()).getCode())), C0723j.m2744a("sum", Double.valueOf(parking.getNormalizedPrice())), C0723j.m2744a("address", parking.getAddress()), C0723j.m2744a("selltime", DateUtils.INSTANCE.toTime(parking.getTimeLong())), C0723j.m2744a("time", DateUtils.INSTANCE.toTime(currentTimeMillis)), C0723j.m2744a("timedelta", Long.valueOf((currentTimeMillis - parking.getTimeLong()) / 1000))), (Map) carProps(car));
    }

    private final Map<String, Object> carProps(Car car) {
        C0715h[] c0715hArr = new C0715h[5];
        Object obj = null;
        c0715hArr[0] = C0723j.m2744a("car_brand", car != null ? car.getBrand() : null);
        c0715hArr[1] = C0723j.m2744a("car_model", car != null ? car.getModel() : null);
        c0715hArr[2] = C0723j.m2744a("car_number", car != null ? car.getNumber() : null);
        c0715hArr[3] = C0723j.m2744a("car_color", car != null ? car.getColor() : null);
        String str = "car_id";
        if (car != null) {
            obj = car.getId();
        }
        c0715hArr[4] = C0723j.m2744a(str, obj);
        return ad.m18898a(c0715hArr);
    }

    public final void onEventMainThread(ApplicationStartEvent applicationStartEvent) {
        C0700j.m2715b(applicationStartEvent, "event");
        sendEvent$default(this, "APPLICATION_START", null, 2, null);
    }

    public final void onEventMainThread(ApplicationStopEvent applicationStopEvent) {
        C0700j.m2715b(applicationStopEvent, "event");
        sendEvent$default(this, "APPLICATION_STOP", null, 2, null);
    }

    public static /* synthetic */ void sendEvent$default(Analytics analytics, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = ad.m18896a();
        }
        analytics.sendEvent(str, map);
    }

    public final void sendEvent(String str, Map<String, ? extends Object> map) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(map, "props");
        Bus.INSTANCE.send(new AnalyticsEvent(str, ad.m18897a(commonProps(), (Map) map)));
    }
}
