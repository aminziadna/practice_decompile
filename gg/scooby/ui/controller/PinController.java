package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C4333c.C0095a;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.gms.p122e.C1425e;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.iid.C1654a;
import com.google.firebase.iid.FirebaseInstanceId;
import io.card.payment.BuildConfig;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.DeviceManager;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Pin;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.gg.scooby.ui.custom.SmsPinView;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.Log;
import ru.skooby.R;

/* compiled from: PinController.kt */
public final class PinController extends BaseController {
    public static final String ARG_OPERATION_TYPE = "ARG_OPERATION_TYPE";
    public static final Companion Companion = new Companion();
    public static final int OPERATION_CREATE = 0;
    public static final int OPERATION_ENTER = 1;
    public static final int PIN_LENGTH = 4;
    private String firstEnteredPin;
    @BindView
    public TextView forgotPasswordButton;
    private boolean isEnteringConfirmation;
    @BindView
    public PinKeyboard pinKeyboard;
    @BindView
    public SmsPinView smsPinView;
    @BindView
    public TextView titleText;

    /* compiled from: PinController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[ValidationCode.values().length];

        static {
            $EnumSwitchMapping$0[ValidationCode.Ok.ordinal()] = 1;
            $EnumSwitchMapping$1 = new int[ValidationCode.values().length];
            $EnumSwitchMapping$1[ValidationCode.Ok.ordinal()] = 1;
            $EnumSwitchMapping$1[ValidationCode.WrongPin.ordinal()] = 2;
            $EnumSwitchMapping$1[ValidationCode.WrongPinLocked.ordinal()] = 3;
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$a */
    static final class C2686a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PinController f8308a;
        /* renamed from: b */
        final /* synthetic */ View f8309b;

        C2686a(PinController pinController, View view) {
            this.f8308a = pinController;
            this.f8309b = view;
        }

        public final void onClick(View view) {
            new C0095a(this.f8309b.getContext()).m294a((int) R.string.forgot_password_message).m295a((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C0700j.m2715b(dialogInterface, "dialogInterface");
                    UserManager.INSTANCE.logout();
                    this.f8308a.showNextScreen();
                }
            }).m302b(R.string.no, null).m303b().show();
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$g */
    static final class C2687g implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ PinController f8310a;

