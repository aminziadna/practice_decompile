package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class ProfileController_ViewBinding implements Unbinder {
    private ProfileController target;
    private View view7f090055;
    private View view7f09005e;
    private View view7f09005f;
    private View view7f090060;
    private View view7f090062;
    private View view7f09006b;
    private View view7f09006c;
    private View view7f09006e;
    private View view7f090085;

    public ProfileController_ViewBinding(final ProfileController profileController, View view) {
        this.target = profileController;
        profileController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        profileController.textName = (TextView) C0730b.m2751a(view, R.id.text_name, "field 'textName'", TextView.class);
        profileController.textPhone = (TextView) C0730b.m2751a(view, R.id.text_phone, "field 'textPhone'", TextView.class);
        profileController.textBalance = (TextView) C0730b.m2751a(view, R.id.text_balance, "field 'textBalance'", TextView.class);
        profileController.textTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'textTitle'", TextView.class);
        profileController.editButton = C0730b.m2750a(view, R.id.btn_edit, "field 'editButton'");
        profileController.avatarButton = C0730b.m2750a(view, R.id.btn_profile_photo, "field 'avatarButton'");
        profileController.textBankCards = (TextView) C0730b.m2751a(view, R.id.text_bank_cards_count, "field 'textBankCards'", TextView.class);
        profileController.textMyCars = (TextView) C0730b.m2751a(view, R.id.text_my_cars_count, "field 'textMyCars'", TextView.class);
        View a = C0730b.m2750a(view, R.id.block_dev_settings, "field 'devSettings' and method 'onDevSettingsClick'");
        profileController.devSettings = a;
        this.view7f09005e = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12773c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onDevSettingsClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_finances, "method 'onFinancesClick'");
        this.view7f09005f = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12775c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onFinancesClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_bank_cards, "method 'onBankCardsClick'");
        this.view7f090055 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12777c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onBankCardsClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_logout, "method 'onLogoutClick'");
        this.view7f090060 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12779c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onLogoutClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12781c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onBackClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_terms, "method 'onTermsClick'");
        this.view7f09006e = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12783c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onTermsClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.block_support, "method 'onChatSupportClick'");
        this.view7f09006c = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12785c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onChatSupportClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_my_cars, "method 'onMyCarsClick'");
        this.view7f090062 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12787c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onMyCarsClick();
            }
        });
        view = C0730b.m2750a(view, R.id.block_share_app, "method 'onShareAppClick'");
        this.view7f09006b = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileController_ViewBinding f12789c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileController.onShareAppClick();
            }
        });
    }

    public void unbind() {
        ProfileController profileController = this.target;
        if (profileController != null) {
            this.target = null;
            profileController.imageAvatar = null;
            profileController.textName = null;
            profileController.textPhone = null;
            profileController.textBalance = null;
            profileController.textTitle = null;
            profileController.editButton = null;
            profileController.avatarButton = null;
            profileController.textBankCards = null;
            profileController.textMyCars = null;
            profileController.devSettings = null;
            this.view7f09005e.setOnClickListener(null);
            this.view7f09005e = null;
            this.view7f09005f.setOnClickListener(null);
            this.view7f09005f = null;
            this.view7f090055.setOnClickListener(null);
            this.view7f090055 = null;
            this.view7f090060.setOnClickListener(null);
            this.view7f090060 = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f09006e.setOnClickListener(null);
            this.view7f09006e = null;
            this.view7f09006c.setOnClickListener(null);
            this.view7f09006c = null;
            this.view7f090062.setOnClickListener(null);
            this.view7f090062 = null;
            this.view7f09006b.setOnClickListener(null);
            this.view7f09006b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
