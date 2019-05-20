package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.p065a.C4409b;
import p042b.p047e.p049b.C0700j;

/* compiled from: MapHorizontalChangeHandler.kt */
public final class MapHorizontalChangeHandler extends C4409b {
    public MapHorizontalChangeHandler() {
        super(false);
    }

    protected Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        C0700j.m2715b(viewGroup, "container");
        Object animator = super.getAnimator(viewGroup, view, view2, z, z2);
        C0700j.m2711a(animator, "super.getAnimator(contai…Push, toAddedToContainer)");
        if (!(z || view2 == null)) {
            view2.setVisibility(null);
        }
        return animator;
    }

    protected void resetFromView(View view) {
        C0700j.m2715b(view, "from");
        super.resetFromView(view);
        view.setVisibility(4);
    }
}
