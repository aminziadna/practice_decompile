package ru.gg.scooby.manager;

import io.card.payment.BuildConfig;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.List;
import p042b.C0727n;
import p042b.p043a.C3033j;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.ApplicationHelper.ApplicationStartEvent;
import ru.gg.scooby.Bus;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.util.PriceExKt;
import ru.skooby.R;

/* compiled from: UserManager.kt */
public final class UserManager {
    public static final UserManager INSTANCE;
    private static boolean askToSetCar = true;
    private static boolean askToSetName = true;
    private static List<Car> cars = C3033j.m13044a();
    private static boolean firstUserLoad = true;
    private static boolean loggedIn;
    private static String phone = BuildConfig.FLAVOR;
    private static boolean pinSet;
    private static User user;

    /* compiled from: UserManager.kt */
    public static final class UserLoggedInEvent {
        public static final UserLoggedInEvent INSTANCE = new UserLoggedInEvent();

        private UserLoggedInEvent() {
        }
    }

    /* compiled from: UserManager.kt */
    public static final class UserLoggedOutEvent {
        public static final UserLoggedOutEvent INSTANCE = new UserLoggedOutEvent();

        private UserLoggedOutEvent() {
        }
    }

    /* compiled from: UserManager.kt */
    public static final class UserUpdatedEvent {
        private final User user;

        public UserUpdatedEvent(User user) {
            C0700j.m2715b(user, "user");
            this.user = user;
        }

        public final User getUser() {
            return this.user;
        }
    }

    /* compiled from: UserManager.kt */
    /* renamed from: ru.gg.scooby.manager.UserManager$a */
    static final class C4606a extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4606a f14119a = new C4606a();

        C4606a() {
            super(1);
        }

        /* renamed from: a */
        public final void m20463a(Throwable th) {
            C0700j.m2715b(th, "it");
        }
    }

    /* compiled from: UserManager.kt */
    /* renamed from: ru.gg.scooby.manager.UserManager$b */
    static final class C4607b extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4607b f14120a = new C4607b();

        C4607b() {
            super(1);
        }

        /* renamed from: a */
        public final void m20465a(Throwable th) {
            C0700j.m2715b(th, "it");
        }
    }

    static {
        UserManager userManager = new UserManager();
        INSTANCE = userManager;
        Bus.INSTANCE.register(userManager, Bus.INSTANCE.getPRIORITY_HIGH());
        userManager.setPhone(Settings.INSTANCE.getPhone());
        userManager.setPinSet(Settings.INSTANCE.getPinSet());
        userManager.setUser(Settings.INSTANCE.getUser());
    }

    private UserManager() {
    }

    public final User getUser() {
        return user;
    }

    public final void setUser(User user) {
        user = user;
        Settings.INSTANCE.setUser(user);
    }

    public final String getPhone() {
        return phone;
    }

    public final void setPhone(String str) {
        C0700j.m2715b(str, "value");
        phone = str;
        Settings.INSTANCE.setPhone(str);
    }

    public final boolean getPinSet() {
        return pinSet;
    }

    public final void setPinSet(boolean z) {
        pinSet = z;
        Settings.INSTANCE.setPinSet(z);
    }

    public final boolean getLoggedIn() {
        return loggedIn;
    }

    public final void setLoggedIn(boolean z) {
        if (z && !loggedIn) {
            firstUserLoad = true;
            Bus.INSTANCE.send(UserLoggedInEvent.INSTANCE);
        }
        loggedIn = z;
    }

    public final boolean getAskToSetName() {
        return askToSetName;
    }

    public final void setAskToSetName(boolean z) {
        askToSetName = z;
    }

    public final boolean getAskToSetCar() {
        return askToSetCar;
    }

    public final void setAskToSetCar(boolean z) {
        askToSetCar = z;
    }

    public final List<Car> getCars() {
        return cars;
    }

    public final void setCars(List<Car> list) {
        C0700j.m2715b(list, "<set-?>");
        cars = list;
    }

    public final String getBalanceWithCurrency() {
        User user = user;
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                double normalizedBalance = profile.getNormalizedBalance();
                String string = ContextProvider.INSTANCE.getContext().getResources().getString(R.string.price_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(normalizedBalance))});
                if (string != null) {
                    return string;
                }
            }
        }
        UserManager userManager = this;
        return BuildConfig.FLAVOR;
    }

    public final boolean getFirstUserLoad() {
        return firstUserLoad;
    }

    public final void setFirstUserLoad(boolean z) {
        firstUserLoad = z;
    }

    public final void logout() {
        setPhone(BuildConfig.FLAVOR);
        setPinSet(false);
        setUser((User) null);
        setLoggedIn(false);
        askToSetName = true;
        askToSetCar = true;
        Settings.INSTANCE.clear();
        Bus.INSTANCE.send(UserLoggedOutEvent.INSTANCE);
    }

    public final void updateName(String str) {
        C0700j.m2715b(str, "name");
        User user = user;
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                profile.setName(str);
            }
        }
    }

    public final void refreshUserFromBackend() {
        Object a = ApiManager.INSTANCE.getUser(phone).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.getUser(phone…dSchedulers.mainThread())");
        C2517a.m10349a(a, C4606a.f14119a, null, null, 6, null);
    }

    public final void updateDeviceIdToken(String str) {
        C0700j.m2715b(str, "token");
        Object a = ApiManager.INSTANCE.updateDeviceId(str).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.updateDeviceI…dSchedulers.mainThread())");
        C2517a.m10349a(a, (C0690b) C4607b.f14120a, null, null, 6, null);
    }

    public final void onEvent(UserUpdatedEvent userUpdatedEvent) {
        C0700j.m2715b(userUpdatedEvent, "event");
        ParkingAdvert activeParkingFromUser = getActiveParkingFromUser(userUpdatedEvent.getUser());
        if (firstUserLoad) {
            User user = user;
            if (user != null) {
                firstUserLoad = false;
                if (user == null) {
                    C0700j.m2709a();
                }
                ParkingAdvert activeParkingFromUser2 = getActiveParkingFromUser(user);
                if (activeParkingFromUser == null && activeParkingFromUser2 != null) {
                    ParkingManager.INSTANCE.onCachedParkingLoaded(activeParkingFromUser2);
                }
            }
        }
        setUser(userUpdatedEvent.getUser());
        ParkingManager.INSTANCE.onParkingLoaded(activeParkingFromUser);
    }

    public final void onEvent(ApplicationStartEvent applicationStartEvent) {
        C0700j.m2715b(applicationStartEvent, "event");
        refreshUserFromBackend();
    }

    private final ParkingAdvert getActiveParkingFromUser(User user) {
        if (user.getAdvForSale() == null || !AdvStatus.Companion.byCode(user.getAdvForSale().getParking().getStatus()).isValidStatus()) {
            return (user.getAdvForBuy() == null || !AdvStatus.Companion.byCode(user.getAdvForBuy().getParking().getStatus()).isValidStatus()) ? null : new ParkingAdvert(user.getAdvForBuy(), 0);
        } else {
            return new ParkingAdvert(user.getAdvForSale(), 1);
        }
    }
}
