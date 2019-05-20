package ru.gg.scooby.ui.controller.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d.C0808b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.TripFinishHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.util.PhoneUtils;
import ru.skooby.R;

/* compiled from: WaitingPaySellerController.kt */
public final class WaitingPaySellerController extends BaseController {
    @BindView
    public AvatarImageView imageAvatar;

    public WaitingPaySellerController() {
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

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_waiting_buyer, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_buyer, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view != null) {
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
    public final void onCallClick() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Profile profile = activeParking.getProfile();
            if (profile != null) {
                String phoneNumber = profile.getPhoneNumber();
                if (phoneNumber != null) {
                    PhoneUtils.INSTANCE.dial(this, phoneNumber);
                }
            }
        }
    }
}
