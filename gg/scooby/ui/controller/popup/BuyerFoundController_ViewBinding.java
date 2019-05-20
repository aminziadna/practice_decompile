package ru.gg.scooby.ui.controller.popup;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class BuyerFoundController_ViewBinding implements Unbinder {
    private BuyerFoundController target;
    private View view7f090099;

    public BuyerFoundController_ViewBinding(final BuyerFoundController buyerFoundController, View view) {
        this.target = buyerFoundController;
        buyerFoundController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        buyerFoundController.textBuyerName = (TextView) C0730b.m2751a(view, R.id.text_buyer_name, "field 'textBuyerName'", TextView.class);
        buyerFoundController.textCarModel = (TextView) C0730b.m2751a(view, R.id.text_car_model, "field 'textCarModel'", TextView.class);
        buyerFoundController.textCarColor = (TextView) C0730b.m2751a(view, R.id.text_car_color, "field 'textCarColor'", TextView.class);
        buyerFoundController.textLikes = (TextView) C0730b.m2751a(view, R.id.text_likes, "field 'textLikes'", TextView.class);
        buyerFoundController.textCarNumber = (TextView) C0730b.m2751a(view, R.id.text_car_number, "field 'textCarNumber'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_ok, "method 'onOkClick'");
        this.view7f090099 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BuyerFoundController_ViewBinding f12872c;

            /* renamed from: a */
            public void mo1911a(View view) {
                buyerFoundController.onOkClick();
            }
        });
    }

    public void unbind() {
        BuyerFoundController buyerFoundController = this.target;
        if (buyerFoundController != null) {
            this.target = null;
            buyerFoundController.imageAvatar = null;
            buyerFoundController.textBuyerName = null;
            buyerFoundController.textCarModel = null;
            buyerFoundController.textCarColor = null;
            buyerFoundController.textLikes = null;
            buyerFoundController.textCarNumber = null;
            this.view7f090099.setOnClickListener(null);
            this.view7f090099 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
