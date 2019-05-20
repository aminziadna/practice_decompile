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
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.Bus;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.util.Log;
import ru.skooby.R;

/* compiled from: SuccessBuyController.kt */
public final class SuccessBuyController extends BaseController {
    @BindView
    public ImageView imageLikeHeart;
    private boolean liked;
    @BindView
    public TextView textLike;

    /* compiled from: SuccessBuyController.kt */
    public static final class SellEvent {
        public static final SellEvent INSTANCE = new SellEvent();

        private SellEvent() {
        }
    }

    /* compiled from: SuccessBuyController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SuccessBuyController$a */
    static final class C4665a extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4665a f14124a = new C4665a();

        C4665a() {
            super(1);
        }

        /* renamed from: a */
        public final void m20581a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.e$default(Log.INSTANCE, th, false, 2, null);
        }
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
                    C2517a.m10349a(a, (C0690b) C4665a.f14124a, null, null, 6, null);
                }
            }
        }
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_success_buy, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ss_buy, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.colorPrimary), false));
    }

    @OnClick
    public final void onSellClick() {
        getRouter().m3169l();
        Bus.INSTANCE.send(SellEvent.INSTANCE);
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
