package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p024h.C0400u;
import com.bluelinelabs.conductor.p065a.C4410d;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;

/* compiled from: BuyerFoundChangeHandler.kt */
public final class BuyerFoundChangeHandler extends C4410d {
    public BuyerFoundChangeHandler() {
        super(false);
    }

    protected Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        C0700j.m2715b(viewGroup, "container");
        view = super.getAnimator(viewGroup, view, view2, z, z2);
        if (view != null) {
            AnimatorSet animatorSet = (AnimatorSet) view;
            view2 = viewGroup.getParent();
            if (view2 != null) {
                ViewGroup viewGroup2 = (ViewGroup) view2;
                View findViewById = viewGroup2.findViewById(true);
                view2 = viewGroup2.findViewById(R.id.btn_my_location);
                if (z) {
                    C0400u.m1622a(view2, 0.0f);
                    C0400u.m1622a(findViewById, 0.0f);
                } else {
                    float dimensionPixelSize = (float) viewGroup.getResources().getDimensionPixelSize(true);
                    C0400u.m1622a(view2, dimensionPixelSize);
                    C0400u.m1622a(findViewById, dimensionPixelSize);
                }
                return animatorSet;
            }
            throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new C0724k("null cannot be cast to non-null type android.animation.AnimatorSet");
    }
}
