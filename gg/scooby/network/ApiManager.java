package ru.gg.scooby.network;

import android.net.Uri;
import android.util.Log;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.google.gson.C1729g;
import com.google.gson.C3583d;
import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2483e;
import io.p181b.p198h.C2527a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.C2639m;
import okhttp3.C2651u;
import okhttp3.C2652v;
import okhttp3.C4138w.C2654b;
import okhttp3.C4140x.C2655a;
import okhttp3.ab;
import okhttp3.p202a.C4088a;
import okhttp3.p202a.C4088a.C2556a;
import okhttp3.p202a.C4088a.C2557b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p165d.C2326c.C2301a;
import p165d.C2331f.C2330a;
import p165d.C2342r;
import p165d.C2345s;
import p165d.C2345s.C2344a;
import p165d.p166a.p167a.C3926h;
import p165d.p229b.p230a.C3928a;
import ru.gg.scooby.BuildConfig;
import ru.gg.scooby.Bus;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.manager.FileUploadManager;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.manager.UserManager.UserUpdatedEvent;
import ru.gg.scooby.model.AdvFilter;
import ru.gg.scooby.model.CancelReason;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.GetVerifyCodeResponse;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingForSell;
import ru.gg.scooby.model.ParkingStatus;
import ru.gg.scooby.model.ParkingStatusResponse;
import ru.gg.scooby.model.ParkingsResponse;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.Pin;
import ru.gg.scooby.model.PostVerifyCodeResponse;
import ru.gg.scooby.model.User;
import ru.gg.scooby.model.UserLocationRequest;
import ru.gg.scooby.model.UserLocationResponse;

/* compiled from: ApiManager.kt */
public final class ApiManager {
    public static final ApiManager INSTANCE;
    private static final long RETRY_COUNT = 2;
    private static final String TAG = "NetworkRequest";
    private static final C4088a loggingInterceptor;
    public static C2345s retrofit;
    public static ApiService service;

    /* compiled from: ApiManager.kt */
    public static final class ApiException extends Exception {
        private final int code;
        private final String error;

        public final int getCode() {
            return this.code;
        }

        public ApiException(int i, String str) {
            this.code = i;
            this.error = str;
        }

        public /* synthetic */ ApiException(int i, String str, int i2, C0697g c0697g) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            this(i, str);
        }

