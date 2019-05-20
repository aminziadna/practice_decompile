package ru.gg.scooby.ui.controller.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.controller.BaseController;
import ru.skooby.R;

/* compiled from: PhotoActionsPanelController.kt */
public final class PhotoActionsPanelController extends BaseController {
    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_photo_actions_panel, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_panel, container, false)");
        return inflate;
    }

    @OnClick
    public final void dismiss() {
        getRouter().m3169l();
    }

    @OnClick
    public final void handleClick(View view) {
        C0700j.m2715b(view, "view");
        dismiss();
        OptionClickListener optionClickListener = (OptionClickListener) getTargetController();
        if (optionClickListener != null) {
            optionClickListener.onOptionClick(view.getId());
        }
    }
}
