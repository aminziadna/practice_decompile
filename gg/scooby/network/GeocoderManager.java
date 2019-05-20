package ru.gg.scooby.network;

import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import com.google.gson.C1729g;
import com.mapbox.mapboxsdk.geometry.LatLng;
import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p187d.C2483e;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import okhttp3.C4140x.C2655a;
import okhttp3.p202a.C4088a;
import okhttp3.p202a.C4088a.C2556a;
import okhttp3.p202a.C4088a.C2557b;
import p042b.p043a.C4774r;
import p042b.p047e.p049b.C0700j;
import p165d.C2326c.C2301a;
import p165d.C2331f.C2330a;
import p165d.C2345s;
import p165d.C2345s.C2344a;
import p165d.p166a.p167a.C3926h;
import p165d.p229b.p230a.C3928a;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.model.geo.GeocoderFeature;
import ru.gg.scooby.model.geo.GeocoderResponse;

/* compiled from: GeocoderManager.kt */
public final class GeocoderManager {
    public static final String BASE_URL = "https://api.mapbox.com/";
    public static final GeocoderManager INSTANCE;
    private static final String TAG = "NetworkRequest";
    private static final C4088a loggingInterceptor;
    private static final GeocoderService service;

    /* compiled from: GeocoderManager.kt */
    /* renamed from: ru.gg.scooby.network.GeocoderManager$a */
    static final class C2667a<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        final /* synthetic */ double f8286a;
        /* renamed from: b */
        final /* synthetic */ double f8287b;

        C2667a(double d, double d2) {
            this.f8286a = d;
            this.f8287b = d2;
        }

        public /* synthetic */ Object call() {
            return m11181a();
        }

