package ru.gg.scooby.manager;

import io.card.payment.BuildConfig;
import io.p181b.C2518g;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2482d;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p042b.C0727n;
import p042b.p043a.C4774r;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.UserManager.UserLoggedInEvent;
import ru.gg.scooby.manager.UserManager.UserLoggedOutEvent;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.util.Log;
import ru.tinkoff.acquiring.sdk.C2766h;
import ru.tinkoff.acquiring.sdk.C2772l;
import ru.tinkoff.acquiring.sdk.C4307c;

/* compiled from: BankCardsManager.kt */
public final class BankCardsManager {
    public static final BankCardsManager INSTANCE = new BankCardsManager();
    private static final C2772l cardManager = new C2772l(sdk);
    private static final List<C2766h> cards = new ArrayList();
    private static final C4307c sdk = new C4307c(AcquiringCredentialsProvider.INSTANCE.getTERMINAL_KEY(), AcquiringCredentialsProvider.INSTANCE.getPASSWORD(), AcquiringCredentialsProvider.INSTANCE.getPUBLIC_KEY());

    /* compiled from: BankCardsManager.kt */
    /* renamed from: ru.gg.scooby.manager.BankCardsManager$a */
    static final class C2661a<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        public static final C2661a f8279a = new C2661a();

        C2661a() {
        }

        public /* synthetic */ Object call() {
            return m11175a();
        }

        /* renamed from: a */
        public final io.p181b.C4050f<java.util.List<ru.tinkoff.acquiring.sdk.C2766h>> m11175a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = ru.gg.scooby.manager.BankCardsManager.INSTANCE;	 Catch:{ Exception -> 0x0020 }
            r0 = r0.getCardManager();	 Catch:{ Exception -> 0x0020 }
            r1 = ru.gg.scooby.manager.AcquiringCredentialsProvider.INSTANCE;	 Catch:{ Exception -> 0x0020 }
            r1 = r1.getCUSTOMER_ID();	 Catch:{ Exception -> 0x0020 }
            r0.m11410c(r1);	 Catch:{ Exception -> 0x0020 }
            r0 = ru.gg.scooby.manager.BankCardsManager.INSTANCE;	 Catch:{ Exception -> 0x0020 }
            r0 = r0.getCardManager();	 Catch:{ Exception -> 0x0020 }
            r1 = ru.gg.scooby.manager.AcquiringCredentialsProvider.INSTANCE;	 Catch:{ Exception -> 0x0020 }
            r1 = r1.getCUSTOMER_ID();	 Catch:{ Exception -> 0x0020 }
            r0 = r0.m11408a(r1);	 Catch:{ Exception -> 0x0020 }
            goto L_0x0023;
        L_0x0020:
            r0 = 0;
            r0 = new ru.tinkoff.acquiring.sdk.C2766h[r0];
        L_0x0023:
            r1 = "array";
            p042b.p047e.p049b.C0700j.m2711a(r0, r1);
            r0 = p042b.p043a.C4684f.m20938c(r0);
            r0 = io.p181b.C4050f.m17704a(r0);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.manager.BankCardsManager.a.a():io.b.f<java.util.List<ru.tinkoff.acquiring.sdk.h>>");
        }
    }

    /* compiled from: BankCardsManager.kt */
    /* renamed from: ru.gg.scooby.manager.BankCardsManager$d */
    static final class C2662d<V> implements Callable<C2518g<? extends T>> {
        /* renamed from: a */
        final /* synthetic */ String f8280a;

        C2662d(String str) {
            this.f8280a = str;
        }

        public /* synthetic */ Object call() {
            return m11176a();
        }

        /* renamed from: a */
        public final C4050f<Boolean> m11176a() {
            return C4050f.m17704a(Boolean.valueOf(BankCardsManager.INSTANCE.getSdk().m18459a(AcquiringCredentialsProvider.INSTANCE.getCUSTOMER_ID(), this.f8280a)));
        }
    }

    /* compiled from: BankCardsManager.kt */
    /* renamed from: ru.gg.scooby.manager.BankCardsManager$b */
    static final class C4143b<T> implements C2482d<List<? extends C2766h>> {
        /* renamed from: a */
        public static final C4143b f12649a = new C4143b();

        C4143b() {
        }

        /* renamed from: a */
        public final void m18091a(List<? extends C2766h> list) {
            BankCardsManager.INSTANCE.getCards().clear();
            List cards = BankCardsManager.INSTANCE.getCards();
            C0700j.m2711a((Object) list, "it");
            cards.addAll(list);
        }
    }

    /* compiled from: BankCardsManager.kt */
    /* renamed from: ru.gg.scooby.manager.BankCardsManager$e */
    static final class C4144e<T> implements C2482d<Boolean> {
        /* renamed from: a */
        final /* synthetic */ String f12650a;

        C4144e(String str) {
            this.f12650a = str;
        }

        /* renamed from: a */
        public final void m18092a(Boolean bool) {
            C0700j.m2711a((Object) bool, "it");
            if (bool.booleanValue() != null && C0700j.m2713a(this.f12650a, Settings.INSTANCE.getPrimaryCardId()) != null) {
                String b;
                for (Object next : BankCardsManager.INSTANCE.getCards()) {
                    if (C0700j.m2713a(((C2766h) next).m11387b(), this.f12650a)) {
                        break;
                    }
                }
                Object next2 = null;
                C2766h c2766h = (C2766h) next2;
                if (c2766h != null) {
                    BankCardsManager.INSTANCE.getCards().remove(c2766h);
                }
                bool = Settings.INSTANCE;
                c2766h = (C2766h) C4774r.m22244d(BankCardsManager.INSTANCE.getCards());
                if (c2766h != null) {
                    b = c2766h.m11387b();
                    if (b != null) {
                        bool.setPrimaryCardId(b);
                    }
                }
                b = BuildConfig.FLAVOR;
                bool.setPrimaryCardId(b);
            }
        }
    }

    /* compiled from: BankCardsManager.kt */
    /* renamed from: ru.gg.scooby.manager.BankCardsManager$c */
    static final class C4598c extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4598c f14111a = new C4598c();

        C4598c() {
            super(1);
        }

        /* renamed from: a */
        public final void m20447a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.e$default(Log.INSTANCE, th, false, 2, null);
        }
    }

    private BankCardsManager() {
    }

    public final C4307c getSdk() {
        return sdk;
    }

    public final C2772l getCardManager() {
        return cardManager;
    }

    public final List<C2766h> getCards() {
        return cards;
    }

    public final void init() {
        Bus.INSTANCE.register(this);
    }

    public final C4050f<List<C2766h>> loadCards() {
        Object a = C4050f.m17705a((Callable) C2661a.f8279a).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17714a((C2482d) C4143b.f12649a);
        C0700j.m2711a(a, "Observable.defer {\n     …All(it)\n                }");
        return a;
    }

    public final C4050f<Boolean> removeCard(String str) {
        C0700j.m2715b(str, "cardId");
        Object a = C4050f.m17705a((Callable) new C2662d(str)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17714a((C2482d) new C4144e(str));
        C0700j.m2711a(a, "Observable.defer {\n     …      }\n                }");
        return a;
    }

    public final void onEventMainThread(UserLoggedInEvent userLoggedInEvent) {
        C0700j.m2715b(userLoggedInEvent, "event");
        C2517a.m10349a(loadCards(), (C0690b) C4598c.f14111a, null, null, 6, null);
    }

    public final void onEventMainThread(UserLoggedOutEvent userLoggedOutEvent) {
        C0700j.m2715b(userLoggedOutEvent, "event");
        cards.clear();
    }
}
