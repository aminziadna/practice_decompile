package ru.gg.scooby.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.C0671a;
import com.viewpagerindicator.C2049a;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;

/* compiled from: OnboardingAdapter.kt */
public final class OnboardingAdapter extends C0671a implements C2049a {
    public static final Companion Companion = new Companion();
    public static final int PAGE_EARN = 2;
    public static final int PAGE_PARK = 1;
    public static final int PAGE_SCOOBY = 0;

    /* compiled from: OnboardingAdapter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public int getCount() {
        return 3;
    }

    public int getIconResId(int i) {
        return R.drawable.tutorial_pager_indicator;
    }

    public boolean isViewFromObject(View view, Object obj) {
        C0700j.m2715b(view, "view");
        C0700j.m2715b(obj, "object");
        return view == obj;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C0700j.m2715b(viewGroup, "container");
        Object inflate = View.inflate(viewGroup.getContext(), R.layout.view_onboarding_page, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_onboarding);
        TextView textView = (TextView) inflate.findViewById(R.id.text_onboarding_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.text_onboarding_description);
        i = OnboardingPage.Companion.byPosition(i);
        imageView.setImageResource(i.getImage());
        textView.setText(i.getTitle());
        textView2.setText(i.getDescription());
        viewGroup.addView(inflate);
        C0700j.m2711a(inflate, "tutorialPage");
        return inflate;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        C0700j.m2715b(viewGroup, "container");
        C0700j.m2715b(obj, "object");
        viewGroup.removeView((View) obj);
    }
}
