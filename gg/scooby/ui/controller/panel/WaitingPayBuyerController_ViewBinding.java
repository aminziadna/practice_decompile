package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class WaitingPayBuyerController_ViewBinding implements Unbinder {
    private WaitingPayBuyerController target;
    private View view7f090088;
    private View view7f09009a;

    public WaitingPayBuyerController_ViewBinding(final WaitingPayBuyerController waitingPayBuyerController, View view) {
        this.target = waitingPayBuyerController;
        waitingPayBuyerController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        View a = C0730b.m2750a(view, R.id.btn_cancel, "method 'onCancelClick'");
        this.view7f090088 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingPayBuyerController_ViewBinding f12864c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingPayBuyerController.onCancelClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_pay, "method 'onPayClick'");
        this.view7f09009a = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingPayBuyerController_ViewBinding f12866c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingPayBuyerController.onPayClick();
            }
        });
    }

    public void unbind() {
        WaitingPayBuyerController waitingPayBuyerController = this.target;
        if (waitingPayBuyerController != null) {
            this.target = null;
            waitingPayBuyerController.imageAvatar = null;
            this.view7f090088.setOnClickListener(null);
            this.view7f090088 = null;
            this.view7f09009a.setOnClickListener(null);
            this.view7f09009a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
