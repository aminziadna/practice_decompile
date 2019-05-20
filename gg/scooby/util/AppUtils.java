package ru.gg.scooby.util;

import android.content.Context;
import android.content.Intent;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.skooby.R;

/* compiled from: AppUtils.kt */
public final class AppUtils {
    public static final AppUtils INSTANCE = new AppUtils();

    private AppUtils() {
    }

    public final java.lang.String getVersionName() {
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
        r3 = this;
        r0 = ru.gg.scooby.ContextProvider.INSTANCE;	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r0.getContext();	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r1.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = "context.packageManager.g…ckageName, 0).versionName";	 Catch:{ NameNotFoundException -> 0x001b }
        p042b.p047e.p049b.C0700j.m2711a(r0, r1);	 Catch:{ NameNotFoundException -> 0x001b }
        return r0;
    L_0x001b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.AppUtils.getVersionName():java.lang.String");
    }

    public final void openAppSettings(android.content.Context r5) {
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
        r4 = this;
        r0 = "context";
        p042b.p047e.p049b.C0700j.m2715b(r5, r0);
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "android.settings.APPLICATION_DETAILS_SETTINGS";
        r0.setAction(r1);
        r1 = "package";
        r2 = r5.getPackageName();
        r3 = 0;
        r1 = android.net.Uri.fromParts(r1, r2, r3);
        r0.setData(r1);
        r5.startActivity(r0);	 Catch:{ Exception -> 0x0021 }
        goto L_0x002b;
    L_0x0021:
        r0 = new android.content.Intent;
        r1 = "android.settings.SETTINGS";
        r0.<init>(r1);
        r5.startActivity(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.AppUtils.openAppSettings(android.content.Context):void");
    }

    public final void openShareApp(Context context) {
        C0700j.m2715b(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.share_app_subject));
        intent.putExtra("android.intent.extra.TEXT", context.getString(R.string.share_app_text, new Object[]{context.getString(R.string.share_app_url)}));
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_app_subject)));
    }

    public static /* synthetic */ Intent getVoiceRecognitionIntent$default(AppUtils appUtils, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != null) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = "ru-RU";
        }
        return appUtils.getVoiceRecognitionIntent(i, str);
    }

    public final Intent getVoiceRecognitionIntent(int i, String str) {
        C0700j.m2715b(str, "language");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("calling_package", ContextProvider.INSTANCE.getContext().getPackageName());
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
        intent.putExtra("android.speech.extra.LANGUAGE", str);
        if (i > 0) {
            intent.putExtra("android.speech.extra.PROMPT", ContextProvider.INSTANCE.getContext().getResources().getString(i));
        }
        return intent;
    }

    public final void goToMarket() {
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
        r7 = this;
        r0 = ru.gg.scooby.ContextProvider.INSTANCE;
        r0 = r0.getContext();
        r1 = r0.getPackageName();
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r3 = new java.lang.StringBuilder;	 Catch:{ ActivityNotFoundException -> 0x002f }
        r3.<init>();	 Catch:{ ActivityNotFoundException -> 0x002f }
        r4 = "market://details?id=";	 Catch:{ ActivityNotFoundException -> 0x002f }
        r3.append(r4);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r3.append(r1);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r3 = r3.toString();	 Catch:{ ActivityNotFoundException -> 0x002f }
        r3 = android.net.Uri.parse(r3);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r4 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x002f }
        r5 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x002f }
        r4.<init>(r5, r3);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r4.setFlags(r2);	 Catch:{ ActivityNotFoundException -> 0x002f }
        r0.startActivity(r4);	 Catch:{ ActivityNotFoundException -> 0x002f }
        goto L_0x0051;
    L_0x002f:
        r3 = new android.content.Intent;
        r4 = "android.intent.action.VIEW";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "http://play.google.com/store/apps/details?id=";
        r5.append(r6);
        r5.append(r1);
        r1 = r5.toString();
        r1 = android.net.Uri.parse(r1);
        r3.<init>(r4, r1);
        r3.setFlags(r2);
        r0.startActivity(r3);
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.AppUtils.goToMarket():void");
    }
}
