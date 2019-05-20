package ru.gg.scooby.ui.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p187d.C2482d;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.concurrent.TimeUnit;
import p042b.C0687c;
import p042b.C0704e;
import p042b.C0727n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C0701o;
import p042b.p047e.p049b.C3038k;
import p042b.p047e.p049b.C4749n;
import p042b.p051g.C3045e;
import p165d.C2342r;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.model.GetVerifyCodeResponse;
import ru.gg.scooby.model.PostVerifyCodeResponse;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.gg.scooby.ui.custom.SmsPinView;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.DateUtils;
import ru.gg.scooby.util.StringExKt;
import ru.gg.scooby.util.UIUtilsKt;
import ru.skooby.R;

/* compiled from: SmsPinController.kt */
public final class SmsPinController extends BaseController {
    static final /* synthetic */ C3045e[] $$delegatedProperties = new C3045e[]{C0701o.m2720a(new C4749n(C0701o.m2719a(SmsPinController.class), "phoneNumberNoDigits", "getPhoneNumberNoDigits()Ljava/lang/String;"))};
    public static final String ARG_PHONE_NUMBER = "ARG_PHONE_NUMBER";
    public static final String ARG_RESEND_CODE_DURATION = "ARG_RESEND_CODE_DURATION";
    public static final Companion Companion = new Companion();
    @BindView
    public View backButton;
    @BindView
    public TextView nextButton;
    private final C0687c phoneNumberNoDigits$delegate;
    @BindView
    public PinKeyboard pinKeyboard;
    @BindView
    public TextView sendCodeAgainButton;
    @BindView
    public SmsPinView smsPinView;
    @BindView
    public TextView subtitleText;
    private C2468b timerDisposable;

    /* compiled from: SmsPinController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$a */
    static final class C2693a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SmsPinController f8316a;

        C2693a(SmsPinController smsPinController) {
            this.f8316a = smsPinController;
        }

