package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class MyCarsController_ViewBinding implements Unbinder {
    private MyCarsController target;
    private View view7f090081;
    private View view7f090085;

    public MyCarsController_ViewBinding(final MyCarsController myCarsController, View view) {
        this.target = myCarsController;
        myCarsController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        myCarsController.emptyView = C0730b.m2750a(view, R.id.empty_view, "field 'emptyView'");
        myCarsController.screenTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'screenTitle'", TextView.class);
        myCarsController.listContainer = C0730b.m2750a(view, R.id.list_container, "field 'listContainer'");
        myCarsController.carsList = (RecyclerView) C0730b.m2751a(view, R.id.list_cars, "field 'carsList'", RecyclerView.class);
        myCarsController.blockPrimaryCar = C0730b.m2750a(view, R.id.block_primary_car, "field 'blockPrimaryCar'");
        myCarsController.textPrimaryCar = (TextView) C0730b.m2751a(view, R.id.text_primary_car, "field 'textPrimaryCar'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ MyCarsController_ViewBinding f12759c;

            /* renamed from: a */
            public void mo1911a(View view) {
                myCarsController.onBackClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_add, "method 'onAddButtonClick'");
        this.view7f090081 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ MyCarsController_ViewBinding f12761c;

            /* renamed from: a */
            public void mo1911a(View view) {
                myCarsController.onAddButtonClick();
            }
        });
    }

    public void unbind() {
        MyCarsController myCarsController = this.target;
        if (myCarsController != null) {
            this.target = null;
            myCarsController.imageAvatar = null;
            myCarsController.emptyView = null;
            myCarsController.screenTitle = null;
            myCarsController.listContainer = null;
            myCarsController.carsList = null;
            myCarsController.blockPrimaryCar = null;
            myCarsController.textPrimaryCar = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f090081.setOnClickListener(null);
            this.view7f090081 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