        /* renamed from: a */
        public final C4050f<Address> m11181a() {
            Object fromLocation = new Geocoder(ContextProvider.INSTANCE.getContext(), new Locale("ru")).getFromLocation(this.f8286a, this.f8287b, 1);
            C0700j.m2711a(fromLocation, "geocoder.getFromLocation(latitude, longitude, 1)");
            return C4050f.m17704a(C4774r.m22244d((List) fromLocation));
        }
    }

    /* compiled from: GeocoderManager.kt */
    /* renamed from: ru.gg.scooby.network.GeocoderManager$b */
    static final class C2668b<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        final /* synthetic */ String f8288a;
        /* renamed from: b */
        final /* synthetic */ LatLng f8289b;

        /* compiled from: GeocoderManager.kt */
        /* renamed from: ru.gg.scooby.network.GeocoderManager$b$1 */
        static final class C41781<T, R> implements C2483e<T, R> {
            /* renamed from: a */
            public static final C41781 f12687a = new C41781();

            C41781() {
            }

            /* renamed from: a */
            public final ArrayList<Address> m18160a(GeocoderResponse geocoderResponse) {
                C0700j.m2715b(geocoderResponse, "it");
                ArrayList<Address> arrayList = new ArrayList();
                for (GeocoderFeature geocoderFeature : geocoderResponse.getFeatures()) {
                    geocoderFeature.postInit();
                    Address address = new Address(Locale.getDefault());
                    address.setLocality(geocoderFeature.getSubTitle());
                    address.setAddressLine(0, geocoderFeature.getTitle());
                    address.setLongitude(geocoderFeature.getLongitude());
                    address.setLatitude(geocoderFeature.getLatitude());
                    arrayList.add(address);
                }
                return arrayList;
            }
        }

        C2668b(String str, LatLng latLng) {
            this.f8288a = str;
            this.f8289b = latLng;
        }

        public /* synthetic */ Object call() {
            return m11182a();
        }

        /* renamed from: a */
        public final io.p181b.C4050f<? extends java.util.List<android.location.Address>> m11182a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
            /*
            r10 = this;
            r0 = new android.location.Geocoder;
            r1 = ru.gg.scooby.ContextProvider.INSTANCE;
            r1 = r1.getContext();
            r2 = new java.util.Locale;
            r3 = "ru";
            r2.<init>(r3);
            r0.<init>(r1, r2);
            r1 = r10.f8288a;	 Catch:{ Exception -> 0x001e }
            r2 = 5;	 Catch:{ Exception -> 0x001e }
            r0 = r0.getFromLocationName(r1, r2);	 Catch:{ Exception -> 0x001e }
            r0 = io.p181b.C4050f.m17704a(r0);	 Catch:{ Exception -> 0x001e }
            goto L_0x0062;
            r0 = r10.f8289b;
            if (r0 == 0) goto L_0x0045;
        L_0x0023:
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = r10.f8289b;
            r1 = r1.m7220b();
            r0.append(r1);
            r1 = 44;
            r0.append(r1);
            r1 = r10.f8289b;
            r1 = r1.m7217a();
            r0.append(r1);
            r0 = r0.toString();
            r3 = r0;
            goto L_0x0047;
        L_0x0045:
            r0 = 0;
            r3 = r0;
        L_0x0047:
            r0 = ru.gg.scooby.network.GeocoderManager.INSTANCE;
            r1 = ru.gg.scooby.network.GeocoderManager.service;
            r2 = r10.f8288a;
            r4 = 0;
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r8 = 60;
            r9 = 0;
            r0 = ru.gg.scooby.network.GeocoderService.DefaultImpls.geocode$default(r1, r2, r3, r4, r5, r6, r7, r8, r9);
            r1 = ru.gg.scooby.network.GeocoderManager.C2668b.C41781.f12687a;
            r1 = (io.p181b.p187d.C2483e) r1;
            r0 = r0.m17728b(r1);
        L_0x0062:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.network.GeocoderManager.b.a():io.b.f<? extends java.util.List<android.location.Address>>");
        }
    }

    /* compiled from: GeocoderManager.kt */
    /* renamed from: ru.gg.scooby.network.GeocoderManager$c */
    static final class C4179c implements C2557b {
        /* renamed from: b */
        public static final C4179c f12688b = new C4179c();

        C4179c() {
        }

        /* renamed from: a */
        public final void mo1823a(String str) {
            Log.d(GeocoderManager.TAG, str);
        }
    }

    public final void addDebugInterceptors(C2655a c2655a) {
        C0700j.m2715b(c2655a, "builder");
    }

    static {
        GeocoderManager geocoderManager = new GeocoderManager();
        INSTANCE = geocoderManager;
        C4088a c4088a = new C4088a(C4179c.f12688b);
        c4088a.m17851a(C2556a.BODY);
        loggingInterceptor = c4088a;
        Object a = geocoderManager.createJsonAdapter(BASE_URL).m9843a(GeocoderService.class);
        C0700j.m2711a(a, "createJsonAdapter(BASE_U…coderService::class.java)");
        service = (GeocoderService) a;
    }

    private GeocoderManager() {
    }

    public final C4088a getLoggingInterceptor() {
        return loggingInterceptor;
    }

    private final C2345s createJsonAdapter(String str) {
        C2655a c2655a = new C2655a();
        addDebugInterceptors(c2655a);
        Object a = new C2344a().m9831a(str).m9834a(c2655a.m11167a()).m9830a((C2330a) C3928a.m17309a(new C1729g().m6462b())).m9829a((C2301a) C3926h.m17304a()).m9835a();
        C0700j.m2711a(a, "Retrofit.Builder()\n     …\n                .build()");
        return a;
    }

    public static /* synthetic */ C4050f geocodeQuery$default(GeocoderManager geocoderManager, String str, LatLng latLng, int i, Object obj) {
        if ((i & 2) != 0) {
            latLng = null;
        }
        return geocoderManager.geocodeQuery(str, latLng);
    }

    public final C4050f<List<Address>> geocodeQuery(String str, LatLng latLng) {
        C0700j.m2715b(str, "query");
        Object a = C4050f.m17705a((Callable) new C2668b(str, latLng));
        C0700j.m2711a(a, "Observable.defer {\n     …}\n            }\n        }");
        return a;
    }

    public final C4050f<Address> geocodeLocation(double d, double d2) {
        Object a = C4050f.m17705a((Callable) new C2667a(d, d2));
        C0700j.m2711a(a, "Observable.defer {\n     ….firstOrNull())\n        }");
        return a;
    }
}
