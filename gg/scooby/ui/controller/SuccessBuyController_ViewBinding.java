package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class SuccessBuyController_ViewBinding implements Unbinder {
    private SuccessBuyController target;
    private View view7f090090;
    private View view7f090096;
    private View view7f0900a1;

    public SuccessBuyController_ViewBinding(final SuccessBuyController successBuyController, View view) {
        this.target = successBuyController;
        successBuyController.imageLikeHeart = (ImageView) C0730b.m2751a(view, R.id.image_like_heart, "field 'imageLikeHeart'", ImageView.class);
        successBuyController.textLike = (TextView) C0730b.m2751a(view, R.id.text_like, "field 'textLike'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_sell, "method 'onSellClick'");
        this.view7f0900a1 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessBuyController_ViewBinding f12808c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successBuyController.onSellClick();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_like, "method 'onLikeClick'");
        this.view7f090096 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessBuyController_ViewBinding f12810c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successBuyController.onLikeClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessBuyController_ViewBinding f12812c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successBuyController.onFinishClick();
            }
        });
    }

    public void unbind() {
        SuccessBuyController successBuyController = this.target;
        if (successBuyController != null) {
            this.target = null;
            successBuyController.imageLikeHeart = null;
            successBuyController.textLike = null;
            this.view7f0900a1.setOnClickListener(null);
            this.view7f0900a1 = null;
            this.view7f090096.setOnClickListener(null);
            this.view7f090096 = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
