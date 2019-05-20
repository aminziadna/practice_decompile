package ru.gg.scooby.ui.controller.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C4333c.C0095a;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0808b;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0820k;
import com.mapbox.mapboxsdk.maps.C1985l;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.Bus;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.ParkingManager.UpdateParkingEvent;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.changehandler.SellPlacePanelChangeHandler;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.controller.ControllerExKt;
import ru.gg.scooby.ui.controller.IMapView;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.DateUtils;
import ru.skooby.R;

/* compiled from: ParkingPostedController.kt */
public final class ParkingPostedController extends BaseController {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textAddress;
    @BindView
    public TextView textDate;
    @BindView
    public TextView textPriceTitle;

    /* compiled from: ParkingPostedController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.ParkingPostedController$c */
    static final class C2697c implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ParkingPostedController f8320a;

        C2697c(ParkingPostedController parkingPostedController) {
            this.f8320a = parkingPostedController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0700j.m2715b(dialogInterface, "dialogInterface");
            this.f8320a.deleteParking();
        }
    }

    /* compiled from: ParkingPostedController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.ParkingPostedController$a */
    static final class C4668a extends C3038k implements C0690b<C2342r<? extends Void>, C0727n> {
        final /* synthetic */ ParkingPostedController this$0;

        C4668a(ParkingPostedController parkingPostedController) {
            this.this$0 = parkingPostedController;
            super(1);
        }

        /* renamed from: a */
        public final void m20587a(C2342r<? extends Void> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                this.this$0.getRouter().m3169l();
                ParkingManager.INSTANCE.deleteParking();
                return;
            }
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: ParkingPostedController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.ParkingPostedController$b */
    static final class C4669b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ ParkingPostedController this$0;

        C4669b(ParkingPostedController parkingPostedController) {
            this.this$0 = parkingPostedController;
            super(1);
        }

        /* renamed from: a */
        public final void m20589a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public ParkingPostedController() {
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

    public final TextView getTextAddress() {
        TextView textView = this.textAddress;
        if (textView == null) {
            C0700j.m2716b("textAddress");
        }
        return textView;
    }

    public final void setTextAddress(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textAddress = textView;
    }

    public final TextView getTextPriceTitle() {
        TextView textView = this.textPriceTitle;
        if (textView == null) {
            C0700j.m2716b("textPriceTitle");
        }
        return textView;
    }

    public final void setTextPriceTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPriceTitle = textView;
    }

    public final TextView getTextDate() {
        TextView textView = this.textDate;
        if (textView == null) {
            C0700j.m2716b("textDate");
        }
        return textView;
    }

    public final void setTextDate(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textDate = textView;
    }

    public final C1985l getMap() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            return ((IMapView) parentController).getMap();
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.IMapView");
    }

    public final IMapView getImapView() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            return (IMapView) parentController;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.IMapView");
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_parking_posted, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…posted, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        String avatarUrl;
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = this.imageAvatar;
        if (view == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                avatarUrl = profile.getAvatarUrl();
                view.setTargetImageUrl(avatarUrl);
            }
        }
        avatarUrl = null;
        view.setTargetImageUrl(avatarUrl);
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        Bus.INSTANCE.register(this);
        updateParking();
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        Bus.INSTANCE.unregister(this);
        super.onDetach(view);
    }

    @OnClick
    public final void onDelete() {
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        new C0095a(view.getContext()).m294a((int) R.string.sell_remove_confirmation).m295a((int) R.string.yes, (OnClickListener) new C2697c(this)).m302b(R.string.no, null).m303b().show();
    }

    public final void updateParking() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null) {
                TextView textView = this.textAddress;
                if (textView == null) {
                    C0700j.m2716b("textAddress");
                }
                textView.setText(parking.getAddress());
                textView = this.textPriceTitle;
                if (textView == null) {
                    C0700j.m2716b("textPriceTitle");
                }
                textView.setText(Parking.Companion.getPriceForUI(parking.getNormalizedPrice()));
                textView = this.textDate;
                if (textView == null) {
                    C0700j.m2716b("textDate");
                }
                textView.setText(DateUtils.INSTANCE.relativeStringDate(parking.getTimeLong()));
            }
        }
    }

    @OnClick
    public final void onEdit() {
        C0814e sellPlacePanelChangeHandler = new SellPlacePanelChangeHandler(getMap(), new ParkingPostedController$onEdit$changeHandler$1());
        getRouter().m3151b(C0820k.m3183a((C0809d) new SellPlacePanelController(1)).m3184a(sellPlacePanelChangeHandler).m3189b(sellPlacePanelChangeHandler));
    }

    public final void deleteParking() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null) {
                Long id = parking.getId();
                if (id != null) {
                    long longValue = id.longValue();
                    Analytics analytics = Analytics.INSTANCE;
                    ParkingAdvert activeParking2 = ParkingManager.INSTANCE.getActiveParking();
                    if (activeParking2 == null) {
                        C0700j.m2709a();
                    }
                    analytics.deleteParking(activeParking2.getParking());
                    ControllerExKt.showProgress$default(this, null, 1, null);
                    Object a = ApiManager.INSTANCE.deleteParking(longValue).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                    C0700j.m2711a(a, "ApiManager.deleteParking…dSchedulers.mainThread())");
                    if (C2517a.m10349a(a, new C4669b(this), null, new C4668a(this), 2, null) != null) {
                        return;
                    }
                }
            }
        }
        Boolean.valueOf(getRouter().m3169l());
    }

    public final void onEventMainThread(UpdateParkingEvent updateParkingEvent) {
        C0700j.m2715b(updateParkingEvent, "event");
        updateParking();
    }
}
