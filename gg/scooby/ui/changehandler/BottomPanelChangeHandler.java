package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.p065a.C3077a;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;

/* compiled from: BottomPanelChangeHandler.kt */
public final class BottomPanelChangeHandler extends C3077a {
    protected void resetFromView(View view) {
        C0700j.m2715b(view, "from");
    }

    public BottomPanelChangeHandler() {
        super(false);
    }

    protected Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        C0700j.m2715b(viewGroup, "container");
        viewGroup = new AnimatorSet();
        if (z) {
            if (view2 == null) {
                C0700j.m2709a();
            }
            Object findViewById = view2.findViewById(R.id.container_panel);
            viewGroup.play(ObjectAnimator.ofFloat(view2.findViewById(R.id.background_view), View.ALPHA, new float[]{0.0f, 1.0f}));
            view2 = View.TRANSLATION_Y;
            z = new float[2];
            C0700j.m2711a(findViewById, "panelContainer");
            z[0] = (float) findViewById.getHeight();
            z[1] = null;
            viewGroup.play(ObjectAnimator.ofFloat(findViewById, view2, z));
        } else {
            if (view == null) {
                C0700j.m2709a();
            }
            Object findViewById2 = view.findViewById(R.id.container_panel);
            viewGroup.play(ObjectAnimator.ofFloat(view.findViewById(R.id.background_view), View.ALPHA, new float[]{0.0f}));
            view = View.TRANSLATION_Y;
            z = new float[1];
            C0700j.m2711a(findViewById2, "panelContainer");
            z[0] = (float) findViewById2.getHeight();
            viewGroup.play(ObjectAnimator.ofFloat(findViewById2, view, z));
        }
        return (Animator) viewGroup;
    }
}
