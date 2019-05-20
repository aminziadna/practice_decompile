package ru.gg.scooby.ui.controller;

import androidx.viewpager.widget.ViewPager.C0666f;

/* compiled from: OnboardingController.kt */
public final class OnboardingController$onViewBound$1 implements C0666f {
    final /* synthetic */ OnboardingController this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    OnboardingController$onViewBound$1(OnboardingController onboardingController) {
        this.this$0 = onboardingController;
    }

    public void onPageSelected(int i) {
        if (i == 2) {
            this.this$0.setLastSlideShown(true);
        }
    }
}
