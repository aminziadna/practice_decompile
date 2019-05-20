package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class WaitingConfirmOtherSideController_ViewBinding implements Unbinder {
    private WaitingConfirmOtherSideController target;
    private View view7f090087;
    private View view7f090088;

    public WaitingConfirmOtherSideController_ViewBinding(final WaitingConfirmOtherSideController waitingConfirmOtherSideController, View view) {
        this.target = waitingConfirmOtherSideController;
        waitingConfirmOtherSideController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        waitingConfirmOtherSideController.textWaitingConfirm = (TextView) C0730b.m2751a(view, R.id.text_waiting_confirm, "field 'textWaitingConfirm'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_cancel, "field 'btnCancel' and method 'onCancelClick'");
        waitingConfirmOtherSideController.btnCancel = (TextView) C0730b.m2753b(a, R.id.btn_cancel, "field 'btnCancel'", TextView.class);
        this.view7f090088 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingConfirmOtherSideController_ViewBinding f12860c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingConfirmOtherSideController.onCancelClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_call, "field 'btnCall' and method 'onCallClick'");
        waitingConfirmOtherSideController.btnCall = (TextView) C0730b.m2753b(view, R.id.btn_call, "field 'btnCall'", TextView.class);
        this.view7f090087 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingConfirmOtherSideController_ViewBinding f12862c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingConfirmOtherSideController.onCallClick();
            }
        });
    }

    public void unbind() {
        WaitingConfirmOtherSideController waitingConfirmOtherSideController = this.target;
        if (waitingConfirmOtherSideController != null) {
            this.target = null;
            waitingConfirmOtherSideController.imageAvatar = null;
            waitingConfirmOtherSideController.textWaitingConfirm = null;
            waitingConfirmOtherSideController.btnCancel = null;
            waitingConfirmOtherSideController.btnCall = null;
            this.view7f090088.setOnClickListener(null);
            this.view7f090088 = null;
            this.view7f090087.setOnClickListener(null);
            this.view7f090087 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
