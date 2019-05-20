package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.view.View;
import p042b.p047e.p049b.C0700j;

/* compiled from: TripPanelChangeHandler.kt */
public final class TripPanelChangeHandler$getAnimator$5 implements AnimatorListener {
    final /* synthetic */ AnimatorSet $animator;
    final /* synthetic */ boolean $isPush;
    final /* synthetic */ View $profileButton;
    final /* synthetic */ View $searchButton;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    TripPanelChangeHandler$getAnimator$5(boolean z, View view, View view2, AnimatorSet animatorSet) {
        this.$isPush = z;
        this.$searchButton = view;
        this.$profileButton = view2;
        this.$animator = animatorSet;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.$isPush != null) {
            Object obj = this.$searchButton;
            C0700j.m2711a(obj, "searchButton");
            obj.setVisibility(8);
            animator = this.$profileButton;
            if (animator != null) {
                animator.setVisibility(8);
            }
        }
        this.$animator.removeListener(this);
    }
}
