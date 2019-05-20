package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p187d.C2482d;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.model.GetVerifyCodeResponse;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.PhoneField;
import ru.gg.scooby.ui.input.form.Form;
import ru.gg.scooby.ui.input.form.Form.ErrorStateListener;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.PhoneUtils;
import ru.gg.scooby.util.StringExKt;
import ru.gg.scooby.util.UIUtils;
import ru.gg.scooby.util.UIUtilsKt;
import ru.skooby.R;

/* compiled from: PhoneInputController.kt */
public final class PhoneInputController extends BaseController implements ErrorStateListener {
    @BindView
    public TextView devSettingsButton;
    private Form form;
    @BindView
    public TextView nextButton;
    @BindView
    public EditText phoneEditText;
    @BindView
    public PinKeyboard pinKeyboard;
    @BindView
    public TextView termsText;

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$a */
    static final class C2683a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PhoneInputController f8305a;

        C2683a(PhoneInputController phoneInputController) {
            this.f8305a = phoneInputController;
        }

        public final void onClick(View view) {
            this.f8305a.requestSms();
        }
    }

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$b */
    static final class C2684b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PhoneInputController f8306a;

        C2684b(PhoneInputController phoneInputController) {
            this.f8306a = phoneInputController;
        }

        public final void onClick(View view) {
            this.f8306a.requestSms();
        }
    }

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$d */
    static final class C4223d<T> implements C2482d<C2468b> {
        /* renamed from: a */
        final /* synthetic */ PhoneInputController f12768a;

        C4223d(PhoneInputController phoneInputController) {
            this.f12768a = phoneInputController;
        }

        /* renamed from: a */
        public final void m18209a(C2468b c2468b) {
            ControllerExKt.showProgress$default(this.f12768a, null, 1, null);
        }
    }

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$c */
    static final class C4640c extends C3038k implements C0690b<String, C0727n> {
        final /* synthetic */ View $view;
        final /* synthetic */ PhoneInputController this$0;

        C4640c(PhoneInputController phoneInputController, View view) {
            this.this$0 = phoneInputController;
            this.$view = view;
            super(1);
        }

        /* renamed from: a */
        public final void m20531a(String str) {
            C0700j.m2715b(str, "it");
            C0818i router = this.this$0.getRouter();
            Object string = this.$view.getResources().getString(R.string.profile_terms);
            C0700j.m2711a(string, "view.resources.getString(R.string.profile_terms)");
            router.m3151b(C0820k.m3183a((C0809d) new WebUrlController(str, string)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
        }
    }

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$e */
    static final class C4641e extends C3038k implements C0690b<C2342r<GetVerifyCodeResponse>, C0727n> {
        final /* synthetic */ PhoneInputController this$0;

        C4641e(PhoneInputController phoneInputController) {
            this.this$0 = phoneInputController;
            super(1);
        }

        /* renamed from: a */
        public final void m20533a(p165d.C2342r<ru.gg.scooby.model.GetVerifyCodeResponse> r6) {
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
            if (r0 != r1) goto L_0x0103;
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
            r0.showPinScreen(r1);
            goto L_0x011a;
        L_0x0103:
            r6 = r5.this$0;
            r6 = r6.getView();
            if (r6 != 0) goto L_0x010e;
        L_0x010b:
            p042b.p047e.p049b.C0700j.m2709a();
        L_0x010e:
            r0 = r0.getErrorMessage();
            r1 = -1;
            r6 = com.google.android.material.snackbar.Snackbar.m15345a(r6, r0, r1);
            r6.mo1269f();
        L_0x011a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.ui.controller.PhoneInputController.e.a(d.r):void");
        }
    }

    /* compiled from: PhoneInputController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PhoneInputController$f */
    static final class C4642f extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ PhoneInputController this$0;

        C4642f(PhoneInputController phoneInputController) {
            this.this$0 = phoneInputController;
            super(1);
        }

        /* renamed from: a */
        public final void m20535a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
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

    public final EditText getPhoneEditText() {
        EditText editText = this.phoneEditText;
        if (editText == null) {
            C0700j.m2716b("phoneEditText");
        }
        return editText;
    }

    public final void setPhoneEditText(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.phoneEditText = editText;
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

    public final TextView getTermsText() {
        TextView textView = this.termsText;
        if (textView == null) {
            C0700j.m2716b("termsText");
        }
        return textView;
    }

    public final void setTermsText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.termsText = textView;
    }

    public final TextView getDevSettingsButton() {
        TextView textView = this.devSettingsButton;
        if (textView == null) {
            C0700j.m2716b("devSettingsButton");
        }
        return textView;
    }

    public final void setDevSettingsButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.devSettingsButton = textView;
    }

    public final Form getForm() {
        return this.form;
    }

    public final void setForm(Form form) {
        this.form = form;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_phone_input, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_input, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.colorPrimary), false));
        UIUtils uIUtils = UIUtils.INSTANCE;
        EditText editText = this.phoneEditText;
        if (editText == null) {
            C0700j.m2716b("phoneEditText");
        }
        uIUtils.setEditable(editText, false);
        PinKeyboard pinKeyboard = this.pinKeyboard;
        if (pinKeyboard == null) {
            C0700j.m2716b("pinKeyboard");
        }
        pinKeyboard.setListener(new PhoneInputController$onViewBound$1(this));
        pinKeyboard = this.pinKeyboard;
        if (pinKeyboard == null) {
            C0700j.m2716b("pinKeyboard");
        }
        pinKeyboard.getCheckMark().setOnClickListener(new C2683a(this));
        TextView textView = this.nextButton;
        if (textView == null) {
            C0700j.m2716b("nextButton");
        }
        textView.setOnClickListener(new C2684b(this));
        textView = this.termsText;
        if (textView == null) {
            C0700j.m2716b("termsText");
        }
        UIUtils uIUtils2 = UIUtils.INSTANCE;
        Resources resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        Object string = resources.getString(R.string.terms_of_service_notice);
        C0700j.m2711a(string, "resources!!.getString(R.….terms_of_service_notice)");
        textView.setText(uIUtils2.fromHtmlWithUrlAction(string, new C4640c(this, view)));
        view = this.termsText;
        if (view == null) {
            C0700j.m2716b("termsText");
        }
        view.setMovementMethod(LinkMovementMethod.getInstance());
        initForm();
        updateButtonsState();
        view = this.devSettingsButton;
        if (view == null) {
            C0700j.m2716b("devSettingsButton");
        }
        view.setVisibility(8);
    }

    @OnClick
    public final void onDevSettingsClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new DevSettingsController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    public final void initForm() {
        View view;
        this.form = new Form();
        Form form = this.form;
        if (form != null) {
            FieldId fieldId = FieldId.Phone;
            Resources resources = getResources();
            if (resources == null) {
                C0700j.m2709a();
            }
            Object string = resources.getString(R.string.phone_field);
            C0700j.m2711a(string, "resources!!.getString(R.string.phone_field)");
            EditText editText = this.phoneEditText;
            if (editText == null) {
                C0700j.m2716b("phoneEditText");
            }
            form.add(fieldId, new PhoneField(string, editText, null, false, 12, null));
        }
        form = this.form;
        if (form != null) {
            form.setErrorStateListener(this);
        }
        form = this.form;
        if (form != null) {
            Field field = form.getField(FieldId.Phone);
            if (field != null) {
                view = field.getView();
                if (view == null) {
                    ((TextView) view).addTextChangedListener(new PhoneInputController$initForm$1(this));
                }
                throw new C0724k("null cannot be cast to non-null type android.widget.TextView");
            }
        }
        view = null;
        if (view == null) {
            throw new C0724k("null cannot be cast to non-null type android.widget.TextView");
        }
        ((TextView) view).addTextChangedListener(new PhoneInputController$initForm$1(this));
    }

    public void onErrorStateChanged(Form form, boolean z) {
        C0700j.m2715b(form, "form");
        form = this.nextButton;
        if (form == null) {
            C0700j.m2716b("nextButton");
        }
        UIUtilsKt.setEnabledWithOpacity((View) form, z ^ 1);
    }

    public final void requestSms() {
        Form form = this.form;
        if (form != null) {
            if (form.validate()) {
                ApiManager apiManager = ApiManager.INSTANCE;
                EditText editText = this.phoneEditText;
                if (editText == null) {
                    C0700j.m2716b("phoneEditText");
                }
                Object b = apiManager.requestCode(StringExKt.removeNonDigits(editText.getText().toString())).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17727b((C2482d) new C4223d(this));
                C0700j.m2711a(b, "ApiManager.requestCode(p…gress()\n                }");
                addDisposable(C2517a.m10349a(b, new C4642f(this), null, new C4641e(this), 2, null));
            }
        }
    }

    public final void showPinScreen(long j) {
        C0818i router = getRouter();
        EditText editText = this.phoneEditText;
        if (editText == null) {
            C0700j.m2716b("phoneEditText");
        }
        router.m3151b(C0820k.m3183a((C0809d) new SmsPinController(editText.getText().toString(), j)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    public final void updateButtonsState() {
        EditText editText = this.phoneEditText;
        if (editText == null) {
            C0700j.m2716b("phoneEditText");
        }
        int i = 0;
        Object obj = StringExKt.removeNonDigits(editText.getText().toString()).length() == PhoneUtils.INSTANCE.getRUSSIA_PHONE_LENGTH_WITH_PREFIX() ? 1 : null;
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
}
