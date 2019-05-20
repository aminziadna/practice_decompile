package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class ChatSupportController_ViewBinding implements Unbinder {
    private ChatSupportController target;
    private View view7f09006d;
    private View view7f090070;
    private View view7f090071;
    private View view7f090085;

    public ChatSupportController_ViewBinding(final ChatSupportController chatSupportController, View view) {
        this.target = chatSupportController;
        chatSupportController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        chatSupportController.textTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'textTitle'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ChatSupportController_ViewBinding f12722c;

            /* renamed from: a */
            public void mo1911a(View view) {
                chatSupportController.onBackClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_telegram, "method 'onBlockClick'");
        this.view7f09006d = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ChatSupportController_ViewBinding f12724c;

            /* renamed from: a */
            public void mo1911a(View view) {
                chatSupportController.onBlockClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.block_whatsapp, "method 'onBlockClick'");
        this.view7f090071 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ChatSupportController_ViewBinding f12726c;

            /* renamed from: a */
            public void mo1911a(View view) {
                chatSupportController.onBlockClick(view);
            }
        });
        view = C0730b.m2750a(view, R.id.block_viber, "method 'onBlockClick'");
        this.view7f090070 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ChatSupportController_ViewBinding f12728c;

            /* renamed from: a */
            public void mo1911a(View view) {
                chatSupportController.onBlockClick(view);
            }
        });
    }

    public void unbind() {
        ChatSupportController chatSupportController = this.target;
        if (chatSupportController != null) {
            this.target = null;
            chatSupportController.imageAvatar = null;
            chatSupportController.textTitle = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f09006d.setOnClickListener(null);
            this.view7f09006d = null;
            this.view7f090071.setOnClickListener(null);
            this.view7f090071 = null;
            this.view7f090070.setOnClickListener(null);
            this.view7f090070 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
