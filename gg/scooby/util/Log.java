package ru.gg.scooby.util;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import com.crashlytics.android.C3319a;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import p042b.p047e.p049b.C0700j;

/* compiled from: Log.kt */
public final class Log {
    public static final String APP_TAG = "Scooby";
    public static final Log INSTANCE = new Log();
    private static final Log$LOG_TIME_FORMATTER$1 LOG_TIME_FORMATTER = new Log$LOG_TIME_FORMATTER$1();
    private static boolean isEnabled;
    private static boolean isExternalLoggingEnabled = true;

    private final String priorityStr(int i) {
        String str = "V";
        switch (i) {
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            default:
                return str;
        }
    }

    private Log() {
    }

    public final boolean isEnabled() {
        return isEnabled;
    }

    public final void setEnabled(boolean z) {
        isEnabled = z;
    }

    public final boolean isExternalLoggingEnabled() {
        return isExternalLoggingEnabled;
    }

    public final void setExternalLoggingEnabled(boolean z) {
        isExternalLoggingEnabled = z;
    }

    /* renamed from: d */
    public final void m11184d(String str, String str2) {
        C0700j.m2715b(str, "tag");
        C0700j.m2715b(str2, "msg");
        if (isEnabled) {
            android.util.Log.d(str, str2);
        }
        if (isExternalLoggingEnabled) {
            logExternal(3, str, str2);
        }
    }

    /* renamed from: e */
    public final void m11185e(String str, String str2) {
        C0700j.m2715b(str, "tag");
        C0700j.m2715b(str2, "msg");
        if (isEnabled) {
            android.util.Log.e(str, str2);
        }
        if (isExternalLoggingEnabled) {
            logExternal(6, str, str2);
        }
    }

    public static /* synthetic */ void e$default(Log log, String str, String str2, Throwable th, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        log.m11186e(str, str2, th, z);
    }

    /* renamed from: e */
    public final void m11186e(String str, String str2, Throwable th, boolean z) {
        C0700j.m2715b(str, "tag");
        C0700j.m2715b(str2, "msg");
        C0700j.m2715b(th, "tr");
        if (isEnabled) {
            android.util.Log.e(str, str2, th);
        }
        if (isExternalLoggingEnabled) {
            logExternal(6, str, str2);
            if (z) {
                C3319a.m14147a(th);
            }
        }
    }

    /* renamed from: d */
    public final void m11183d(String str) {
        C0700j.m2715b(str, "msg");
        INSTANCE.m11184d(APP_TAG, str);
    }

    public static /* synthetic */ void e$default(Log log, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        log.m11188e(str, z);
    }

    /* renamed from: e */
    public final void m11188e(String str, boolean z) {
        C0700j.m2715b(str, "msg");
        INSTANCE.m11186e(APP_TAG, "Exception", new Exception(str), z);
    }

    public static /* synthetic */ void e$default(Log log, Throwable th, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        log.m11189e(th, z);
    }

    /* renamed from: e */
    public final void m11189e(Throwable th, boolean z) {
        C0700j.m2715b(th, "tr");
        INSTANCE.m11186e(APP_TAG, "Exception", th, z);
    }

    public static /* synthetic */ void e$default(Log log, String str, Throwable th, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        log.m11187e(str, th, z);
    }

    /* renamed from: e */
    public final void m11187e(String str, Throwable th, boolean z) {
        C0700j.m2715b(str, "msg");
        C0700j.m2715b(th, "tr");
        INSTANCE.m11186e(APP_TAG, str, th, z);
    }