        C2687g(PinController pinController) {
            this.f8310a = pinController;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            UserManager.INSTANCE.logout();
            this.f8310a.showNextScreen();
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$f */
    static final class C4225f<TResult> implements C1425e<C1654a> {
        /* renamed from: a */
        public static final C4225f f12771a = new C4225f();

        C4225f() {
        }

        /* renamed from: a */
        public final void m18212a(C1654a c1654a) {
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FirebaseInstanceId result id = ");
            C0700j.m2711a((Object) c1654a, "it");
            stringBuilder.append(c1654a.mo1297a());
            stringBuilder.append(" token = ");
            stringBuilder.append(c1654a.mo1298b());
            log.m11183d(stringBuilder.toString());
            UserManager userManager = UserManager.INSTANCE;
            Object b = c1654a.mo1298b();
            C0700j.m2711a(b, "it.token");
            userManager.updateDeviceIdToken(b);
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$b */
    static final class C4643b extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ PinController this$0;

        C4643b(PinController pinController) {
            this.this$0 = pinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20537a(C2342r<Void> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ru.gg.scooby.ui.input.validator.ValidationCode.Companion companion = ValidationCode.Companion;
            C0700j.m2711a((Object) c2342r, "it");
            if (WhenMappings.$EnumSwitchMapping$0[companion.getCodeByResponse(c2342r).ordinal()] != 1) {
                this.this$0.showReAuthDialog(R.string.error_message_session_expired);
                return;
            }
            Analytics.INSTANCE.pinCodeSet();
            this.this$0.showNextScreen();
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$c */
    static final class C4644c extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ PinController this$0;

        C4644c(PinController pinController) {
            this.this$0 = pinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20539a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$d */
    static final class C4645d extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ PinController this$0;

        C4645d(PinController pinController) {
            this.this$0 = pinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20541a(C2342r<? extends Object> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ru.gg.scooby.ui.input.validator.ValidationCode.Companion companion = ValidationCode.Companion;
            C0700j.m2711a((Object) c2342r, "it");
            c2342r = companion.getCodeByResponse(c2342r);
            switch (c2342r) {
                case Ok:
                    Analytics.INSTANCE.authPin(true);
                    this.this$0.showNextScreen();
                    return;
                case WrongPin:
                    Analytics.INSTANCE.authPin(false);
                    this.this$0.getSmsPinView().setPinValue(BuildConfig.FLAVOR);
                    this.this$0.showWrongPin();
                    return;
                case WrongPinLocked:
                    Analytics.INSTANCE.authPin(false);
                    this.this$0.showReAuthDialog(c2342r.getErrorMessage());
                    return;
                default:
                    Analytics.INSTANCE.authPin(false);
                    this.this$0.getSmsPinView().setPinValue(BuildConfig.FLAVOR);
                    View view = this.this$0.getView();
                    if (view == null) {
                        C0700j.m2709a();
                    }
                    Snackbar.m15345a(view, c2342r.getErrorMessage(), -1).mo1269f();
                    return;
            }
        }
    }

    /* compiled from: PinController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PinController$e */
    static final class C4646e extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ PinController this$0;

        C4646e(PinController pinController) {
            this.this$0 = pinController;
            super(1);
        }

        /* renamed from: a */
        public final void m20543a(Throwable th) {
            C0700j.m2715b(th, "it");
            Analytics.INSTANCE.authPin(false);
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            this.this$0.getSmsPinView().setPinValue(BuildConfig.FLAVOR);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    public PinController(int i) {
        this(new BundleBuilder(new Bundle()).putInt("ARG_OPERATION_TYPE", i).build());
    }

    public PinController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        this.firstEnteredPin = BuildConfig.FLAVOR;
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

    public final TextView getTitleText() {
        TextView textView = this.titleText;
        if (textView == null) {
            C0700j.m2716b("titleText");
        }
        return textView;
    }

    public final void setTitleText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.titleText = textView;
    }

    public final TextView getForgotPasswordButton() {
        TextView textView = this.forgotPasswordButton;
        if (textView == null) {
            C0700j.m2716b("forgotPasswordButton");
        }
        return textView;
    }

    public final void setForgotPasswordButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.forgotPasswordButton = textView;
    }

    public final int getOperationType() {
        return getArgs().getInt("ARG_OPERATION_TYPE");
    }

    public final boolean isEnteringConfirmation() {
        return this.isEnteringConfirmation;
    }

    public final void setEnteringConfirmation(boolean z) {
        this.isEnteringConfirmation = z;
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        smsPinView.setPinValue(BuildConfig.FLAVOR);
        TextView textView = this.titleText;
        if (textView == null) {
            C0700j.m2716b("titleText");
        }
        textView.setText(z ? true : true);
    }

    public final String getFirstEnteredPin() {
        return this.firstEnteredPin;
    }

    public final void setFirstEnteredPin(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.firstEnteredPin = str;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_pin, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…er_pin, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        int i = 0;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.colorPrimary), false));
        TextView textView = this.titleText;
        if (textView == null) {
            C0700j.m2716b("titleText");
        }
        textView.setText(getOperationType() == 0 ? R.string.pin_create_title : R.string.pin_enter_title);
        textView = this.forgotPasswordButton;
        if (textView == null) {
            C0700j.m2716b("forgotPasswordButton");
        }
        if (getOperationType() == 0) {
            i = 8;
        }
        textView.setVisibility(i);
        textView = this.forgotPasswordButton;
        if (textView == null) {
            C0700j.m2716b("forgotPasswordButton");
        }
        textView.setOnClickListener(new C2686a(this, view));
        view = this.pinKeyboard;
        if (view == null) {
            C0700j.m2716b("pinKeyboard");
        }
        view.setListener(new PinController$onViewBound$2(this));
    }

    public final void updateButtonsState() {
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        int i = 0;
        Object obj = smsPinView.getPinValue().length() == 4 ? 1 : null;
        PinKeyboard pinKeyboard = this.pinKeyboard;
        if (pinKeyboard == null) {
            C0700j.m2716b("pinKeyboard");
        }
        View checkMark = pinKeyboard.getCheckMark();
        if (obj == null) {
            i = 8;
        }
        checkMark.setVisibility(i);
    }

    public final void processEnteredPin() {
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        Object pinValue = smsPinView.getPinValue();
        if (pinValue.length() >= 4) {
            Object a;
            if (getOperationType() != 0) {
                ControllerExKt.showProgress$default(this, null, 1, null);
                a = ApiManager.INSTANCE.pinLogin(UserManager.INSTANCE.getPhone(), new Pin(DeviceManager.INSTANCE.getDeviceId(), pinValue)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a, "ApiManager.pinLogin(User…dSchedulers.mainThread())");
                addDisposable(C2517a.m10349a(a, new C4646e(this), null, new C4645d(this), 2, null));
            } else if (!this.isEnteringConfirmation) {
                this.firstEnteredPin = pinValue;
                setEnteringConfirmation(true);
            } else if ((C0700j.m2713a(this.firstEnteredPin, pinValue) ^ 1) != 0) {
                setEnteringConfirmation(false);
                View view = getView();
                if (view == null) {
                    C0700j.m2709a();
                }
                Snackbar.m15345a(view, (int) R.string.error_message_passwords_not_match, -1).mo1269f();
            } else {
                ControllerExKt.showProgress$default(this, null, 1, null);
                a = ApiManager.INSTANCE.pinSet(new Pin(DeviceManager.INSTANCE.getDeviceId(), pinValue)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a, "ApiManager.pinSet(Pin(de…dSchedulers.mainThread())");
                addDisposable(C2517a.m10349a(a, new C4644c(this), null, new C4643b(this), 2, null));
            }
        }
    }

    public final void showNextScreen() {
        Object router = getRouter();
        C0700j.m2711a(router, "router");
        Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
        C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
        C0819j.m3181a(router, a);
        router = FirebaseInstanceId.m6113a();
        C0700j.m2711a(router, "FirebaseInstanceId.getInstance()");
        router.m6134d().mo1173a((C1425e) C4225f.f12771a);
    }

    public final void showWrongPin() {
        SmsPinView smsPinView = this.smsPinView;
        if (smsPinView == null) {
            C0700j.m2716b("smsPinView");
        }
        smsPinView.setPinValue(BuildConfig.FLAVOR);
        View view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        Snackbar.m15345a(view, ValidationCode.WrongPin.getErrorMessage(), -1).mo1269f();
    }

    public final void showReAuthDialog(int i) {
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        new C0095a(view.getContext()).m294a(i).m295a(17039370, null).m296a((OnDismissListener) new C2687g(this)).m303b().show();
    }
}
