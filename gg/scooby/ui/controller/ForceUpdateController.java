package ru.gg.scooby.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.AppUtils;
import ru.skooby.R;

/* compiled from: ForceUpdateController.kt */
public final class ForceUpdateController extends BaseController {
    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_force_update, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…update, container, false)");
        return inflate;
    }

    @OnClick
    public final void onUpdateClick() {
        AppUtils.INSTANCE.goToMarket();
    }
}