    public final void dTrace(String str, String str2) {
        C0700j.m2715b(str, "tag");
        C0700j.m2715b(str2, "msg");
        if (isEnabled) {
            Log log = INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getLogLocation());
            stringBuilder.append(str2);
            log.m11184d(str, stringBuilder.toString());
        }
    }

    public final void dTrace(String str) {
        C0700j.m2715b(str, "msg");
        dTrace(APP_TAG, str);
    }

    public final void eTrace(String str) {
        C0700j.m2715b(str, "msg");
        if (isEnabled) {
            Log log = INSTANCE;
            String str2 = APP_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getLogLocation());
            stringBuilder.append(str);
            log.m11185e(str2, stringBuilder.toString());
        }
    }

    public final void eTrace(Throwable th) {
        C0700j.m2715b(th, "throwable");
        if (isEnabled) {
            Log log = INSTANCE;
            String str = APP_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getLogLocation());
            stringBuilder.append("exception");
            e$default(log, str, stringBuilder.toString(), th, false, 8, null);
        }
    }

    public final void dumpOnSizeChanged(int i, int i2, int i3, int i4) {
        Log log = INSTANCE;
        String str = APP_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSizeChanged w=");
        stringBuilder.append(i);
        stringBuilder.append(" h=");
        stringBuilder.append(i2);
        stringBuilder.append(" oldw=");
        stringBuilder.append(i3);
        stringBuilder.append(" oldh=");
        stringBuilder.append(i4);
        log.m11184d(str, stringBuilder.toString());
    }

    public final void dumpOnMeasure(int i, int i2) {
        i = MeasureSpec.getSize(i);
        i2 = MeasureSpec.getSize(i2);
        Log log = INSTANCE;
        String str = APP_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onMeasure w=");
        stringBuilder.append(i);
        stringBuilder.append(" h=");
        stringBuilder.append(i2);
        log.m11184d(str, stringBuilder.toString());
    }

    public final void dumpOnLayout(boolean z, int i, int i2, int i3, int i4) {
        Log log = INSTANCE;
        String str = APP_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLayout changed=");
        stringBuilder.append(z);
        stringBuilder.append(" l=");
        stringBuilder.append(i);
        stringBuilder.append(" t=");
        stringBuilder.append(i2);
        stringBuilder.append(" r=");
        stringBuilder.append(i3);
        stringBuilder.append(" b=");
        stringBuilder.append(i4);
        log.m11184d(str, stringBuilder.toString());
    }

    public final String dump(Object obj) {
        C0700j.m2715b(obj, "o");
        return dump(obj, 0);
    }

    private final String dump(Object obj, int i) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Bundle) {
            return dumpBundle((Bundle) obj, i);
        }
        if (obj instanceof SparseArray) {
            return dumpSparseArray((SparseArray) obj, i);
        }
        return obj.toString();
    }

    public final String dumpSparseArray(SparseArray<?> sparseArray) {
        C0700j.m2715b(sparseArray, "array");
        return dumpSparseArray(sparseArray, 0);
    }

    private final String dumpSparseArray(SparseArray<?> sparseArray, int i) {
        if (sparseArray == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = sparseArray.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                stringBuilder.append('\n');
                int keyAt = sparseArray.keyAt(i2);
                Object valueAt = sparseArray.valueAt(i2);
                int i3 = i - 1;
                if (i3 >= 0) {
                    int i4 = 0;
                    while (true) {
                        stringBuilder.append("? ");
                        if (i4 == i3) {
                            break;
                        }
                        i4++;
                    }
                }
                stringBuilder.append(keyAt);
                stringBuilder.append(": ");
                stringBuilder.append(dump(valueAt, i + 1));
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        Object stringBuilder2 = stringBuilder.toString();
        C0700j.m2711a(stringBuilder2, "ret.toString()");
        return stringBuilder2;
    }

    public final String dumpBundle(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        return dumpBundle(bundle, 0);
    }

    private final String dumpBundle(Bundle bundle, int i) {
        if (bundle == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder.append('\n');
            Object obj = bundle.get(str);
            int i2 = 0;
            int i3 = i - 1;
            if (i3 >= 0) {
                while (true) {
                    stringBuilder.append("? ");
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(dump(obj, i + 1));
        }
        Object stringBuilder2 = stringBuilder.toString();
        C0700j.m2711a(stringBuilder2, "ret.toString()");
        return stringBuilder2;
    }

    public final void dumpCollection(Collection<?> collection) {
        C0700j.m2715b(collection, "collection");
        dumpCollection(APP_TAG, collection);
    }

    public final void dumpCollection(String str, Collection<?> collection) {
        C0700j.m2715b(str, "tag");
        C0700j.m2715b(collection, "collection");
        if (isEnabled && !collection.isEmpty()) {
            for (Object valueOf : collection) {
                INSTANCE.m11184d(str, String.valueOf(valueOf));
            }
        }
    }

    private final java.lang.String getLogLocation() {
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
        r12 = this;
        r0 = ru.gg.scooby.util.Log.class;
        r0 = r0.getCanonicalName();
        r1 = java.lang.Thread.currentThread();
        r2 = "Thread.currentThread()";
        p042b.p047e.p049b.C0700j.m2711a(r1, r2);
        r1 = r1.getStackTrace();
        r2 = "traces";
        p042b.p047e.p049b.C0700j.m2711a(r1, r2);
        r2 = r1.length;
        r3 = 0;
        r4 = 0;
        r5 = 0;
    L_0x001c:
        if (r4 >= r2) goto L_0x00ee;
    L_0x001e:
        r6 = r1[r4];
        r7 = 0;
        r8 = 2;
        r9 = 1;
        if (r5 == 0) goto L_0x00d0;
    L_0x0025:
        r10 = "trace";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r6, r10);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10 = r6.getClassName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r11 = "trace.className";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r10, r11);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r11 = "logClassName";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r0, r11);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = p042b.p053i.C4771n.m22207a(r10, r0, r3, r8, r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        if (r7 != 0) goto L_0x00ea;	 Catch:{ ClassNotFoundException -> 0x00ea }
    L_0x003e:
        r7 = r6.getClassName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = java.lang.Class.forName(r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = r1.length;	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = r8 - r9;	 Catch:{ ClassNotFoundException -> 0x00ea }
        if (r4 >= r8) goto L_0x0093;	 Catch:{ ClassNotFoundException -> 0x00ea }
    L_0x004a:
        r8 = r4 + 1;	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = r1[r8];	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = "prevTrace";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r8, r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = r8.getClassName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = java.lang.Class.forName(r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.<init>();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r11 = "[[";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r11);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r11 = "prevClazz";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r9, r11);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = r9.getSimpleName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = ":";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = r8.getMethodName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9 = "(";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r9);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = r8.getLineNumber();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r8);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = ")]] ";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10.append(r8);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = r10.toString();	 Catch:{ ClassNotFoundException -> 0x00ea }
        goto L_0x0095;	 Catch:{ ClassNotFoundException -> 0x00ea }
    L_0x0093:
        r8 = "";	 Catch:{ ClassNotFoundException -> 0x00ea }
    L_0x0095:
        r9 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.<init>();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r8);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = "[";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r8);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r8 = "clazz";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r7, r8);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = r7.getSimpleName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = ":";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = r6.getMethodName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r7 = "(";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r6 = r6.getLineNumber();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r6);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r6 = ")]: ";	 Catch:{ ClassNotFoundException -> 0x00ea }
        r9.append(r6);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r0 = r9.toString();	 Catch:{ ClassNotFoundException -> 0x00ea }
        return r0;	 Catch:{ ClassNotFoundException -> 0x00ea }
    L_0x00d0:
        r10 = "trace";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r6, r10);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r6 = r6.getClassName();	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10 = "trace.className";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r6, r10);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r10 = "logClassName";	 Catch:{ ClassNotFoundException -> 0x00ea }
        p042b.p047e.p049b.C0700j.m2711a(r0, r10);	 Catch:{ ClassNotFoundException -> 0x00ea }
        r6 = p042b.p053i.C4771n.m22207a(r6, r0, r3, r8, r7);	 Catch:{ ClassNotFoundException -> 0x00ea }
        if (r6 == 0) goto L_0x00ea;
    L_0x00e9:
        r5 = 1;
    L_0x00ea:
        r4 = r4 + 1;
        goto L_0x001c;
    L_0x00ee:
        r0 = "[]: ";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.Log.getLogLocation():java.lang.String");
    }

    private final void logExternal(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(priorityStr(i));
        stringBuilder.append(47);
        stringBuilder.append(str);
        stringBuilder.append(' ');
        stringBuilder.append(((SimpleDateFormat) LOG_TIME_FORMATTER.get()).format(Long.valueOf(System.currentTimeMillis())));
        stringBuilder.append(' ');
        stringBuilder.append(str2);
        C3319a.m14146a(stringBuilder.toString());
    }
}
