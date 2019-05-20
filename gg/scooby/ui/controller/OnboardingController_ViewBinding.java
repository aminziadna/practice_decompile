package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import com.viewpagerindicator.IconPageIndicator;
import ru.skooby.R;

public final class OnboardingController_ViewBinding implements Unbinder {
    private OnboardingController target;
    private View view7f090098;

    public OnboardingController_ViewBinding(final OnboardingController onboardingController, View view) {
        this.target = onboardingController;
        onboardingController.pager = (ViewPager) C0730b.m2751a(view, R.id.pager, "field 'pager'", ViewPager.class);
        onboardingController.pagerIndicator = (IconPageIndicator) C0730b.m2751a(view, R.id.pager_indicator, "field 'pagerIndicator'", IconPageIndicator.class);
        view = C0730b.m2750a(view, R.id.btn_next, "field 'buttonNext' and method 'onNextClick'");
        onboardingController.buttonNext = (TextView) C0730b.m2753b(view, R.id.btn_next, "field 'buttonNext'", TextView.class);
        this.view7f090098 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ OnboardingController_ViewBinding f12763c;

            /* renamed from: a */
            public void mo1911a(View view) {
                onboardingController.onNextClick();
            }
        });
    }

    public void unbind() {
        OnboardingController onboardingController = this.target;
        if (onboardingController != null) {
            this.target = null;
            onboardingController.pager = null;
            onboardingController.pagerIndicator = null;
            onboardingController.buttonNext = null;
            this.view7f090098.setOnClickListener(null);
            this.view7f090098 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
