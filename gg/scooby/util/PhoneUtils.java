package ru.gg.scooby.util;

import com.p090c.p091a.p092a.C1045f;
import com.p090c.p091a.p093b.C1049a;
import p042b.p043a.C3033j;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.PhoneTextWatcher;

/* compiled from: PhoneUtils.kt */
public final class PhoneUtils {
    public static final PhoneUtils INSTANCE = new PhoneUtils();
    private static final int RUSSIA_PHONE_LENGTH_WITH_PREFIX = 11;

    private PhoneUtils() {
    }

    public final int getRUSSIA_PHONE_LENGTH_WITH_PREFIX() {
        return RUSSIA_PHONE_LENGTH_WITH_PREFIX;
    }

    public final String formatPhoneNumber(String str) {
        C0700j.m2715b(str, "phone");
        return C1045f.f2874a.m3941a(PhoneTextWatcher.RU_PHONE_NUMBER_MASK, C3033j.m13044a()).m3949a(new C1049a(str, str.length()), (boolean) null).m3942a().m3955a();
    }

    public final void dial(com.bluelinelabs.conductor.C0809d r4, java.lang.String r5) {
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
        r0 = "source";
        p042b.p047e.p049b.C0700j.m2715b(r4, r0);
        r0 = "phoneNumber";
        p042b.p047e.p049b.C0700j.m2715b(r5, r0);
        r0 = r5;
        r0 = (java.lang.CharSequence) r0;
        r0 = r0.length();
        r1 = 0;
        if (r0 <= 0) goto L_0x0016;
    L_0x0014:
        r0 = 1;
        goto L_0x0017;
    L_0x0016:
        r0 = 0;
    L_0x0017:
        if (r0 == 0) goto L_0x0034;
    L_0x0019:
        r0 = r5.charAt(r1);
        r1 = 43;
        if (r0 == r1) goto L_0x0034;
    L_0x0021:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = java.lang.String.valueOf(r1);
        r0.append(r1);
        r0.append(r5);
        r5 = r0.toString();
    L_0x0034:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.DIAL";
        r0.<init>(r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "tel:";
        r1.append(r2);
        r1.append(r5);
        r5 = r1.toString();
        r5 = android.net.Uri.parse(r5);
        r0.setData(r5);
        r4.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x005b }
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.PhoneUtils.dial(com.bluelinelabs.conductor.d, java.lang.String):void");
    }
}
