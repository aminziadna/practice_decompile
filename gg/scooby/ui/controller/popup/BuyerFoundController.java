package ru.gg.scooby.ui.controller.popup;

import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d.C0808b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

/* compiled from: BuyerFoundController.kt */
public final class BuyerFoundController extends BaseController {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textBuyerName;
    @BindView
    public TextView textCarColor;
    @BindView
    public TextView textCarModel;
    @BindView
    public TextView textCarNumber;
    @BindView
    public TextView textLikes;

    public BuyerFoundController() {
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

    public final TextView getTextBuyerName() {
        TextView textView = this.textBuyerName;
        if (textView == null) {
            C0700j.m2716b("textBuyerName");
        }
        return textView;
    }

    public final void setTextBuyerName(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textBuyerName = textView;
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

    public final TextView getTextLikes() {
        TextView textView = this.textLikes;
        if (textView == null) {
            C0700j.m2716b("textLikes");
        }
        return textView;
    }

    public final void setTextLikes(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textLikes = textView;
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

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_buyer_found, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_found, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view != null) {
            Color color;
            String name;
            StringBuilder stringBuilder;
            int parseColor;
            TextView textView;
            Object obj;
            AvatarImageView avatarImageView;
            TextView textView2 = this.textBuyerName;
            if (textView2 == null) {
                C0700j.m2716b("textBuyerName");
            }
            Profile profile = view.getProfile();
            textView2.setText(profile != null ? profile.getName() : null);
            textView2 = this.textCarModel;
            if (textView2 == null) {
                C0700j.m2716b("textCarModel");
            }
            Car carOpposite = view.getCarOpposite();
            textView2.setText(carOpposite != null ? carOpposite.getCommonCarName() : null);
            textView2 = this.textCarNumber;
            if (textView2 == null) {
                C0700j.m2716b("textCarNumber");
            }
            carOpposite = view.getCarOpposite();
            textView2.setText(carOpposite != null ? carOpposite.getNumber() : null);
            textView2 = this.textCarColor;
            if (textView2 == null) {
                C0700j.m2716b("textCarColor");
            }
            carOpposite = view.getCarOpposite();
            if (carOpposite != null) {
                color = carOpposite.getColor();
                if (color != null) {
                    name = color.getName();
                    textView2.setText(name);
                    textView2 = this.textLikes;
                    if (textView2 == null) {
                        C0700j.m2716b("textLikes");
                    }
                    profile = view.getProfile();
                    textView2.setText(String.valueOf(profile == null ? profile.getLikes() : null));
                    stringBuilder = new StringBuilder();
                    stringBuilder.append('#');
                    carOpposite = view.getCarOpposite();
                    if (carOpposite != null) {
                        color = carOpposite.getColor();
                        if (color != null) {
                            name = color.getHex();
                            stringBuilder.append(name);
                            parseColor = android.graphics.Color.parseColor(stringBuilder.toString());
                            if (parseColor != -1) {
                                textView = this.textCarColor;
                                if (textView == null) {
                                    C0700j.m2716b("textCarColor");
                                }
                                obj = textView.getCompoundDrawables()[2];
                                C0700j.m2711a(obj, "textCarColor.compoundDrawables[2]");
                                obj.setColorFilter(new PorterDuffColorFilter(parseColor, Mode.SRC_ATOP));
                            }
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
                    parseColor = android.graphics.Color.parseColor(stringBuilder.toString());
                    if (parseColor != -1) {
                        textView = this.textCarColor;
                        if (textView == null) {
                            C0700j.m2716b("textCarColor");
                        }
                        obj = textView.getCompoundDrawables()[2];
                        C0700j.m2711a(obj, "textCarColor.compoundDrawables[2]");
                        obj.setColorFilter(new PorterDuffColorFilter(parseColor, Mode.SRC_ATOP));
                    }
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
            textView2.setText(name);
            textView2 = this.textLikes;
            if (textView2 == null) {
                C0700j.m2716b("textLikes");
            }
            profile = view.getProfile();
            if (profile == null) {
            }
            textView2.setText(String.valueOf(profile == null ? profile.getLikes() : null));
            stringBuilder = new StringBuilder();
            stringBuilder.append('#');
            carOpposite = view.getCarOpposite();
            if (carOpposite != null) {
                color = carOpposite.getColor();
                if (color != null) {
                    name = color.getHex();
                    stringBuilder.append(name);
                    parseColor = android.graphics.Color.parseColor(stringBuilder.toString());
                    if (parseColor != -1) {
                        textView = this.textCarColor;
                        if (textView == null) {
                            C0700j.m2716b("textCarColor");
                        }
                        obj = textView.getCompoundDrawables()[2];
                        C0700j.m2711a(obj, "textCarColor.compoundDrawables[2]");
                        obj.setColorFilter(new PorterDuffColorFilter(parseColor, Mode.SRC_ATOP));
                    }
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
            parseColor = android.graphics.Color.parseColor(stringBuilder.toString());
            if (parseColor != -1) {
                textView = this.textCarColor;
                if (textView == null) {
                    C0700j.m2716b("textCarColor");
                }
                obj = textView.getCompoundDrawables()[2];
                C0700j.m2711a(obj, "textCarColor.compoundDrawables[2]");
                obj.setColorFilter(new PorterDuffColorFilter(parseColor, Mode.SRC_ATOP));
            }
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

    @OnClick
    public final void onOkClick() {
        getRouter().m3169l();
    }
}
