package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

/* compiled from: ChatSupportController.kt */
public final class ChatSupportController extends BaseController {
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textTitle;

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

    public final TextView getTextTitle() {
        TextView textView = this.textTitle;
        if (textView == null) {
            C0700j.m2716b("textTitle");
        }
        return textView;
    }

    public final void setTextTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textTitle = textView;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_chat_support, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…upport, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.profile_status_bar), false, 8, null));
        view = this.textTitle;
        if (view == null) {
            C0700j.m2716b("textTitle");
        }
        view.setText(R.string.profile_support);
        view = this.imageAvatar;
        if (view == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                str = profile.getAvatarUrl();
            }
        }
        view.setTargetImageUrl(str);
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onBlockClick(View view) {
        C0700j.m2715b(view, "view");
        view = view.getId();
        Object parse;
        if (view != R.id.block_telegram) {
            switch (view) {
                case R.id.block_viber:
                    Analytics.INSTANCE.profileChat("chat_viber");
                    parse = Uri.parse("viber://chat?number=%2B79255466514");
                    C0700j.m2711a(parse, "Uri.parse(\"viber://chat?number=%2B79255466514\")");
                    ControllerExKt.startActivityForUri(this, parse);
                    return;
                case R.id.block_whatsapp:
                    Analytics.INSTANCE.profileChat("chat_whatsapp");
                    parse = Uri.parse("https://api.whatsapp.com/send?phone=79255466514");
                    C0700j.m2711a(parse, "Uri.parse(\"https://api.w…/send?phone=79255466514\")");
                    ControllerExKt.startActivityForUri(this, parse);
                    return;
                default:
                    return;
            }
        }
        Analytics.INSTANCE.profileChat("chat_telegram");
        parse = Uri.parse("tg://resolve?domain=Skooby_Parksharing");
        C0700j.m2711a(parse, "Uri.parse(\"tg://resolve?…main=Skooby_Parksharing\")");
        ControllerExKt.startActivityForUri(this, parse);
    }
}
