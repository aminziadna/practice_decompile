package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import com.mapbox.mapboxsdk.maps.C1985l;
import p042b.C0724k;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.map.MapCenterProvider;

/* compiled from: SellPlacePanelChangeHandler.kt */
public final class SellPlacePanelChangeHandler extends TripPanelChangeHandler {
    public SellPlacePanelChangeHandler() {
        this(null, null, 3, null);
    }

    protected void resetFromView(View view) {
        C0700j.m2715b(view, "from");
    }

    public SellPlacePanelChangeHandler(C1985l c1985l, MapCenterProvider mapCenterProvider) {
        super(c1985l, mapCenterProvider);
    }

    public /* synthetic */ SellPlacePanelChangeHandler(C1985l c1985l, MapCenterProvider mapCenterProvider, int i, C0697g c0697g) {
        if ((i & 1) != null) {
            c1985l = null;
        }
        if ((i & 2) != 0) {
            mapCenterProvider = null;
        }
        this(c1985l, mapCenterProvider);
    }

    protected Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        C0700j.m2715b(viewGroup, "container");
        viewGroup = super.getAnimator(viewGroup, view, view2, z, z2);
        if (viewGroup != null) {
            AnimatorSet animatorSet = (AnimatorSet) viewGroup;
            if (z) {
                view = getMap();
                if (view != null) {
                    view = view.m7606m();
                    if (view != null) {
                        view.m7338a((boolean) null);
                    }
                }
            } else {
                view = getMap();
                if (view != null) {
                    view = view.m7606m();
                    if (view != null) {
                        view.m7338a(true);
                    }
                }
            }
            return animatorSet;
        }
        throw new C0724k("null cannot be cast to non-null type android.animation.AnimatorSet");
    }
}
