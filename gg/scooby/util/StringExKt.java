package ru.gg.scooby.util;

import android.text.TextUtils;
import io.card.payment.BuildConfig;
import java.util.regex.Pattern;
import p042b.p047e.p049b.C0700j;

/* compiled from: StringEx.kt */
public final class StringExKt {
    private static final Pattern NON_DIGIT_SYMBOLS = Pattern.compile("[\\D]");

    public static final String nonEmptyOrNull(String str) {
        C0700j.m2715b(str, "receiver$0");
        return !TextUtils.isEmpty((CharSequence) str) ? str : null;
    }

    public static final String removeNonDigits(String str) {
        C0700j.m2715b(str, "receiver$0");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return BuildConfig.FLAVOR;
        }
        Object replaceAll = NON_DIGIT_SYMBOLS.matcher(charSequence).replaceAll(BuildConfig.FLAVOR);
        C0700j.m2711a(replaceAll, "matcher.replaceAll(\"\")");
        return replaceAll;
    }

    public static final java.lang.Long safeToLong(java.lang.String r2) {
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
        r0 = "receiver$0";
        p042b.p047e.p049b.C0700j.m2715b(r2, r0);
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ Exception -> 0x000e }
        r2 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x000e }
        return r2;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.StringExKt.safeToLong(java.lang.String):java.lang.Long");
    }

    public static final java.lang.Double safeToDouble(java.lang.String r2) {
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
        r0 = "receiver$0";
        p042b.p047e.p049b.C0700j.m2715b(r2, r0);
        r0 = java.lang.Double.parseDouble(r2);	 Catch:{ Exception -> 0x000e }
        r2 = java.lang.Double.valueOf(r0);	 Catch:{ Exception -> 0x000e }
        return r2;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.StringExKt.safeToDouble(java.lang.String):java.lang.Double");
    }
}
