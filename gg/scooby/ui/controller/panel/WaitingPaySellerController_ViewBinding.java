package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class WaitingPaySellerController_ViewBinding implements Unbinder {
    private WaitingPaySellerController target;
    private View view7f090087;
    private View view7f090088;

    public WaitingPaySellerController_ViewBinding(final WaitingPaySellerController waitingPaySellerController, View view) {
        this.target = waitingPaySellerController;
        waitingPaySellerController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        View a = C0730b.m2750a(view, R.id.btn_cancel, "method 'onCancelClick'");
        this.view7f090088 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingPaySellerController_ViewBinding f12868c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingPaySellerController.onCancelClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_call, "method 'onCallClick'");
        this.view7f090087 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingPaySellerController_ViewBinding f12870c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingPaySellerController.onCallClick();
            }
        });
    }

    public void unbind() {
        WaitingPaySellerController waitingPaySellerController = this.target;
        if (waitingPaySellerController != null) {
            this.target = null;
            waitingPaySellerController.imageAvatar = null;
            this.view7f090088.setOnClickListener(null);
            this.view7f090088 = null;
            this.view7f090087.setOnClickListener(null);
            this.view7f090087 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
