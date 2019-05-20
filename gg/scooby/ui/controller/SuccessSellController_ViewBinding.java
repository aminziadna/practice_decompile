package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class SuccessSellController_ViewBinding implements Unbinder {
    private SuccessSellController target;
    private View view7f090090;
    private View view7f090096;

    public SuccessSellController_ViewBinding(final SuccessSellController successSellController, View view) {
        this.target = successSellController;
        successSellController.imageLikeHeart = (ImageView) C0730b.m2751a(view, R.id.image_like_heart, "field 'imageLikeHeart'", ImageView.class);
        successSellController.textLike = (TextView) C0730b.m2751a(view, R.id.text_like, "field 'textLike'", TextView.class);
        successSellController.textMoney = (TextView) C0730b.m2751a(view, R.id.text_money, "field 'textMoney'", TextView.class);
        successSellController.textTitle = (TextView) C0730b.m2751a(view, R.id.text_title, "field 'textTitle'", TextView.class);
        successSellController.textDescription = (TextView) C0730b.m2751a(view, R.id.text_description, "field 'textDescription'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_like, "method 'onLikeClick'");
        this.view7f090096 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessSellController_ViewBinding f12816c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successSellController.onLikeClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessSellController_ViewBinding f12818c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successSellController.onFinishClick();
            }
        });
    }

    public void unbind() {
        SuccessSellController successSellController = this.target;
        if (successSellController != null) {
            this.target = null;
            successSellController.imageLikeHeart = null;
            successSellController.textLike = null;
            successSellController.textMoney = null;
            successSellController.textTitle = null;
            successSellController.textDescription = null;
            this.view7f090096.setOnClickListener(null);
            this.view7f090096 = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
