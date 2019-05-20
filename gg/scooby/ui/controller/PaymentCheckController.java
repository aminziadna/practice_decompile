package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.app.C4333c.C0095a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
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
import ru.gg.scooby.manager.TemplatesManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.TransferResponse;
import ru.gg.scooby.model.User;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.ui.input.MoneyTextWatcher;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.ui.input.form.Form;
import ru.gg.scooby.ui.input.validator.PaymentAmountValidator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.PriceExKt;
import ru.skooby.R;

/* compiled from: PaymentCheckController.kt */
public final class PaymentCheckController extends BaseController {
    public static final String ARG_TEMPLATE = "ARG_TEMPLATE";
    public static final Companion Companion = new Companion();
    @BindView
    public TextView buttonTransfer;
    @BindView
    public EditText editTextAmount;
    private final Form form;
    private PaymentTemplate template;
    @BindView
    public TextView textBalance;
    @BindView
    public TextView textCommission;
    @BindView
    public TextView textWhere;
    @BindView
    public Toolbar toolbar;

    /* compiled from: PaymentCheckController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$e */
    static final class C2681e implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PaymentCheckController f8303a;

        C2681e(PaymentCheckController paymentCheckController) {
            this.f8303a = paymentCheckController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0700j.m2715b(dialogInterface, "dialogInterface");
            this.f8303a.doRemoveTemplate();
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$f */
    static final class C2682f implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PaymentCheckController f8304a;

        C2682f(PaymentCheckController paymentCheckController) {
            this.f8304a = paymentCheckController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0700j.m2715b(dialogInterface, "dialogInterface");
            this.f8304a.doTransferFunds();
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$a */
    static final class C4636a extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ PaymentCheckController this$0;

        C4636a(PaymentCheckController paymentCheckController) {
            this.this$0 = paymentCheckController;
            super(1);
        }

        /* renamed from: a */
        public final void m20523a(C2342r<Void> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                c2342r = this.this$0.getActivity();
                if (c2342r != null) {
                    c2342r = c2342r.getWindow();
                    if (c2342r != null) {
                        c2342r.setSoftInputMode(32);
                    }
                }
                this.this$0.getRouter().m3169l();
                return;
            }
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$b */
    static final class C4637b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ PaymentCheckController this$0;

        C4637b(PaymentCheckController paymentCheckController) {
            this.this$0 = paymentCheckController;
            super(1);
        }

        /* renamed from: a */
        public final void m20525a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$c */
    static final class C4638c extends C3038k implements C0690b<C2342r<TransferResponse>, C0727n> {
        final /* synthetic */ PaymentCheckController this$0;

        C4638c(PaymentCheckController paymentCheckController) {
            this.this$0 = paymentCheckController;
            super(1);
        }

        /* renamed from: a */
        public final void m20527a(C2342r<TransferResponse> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                double toNormalizedPrice;
                Activity activity = this.this$0.getActivity();
                if (activity != null) {
                    Window window = activity.getWindow();
                    if (window != null) {
                        window.setSoftInputMode(32);
                    }
                }
                C0818i router = this.this$0.getRouter();
                TransferResponse transferResponse = (TransferResponse) c2342r.m9827d();
                if (transferResponse != null) {
                    toNormalizedPrice = PriceExKt.toNormalizedPrice(transferResponse.getAmountMinusFee());
                } else {
                    toNormalizedPrice = this.this$0.getTransferAmount();
                }
                router.m3151b(C0820k.m3183a((C0809d) new SuccessMoneyTransferController(toNormalizedPrice)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
                UserManager.INSTANCE.refreshUserFromBackend();
                return;
            }
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: PaymentCheckController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.PaymentCheckController$d */
    static final class C4639d extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ PaymentCheckController this$0;

        C4639d(PaymentCheckController paymentCheckController) {
            this.this$0 = paymentCheckController;
            super(1);
        }

        /* renamed from: a */
        public final void m20529a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public PaymentCheckController(PaymentTemplate paymentTemplate) {
        C0700j.m2715b(paymentTemplate, "template");
        this(new BundleBuilder(null, 1, null).putParcelable(ARG_TEMPLATE, paymentTemplate).build());
    }

    public PaymentCheckController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        setHasOptionsMenu(true);
        this.form = new Form();
    }

    public final Double getAmount() {
        EditText editText = this.editTextAmount;
        if (editText == null) {
            C0700j.m2716b("editTextAmount");
        }
        Editable text = editText.getText();
        if (text != null) {
            String obj = text.toString();
            if (obj != null) {
                return PriceExKt.parsePrice(obj);
            }
        }
        return null;
    }

    public final double getCommissionAmount() {
        Double amount = getAmount();
        return (amount != null ? amount.doubleValue() : 0.0d) * 0.15d;
    }

    public final double getTransferAmount() {
        Double amount = getAmount();
        return (amount != null ? amount.doubleValue() : 0.0d) - getCommissionAmount();
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

    public final TextView getTextBalance() {
        TextView textView = this.textBalance;
        if (textView == null) {
            C0700j.m2716b("textBalance");
        }
        return textView;
    }

    public final void setTextBalance(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textBalance = textView;
    }

    public final TextView getTextWhere() {
        TextView textView = this.textWhere;
        if (textView == null) {
            C0700j.m2716b("textWhere");
        }
        return textView;
    }

    public final void setTextWhere(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textWhere = textView;
    }

    public final EditText getEditTextAmount() {
        EditText editText = this.editTextAmount;
        if (editText == null) {
            C0700j.m2716b("editTextAmount");
        }
        return editText;
    }

    public final void setEditTextAmount(EditText editText) {
        C0700j.m2715b(editText, "<set-?>");
        this.editTextAmount = editText;
    }

    public final TextView getTextCommission() {
        TextView textView = this.textCommission;
        if (textView == null) {
            C0700j.m2716b("textCommission");
        }
        return textView;
    }

    public final void setTextCommission(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCommission = textView;
    }

    public final TextView getButtonTransfer() {
        TextView textView = this.buttonTransfer;
        if (textView == null) {
            C0700j.m2716b("buttonTransfer");
        }
        return textView;
    }

    public final void setButtonTransfer(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.buttonTransfer = textView;
    }

    public final Form getForm() {
        return this.form;
    }

    public final PaymentTemplate getTemplate() {
        return this.template;
    }

    public final void setTemplate(PaymentTemplate paymentTemplate) {
        this.template = paymentTemplate;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_payment_check, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_check, container, false)");
        return inflate;
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = getActivity();
        if (view != null) {
            view = view.getWindow();
            if (view != null) {
                view.setSoftInputMode(16);
            }
        }
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        this.template = (PaymentTemplate) getArgs().getParcelable(ARG_TEMPLATE);
        view = this.textBalance;
        if (view == null) {
            C0700j.m2716b("textBalance");
        }
        view.setText(UserManager.INSTANCE.getBalanceWithCurrency());
        view = this.textWhere;
        if (view == null) {
            C0700j.m2716b("textWhere");
        }
        PaymentTemplate paymentTemplate = this.template;
        view.setText(paymentTemplate != null ? paymentTemplate.getTemplateName() : null);
        view = this.form;
        FieldId fieldId = FieldId.PaymentAmount;
        Resources resources = getResources();
        if (resources == null) {
            C0700j.m2709a();
        }
        Object string = resources.getString(R.string.payment_check_amount);
        C0700j.m2711a(string, "resources!!.getString(R.…ing.payment_check_amount)");
        EditText editText = this.editTextAmount;
        if (editText == null) {
            C0700j.m2716b("editTextAmount");
        }
        View view2 = editText;
        User user = UserManager.INSTANCE.getUser();
        if (user == null) {
            C0700j.m2709a();
        }
        view.add(fieldId, new SimpleTextField(string, view2, new PaymentAmountValidator(100.0d, user.getProfile().getNormalizedBalance()), false, 8, null));
        view = this.editTextAmount;
        if (view == null) {
            C0700j.m2716b("editTextAmount");
        }
        view.addTextChangedListener(new PaymentCheckController$onViewBound$1(this));
        view = this.editTextAmount;
        if (view == null) {
            C0700j.m2716b("editTextAmount");
        }
        editText = this.editTextAmount;
        if (editText == null) {
            C0700j.m2716b("editTextAmount");
        }
        view.addTextChangedListener(new MoneyTextWatcher(editText));
        view = this.editTextAmount;
        if (view == null) {
            C0700j.m2716b("editTextAmount");
        }
        User user2 = UserManager.INSTANCE.getUser();
        if (user2 != null) {
            Profile profile = user2.getProfile();
            if (profile != null) {
                str = PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(profile.getNormalizedBalance()));
            }
        }
        view.setText(str);
        initAppBar();
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

    public final void updateButtonAndCommission() {
        Double amount = getAmount();
        String str = null;
        TextView textView;
        if (amount != null) {
            String string;
            amount.doubleValue();
            textView = this.textCommission;
            if (textView == null) {
                C0700j.m2716b("textCommission");
            }
            Resources resources = getResources();
            if (resources != null) {
                string = resources.getString(R.string.price_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(getCommissionAmount()))});
            } else {
                string = null;
            }
            textView.setText(string);
            textView = this.buttonTransfer;
            if (textView == null) {
                C0700j.m2716b("buttonTransfer");
            }
            resources = getResources();
            if (resources != null) {
                str = resources.getString(R.string.transfer_amount_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(getTransferAmount()))});
            }
            textView.setText(str);
            return;
        }
        PaymentCheckController paymentCheckController = this;
        TextView textView2 = paymentCheckController.textCommission;
        if (textView2 == null) {
            C0700j.m2716b("textCommission");
        }
        textView2.setText((CharSequence) null);
        textView = paymentCheckController.buttonTransfer;
        if (textView == null) {
            C0700j.m2716b("buttonTransfer");
        }
        textView.setText(R.string.transfer_amount);
    }

