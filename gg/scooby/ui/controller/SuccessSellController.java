package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.PriceExKt;
import ru.skooby.R;

/* compiled from: SuccessSellController.kt */
public final class SuccessSellController extends BaseController {
    public static final String ARG_AMOUNT = "ARG_AMOUNT";
    public static final Companion Companion = new Companion();
    @BindView
    public ImageView imageLikeHeart;
    private boolean liked;
    @BindView
    public TextView textDescription;
    @BindView
    public TextView textLike;
    @BindView
    public TextView textMoney;
    @BindView
    public TextView textTitle;

    /* compiled from: SuccessSellController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: SuccessSellController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SuccessSellController$a */
    static final class C4666a extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4666a f14125a = new C4666a();

        C4666a() {
            super(1);
        }

        /* renamed from: a */
        public final void m20583a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.e$default(Log.INSTANCE, th, false, 2, null);
        }
    }

    public SuccessSellController() {
        this(0.0d, 1, null);
    }

    public SuccessSellController(double d) {
        super(new BundleBuilder(null, 1, null).putDouble("ARG_AMOUNT", d).build());
    }

    public /* synthetic */ SuccessSellController(double d, int i, C0697g c0697g) {
        if ((i & 1) != 0) {
            d = 0.0d;
        }
        this(d);
    }

    public final ImageView getImageLikeHeart() {
        ImageView imageView = this.imageLikeHeart;
        if (imageView == null) {
            C0700j.m2716b("imageLikeHeart");
        }
        return imageView;
    }

    public final void setImageLikeHeart(ImageView imageView) {
        C0700j.m2715b(imageView, "<set-?>");
        this.imageLikeHeart = imageView;
    }

    public final TextView getTextLike() {
        TextView textView = this.textLike;
        if (textView == null) {
            C0700j.m2716b("textLike");
        }
        return textView;
    }

    public final void setTextLike(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textLike = textView;
    }

    public final TextView getTextMoney() {
        TextView textView = this.textMoney;
        if (textView == null) {
            C0700j.m2716b("textMoney");
        }
        return textView;
    }

    public final void setTextMoney(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textMoney = textView;
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

    public final TextView getTextDescription() {
        TextView textView = this.textDescription;
        if (textView == null) {
            C0700j.m2716b("textDescription");
        }
        return textView;
    }

    public final void setTextDescription(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textDescription = textView;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
        if (z) {
            z = getResources();
            if (!z) {
                C0700j.m2709a();
            }
            z = z.getColor(R.color.blue_text);
            ImageView imageView = this.imageLikeHeart;
            if (imageView == null) {
                C0700j.m2716b("imageLikeHeart");
            }
            imageView.setColorFilter(z);
            TextView textView = this.textLike;
            if (textView == null) {
                C0700j.m2716b("textLike");
            }
            textView.setTextColor(z);
        } else {
            z = this.imageLikeHeart;
            if (!z) {
                C0700j.m2716b("imageLikeHeart");
            }
            z.clearColorFilter();
            z = this.textLike;
            if (!z) {
                C0700j.m2716b("textLike");
            }
            Resources resources = getResources();
            if (resources == null) {
                C0700j.m2709a();
            }
            z.setTextColor(resources.getColor(R.color.gray_text));
        }
        z = ParkingManager.INSTANCE.getLastKnownParking();
        if (z) {
            z = z.getParking();
            if (z) {
                z = z.getId();
                if (z) {
                    Object a = ApiManager.INSTANCE.likeParking(((Number) z).longValue()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                    C0700j.m2711a(a, "ApiManager.likeParking(i…dSchedulers.mainThread())");
                    C2517a.m10349a(a, (C0690b) C4666a.f14125a, null, null, 6, null);
                }
            }
        }
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_success_sell, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…s_sell, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.colorPrimary), false));
        if (getArgs().getDouble("ARG_AMOUNT") > ((double) null)) {
            view = this.textTitle;
            if (view == null) {
                C0700j.m2716b("textTitle");
            }
            view.setText(R.string.parking_sold_congratulations);
            view = this.textDescription;
            if (view == null) {
                C0700j.m2716b("textDescription");
            }
            view.setText(R.string.parking_sold_money_transferred);
            view = this.textMoney;
            if (view == null) {
                C0700j.m2716b("textMoney");
            }
            Resources resources = getResources();
            if (resources != null) {
                str = resources.getString(R.string.price_with_currency, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(r0))});
            }
            view.setText(str);
            return;
        }
        view = this.textTitle;
        if (view == null) {
            C0700j.m2716b("textTitle");
        }
        view.setText(R.string.thank_you);
        view = this.textDescription;
        if (view == null) {
            C0700j.m2716b("textDescription");
        }
        view.setText(R.string.parking_sold_amount_zero);
        view = this.textMoney;
        if (view == null) {
            C0700j.m2716b("textMoney");
        }
        view.setText((CharSequence) null);
    }

    @OnClick
    public final void onLikeClick() {
        setLiked(this.liked ^ 1);
    }

    @OnClick
    public final void onFinishClick() {
        getRouter().m3169l();
    }
}
