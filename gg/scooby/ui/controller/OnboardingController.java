package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.C0666f;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.viewpagerindicator.IconPageIndicator;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.settings.DeviceSettings;
import ru.gg.scooby.ui.adapter.OnboardingAdapter;
import ru.skooby.R;

/* compiled from: OnboardingController.kt */
public final class OnboardingController extends BaseController {
    public OnboardingAdapter adapter;
    @BindView
    public TextView buttonNext;
    private boolean lastSlideShown;
    @BindView
    public ViewPager pager;
    @BindView
    public IconPageIndicator pagerIndicator;
    private long startTime;

    public final ViewPager getPager() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            C0700j.m2716b("pager");
        }
        return viewPager;
    }

    public final void setPager(ViewPager viewPager) {
        C0700j.m2715b(viewPager, "<set-?>");
        this.pager = viewPager;
    }

    public final IconPageIndicator getPagerIndicator() {
        IconPageIndicator iconPageIndicator = this.pagerIndicator;
        if (iconPageIndicator == null) {
            C0700j.m2716b("pagerIndicator");
        }
        return iconPageIndicator;
    }

    public final void setPagerIndicator(IconPageIndicator iconPageIndicator) {
        C0700j.m2715b(iconPageIndicator, "<set-?>");
        this.pagerIndicator = iconPageIndicator;
    }

    public final TextView getButtonNext() {
        TextView textView = this.buttonNext;
        if (textView == null) {
            C0700j.m2716b("buttonNext");
        }
        return textView;
    }

    public final void setButtonNext(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.buttonNext = textView;
    }

    public final OnboardingAdapter getAdapter() {
        OnboardingAdapter onboardingAdapter = this.adapter;
        if (onboardingAdapter == null) {
            C0700j.m2716b("adapter");
        }
        return onboardingAdapter;
    }

    public final void setAdapter(OnboardingAdapter onboardingAdapter) {
        C0700j.m2715b(onboardingAdapter, "<set-?>");
        this.adapter = onboardingAdapter;
    }

    public final boolean getLastSlideShown() {
        return this.lastSlideShown;
    }

    public final void setLastSlideShown(boolean z) {
        this.lastSlideShown = z;
        if (z) {
            z = this.buttonNext;
            if (!z) {
                C0700j.m2716b("buttonNext");
            }
            z.setText(R.string.enter);
        }
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_onboarding, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…arding, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        this.startTime = System.currentTimeMillis();
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.onboarding_gradient_start), false, 8, null));
        this.adapter = new OnboardingAdapter();
        view = this.pager;
        if (view == null) {
            C0700j.m2716b("pager");
        }
        OnboardingAdapter onboardingAdapter = this.adapter;
        if (onboardingAdapter == null) {
            C0700j.m2716b("adapter");
        }
        view.setAdapter(onboardingAdapter);
        view = this.pager;
        if (view == null) {
            C0700j.m2716b("pager");
        }
        view.setOffscreenPageLimit(2);
        view = this.pager;
        if (view == null) {
            C0700j.m2716b("pager");
        }
        view.m2655a((C0666f) new OnboardingController$onViewBound$1(this));
        view = this.pagerIndicator;
        if (view == null) {
            C0700j.m2716b("pagerIndicator");
        }
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            C0700j.m2716b("pager");
        }
        view.setViewPager(viewPager);
    }

    @OnClick
    public final void onNextClick() {
        if (!this.lastSlideShown) {
            ViewPager viewPager = this.pager;
            if (viewPager == null) {
                C0700j.m2716b("pager");
            }
            if (viewPager.getCurrentItem() != 2) {
                viewPager = this.pager;
                if (viewPager == null) {
                    C0700j.m2716b("pager");
                }
                ViewPager viewPager2 = this.pager;
                if (viewPager2 == null) {
                    C0700j.m2716b("pager");
                }
                viewPager.m2652a(viewPager2.getCurrentItem() + 1, true);
                return;
            }
        }
        Analytics.INSTANCE.onboardingOk((System.currentTimeMillis() - this.startTime) / ((long) 1000));
        DeviceSettings.INSTANCE.setOnboardingShown(true);
        Object router = getRouter();
        C0700j.m2711a(router, "router");
        Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
        C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
        C0819j.m3181a(router, a);
    }
}