        public final void onClick(View view) {
            this.f8316a.verifyCode();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$b */
    static final class C2694b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SmsPinController f8317a;

        C2694b(SmsPinController smsPinController) {
            this.f8317a = smsPinController;
        }

        public final void onClick(View view) {
            this.f8317a.verifyCode();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$c */
    static final class C2695c implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SmsPinController f8318a;

        C2695c(SmsPinController smsPinController) {
            this.f8318a = smsPinController;
        }

        public final void onClick(View view) {
            this.f8318a.getRouter().m3169l();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$d */
    static final class C2696d implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ SmsPinController f8319a;

        C2696d(SmsPinController smsPinController) {
            this.f8319a = smsPinController;
        }

        public final void onClick(View view) {
            this.f8319a.requestCode();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$h */
    static final class C4243h<T> implements C2482d<C2468b> {
        /* renamed from: a */
        final /* synthetic */ SmsPinController f12806a;

        C4243h(SmsPinController smsPinController) {
            this.f12806a = smsPinController;
        }

        /* renamed from: a */
        public final void m18231a(C2468b c2468b) {
            ControllerExKt.showProgress$default(this.f12806a, null, 1, null);
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$e */
    static final class C4657e extends C3038k implements C0689a<String> {
        final /* synthetic */ SmsPinController this$0;

        C4657e(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            return m20565b();
        }

        /* renamed from: b */
        public final String m20565b() {
            return StringExKt.removeNonDigits(this.this$0.getPhoneNumber());
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$f */
    static final class C4658f extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4658f(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20567a(C2342r<? extends Object> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                Analytics.INSTANCE.registration();
                this.this$0.showNextScreen();
                return;
            }
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$g */
    static final class C4659g extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4659g(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20569a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$i */
    static final class C4660i extends C3038k implements C0690b<C2342r<GetVerifyCodeResponse>, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4660i(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20571a(p165d.C2342r<ru.gg.scooby.model.GetVerifyCodeResponse> r6) {
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
            r5 = this;
            r0 = r5.this$0;
            r1 = 0;
            r2 = 1;
            ru.gg.scooby.ui.controller.ControllerExKt.hideProgress$default(r0, r1, r2, r1);
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.Companion;
            r2 = "it";
            p042b.p047e.p049b.C0700j.m2711a(r6, r2);
            r2 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r3 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r2 = p042b.p047e.p049b.C0700j.m2713a(r2, r3);
            r3 = 0;
            if (r2 == 0) goto L_0x0079;
        L_0x0019:
            r2 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r2 = r6.m9826c();
            if (r2 == 0) goto L_0x0026;
        L_0x0021:
            r2 = r6.m9827d();
            goto L_0x0040;
        L_0x0026:
            r2 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r2 = r2.getRetrofit();
            r4 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r4 = (java.lang.reflect.Type) r4;
            r3 = new java.lang.annotation.Annotation[r3];
            r2 = r2.m9844b(r4, r3);
            r3 = r6.m9828e();	 Catch:{ Exception -> 0x003f }
            r2 = r2.mo1722a(r3);	 Catch:{ Exception -> 0x003f }
            goto L_0x0040;
        L_0x003f:
            r2 = r1;
        L_0x0040:
            r2 = (ru.gg.scooby.model.GetVerifyCodeResponse) r2;
            if (r2 == 0) goto L_0x004e;
        L_0x0044:
            r3 = r2.getSmsRequest();
            if (r3 == 0) goto L_0x004e;
        L_0x004a:
            r1 = r3.getStatus();
        L_0x004e:
            if (r1 != 0) goto L_0x0052;
        L_0x0050:
            goto L_0x00e2;
        L_0x0052:
            r3 = ru.gg.scooby.ui.input.validator.ValidationCode.Companion.WhenMappings.$EnumSwitchMapping$0;
            r1 = r1.ordinal();
            r1 = r3[r1];
            switch(r1) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0071;
                case 3: goto L_0x005f;
                default: goto L_0x005d;
            };
        L_0x005d:
            goto L_0x00e2;
        L_0x005f:
            r0 = r2.getUserStatus();
            r0 = r0.getUntilDate();
            if (r0 == 0) goto L_0x006d;
        L_0x0069:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            goto L_0x00e6;
        L_0x006d:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            goto L_0x00e6;
        L_0x0071:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTimeout;
            goto L_0x00e6;
        L_0x0075:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            goto L_0x00e6;
        L_0x0079:
            r2 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r4 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r2 = p042b.p047e.p049b.C0700j.m2713a(r2, r4);
            if (r2 == 0) goto L_0x00e2;
        L_0x0083:
            r0 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r0 = r6.m9826c();
            if (r0 == 0) goto L_0x0090;
        L_0x008b:
            r0 = r6.m9827d();
            goto L_0x00aa;
        L_0x0090:
            r0 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r0 = r0.getRetrofit();
            r2 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r2 = (java.lang.reflect.Type) r2;
            r3 = new java.lang.annotation.Annotation[r3];
            r0 = r0.m9844b(r2, r3);
            r2 = r6.m9828e();	 Catch:{ Exception -> 0x00a9 }
            r0 = r0.mo1722a(r2);	 Catch:{ Exception -> 0x00a9 }
            goto L_0x00aa;
        L_0x00a9:
            r0 = r1;
        L_0x00aa:
            r0 = (ru.gg.scooby.model.PostVerifyCodeResponse) r0;
            if (r0 == 0) goto L_0x00b2;
        L_0x00ae:
            r1 = r0.getResult();
        L_0x00b2:
            r2 = ru.gg.scooby.model.VerifiedCodeResult.VALID;
            if (r1 != r2) goto L_0x00b9;
        L_0x00b6:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            goto L_0x00e6;
        L_0x00b9:
            if (r0 == 0) goto L_0x00cc;
        L_0x00bb:
            r1 = r0.getUserStatus();
            if (r1 == 0) goto L_0x00cc;
        L_0x00c1:
            r1 = r1.getCode();
            r2 = -152; // 0xffffffffffffff68 float:NaN double:NaN;
            if (r1 != r2) goto L_0x00cc;
        L_0x00c9:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            goto L_0x00e6;
        L_0x00cc:
            if (r0 == 0) goto L_0x00df;
        L_0x00ce:
            r0 = r0.getUserStatus();
            if (r0 == 0) goto L_0x00df;
        L_0x00d4:
            r0 = r0.getCode();
            r1 = -157; // 0xffffffffffffff63 float:NaN double:NaN;
            if (r0 != r1) goto L_0x00df;
        L_0x00dc:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            goto L_0x00e6;
        L_0x00df:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsWrongCode;
            goto L_0x00e6;
        L_0x00e2:
            r0 = r0.getCodeByResponse(r6);
        L_0x00e6:
            r1 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            if (r0 != r1) goto L_0x0108;
        L_0x00ea:
            r0 = r5.this$0;
            r6 = r6.m9827d();
            if (r6 != 0) goto L_0x00f5;
        L_0x00f2:
            p042b.p047e.p049b.C0700j.m2709a();
        L_0x00f5:
            r6 = (ru.gg.scooby.model.GetVerifyCodeResponse) r6;
            r6 = r6.getSmsRequest();
            r1 = r6.getTimeout();
            r0.startResendTimer(r1);
            r6 = r5.this$0;
            r6.requestDebugCode();
            goto L_0x0130;
        L_0x0108:
            r6 = r5.this$0;
            r6 = r6.getView();
            if (r6 != 0) goto L_0x0113;
        L_0x0110:
            p042b.p047e.p049b.C0700j.m2709a();
        L_0x0113:
            r1 = r0.getErrorMessage();
            r2 = -1;
            r6 = com.google.android.material.snackbar.Snackbar.m15345a(r6, r1, r2);
            r6.mo1269f();
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            if (r0 == r6) goto L_0x0127;
        L_0x0123:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            if (r0 != r6) goto L_0x0130;
        L_0x0127:
            r6 = r5.this$0;
            r6 = r6.getRouter();
            r6.m3169l();
        L_0x0130:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.controller.SmsPinController.i.a(d.r):void");
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$j */
    static final class C4661j extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4661j(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20573a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$k */
    static final class C4662k extends C3038k implements C0690b<Long, C0727n> {
        final /* synthetic */ long $durationMillis;
        final /* synthetic */ SmsPinController this$0;

        C4662k(SmsPinController smsPinController, long j) {
            this.this$0 = smsPinController;
            this.$durationMillis = j;
            super(1);
        }

        /* renamed from: a */
        public final void m20575a(Long l) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C0700j.m2711a((Object) l, "it");
            String str = null;
            if (timeUnit.toMillis(l.longValue()) >= this.$durationMillis) {
                l = this.this$0.getSendCodeAgainButton();
                Resources resources = this.this$0.getResources();
                if (resources != null) {
                    str = resources.getString(R.string.send_again);
                }
                l.setText(str);
                UIUtilsKt.setEnabledWithOpacity(this.this$0.getSendCodeAgainButton(), true);
                l = this.this$0.timerDisposable;
                if (l != null) {
                    l.mo1727a();
                    return;
                }
                return;
            }
            UIUtilsKt.setEnabledWithOpacity(this.this$0.getSendCodeAgainButton(), false);
            TextView sendCodeAgainButton = this.this$0.getSendCodeAgainButton();
            Resources resources2 = this.this$0.getResources();
            if (resources2 != null) {
                str = resources2.getString(R.string.send_again_in, new Object[]{DateUtils.INSTANCE.toMinutesSeconds(this.$durationMillis - TimeUnit.SECONDS.toMillis(l.longValue()))});
            }
            sendCodeAgainButton.setText(str);
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$l */
    static final class C4663l extends C3038k implements C0690b<C2342r<PostVerifyCodeResponse>, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4663l(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20577a(p165d.C2342r<ru.gg.scooby.model.PostVerifyCodeResponse> r6) {
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
            r5 = this;
            r0 = r5.this$0;
            r1 = 0;
            r2 = 1;
            ru.gg.scooby.ui.controller.ControllerExKt.hideProgress$default(r0, r1, r2, r1);
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.Companion;
            r2 = "it";
            p042b.p047e.p049b.C0700j.m2711a(r6, r2);
            r2 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r3 = ru.gg.scooby.model.GetVerifyCodeResponse.class;
            r2 = p042b.p047e.p049b.C0700j.m2713a(r2, r3);
            r3 = 0;
            if (r2 == 0) goto L_0x0079;
        L_0x0019:
            r2 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r2 = r6.m9826c();
            if (r2 == 0) goto L_0x0026;
        L_0x0021:
            r2 = r6.m9827d();
            goto L_0x0040;
        L_0x0026:
            r2 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r2 = r2.getRetrofit();
            r4 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r4 = (java.lang.reflect.Type) r4;
            r3 = new java.lang.annotation.Annotation[r3];
            r2 = r2.m9844b(r4, r3);
            r3 = r6.m9828e();	 Catch:{ Exception -> 0x003f }
            r2 = r2.mo1722a(r3);	 Catch:{ Exception -> 0x003f }
            goto L_0x0040;
        L_0x003f:
            r2 = r1;
        L_0x0040:
            r2 = (ru.gg.scooby.model.GetVerifyCodeResponse) r2;
            if (r2 == 0) goto L_0x004e;
        L_0x0044:
            r3 = r2.getSmsRequest();
            if (r3 == 0) goto L_0x004e;
        L_0x004a:
            r1 = r3.getStatus();
        L_0x004e:
            if (r1 != 0) goto L_0x0052;
        L_0x0050:
            goto L_0x00e2;
        L_0x0052:
            r3 = ru.gg.scooby.ui.input.validator.ValidationCode.Companion.WhenMappings.$EnumSwitchMapping$0;
            r1 = r1.ordinal();
            r1 = r3[r1];
            switch(r1) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0071;
                case 3: goto L_0x005f;
                default: goto L_0x005d;
            };
        L_0x005d:
            goto L_0x00e2;
        L_0x005f:
            r6 = r2.getUserStatus();
            r6 = r6.getUntilDate();
            if (r6 == 0) goto L_0x006d;
        L_0x0069:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            goto L_0x00e6;
        L_0x006d:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            goto L_0x00e6;
        L_0x0071:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTimeout;
            goto L_0x00e6;
        L_0x0075:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            goto L_0x00e6;
        L_0x0079:
            r2 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r4 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r2 = p042b.p047e.p049b.C0700j.m2713a(r2, r4);
            if (r2 == 0) goto L_0x00e2;
        L_0x0083:
            r0 = ru.gg.scooby.network.ResponseConverter.INSTANCE;
            r0 = r6.m9826c();
            if (r0 == 0) goto L_0x0090;
        L_0x008b:
            r6 = r6.m9827d();
            goto L_0x00aa;
        L_0x0090:
            r0 = ru.gg.scooby.network.ApiManager.INSTANCE;
            r0 = r0.getRetrofit();
            r2 = ru.gg.scooby.model.PostVerifyCodeResponse.class;
            r2 = (java.lang.reflect.Type) r2;
            r3 = new java.lang.annotation.Annotation[r3];
            r0 = r0.m9844b(r2, r3);
            r6 = r6.m9828e();	 Catch:{ Exception -> 0x00a9 }
            r6 = r0.mo1722a(r6);	 Catch:{ Exception -> 0x00a9 }
            goto L_0x00aa;
        L_0x00a9:
            r6 = r1;
        L_0x00aa:
            r6 = (ru.gg.scooby.model.PostVerifyCodeResponse) r6;
            if (r6 == 0) goto L_0x00b2;
        L_0x00ae:
            r1 = r6.getResult();
        L_0x00b2:
            r0 = ru.gg.scooby.model.VerifiedCodeResult.VALID;
            if (r1 != r0) goto L_0x00b9;
        L_0x00b6:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            goto L_0x00e6;
        L_0x00b9:
            if (r6 == 0) goto L_0x00cc;
        L_0x00bb:
            r0 = r6.getUserStatus();
            if (r0 == 0) goto L_0x00cc;
        L_0x00c1:
            r0 = r0.getCode();
            r1 = -152; // 0xffffffffffffff68 float:NaN double:NaN;
            if (r0 != r1) goto L_0x00cc;
        L_0x00c9:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            goto L_0x00e6;
        L_0x00cc:
            if (r6 == 0) goto L_0x00df;
        L_0x00ce:
            r6 = r6.getUserStatus();
            if (r6 == 0) goto L_0x00df;
        L_0x00d4:
            r6 = r6.getCode();
            r0 = -157; // 0xffffffffffffff63 float:NaN double:NaN;
            if (r6 != r0) goto L_0x00df;
        L_0x00dc:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            goto L_0x00e6;
        L_0x00df:
            r6 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsWrongCode;
            goto L_0x00e6;
        L_0x00e2:
            r6 = r0.getCodeByResponse(r6);
        L_0x00e6:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.Ok;
            if (r6 != r0) goto L_0x00f0;
        L_0x00ea:
            r6 = r5.this$0;
            r6.postLogin();
            goto L_0x0123;
        L_0x00f0:
            r0 = r5.this$0;
            r0 = r0.getSmsPinView();
            r1 = "";
            r0.setPinValue(r1);
            r0 = r5.this$0;
            r0 = r0.getView();
            if (r0 != 0) goto L_0x0106;
        L_0x0103:
            p042b.p047e.p049b.C0700j.m2709a();
        L_0x0106:
            r1 = r6.getErrorMessage();
            r2 = -1;
            r0 = com.google.android.material.snackbar.Snackbar.m15345a(r0, r1, r2);
            r0.mo1269f();
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsPermanentBlocked;
            if (r6 == r0) goto L_0x011a;
        L_0x0116:
            r0 = ru.gg.scooby.ui.input.validator.ValidationCode.SmsTemporaryBlocked;
            if (r6 != r0) goto L_0x0123;
        L_0x011a:
            r6 = r5.this$0;
            r6 = r6.getRouter();
            r6.m3169l();
        L_0x0123:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.controller.SmsPinController.l.a(d.r):void");
        }
    }

    /* compiled from: SmsPinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SmsPinController$m */
    static final class C4664m extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SmsPinController this$0;

        C4664m(SmsPinController smsPinController) {
            this.this$0 = smsPinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20579a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    public final String getPhoneNumberNoDigits() {
        C0687c c0687c = this.phoneNumberNoDigits$delegate;
        C3045e c3045e = $$delegatedProperties[0];
        return (String) c0687c.mo625a();
    }

    public final void requestDebugCode() {
    }

    public SmsPinController(String str, long j) {
        C0700j.m2715b(str, "phone");
        this(new BundleBuilder(new Bundle()).putString(ARG_PHONE_NUMBER, str).putLong(ARG_RESEND_CODE_DURATION, j).build());
    }

    public SmsPinController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        this.phoneNumberNoDigits$delegate = C0704e.m2726a((C0689a) new C4657e(this));
    }

    public final PinKeyboard getPinKeyboard() {
        PinKeyboard pinKeyboard = this.pinKeyboard;
        if (pinKeyboard == null) {
            C0700j.m2716b("pinKeyboard");
        }
        return pinKeyboard;
    }

    public final void setPinKeyboard(PinKeyboard pinKeyboard) {
        C0700j.m2715b(pinKeyboard, "<set-?>");
        this.pinKeyboard = pinKeyboard;
    }

    public final SmsPinView getSmsPinView() {
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        return smsPinView;
    }

    public final void setSmsPinView(SmsPinView smsPinView) {
        C0700j.m2715b(smsPinView, "<set-?>");
        this.smsPinView = smsPinView;
    }

    public final TextView getSendCodeAgainButton() {
        TextView textView = this.sendCodeAgainButton;
        if (textView == null) {
            C0700j.m2716b("sendCodeAgainButton");
        }
        return textView;
    }

    public final void setSendCodeAgainButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.sendCodeAgainButton = textView;
    }

    public final TextView getNextButton() {
        TextView textView = this.nextButton;
        if (textView == null) {
            C0700j.m2716b("nextButton");
        }
        return textView;
    }

    public final void setNextButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.nextButton = textView;
    }

    public final TextView getSubtitleText() {
        TextView textView = this.subtitleText;
        if (textView == null) {
            C0700j.m2716b("subtitleText");
        }
        return textView;
    }

    public final void setSubtitleText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.subtitleText = textView;
    }

    public final View getBackButton() {
        View view = this.backButton;
        if (view == null) {
            C0700j.m2716b("backButton");
        }
        return view;
    }

    public final void setBackButton(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.backButton = view;
    }

    public final String getPhoneNumber() {
        Object string = getArgs().getString(ARG_PHONE_NUMBER);
        C0700j.m2711a(string, "args.getString(ARG_PHONE_NUMBER)");
        return string;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_sms_pin, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ms_pin, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        String string;
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = this.pinKeyboard;
        if (view == null) {
            C0700j.m2716b("pinKeyboard");
        }
        view.setListener(new SmsPinController$onViewBound$1(this));
        view = this.pinKeyboard;
        if (view == null) {
            C0700j.m2716b("pinKeyboard");
        }
        view.getCheckMark().setOnClickListener(new C2693a(this));
        view = this.nextButton;
        if (view == null) {
            C0700j.m2716b("nextButton");
        }
        view.setOnClickListener(new C2694b(this));
        view = this.backButton;
        if (view == null) {
            C0700j.m2716b("backButton");
        }
        view.setOnClickListener(new C2695c(this));
        view = this.sendCodeAgainButton;
        if (view == null) {
            C0700j.m2716b("sendCodeAgainButton");
        }
        view.setOnClickListener(new C2696d(this));
        view = this.subtitleText;
        if (view == null) {
            C0700j.m2716b("subtitleText");
        }
        Resources resources = getResources();
        if (resources != null) {
            string = resources.getString(R.string.sms_message_sent, new Object[]{getPhoneNumber()});
        } else {
            string = null;
        }
        view.setText(string);
        updateButtonsState();
        startResendTimer(getArgs().getLong(ARG_RESEND_CODE_DURATION));
        requestDebugCode();
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        C2468b c2468b = this.timerDisposable;
        if (c2468b != null) {
            c2468b.mo1727a();
        }
        super.onDestroyView(view);
    }

    public final void requestCode() {
        Object b = ApiManager.INSTANCE.requestCode(getPhoneNumberNoDigits()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17727b((C2482d) new C4243h(this));
        C0700j.m2711a(b, "ApiManager.requestCode(p…gress()\n                }");
        addDisposable(C2517a.m10349a(b, new C4661j(this), null, new C4660i(this), 2, null));
    }

    public final void verifyCode() {
        ControllerExKt.showProgress$default(this, null, 1, null);
        ApiManager apiManager = ApiManager.INSTANCE;
        String phoneNumberNoDigits = getPhoneNumberNoDigits();
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        Object a = apiManager.verifyCode(phoneNumberNoDigits, smsPinView.getPinValue()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.verifyCode(ph…dSchedulers.mainThread())");
        addDisposable(C2517a.m10349a(a, new C4664m(this), null, new C4663l(this), 2, null));
    }

    public final void postLogin() {
        ControllerExKt.showProgress$default(this, null, 1, null);
        Object a = ApiManager.INSTANCE.postLogin(getPhoneNumberNoDigits()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.postLogin(pho…dSchedulers.mainThread())");
        addDisposable(C2517a.m10349a(a, new C4659g(this), null, new C4658f(this), 2, null));
    }

    public final void startResendTimer(long j) {
        C2468b c2468b = this.timerDisposable;
        if (c2468b != null) {
            c2468b.mo1727a();
        }
        Object a = C4050f.m17701a(0, 1, TimeUnit.SECONDS).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "Observable\n             …dSchedulers.mainThread())");
        this.timerDisposable = C2517a.m10349a(a, null, null, new C4662k(this, j), 3, null);
    }

    public final void updateButtonsState() {
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        int i = 0;
        boolean z = smsPinView.getPinValue().length() == 4;
        TextView textView = this.nextButton;
        if (textView == null) {
            C0700j.m2716b("nextButton");
        }
        UIUtilsKt.setEnabledWithOpacity(textView, z);
        PinKeyboard pinKeyboard = this.pinKeyboard;
        if (pinKeyboard == null) {
            C0700j.m2716b("pinKeyboard");
        }
        View checkMark = pinKeyboard.getCheckMark();
        if (!z) {
            i = 8;
        }
        checkMark.setVisibility(i);
    }

    public final void showNextScreen() {
        C0818i router = getRouter();
        if (router != null) {
            Object b = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b());
            C0700j.m2711a(b, "RouterTransaction.with(S…orizontalChangeHandler())");
            C0819j.m3181a(router, b);
        }
    }
}
