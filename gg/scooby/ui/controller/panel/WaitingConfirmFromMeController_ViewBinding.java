package ru.gg.scooby.ui.controller.panel;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class WaitingConfirmFromMeController_ViewBinding implements Unbinder {
    private WaitingConfirmFromMeController target;
    private View view7f090088;
    private View view7f090090;

    public WaitingConfirmFromMeController_ViewBinding(final WaitingConfirmFromMeController waitingConfirmFromMeController, View view) {
        this.target = waitingConfirmFromMeController;
        waitingConfirmFromMeController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        waitingConfirmFromMeController.textWaitingConfirm = (TextView) C0730b.m2751a(view, R.id.text_waiting_confirm, "field 'textWaitingConfirm'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_cancel, "method 'onCancelClick'");
        this.view7f090088 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingConfirmFromMeController_ViewBinding f12856c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingConfirmFromMeController.onCancelClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ WaitingConfirmFromMeController_ViewBinding f12858c;

            /* renamed from: a */
            public void mo1911a(View view) {
                waitingConfirmFromMeController.onFinishClick();
            }
        });
    }

    public void unbind() {
        WaitingConfirmFromMeController waitingConfirmFromMeController = this.target;
        if (waitingConfirmFromMeController != null) {
            this.target = null;
            waitingConfirmFromMeController.imageAvatar = null;
            waitingConfirmFromMeController.textWaitingConfirm = null;
            this.view7f090088.setOnClickListener(null);
            this.view7f090088 = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