        public final String getError() {
            return this.error;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$a */
    static final class C4159a<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4159a f12668a = new C4159a();

        C4159a() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18122a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getCars();
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$b */
    static final class C4160b<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4160b f12669a = new C4160b();

        C4160b() {
        }

        /* renamed from: a */
        public final C4050f<C2342r<User>> m18124a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            return ApiManager.INSTANCE.getUser(UserManager.INSTANCE.getPhone());
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$c */
    static final class C4161c<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4161c f12670a = new C4161c();

        C4161c() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18126a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getCars();
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$d */
    static final class C4162d<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        public static final C4162d f12671a = new C4162d();

        C4162d() {
        }

        /* renamed from: a */
        public final C2342r<List<Car>> m18128a(C2342r<List<Car>> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                Object obj = (List) c2342r.m9827d();
                if (obj != null) {
                    UserManager userManager = UserManager.INSTANCE;
                    C0700j.m2711a(obj, "it");
                    userManager.setCars(obj);
                }
            }
            return c2342r;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$e */
    static final class C4163e<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        final /* synthetic */ String f12672a;

        C4163e(String str) {
            this.f12672a = str;
        }

        /* renamed from: a */
        public final C2342r<User> m18130a(C2342r<User> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                Object obj = (User) c2342r.m9827d();
                if (obj != null) {
                    UserManager.INSTANCE.setPhone(this.f12672a);
                    UserManager.INSTANCE.setLoggedIn(true);
                    Bus bus = Bus.INSTANCE;
                    C0700j.m2711a(obj, "it");
                    bus.send(new UserUpdatedEvent(obj));
                }
            }
            return c2342r;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$f */
    static final class C4164f<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4164f f12673a = new C4164f();

        C4164f() {
        }

        /* renamed from: a */
        public final C4050f<C2342r<User>> m18132a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            return ApiManager.INSTANCE.getUser(UserManager.INSTANCE.getPhone());
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$g */
    static final class C4165g implements C2557b {
        /* renamed from: b */
        public static final C4165g f12674b = new C4165g();

        C4165g() {
        }

        /* renamed from: a */
        public final void mo1823a(String str) {
            Log.d(ApiManager.TAG, str);
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$h */
    static final class C4166h<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        final /* synthetic */ String f12675a;

        C4166h(String str) {
            this.f12675a = str;
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18135a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getUser(this.f12675a);
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$i */
    static final class C4167i<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4167i f12676a = new C4167i();

        C4167i() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18137a(C2342r<? extends Object> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getCars();
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$j */
    static final class C4168j<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        public static final C4168j f12677a = new C4168j();

        C4168j() {
        }

        /* renamed from: a */
        public final C2342r<Void> m18139a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                UserManager.INSTANCE.setPinSet(true);
                UserManager.INSTANCE.setLoggedIn(true);
            }
            return c2342r;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$k */
    static final class C4169k<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        final /* synthetic */ String f12678a;

        C4169k(String str) {
            this.f12678a = str;
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18141a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getUser(this.f12678a);
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$l */
    static final class C4170l<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4170l f12679a = new C4170l();

        C4170l() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18143a(C2342r<? extends Object> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getCars();
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$m */
    static final class C4171m<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        final /* synthetic */ String f12680a;

        C4171m(String str) {
            this.f12680a = str;
        }

        /* renamed from: a */
        public final C4050f<C2342r<GetVerifyCodeResponse>> m18145a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            return ApiManager.INSTANCE.getService().requestCode(this.f12680a);
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$n */
    static final class C4172n<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4172n f12681a = new C4172n();

        C4172n() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18147a(C2342r<ParkingAdvert> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.getUser$default(ApiManager.INSTANCE, null, 1, null);
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$o */
    static final class C4173o<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        public static final C4173o f12682a = new C4173o();

        C4173o() {
        }

        /* renamed from: a */
        public final C2342r<? extends Object> m18149a(C2342r<? extends Object> c2342r) {
            C0700j.m2715b(c2342r, "it");
            ParkingManager.INSTANCE.publishParking();
            return c2342r;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$p */
    static final class C4174p<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4174p f12683a = new C4174p();

        C4174p() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18151a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.getUser$default(ApiManager.INSTANCE, null, 1, null);
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$q */
    static final class C4175q<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4175q f12684a = new C4175q();

        C4175q() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18153a(C2342r<Void> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.INSTANCE.getCars();
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$r */
    static final class C4176r<T, R> implements C2483e<T, C2518g<? extends R>> {
        /* renamed from: a */
        public static final C4176r f12685a = new C4176r();

        C4176r() {
        }

        /* renamed from: a */
        public final C4050f<? extends C2342r<? extends Object>> m18155a(C2342r<ParkingAdvert> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (c2342r.m9826c()) {
                return ApiManager.getUser$default(ApiManager.INSTANCE, null, 1, null);
            }
            Object a = C4050f.m17704a((Object) c2342r);
            C0700j.m2711a(a, "Observable.just(it)");
            return a;
        }
    }

    /* compiled from: ApiManager.kt */
    /* renamed from: ru.gg.scooby.network.ApiManager$s */
    static final class C4177s<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        public static final C4177s f12686a = new C4177s();

        C4177s() {
        }

        /* renamed from: a */
        public final C2342r<? extends Object> m18157a(C2342r<? extends Object> c2342r) {
            C0700j.m2715b(c2342r, "it");
            ParkingManager.INSTANCE.updateParking();
            return c2342r;
        }
    }

    public final void addDebugInterceptors(C2655a c2655a) {
        C0700j.m2715b(c2655a, "builder");
    }

    static {
        ApiManager apiManager = new ApiManager();
        INSTANCE = apiManager;
        C4088a c4088a = new C4088a(C4165g.f12674b);
        c4088a.m17851a(C2556a.BODY);
        loggingInterceptor = c4088a;
        apiManager.recreateAdapterAndService();
    }

    private ApiManager() {
    }

    public final ApiService getService() {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService;
    }

    public final void setService(ApiService apiService) {
        C0700j.m2715b(apiService, "<set-?>");
        service = apiService;
    }

    public final C2345s getRetrofit() {
        C2345s c2345s = retrofit;
        if (c2345s == null) {
            C0700j.m2716b("retrofit");
        }
        return c2345s;
    }

    public final void setRetrofit(C2345s c2345s) {
        C0700j.m2715b(c2345s, "<set-?>");
        retrofit = c2345s;
    }

    public final C4088a getLoggingInterceptor() {
        return loggingInterceptor;
    }

    public final void recreateAdapterAndService() {
        retrofit = createJsonAdapter(BuildConfig.API_BASE_URL);
        C2345s c2345s = retrofit;
        if (c2345s == null) {
            C0700j.m2716b("retrofit");
        }
        Object a = c2345s.m9843a(ApiService.class);
        C0700j.m2711a(a, "retrofit.create(ApiService::class.java)");
        service = (ApiService) a;
    }

    private final C2345s createJsonAdapter(String str) {
        Object a = new C2655a().m11163a((C2639m) new PersistentCookieJar(new SetCookieCache(), new DummyCookiePersistor()));
        a.m11165a((C2651u) new RequestsInterceptor());
        a.m11165a((C2651u) new ErrorInterceptor());
        a.m11168b(20, TimeUnit.SECONDS);
        a.m11158a(20, TimeUnit.SECONDS);
        C0700j.m2711a(a, "builder");
        addDebugInterceptors(a);
        Object a2 = new C2344a().m9831a(str).m9834a(a.m11167a()).m9830a((C2330a) C3928a.m17309a(new C1729g().m6458a(C3583d.LOWER_CASE_WITH_DASHES).m6462b())).m9829a((C2301a) C3926h.m17305a(C2527a.m10359b())).m9835a();
        C0700j.m2711a(a2, "Retrofit.Builder()\n     …\n                .build()");
        return a2;
    }

    public final C4050f<C2342r<GetVerifyCodeResponse>> requestCode(String str) {
        C0700j.m2715b(str, "phone");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.login(str).m17716a((C2483e) new C4171m(str));
        C0700j.m2711a(a, "service.login(phone)\n   …(phone)\n                }");
        return a;
    }

    public final C4050f<C2342r<PostVerifyCodeResponse>> verifyCode(String str, String str2) {
        C0700j.m2715b(str, "phone");
        C0700j.m2715b(str2, "code");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.sendCode(str, str2);
    }

    public final C4050f<C2342r<? extends Object>> postLogin(String str) {
        C0700j.m2715b(str, "phone");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.login(str).m17716a((C2483e) new C4169k(str)).m17716a((C2483e) C4170l.f12679a);
        C0700j.m2711a(a, "service.login(phone)\n   …      }\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> pinLogin(String str, Pin pin) {
        C0700j.m2715b(str, "phone");
        C0700j.m2715b(pin, "pin");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.pinLogin(str, pin).m17716a((C2483e) new C4166h(str)).m17716a((C2483e) C4167i.f12676a);
        C0700j.m2711a(a, "service.pinLogin(phone, …      }\n                }");
        return a;
    }

    public final C4050f<C2342r<Void>> uploadFile(String str, Uri uri) {
        byte[] bytesFromUri;
        C0700j.m2715b(str, "phone");
        if (uri != null) {
            bytesFromUri = FileUploadManager.INSTANCE.getBytesFromUri(ContextProvider.INSTANCE.getContext(), uri);
        } else {
            bytesFromUri = new byte[null];
        }
        Object a = C2654b.m11156a("file", "avatar.jpg", ab.m10551a(C2652v.m11145b("image/png"), bytesFromUri));
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        C0700j.m2711a(a, "body");
        Object a2 = apiService.updateAvatar(str, a).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a2, "service.updateAvatar(pho…dSchedulers.mainThread())");
        return a2;
    }

    public static /* synthetic */ C4050f getUser$default(ApiManager apiManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserManager.INSTANCE.getPhone();
        }
        return apiManager.getUser(str);
    }

    public final C4050f<C2342r<User>> getUser(String str) {
        C0700j.m2715b(str, "phone");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object b = apiService.getUser(str).m17728b((C2483e) new C4163e(str));
        C0700j.m2711a(b, "service.getUser(phone)\n …     it\n                }");
        return b;
    }

    public final C4050f<C2342r<List<Car>>> getCars() {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object b = apiService.getCars(UserManager.INSTANCE.getPhone()).m17728b((C2483e) C4162d.f12671a);
        C0700j.m2711a(b, "service.getCars(UserMana…     it\n                }");
        return b;
    }

    public final C4050f<C2342r<Void>> pinSet(Pin pin) {
        C0700j.m2715b(pin, "pinBody");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object b = apiService.pinSet(UserManager.INSTANCE.getPhone(), pin).m17728b((C2483e) C4168j.f12677a);
        C0700j.m2711a(b, "service.pinSet(UserManag…     it\n                }");
        return b;
    }

    public final C4050f<C2342r<? extends Object>> addCar(Car car) {
        C0700j.m2715b(car, "car");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.addCar(UserManager.INSTANCE.getPhone(), car).m17716a((C2483e) C4159a.f12668a);
        C0700j.m2711a(a, "service.addCar(UserManag…      }\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> deleteCar(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.deleteCar(UserManager.INSTANCE.getPhone(), j).m17716a((C2483e) C4161c.f12670a);
        C0700j.m2711a(a, "service.deleteCar(UserMa…      }\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> updateCar(Car car) {
        C0700j.m2715b(car, "car");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.updateCar(UserManager.INSTANCE.getPhone(), car).m17716a((C2483e) C4175q.f12684a);
        C0700j.m2711a(a, "service.updateCar(UserMa…      }\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> setDefaultCar(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.setDefaultCar(UserManager.INSTANCE.getPhone(), j).m17716a((C2483e) C4174p.f12683a);
        C0700j.m2711a(a, "service.setDefaultCar(Us…      }\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> sellParking(ParkingForSell parkingForSell) {
        C0700j.m2715b(parkingForSell, "parking");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object b = apiService.sellParking(UserManager.INSTANCE.getPhone(), parkingForSell).m17716a((C2483e) C4172n.f12681a).m17728b((C2483e) C4173o.f12682a);
        C0700j.m2711a(b, "observable");
        return b;
    }

    public final C4050f<? extends C2342r<? extends Void>> deleteParking(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.deleteParking(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<? extends Object>> buyParking(Parking parking) {
        C0700j.m2715b(parking, "parking");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        String phone = UserManager.INSTANCE.getPhone();
        parking = parking.getId();
        if (parking == null) {
            C0700j.m2709a();
        }
        Object a = apiService.buyParking(phone, parking.longValue()).m17716a((C2483e) C4160b.f12669a);
        C0700j.m2711a(a, "ApiManager.service.buyPa….phone)\n                }");
        return a;
    }

    public final C4050f<C2342r<? extends Object>> updateParking(long j, ParkingForSell parkingForSell) {
        C0700j.m2715b(parkingForSell, "parking");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object b = apiService.updateParking(UserManager.INSTANCE.getPhone(), j, parkingForSell).m17716a((C2483e) C4176r.f12685a).m17728b((C2483e) C4177s.f12686a);
        C0700j.m2711a(b, "observable");
        return b;
    }

    public final C4050f<C2342r<Void>> cancelParking(long j, CancelReason cancelReason) {
        C0700j.m2715b(cancelReason, "cancelReason");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.dealCancel(UserManager.INSTANCE.getPhone(), j, cancelReason.getAnalyticsId());
    }

    public final C4050f<C2342r<Void>> finishParking(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.dealComplete(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<ParkingStatus>> getParkingById(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.getParkingById(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<List<PaymentTemplate>>> getPaymentTemplates() {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.getPaymentTemplates(UserManager.INSTANCE.getPhone());
    }

    public final C4050f<C2342r<ParkingsResponse>> getParkings(AdvFilter advFilter) {
        C0700j.m2715b(advFilter, "advFilter");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.getParkings(UserManager.INSTANCE.getPhone(), advFilter);
    }

    public final C4050f<C2342r<ParkingStatusResponse>> getParkingStatus(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.getParkingStatus(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<UserLocationResponse>> getBuyerLocation(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.getBuyerLocation(UserManager.INSTANCE.getPhone(), j);
    }

    public final C4050f<C2342r<Void>> sendBuyerLocation(UserLocationRequest userLocationRequest) {
        C0700j.m2715b(userLocationRequest, "request");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.sendBuyerLocation(UserManager.INSTANCE.getPhone(), userLocationRequest);
    }

    public final C4050f<C2342r<Void>> updateDeviceId(String str) {
        C0700j.m2715b(str, "deviceId");
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        return apiService.updateDeviceId(UserManager.INSTANCE.getPhone(), str);
    }

    public final C4050f<C2342r<? extends Object>> likeParking(long j) {
        ApiService apiService = service;
        if (apiService == null) {
            C0700j.m2716b("service");
        }
        Object a = apiService.like(UserManager.INSTANCE.getPhone(), j).m17716a((C2483e) C4164f.f12673a);
        C0700j.m2711a(a, "ApiManager.service.like(….phone)\n                }");
        return a;
    }
}
