package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.List;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.TemplatesManager;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.ui.input.form.Form;
import ru.gg.scooby.ui.input.form.Form.ErrorStateListener;
import ru.gg.scooby.ui.input.validator.AccountNumberValidator;
import ru.gg.scooby.ui.input.validator.BikValidator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.UIUtilsKt;
import ru.skooby.R;

/* compiled from: CreateTemplateController.kt */
public final class CreateTemplateController extends BaseController implements ErrorStateListener {
    private Snackbar currentSnackbar;
    private final Form form = new Form();
    @BindView
    public TextView nextButton;
    @BindView
    public EditText textAccount;
    @BindView
    public EditText textBik;
    @BindView
    public EditText textFio;
    @BindView
    public EditText textTemplateName;
    @BindView
    public Toolbar toolbar;

    /* compiled from: CreateTemplateController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CreateTemplateController$a */
    static final class C4628a extends C3038k implements C0690b<C2342r<PaymentTemplate>, C0727n> {
        final /* synthetic */ CreateTemplateController this$0;

        C4628a(CreateTemplateController createTemplateController) {
            this.this$0 = createTemplateController;
            super(1);
        }

        /* renamed from: a */
        public final void m20507a(C2342r<PaymentTemplate> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                Object obj = (PaymentTemplate) c2342r.m9827d();
                if (obj != null) {
                    List templates = TemplatesManager.INSTANCE.getTemplates();
                    if (templates != null) {
                        C0700j.m2711a(obj, "paymentTemplate");
                        templates.add(obj);
                    }
                }
                PaymentTemplate paymentTemplate = (PaymentTemplate) c2342r.m9827d();
                if (paymentTemplate != null) {
                    C0818i router = this.this$0.getRouter();
                    C0700j.m2711a((Object) paymentTemplate, "it");
                    router.m3158c(C0820k.m3183a((C0809d) new PaymentCheckController(paymentTemplate)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
                    return;
                }
                ControllerExKt.showSnackbar$default((C0809d) this.this$0, ValidationCode.UnknownError.getErrorMessage(), 0, 0, 6, null);
                return;
            }
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: CreateTemplateController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CreateTemplateController$b */
    static final class C4629b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ CreateTemplateController this$0;

        C4629b(CreateTemplateController createTemplateController) {
            this.this$0 = createTemplateController;
            super(1);
        }

        /* renamed from: a */
        public final void m20509a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public CreateTemplateController() {
        setHasOptionsMenu(true);
    }

    public final Toolbar getToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        return toolbar;
    }

    public final void setToolbar(Toolbar toolbar) {
        C0700j.m2715b(toolbar, "<set-?>");
        this.toolbar = toolbar;
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

    public final EditText getTextFio() {
        EditText editText = this.textFio;
        if (editText == null) {
            C0700j.m2716b("textFio");
        }
        return editText;
    }

    public final void setTextFio(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.textFio = editText;
    }

    public final EditText getTextAccount() {
        EditText editText = this.textAccount;
        if (editText == null) {
            C0700j.m2716b("textAccount");
        }
        return editText;
    }

    public final void setTextAccount(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.textAccount = editText;
    }

    public final EditText getTextBik() {
        EditText editText = this.textBik;
        if (editText == null) {
            C0700j.m2716b("textBik");
        }
        return editText;
    }

    public final void setTextBik(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.textBik = editText;
    }

    public final EditText getTextTemplateName() {
        EditText editText = this.textTemplateName;
        if (editText == null) {
            C0700j.m2716b("textTemplateName");
        }
        return editText;
    }

    public final void setTextTemplateName(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.textTemplateName = editText;
    }

    public final Form getForm() {
        return this.form;
    }

    public final Snackbar getCurrentSnackbar() {
        return this.currentSnackbar;
    }

    public final void setCurrentSnackbar(Snackbar snackbar) {
        this.currentSnackbar = snackbar;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_create_template, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…mplate, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        initAppBar();
        initForm();
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        super.onDestroyView(view);
        view = this.currentSnackbar;
        if (view != null) {
            view.mo1270g();
            this.currentSnackbar = (Snackbar) null;
        }
    }

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        Resources resources = getResources();
        toolbar.setTitle((CharSequence) resources != null ? resources.getString(R.string.template_screen_title) : null);
        toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        ControllerExKt.setActionBar(this, toolbar);
        C0092a actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo141b(true);
        }
        actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo137a(true);
        }
        actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo134a((int) R.drawable.abc_ic_ab_back_material);
        }
    }

    public final void initForm() {
        Form form = this.form;
        FieldId fieldId = FieldId.Fio;
        Resources resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        Object string = resources.getString(FieldId.Fio.getHumanStringRes());
        C0700j.m2711a(string, "resources!!.getString(FieldId.Fio.humanStringRes)");
        EditText editText = this.textFio;
        if (editText == null) {
            C0700j.m2716b("textFio");
        }
        form.add(fieldId, new SimpleTextField(string, editText, null, false, 12, null));
        form = this.form;
        fieldId = FieldId.Account;
        resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        string = resources.getString(FieldId.Account.getHumanStringRes());
        C0700j.m2711a(string, "resources!!.getString(Fi…d.Account.humanStringRes)");
        editText = this.textAccount;
        if (editText == null) {
            C0700j.m2716b("textAccount");
        }
        form.add(fieldId, new SimpleTextField(string, editText, new AccountNumberValidator(), false, 8, null));
        form = this.form;
        fieldId = FieldId.Bik;
        resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        string = resources.getString(FieldId.Bik.getHumanStringRes());
        C0700j.m2711a(string, "resources!!.getString(FieldId.Bik.humanStringRes)");
        editText = this.textBik;
        if (editText == null) {
            C0700j.m2716b("textBik");
        }
        form.add(fieldId, new SimpleTextField(string, editText, new BikValidator(), false, 8, null));
        form = this.form;
        fieldId = FieldId.TemplateName;
        resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        string = resources.getString(FieldId.TemplateName.getHumanStringRes());
        C0700j.m2711a(string, "resources!!.getString(Fi…plateName.humanStringRes)");
        editText = this.textTemplateName;
        if (editText == null) {
            C0700j.m2716b("textTemplateName");
        }
        form.add(fieldId, new SimpleTextField(string, editText, null, false, 12, null));
        this.form.setErrorStateListener(this);
        this.form.setAllFieldsRequired(true);
    }

    public void onErrorStateChanged(Form form, boolean z) {
        C0700j.m2715b(form, "form");
        form = this.nextButton;
        if (form == null) {
            C0700j.m2716b("nextButton");
        }
        UIUtilsKt.setEnabledWithOpacity((View) form, z ^ 1);
    }

    @OnClick
    public final void onNextClick() {
        if (this.form.validate()) {
            ControllerExKt.showProgress$default(this, null, 1, null);
            Object a = TemplatesManager.INSTANCE.addTemplate(templateFromForm()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
            C0700j.m2711a(a, "TemplatesManager.addTemp…dSchedulers.mainThread())");
            addDisposable(C2517a.m10349a(a, new C4629b(this), null, new C4628a(this), 2, null));
        }
    }

    @OnClick
    public final void onInfoFioClick() {
        this.currentSnackbar = ControllerExKt.showSnackbar(this, R.string.template_info_fio, -2, 5);
    }

    @OnClick
    public final void onInfoAccountClick() {
        this.currentSnackbar = ControllerExKt.showSnackbar(this, R.string.template_info_account, -2, 5);
    }

    @OnClick
    public final void onInfoBikClick() {
        this.currentSnackbar = ControllerExKt.showSnackbar(this, R.string.template_info_bik, -2, 5);
    }

    @OnClick
    public final void onInfoNameClick() {
        this.currentSnackbar = ControllerExKt.showSnackbar(this, R.string.template_info_name, -2, 5);
    }

    public final PaymentTemplate templateFromForm() {
        String textValue = this.form.getTextValue(FieldId.Fio);
        if (textValue == null) {
            C0700j.m2709a();
        }
        String textValue2 = this.form.getTextValue(FieldId.Account);
        if (textValue2 == null) {
            C0700j.m2709a();
        }
        String textValue3 = this.form.getTextValue(FieldId.Bik);
        if (textValue3 == null) {
            C0700j.m2709a();
        }
        String textValue4 = this.form.getTextValue(FieldId.TemplateName);
        if (textValue4 == null) {
            C0700j.m2709a();
        }
        return new PaymentTemplate(null, textValue, textValue2, textValue3, textValue4, 1, null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getRouter().m3169l();
        return true;
    }
}
