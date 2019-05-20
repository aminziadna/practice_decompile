package ru.gg.scooby.manager;

import android.location.Address;
import io.p181b.C4050f;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import p042b.C0727n;
import p042b.p043a.C4381k;
import p042b.p043a.C4774r;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.model.SimpleAddress;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.util.Log;

/* compiled from: RecentManager.kt */
public final class RecentManager {
    public static final RecentManager INSTANCE = new RecentManager();
    private static final int MAX_RECENT_COUNT = 10;
    private static List<SimpleAddress> addressList;

    /* compiled from: RecentManager.kt */
    /* renamed from: ru.gg.scooby.manager.RecentManager$a */
    static final class C2665a<V> implements Callable<T> {
        /* renamed from: a */
        public static final C2665a f8283a = new C2665a();

        C2665a() {
        }

        public /* synthetic */ Object call() {
            m11179a();
            return C0727n.f2066a;
        }

        /* renamed from: a */
        public final void m11179a() {
            if ((RecentManager.addressList.isEmpty() ^ 1) != 0) {
                Settings.INSTANCE.setRecentAddresses(RecentManager.addressList);
            }
        }
    }

    /* compiled from: RecentManager.kt */
    /* renamed from: ru.gg.scooby.manager.RecentManager$b */
    static final class C4605b extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4605b f14118a = new C4605b();

        C4605b() {
            super(1);
        }

        /* renamed from: a */
        public final void m20461a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.INSTANCE.m11189e(th, false);
        }
    }

    static {
        addressList = new ArrayList();
        List recentAddresses = Settings.INSTANCE.getRecentAddresses();
        if (recentAddresses != null) {
            addressList = C4774r.m22239a((Collection) recentAddresses);
        }
    }

    private RecentManager() {
    }

    public final List<Address> getAddressList() {
        Iterable<SimpleAddress> iterable = addressList;
        Collection arrayList = new ArrayList(C4381k.m18905a(iterable, 10));
        for (SimpleAddress toAddress : iterable) {
            arrayList.add(toAddress.toAddress());
        }
        return (List) arrayList;
    }

    public final void addAddress(Address address) {
        C0700j.m2715b(address, "address");
        address = SimpleAddress.Companion.fromAddress(address);
        if (addressList.contains(address)) {
            addressList.remove(address);
        }
        addressList.add(0, address);
        if (addressList.size() > 10) {
            address = addressList;
            address.remove(C4774r.m22245e(address));
        }
    }

    public final void save() {
        Object b = C4050f.m17707b((Callable) C2665a.f8283a).m17729b(C2527a.m10359b());
        C0700j.m2711a(b, "Observable.fromCallable …scribeOn(Schedulers.io())");
        C2517a.m10349a(b, C4605b.f14118a, null, null, 6, null);
    }
}
