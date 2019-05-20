package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.PriceExKt;
import ru.skooby.R;

/* compiled from: SuccessMoneyTransferController.kt */
public final class SuccessMoneyTransferController extends BaseController {
    public static final String ARG_AMOUNT = "ARG_AMOUNT";
    public static final Companion Companion = new Companion();
    @BindView
    public TextView textMoney;

    /* compiled from: SuccessMoneyTransferController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public SuccessMoneyTransferController() {
        this(0.0d, 1, null);
    }

    public SuccessMoneyTransferController(double d) {
        super(new BundleBuilder(null, 1, null).putDouble("ARG_AMOUNT", d).build());
    }

    public /* synthetic */ SuccessMoneyTransferController(double d, int i, C0697g c0697g) {
        if ((i & 1) != 0) {
            d = 0.0d;
        }
        this(d);
    }

    public final TextView getTextMoney() {
        TextView textView = this.textMoney;
        if (textView == null) {
            C0700j.m2716b("textMoney");
        }
        return textView;
    }

    public final void setTextMoney(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textMoney = textView;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_success_money_transfer, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ansfer, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.colorPrimary), false));
        view = this.textMoney;
        if (view == null) {
            C0700j.m2716b("textMoney");
        }
        Resources resources = getResources();
        if (resources != null) {
            str = resources.getString(R.string.price_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(getArgs().getDouble("ARG_AMOUNT")))});
        }
        view.setText(str);
    }

    @OnClick
    public final void onFinishClick() {
        getRouter().m3154b("TAG_ROOT");
    }

    public boolean handleBack() {
        return getRouter().m3154b("TAG_ROOT");
    }
}
