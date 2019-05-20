package ru.gg.scooby.ui.controller.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d.C0808b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.TripFinishHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

/* compiled from: WaitingConfirmFromMeController.kt */
public final class WaitingConfirmFromMeController extends BaseController {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textWaitingConfirm;

    public WaitingConfirmFromMeController() {
        setRetainViewMode(C0808b.RETAIN_DETACH);
    }

    public final AvatarImageView getImageAvatar() {
        AvatarImageView avatarImageView = this.imageAvatar;
        if (avatarImageView == null) {
            C0700j.m2716b("imageAvatar");
        }
        return avatarImageView;
    }

    public final void setImageAvatar(AvatarImageView avatarImageView) {
        C0700j.m2715b(avatarImageView, "<set-?>");
        this.imageAvatar = avatarImageView;
    }

    public final TextView getTextWaitingConfirm() {
        TextView textView = this.textWaitingConfirm;
        if (textView == null) {
            C0700j.m2716b("textWaitingConfirm");
        }
        return textView;
    }

    public final void setTextWaitingConfirm(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textWaitingConfirm = textView;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_waiting_confirm_me, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…irm_me, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view != null) {
            TextView textView;
            if (view.getType() == 1) {
                textView = this.textWaitingConfirm;
                if (textView == null) {
                    C0700j.m2716b("textWaitingConfirm");
                }
                textView.setText(R.string.waiting_seller_finished_trip_seller);
            } else {
                textView = this.textWaitingConfirm;
                if (textView == null) {
                    C0700j.m2716b("textWaitingConfirm");
                }
                textView.setText(R.string.waiting_buyer_finished_trip_buyer);
            }
            AvatarImageView avatarImageView = this.imageAvatar;
            if (avatarImageView == null) {
                C0700j.m2716b("imageAvatar");
            }
            view = view.getProfile();
            avatarImageView.setTargetImageUrl(view != null ? view.getAvatarUrl() : null);
        }
    }

    @OnClick
    public final void onCancelClick() {
        new TripFinishHelper(this).cancelTrip();
    }

    @OnClick
    public final void onFinishClick() {
        new TripFinishHelper(this).finishTrip();
    }
}
