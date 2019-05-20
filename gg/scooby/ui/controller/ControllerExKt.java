package ru.gg.scooby.ui.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0819j;
import com.google.android.material.snackbar.Snackbar;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.ActionBarProvider;
import ru.gg.scooby.util.AppUtils;
import ru.gg.scooby.util.UIUtilsKt;
import ru.skooby.R;

/* compiled from: ControllerEx.kt */
public final class ControllerExKt {

    /* compiled from: ControllerEx.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ControllerExKt$a */
    static final class C2675a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C0809d f8294a;

        C2675a(C0809d c0809d) {
            this.f8294a = c0809d;
        }

        public final void onClick(View view) {
            view = AppUtils.INSTANCE;
            Object activity = this.f8294a.getActivity();
            if (activity == null) {
                C0700j.m2709a();
            }
            C0700j.m2711a(activity, "activity!!");
            view.openAppSettings((Context) activity);
        }
    }

    public static final void startActivityForUri(com.bluelinelabs.conductor.C0809d r7, android.net.Uri r8) {
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
        p042b.p047e.p049b.C0700j.m2715b(r7, r0);
        r0 = "uri";
        p042b.p047e.p049b.C0700j.m2715b(r8, r0);
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r0.<init>(r1);
        r0.setData(r8);
        r8 = r7.getActivity();	 Catch:{ Exception -> 0x001e }
        if (r8 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x001e }
    L_0x001a:
        r8.startActivity(r0);	 Catch:{ Exception -> 0x001e }
        goto L_0x0029;
    L_0x001e:
        r2 = 2131755161; // 0x7f100099 float:1.9141193E38 double:1.0532269904E-314;
        r3 = 0;
        r4 = 0;
        r5 = 6;
        r6 = 0;
        r1 = r7;
        showSnackbar$default(r1, r2, r3, r4, r5, r6);
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.controller.ControllerExKt.startActivityForUri(com.bluelinelabs.conductor.d, android.net.Uri):void");
    }

    public static final void setActionBar(C0809d c0809d, Toolbar toolbar) {
        C0700j.m2715b(c0809d, "receiver$0");
        C0700j.m2715b(toolbar, "toolbar");
        c0809d = c0809d.getActivity();
        if (c0809d != null) {
            ((ActionBarProvider) c0809d).setToolbar(toolbar);
            return;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.ActionBarProvider");
    }

    public static final C0092a getActionBar(C0809d c0809d) {
        C0700j.m2715b(c0809d, "receiver$0");
        c0809d = c0809d.getActivity();
        if (c0809d != null) {
            return ((ActionBarProvider) c0809d).getToolbar();
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.ActionBarProvider");
    }

    public static /* synthetic */ void showProgress$default(C0809d c0809d, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        showProgress(c0809d, view);
    }

    public static final void showProgress(C0809d c0809d, View view) {
        C0700j.m2715b(c0809d, "receiver$0");
        if (view == null) {
            view = c0809d.getView();
        }
        if (view != null) {
            c0809d = view.findViewById(R.id.progress_overlay);
            if (c0809d != null) {
                c0809d.setVisibility(null);
            }
        }
    }

    public static /* synthetic */ void hideProgress$default(C0809d c0809d, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        hideProgress(c0809d, view);
    }

    public static final void hideProgress(C0809d c0809d, View view) {
        C0700j.m2715b(c0809d, "receiver$0");
        if (view == null) {
            view = c0809d.getView();
        }
        if (view != null) {
            c0809d = view.findViewById(R.id.progress_overlay);
            if (c0809d != null) {
                c0809d.setVisibility(8);
            }
        }
    }

    public static final void showPermissionDeniedSnackbar(C0809d c0809d, int i) {
        C0700j.m2715b(c0809d, "receiver$0");
        View view = c0809d.getView();
        if (view == null) {
            C0700j.m2709a();
        }
        i = Snackbar.m15345a(view, i, -2);
        Resources resources = c0809d.getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        Object a = i.mo1268e(resources.getColor(R.color.blue_text)).m15348a((int) R.string.settings, (OnClickListener) new C2675a(c0809d));
        C0700j.m2711a(a, "Snackbar.make(view!!, me…ctivity!!)\n            })");
        a.mo1269f();
    }

    public static /* synthetic */ Snackbar showSnackbar$default(C0809d c0809d, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != null) {
            i2 = -1;
        }
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        return showSnackbar(c0809d, i, i2, i3);
    }

    public static final Snackbar showSnackbar(C0809d c0809d, int i, int i2, int i3) {
        C0700j.m2715b(c0809d, "receiver$0");
        View view = c0809d.getView();
        if (view == null) {
            return null;
        }
        Object a = Snackbar.m15345a(view, i, i2);
        C0700j.m2711a(a, "Snackbar.make(it, message, length)");
        if (i3 > 0) {
            UIUtilsKt.setMaxLines(a, i3);
        }
        a.mo1269f();
        return a;
    }

    public static final void safePopCurrentController(com.bluelinelabs.conductor.C0809d r1) {
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
        p042b.p047e.p049b.C0700j.m2715b(r1, r0);
        r1 = r1.getRouter();	 Catch:{ Exception -> 0x000c }
        r1.m3169l();	 Catch:{ Exception -> 0x000c }
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.controller.ControllerExKt.safePopCurrentController(com.bluelinelabs.conductor.d):void");
    }

    public static final boolean isTopController(C0809d c0809d) {
        C0700j.m2715b(c0809d, "receiver$0");
        Object router = c0809d.getRouter();
        C0700j.m2711a(router, "router");
        return C0700j.m2713a(C0819j.m3182b(router), (Object) c0809d);
    }
}
