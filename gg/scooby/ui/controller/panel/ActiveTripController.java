package ru.gg.scooby.ui.controller.panel;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0808b;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.TripFinishHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.ui.changehandler.BottomPanelChangeHandler;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.util.PhoneUtils;
import ru.skooby.R;

/* compiled from: ActiveTripController.kt */
public final class ActiveTripController extends BaseController implements OptionClickListener {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textAddress;
    @BindView
    public TextView textCarColor;
    @BindView
    public TextView textCarModel;
    @BindView
    public TextView textCarNumber;

    public ActiveTripController() {
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

    public final TextView getTextCarNumber() {
        TextView textView = this.textCarNumber;
        if (textView == null) {
            C0700j.m2716b("textCarNumber");
        }
        return textView;
    }

    public final void setTextCarNumber(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCarNumber = textView;
    }

    public final TextView getTextCarModel() {
        TextView textView = this.textCarModel;
        if (textView == null) {
            C0700j.m2716b("textCarModel");
        }
        return textView;
    }

    public final void setTextCarModel(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCarModel = textView;
    }

    public final TextView getTextCarColor() {
        TextView textView = this.textCarColor;
        if (textView == null) {
            C0700j.m2716b("textCarColor");
        }
        return textView;
    }

    public final void setTextCarColor(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCarColor = textView;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_active_trip, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…e_trip, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view != null) {
            Color color;
            String name;
            StringBuilder stringBuilder;
            AvatarImageView avatarImageView;
            TextView textView = this.textAddress;
            if (textView == null) {
                C0700j.m2716b("textAddress");
            }
            textView.setText(view.getParking().getAddress());
            textView = this.textCarNumber;
            if (textView == null) {
                C0700j.m2716b("textCarNumber");
            }
            Car carOpposite = view.getCarOpposite();
            String str = null;
            textView.setText(carOpposite != null ? carOpposite.getNumber() : null);
            textView = this.textCarModel;
            if (textView == null) {
                C0700j.m2716b("textCarModel");
            }
            carOpposite = view.getCarOpposite();
            textView.setText(carOpposite != null ? carOpposite.getCommonCarName() : null);
            textView = this.textCarColor;
            if (textView == null) {
                C0700j.m2716b("textCarColor");
            }
            carOpposite = view.getCarOpposite();
            if (carOpposite != null) {
                color = carOpposite.getColor();
                if (color != null) {
                    name = color.getName();
                    textView.setText(name);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append('#');
                    carOpposite = view.getCarOpposite();
                    if (carOpposite != null) {
                        color = carOpposite.getColor();
                        if (color != null) {
                            name = color.getHex();
                            stringBuilder.append(name);
                            setCarColor(android.graphics.Color.parseColor(stringBuilder.toString()));
                            avatarImageView = this.imageAvatar;
                            if (avatarImageView == null) {
                                C0700j.m2716b("imageAvatar");
                            }
                            view = view.getProfile();
                            if (view != null) {
                                str = view.getAvatarUrl();
                            }
                            avatarImageView.setTargetImageUrl(str);
                        }
                    }
                    name = null;
                    stringBuilder.append(name);
                    setCarColor(android.graphics.Color.parseColor(stringBuilder.toString()));
                    avatarImageView = this.imageAvatar;
                    if (avatarImageView == null) {
                        C0700j.m2716b("imageAvatar");
                    }
                    view = view.getProfile();
                    if (view != null) {
                        str = view.getAvatarUrl();
                    }
                    avatarImageView.setTargetImageUrl(str);
                }
            }
            name = null;
            textView.setText(name);
            stringBuilder = new StringBuilder();
            stringBuilder.append('#');
            carOpposite = view.getCarOpposite();
            if (carOpposite != null) {
                color = carOpposite.getColor();
                if (color != null) {
                    name = color.getHex();
                    stringBuilder.append(name);
                    setCarColor(android.graphics.Color.parseColor(stringBuilder.toString()));
                    avatarImageView = this.imageAvatar;
                    if (avatarImageView == null) {
                        C0700j.m2716b("imageAvatar");
                    }
                    view = view.getProfile();
                    if (view != null) {
                        str = view.getAvatarUrl();
                    }
                    avatarImageView.setTargetImageUrl(str);
                }
            }
            name = null;
            stringBuilder.append(name);
            setCarColor(android.graphics.Color.parseColor(stringBuilder.toString()));
            avatarImageView = this.imageAvatar;
            if (avatarImageView == null) {
                C0700j.m2716b("imageAvatar");
            }
            view = view.getProfile();
            if (view != null) {
                str = view.getAvatarUrl();
            }
            avatarImageView.setTargetImageUrl(str);
        }
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view == null) {
            getRouter().m3169l();
        } else if (view.getType() == 1) {
            addDisposable(ParkingManager.INSTANCE.startListenLocationUpdates());
        }
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        clearDisposables();
    }

    @OnClick
    public final void onFinishClick() {
        C0818i router = getRouter();
        TripFinishPanelController tripFinishPanelController = new TripFinishPanelController();
        tripFinishPanelController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) tripFinishPanelController).m3184a((C0814e) new BottomPanelChangeHandler()).m3189b(new BottomPanelChangeHandler()));
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

    public void onOptionClick(int i) {
        if (i == R.id.text_cancel_booking) {
            new TripFinishHelper(this).cancelTrip();
        } else if (i == R.id.text_finish_trip) {
            new TripFinishHelper(this).finishTrip();
        }
    }

    public final void setCarColor(int i) {
        TextView textView = this.textCarColor;
        if (textView == null) {
            C0700j.m2716b("textCarColor");
        }
        Drawable drawable = textView.getCompoundDrawables()[2];
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Object drawable2 = layerDrawable.getDrawable(layerDrawable.getNumberOfLayers() - 1);
            C0700j.m2711a(drawable2, "colorDrawable.getDrawabl…wable.numberOfLayers - 1)");
            drawable2.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
        }
    }
}
