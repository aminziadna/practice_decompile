package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class SelectPrimaryBankCardController_ViewBinding implements Unbinder {
    private SelectPrimaryBankCardController target;
    private View view7f090085;

    public SelectPrimaryBankCardController_ViewBinding(final SelectPrimaryBankCardController selectPrimaryBankCardController, View view) {
        this.target = selectPrimaryBankCardController;
        selectPrimaryBankCardController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        selectPrimaryBankCardController.list = (RecyclerView) C0730b.m2751a(view, R.id.list, "field 'list'", RecyclerView.class);
        selectPrimaryBankCardController.screenTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'screenTitle'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SelectPrimaryBankCardController_ViewBinding f12797c;

            /* renamed from: a */
            public void mo1911a(View view) {
                selectPrimaryBankCardController.onBackClick();
            }
        });
    }

    public void unbind() {
        SelectPrimaryBankCardController selectPrimaryBankCardController = this.target;
        if (selectPrimaryBankCardController != null) {
            this.target = null;
            selectPrimaryBankCardController.imageAvatar = null;
            selectPrimaryBankCardController.list = null;
            selectPrimaryBankCardController.screenTitle = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
