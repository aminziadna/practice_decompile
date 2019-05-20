package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class SelectPrimaryCarController_ViewBinding implements Unbinder {
    private SelectPrimaryCarController target;
    private View view7f090085;

    public SelectPrimaryCarController_ViewBinding(final SelectPrimaryCarController selectPrimaryCarController, View view) {
        this.target = selectPrimaryCarController;
        selectPrimaryCarController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        selectPrimaryCarController.carsList = (RecyclerView) C0730b.m2751a(view, R.id.list_cars, "field 'carsList'", RecyclerView.class);
        selectPrimaryCarController.screenTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'screenTitle'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SelectPrimaryCarController_ViewBinding f12799c;

            /* renamed from: a */
            public void mo1911a(View view) {
                selectPrimaryCarController.onBackClick();
            }
        });
    }

    public void unbind() {
        SelectPrimaryCarController selectPrimaryCarController = this.target;
        if (selectPrimaryCarController != null) {
            this.target = null;
            selectPrimaryCarController.imageAvatar = null;
            selectPrimaryCarController.carsList = null;
            selectPrimaryCarController.screenTitle = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
