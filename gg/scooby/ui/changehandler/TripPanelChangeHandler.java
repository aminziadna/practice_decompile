package ru.gg.scooby.ui.changehandler;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.p065a.C4410d;
import com.mapbox.mapboxsdk.camera.C1859b;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.C1985l;
import p042b.C0724k;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.map.MapCenterProvider;
import ru.skooby.R;

/* compiled from: TripPanelChangeHandler.kt */
public class TripPanelChangeHandler extends C4410d {
    private final C1985l map;
    private final MapCenterProvider mapCenterProvider;

    public TripPanelChangeHandler() {
        this(null, null, 3, null);
    }

    public boolean isReusable() {
        return true;
    }

    protected void resetFromView(View view) {
        C0700j.m2715b(view, "from");
    }

    public TripPanelChangeHandler(C1985l c1985l, MapCenterProvider mapCenterProvider) {
        super(false);
        this.map = c1985l;
        this.mapCenterProvider = mapCenterProvider;
    }

    public /* synthetic */ TripPanelChangeHandler(C1985l c1985l, MapCenterProvider mapCenterProvider, int i, C0697g c0697g) {
        if ((i & 1) != null) {
            c1985l = null;
        }
        if ((i & 2) != 0) {
            mapCenterProvider = null;
        }
        this(c1985l, mapCenterProvider);
    }

    public final C1985l getMap() {
        return this.map;
    }

    public final MapCenterProvider getMapCenterProvider() {
        return this.mapCenterProvider;
    }

    protected Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        C0700j.m2715b(viewGroup, "container");
        z2 = super.getAnimator(viewGroup, view, view2, z, z2);
        if (z2) {
            AnimatorSet animatorSet = (AnimatorSet) z2;
            viewGroup = viewGroup.getParent();
            if (viewGroup != null) {
                viewGroup = viewGroup;
                Object findViewById = viewGroup.findViewById(R.id.btn_search);
                View findViewById2 = viewGroup.findViewById(R.id.btn_profile);
                View findViewById3 = viewGroup.findViewById(R.id.btn_my_location);
                LatLng latLng = null;
                LatLng currentMapCenter;
                if (z || view2 != null) {
                    if (view2 == null) {
                        C0700j.m2709a();
                    }
                    Object findViewById4 = view2.findViewById(R.id.container_actions);
                    animatorSet.play(ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{0.0f}));
                    if (findViewById2 != null) {
                        animatorSet.play(ObjectAnimator.ofFloat(findViewById2, View.ALPHA, new float[]{0.0f}));
                    }
                    if (findViewById3 != null) {
                        Property property = View.TRANSLATION_Y;
                        float[] fArr = new float[1];
                        C0700j.m2711a(findViewById4, "panelView");
                        fArr[0] = (((findViewById4.getY() - ((float) findViewById3.getHeight())) - ((float) viewGroup.getResources().getDimensionPixelSize(R.dimen.my_location_button_margin_bottom_sell_open))) - findViewById3.getY()) + findViewById3.getTranslationY();
                        animatorSet.play(ObjectAnimator.ofFloat(findViewById3, property, fArr));
                    }
                    viewGroup = this.map;
                    if (viewGroup != null) {
                        C0700j.m2711a(findViewById4, "panelView");
                        viewGroup.m7567a(0, 0, 0, findViewById4.getHeight());
                    }
                    viewGroup = this.mapCenterProvider;
                    if (viewGroup != null) {
                        latLng = viewGroup.getCurrentMapCenter();
                    }
                    if (latLng != null) {
                        viewGroup = this.map;
                        if (viewGroup != null) {
                            currentMapCenter = this.mapCenterProvider.getCurrentMapCenter();
                            if (currentMapCenter == null) {
                                C0700j.m2709a();
                            }
                            viewGroup.m7589b(C1859b.m6949a(currentMapCenter));
                        }
                    }
                } else {
                    viewGroup = View.ALPHA;
                    r8 = new float[2];
                    C0700j.m2711a(findViewById, "searchButton");
                    r8[0] = findViewById.getAlpha();
                    r8[1] = 1.0f;
                    animatorSet.play(ObjectAnimator.ofFloat(findViewById, viewGroup, r8));
                    if (findViewById2 != null) {
                        animatorSet.play(ObjectAnimator.ofFloat(findViewById2, View.ALPHA, new float[]{findViewById2.getAlpha(), 1.0f}));
                    }
                    if (findViewById3 != null) {
                        animatorSet.play(ObjectAnimator.ofFloat(findViewById3, View.TRANSLATION_Y, new float[]{0.0f}));
                    }
                    viewGroup = this.map;
                    if (viewGroup != null) {
                        viewGroup.m7567a(0, 0, 0, 0);
                    }
                    viewGroup = this.mapCenterProvider;
                    if (viewGroup != null) {
                        latLng = viewGroup.getCurrentMapCenter();
                    }
                    if (latLng != null) {
                        viewGroup = this.map;
                        if (viewGroup != null) {
                            currentMapCenter = this.mapCenterProvider.getCurrentMapCenter();
                            if (currentMapCenter == null) {
                                C0700j.m2709a();
                            }
                            viewGroup.m7589b(C1859b.m6949a(currentMapCenter));
                        }
                    }
                }
                if (z && view == null) {
                    animatorSet.addListener((AnimatorListener) new TripPanelChangeHandler$getAnimator$5(z, findViewById, findViewById2, animatorSet));
                } else if (!z && view2 == null) {
                    C0700j.m2711a(findViewById, "searchButton");
                    findViewById.setVisibility(0);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                }
                return animatorSet;
            }
            throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new C0724k("null cannot be cast to non-null type android.animation.AnimatorSet");
    }
}
