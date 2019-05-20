package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class ProfileEditController_ViewBinding implements Unbinder {
    private ProfileEditController target;
    private View view7f09005a;
    private View view7f090085;
    private View view7f09009d;

    public ProfileEditController_ViewBinding(final ProfileEditController profileEditController, View view) {
        this.target = profileEditController;
        profileEditController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        profileEditController.textTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'textTitle'", TextView.class);
        profileEditController.textName = (TextView) C0730b.m2751a(view, R.id.text_name, "field 'textName'", TextView.class);
        profileEditController.textPhone = (TextView) C0730b.m2751a(view, R.id.text_phone, "field 'textPhone'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileEditController_ViewBinding f12791c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileEditController.onBackClick();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_profile_photo, "method 'onAvatarClick'");
        this.view7f09009d = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileEditController_ViewBinding f12793c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileEditController.onAvatarClick();
            }
        });
        view = C0730b.m2750a(view, R.id.block_change_name, "method 'onChangeNameClick'");
        this.view7f09005a = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ProfileEditController_ViewBinding f12795c;

            /* renamed from: a */
            public void mo1911a(View view) {
                profileEditController.onChangeNameClick();
            }
        });
    }

    public void unbind() {
        ProfileEditController profileEditController = this.target;
        if (profileEditController != null) {
            this.target = null;
            profileEditController.imageAvatar = null;
            profileEditController.textTitle = null;
            profileEditController.textName = null;
            profileEditController.textPhone = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f09009d.setOnClickListener(null);
            this.view7f09009d = null;
            this.view7f09005a.setOnClickListener(null);
            this.view7f09005a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
