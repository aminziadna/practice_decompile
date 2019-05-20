package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import io.card.payment.BuildConfig;
import io.p181b.p197g.C2517a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.BankCardsManager;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.skooby.R;

/* compiled from: BankCardEditController.kt */
public final class BankCardEditController extends BaseController {
    public static final String ARG_CARD_ID = "ARG_CARD_ID";
    public static final Companion Companion = new Companion();
    @BindView
    public TextView textCardNumber;
    @BindView
    public Toolbar toolbar;

    /* compiled from: BankCardEditController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: BankCardEditController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BankCardEditController$a */
    static final class C4618a extends C3038k implements C0690b<Boolean, C0727n> {
        final /* synthetic */ BankCardEditController this$0;

        C4618a(BankCardEditController bankCardEditController) {
            this.this$0 = bankCardEditController;
            super(1);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2124a(Object obj) {
            m20487a(((Boolean) obj).booleanValue());
            return C0727n.f2066a;
        }

        /* renamed from: a */
        public final void m20487a(boolean z) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            if (z) {
                ControllerExKt.showSnackbar$default(this.this$0, R.string.cards_card_removed, 0, 0, 6, null);
                this.this$0.getRouter().m3169l();
                return;
            }
            ControllerExKt.showSnackbar$default(this.this$0, R.string.cards_card_not_removed, 0, 0, 6, null);
        }
    }

    /* compiled from: BankCardEditController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BankCardEditController$b */
    static final class C4619b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ BankCardEditController this$0;

        C4619b(BankCardEditController bankCardEditController) {
            this.this$0 = bankCardEditController;
            super(1);
        }

        /* renamed from: a */
        public final void m20489a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public BankCardEditController(String str) {
        C0700j.m2715b(str, "cardId");
        this(new BundleBuilder(null, 1, null).putString(ARG_CARD_ID, str).build());
    }

    public BankCardEditController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        setHasOptionsMenu(true);
    }

    public final TextView getTextCardNumber() {
        TextView textView = this.textCardNumber;
        if (textView == null) {
            C0700j.m2716b("textCardNumber");
        }
        return textView;
    }

    public final void setTextCardNumber(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCardNumber = textView;
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

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_bank_card_edit, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…d_edit, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        initAppBar();
        view = BankCardsManager.INSTANCE.getCardManager().m11409b(getArgs().getString(ARG_CARD_ID));
        if (view != null) {
            TextView textView = this.textCardNumber;
            if (textView == null) {
                C0700j.m2716b("textCardNumber");
            }
            textView.setText(view.m11386a());
        }
    }

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        toolbar.setTitle((CharSequence) BuildConfig.FLAVOR);
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

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getRouter().m3169l();
        return true;
    }

    @OnClick
    public final void onDelete() {
        ControllerExKt.showProgress$default(this, null, 1, null);
        BankCardsManager bankCardsManager = BankCardsManager.INSTANCE;
        Object string = getArgs().getString(ARG_CARD_ID);
        C0700j.m2711a(string, "args.getString(ARG_CARD_ID)");
        C2517a.m10349a(bankCardsManager.removeCard(string), new C4619b(this), null, new C4618a(this), 2, null);
    }
}
