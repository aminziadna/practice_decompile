package ru.tinkoff.p213a.p214a;

import ru.tinkoff.p213a.p214a.p215a.C2701a;
import ru.tinkoff.p213a.p214a.p215a.C4277b;

/* compiled from: Logger */
/* renamed from: ru.tinkoff.a.a.a */
public final class C2702a {
    /* renamed from: a */
    private static final String f8326a = "a";
    /* renamed from: b */
    private static boolean f8327b;
    /* renamed from: c */
    private static C2701a f8328c;

    static {
        C2701a a = C2702a.m11191a();
        if (a != null) {
            f8328c = a;
            return;
        }
        f8328c = new C4277b();
        C2702a.m11194a(f8326a, "WARNING: Can't find Android Logger, may be you forgot to add core-log-android into your dependencies?");
    }

    private C2702a() {
    }

    /* renamed from: a */
    public static void m11195a(String str, String str2, Throwable th) {
        C2702a.m11193a(4, th, str, str2);
    }

    /* renamed from: a */
    public static void m11194a(String str, String str2) {
        C2702a.m11192a(2, str, str2);
    }

    /* renamed from: a */
    private static void m11192a(int i, String str, String str2) {
        C2702a.m11193a(i, null, str, str2);
    }

    /* renamed from: a */
    private static void m11193a(int i, Throwable th, String str, String str2) {
        if (f8327b) {
            f8328c.mo1930a(i, th, str, str2);
        }
    }

    /* renamed from: a */
    private static ru.tinkoff.p213a.p214a.p215a.C2701a m11191a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r0 = "ru.tinkoff.core.log.internal.AndroidLogger";	 Catch:{ Exception -> 0x000d }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x000d }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x000d }
        r0 = (ru.tinkoff.p213a.p214a.p215a.C2701a) r0;	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.a.a.a():ru.tinkoff.a.a.a.a");
    }
}
