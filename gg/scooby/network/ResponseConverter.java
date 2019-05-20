package ru.gg.scooby.network;

/* compiled from: ResponseConverter.kt */
public final class ResponseConverter {
    public static final ResponseConverter INSTANCE = new ResponseConverter();

    private ResponseConverter() {
    }

    private final <T> T parseResponse(p165d.C2342r<T> r4) {
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
        r3 = this;
        r0 = r4.m9826c();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r4 = r4.m9827d();
        return r4;
    L_0x000b:
        r0 = ru.gg.scooby.network.ApiManager.INSTANCE;
        r0 = r0.getRetrofit();
        r1 = 4;
        r2 = "T";
        p042b.p047e.p049b.C0700j.m2710a(r1, r2);
        r1 = java.lang.Object.class;
        r1 = (java.lang.reflect.Type) r1;
        r2 = 0;
        r2 = new java.lang.annotation.Annotation[r2];
        r0 = r0.m9844b(r1, r2);
        r4 = r4.m9828e();	 Catch:{ Exception -> 0x002b }
        r4 = r0.mo1722a(r4);	 Catch:{ Exception -> 0x002b }
        return r4;
    L_0x002b:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.network.ResponseConverter.parseResponse(d.r):T");
    }
}
