package ru.gg.scooby.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import p042b.p047e.p049b.C0700j;

/* compiled from: PriceEx.kt */
public final class PriceExKt {
    private static final DecimalFormat decimalFormat;

    public static final long toRawPrice(int i) {
        return (long) (i * 100);
    }

    static {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);
    }

    public static final double toNormalizedPrice(long j) {
        j = (double) j;
        double d = (double) 100;
        Double.isNaN(j);
        Double.isNaN(d);
        return j / d;
    }

    public static final long toRawPrice(double d) {
        double d2 = (double) 100;
        Double.isNaN(d2);
        return (long) (d * d2);
    }

    public static final java.lang.Double parsePrice(java.lang.String r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r0 = "receiver$0";
        p042b.p047e.p049b.C0700j.m2715b(r2, r0);
        r0 = decimalFormat;	 Catch:{ Exception -> 0x0014 }
        r2 = r0.parse(r2);	 Catch:{ Exception -> 0x0014 }
        r0 = r2.doubleValue();	 Catch:{ Exception -> 0x0014 }
        r2 = java.lang.Double.valueOf(r0);	 Catch:{ Exception -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.PriceExKt.parsePrice(java.lang.String):java.lang.Double");
    }

    public static final String formatPriceWithOptionalDecimalPart(Number number) {
        C0700j.m2715b(number, "receiver$0");
        return decimalFormat.format(number);
    }
}