    @OnClick
    public final void onTransferClick() {
        if (this.form.validate()) {
            Object view = getView();
            if (view == null) {
                C0700j.m2709a();
            }
            C0700j.m2711a(view, "view!!");
            new C0095a(view.getContext()).m294a((int) R.string.transfer_confirmation).m295a((int) R.string.yes, (OnClickListener) new C2682f(this)).m302b(R.string.no, null).m303b().show();
        }
    }

    @OnClick
    public final void onRemoveTemplateClick() {
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        new C0095a(view.getContext()).m294a((int) R.string.remove_template_confirmation).m295a((int) R.string.yes, (OnClickListener) new C2681e(this)).m302b(R.string.no, null).m303b().show();
    }

    public final void doRemoveTemplate() {
        PaymentTemplate paymentTemplate = this.template;
        if (paymentTemplate != null) {
            Long id = paymentTemplate.getId();
            if (id != null) {
                long longValue = id.longValue();
                ControllerExKt.showProgress$default(this, null, 1, null);
                Object a = TemplatesManager.INSTANCE.deleteTemplate(longValue).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a, "TemplatesManager.deleteT…dSchedulers.mainThread())");
                C2517a.m10349a(a, new C4637b(this), null, new C4636a(this), 2, null);
            }
        }
    }

    public final void doTransferFunds() {
        ControllerExKt.showProgress$default(this, null, 1, null);
        Analytics analytics = Analytics.INSTANCE;
        PaymentTemplate paymentTemplate = this.template;
        if (paymentTemplate == null) {
            C0700j.m2709a();
        }
        Long id = paymentTemplate.getId();
        if (id == null) {
            C0700j.m2709a();
        }
        long longValue = id.longValue();
        Double amount = getAmount();
        if (amount == null) {
            C0700j.m2709a();
        }
        analytics.profileFinanceOut(longValue, amount.doubleValue());
        TemplatesManager templatesManager = TemplatesManager.INSTANCE;
        paymentTemplate = this.template;
        if (paymentTemplate == null) {
            C0700j.m2709a();
        }
        id = paymentTemplate.getId();
        if (id == null) {
            C0700j.m2709a();
        }
        longValue = id.longValue();
        amount = getAmount();
        if (amount == null) {
            C0700j.m2709a();
        }
        Object b = templatesManager.withdraw(longValue, PriceExKt.toRawPrice(amount.doubleValue())).m17723a(C2466a.m10262a()).m17729b(C2527a.m10359b());
        C0700j.m2711a(b, "TemplatesManager.withdra…scribeOn(Schedulers.io())");
        C2517a.m10349a(b, new C4639d(this), null, new C4638c(this), 2, null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        menuItem = getActivity();
        if (menuItem != null) {
            menuItem = menuItem.getWindow();
            if (menuItem != null) {
                menuItem.setSoftInputMode(32);
            }
        }
        getRouter().m3169l();
        return true;
    }
}
