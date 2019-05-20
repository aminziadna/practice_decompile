package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.Context;
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
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Scooby;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.BankCardsManager;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.settings.DeviceSettings;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.util.AppUtils;
import ru.gg.scooby.util.PhoneUtils;
import ru.skooby.R;

/* compiled from: ProfileController.kt */
public final class ProfileController extends BaseController {
    @BindView
    public View avatarButton;
    @BindView
    public View devSettings;
    @BindView
    public View editButton;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView textBalance;
    @BindView
    public TextView textBankCards;
    @BindView
    public TextView textMyCars;
    @BindView
    public TextView textName;
    @BindView
    public TextView textPhone;
    @BindView
    public TextView textTitle;

    /* compiled from: ProfileController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileController$a */
    static final class C2688a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ProfileController f8311a;

        C2688a(ProfileController profileController) {
            this.f8311a = profileController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0700j.m2715b(dialogInterface, "dialogInterface");
            Analytics.INSTANCE.profileExit();
            DeviceSettings.INSTANCE.setOnboardingShown(0);
            UserManager.INSTANCE.logout();
            Object router = this.f8311a.getRouter();
            C0700j.m2711a(router, "router");
            Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
            C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
            C0819j.m3181a(router, a);
        }
    }

    /* compiled from: ProfileController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileController$b */
    static final class C2689b implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ProfileController f8312a;

        C2689b(ProfileController profileController) {
            this.f8312a = profileController;
        }

        public final void onClick(View view) {
            this.f8312a.showProfileEditScreen();
        }
    }

    /* compiled from: ProfileController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileController$c */
    static final class C2690c implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ProfileController f8313a;

        C2690c(ProfileController profileController) {
            this.f8313a = profileController;
        }

        public final void onClick(View view) {
            this.f8313a.showProfileEditScreen();
        }
    }

    public ProfileController() {
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

    public final TextView getTextName() {
        TextView textView = this.textName;
        if (textView == null) {
            C0700j.m2716b("textName");
        }
        return textView;
    }

    public final void setTextName(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textName = textView;
    }

    public final TextView getTextPhone() {
        TextView textView = this.textPhone;
        if (textView == null) {
            C0700j.m2716b("textPhone");
        }
        return textView;
    }

    public final void setTextPhone(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPhone = textView;
    }

    public final TextView getTextBalance() {
        TextView textView = this.textBalance;
        if (textView == null) {
            C0700j.m2716b("textBalance");
        }
        return textView;
    }

    public final void setTextBalance(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textBalance = textView;
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

    public final View getEditButton() {
        View view = this.editButton;
        if (view == null) {
            C0700j.m2716b("editButton");
        }
        return view;
    }

    public final void setEditButton(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.editButton = view;
    }

    public final View getAvatarButton() {
        View view = this.avatarButton;
        if (view == null) {
            C0700j.m2716b("avatarButton");
        }
        return view;
    }

    public final void setAvatarButton(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.avatarButton = view;
    }

    public final TextView getTextBankCards() {
        TextView textView = this.textBankCards;
        if (textView == null) {
            C0700j.m2716b("textBankCards");
        }
        return textView;
    }

    public final void setTextBankCards(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textBankCards = textView;
    }

    public final TextView getTextMyCars() {
        TextView textView = this.textMyCars;
        if (textView == null) {
            C0700j.m2716b("textMyCars");
        }
        return textView;
    }

    public final void setTextMyCars(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textMyCars = textView;
    }

    public final View getDevSettings() {
        View view = this.devSettings;
        if (view == null) {
            C0700j.m2716b("devSettings");
        }
        return view;
    }

    public final void setDevSettings(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.devSettings = view;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_profile, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…rofile, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        View view2 = this.devSettings;
        if (view2 == null) {
            C0700j.m2716b("devSettings");
        }
        view2.setVisibility(8);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.profile_status_bar), false, 8, null));
        view = this.textTitle;
        if (view == null) {
            C0700j.m2716b("textTitle");
        }
        view.setText(R.string.profile);
        view = this.editButton;
        if (view == null) {
            C0700j.m2716b("editButton");
        }
        view.setOnClickListener(new C2689b(this));
        view = this.avatarButton;
        if (view == null) {
            C0700j.m2716b("avatarButton");
        }
        view.setOnClickListener(new C2690c(this));
    }

    protected void onAttach(View view) {
        String avatarUrl;
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = UserManager.INSTANCE.getUser();
        if (view != null) {
            view = view.getProfile();
            if (view != null) {
                TextView textView = this.textName;
                if (textView == null) {
                    C0700j.m2716b("textName");
                }
                textView.setText(view.getName());
                textView = this.textPhone;
                if (textView == null) {
                    C0700j.m2716b("textPhone");
                }
                textView.setText(PhoneUtils.INSTANCE.formatPhoneNumber(view.getPhoneNumber()));
            }
        }
        view = this.textBalance;
        if (view == null) {
            C0700j.m2716b("textBalance");
        }
        view.setText(UserManager.INSTANCE.getBalanceWithCurrency());
        view = this.textBankCards;
        if (view == null) {
            C0700j.m2716b("textBankCards");
        }
        view.setText(String.valueOf(BankCardsManager.INSTANCE.getCards().size()));
        view = this.textMyCars;
        if (view == null) {
            C0700j.m2716b("textMyCars");
        }
        view.setText(String.valueOf(UserManager.INSTANCE.getCars().size()));
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

    @OnClick
    public final void onFinancesClick() {
        Analytics.INSTANCE.profileFinance();
        getRouter().m3151b(C0820k.m3183a((C0809d) new FinancesController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b()));
    }

    @OnClick
    public final void onBankCardsClick() {
        Analytics.INSTANCE.profileCards();
        getRouter().m3151b(C0820k.m3183a((C0809d) new BankCardsController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onLogoutClick(View view) {
        C0700j.m2715b(view, "view");
        new C0095a(view.getContext()).m294a((int) R.string.profile_logout_confirmation).m295a((int) R.string.yes, (OnClickListener) new C2688a(this)).m302b(R.string.no, null).m303b().show();
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onTermsClick(View view) {
        C0700j.m2715b(view, "view");
        Analytics.INSTANCE.profileTerms();
        C0818i router = getRouter();
        String str = Scooby.TERMS_URL;
        Object string = view.getResources().getString(R.string.profile_terms);
        C0700j.m2711a(string, "view.resources.getString(R.string.profile_terms)");
        router.m3151b(C0820k.m3183a((C0809d) new WebUrlController(str, string)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onChatSupportClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new ChatSupportController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onMyCarsClick() {
        Analytics.INSTANCE.profileCars();
        getRouter().m3151b(C0820k.m3183a((C0809d) new MyCarsController(0, 1, null)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onShareAppClick() {
        Object activity = getActivity();
        if (activity != null) {
            AppUtils appUtils = AppUtils.INSTANCE;
            C0700j.m2711a(activity, "it");
            appUtils.openShareApp((Context) activity);
        }
    }

    @OnClick
    public final void onDevSettingsClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new DevSettingsController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    public final void showProfileEditScreen() {
        Analytics.INSTANCE.profileEdit();
        getRouter().m3151b(C0820k.m3183a((C0809d) new ProfileEditController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b()));
    }
}
