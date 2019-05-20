package ru.gg.scooby.ui.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.bluelinelabs.conductor.C3090h;
import p042b.p047e.p049b.C0700j;

/* compiled from: ButterKnifeStatefulController.kt */
public abstract class ButterKnifeStatefulController extends C3090h {
    private Unbinder unbinder;

    protected abstract View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onViewBound(View view, Bundle bundle) {
        C0700j.m2715b(view, "view");
    }

    protected ButterKnifeStatefulController() {
    }

    protected ButterKnifeStatefulController(Bundle bundle) {
        C0700j.m2715b(bundle, "args");
        super(bundle);
    }

    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        layoutInflater = inflateView(layoutInflater, viewGroup);
        this.unbinder = ButterKnife.m2745a(this, layoutInflater);
        onViewBound(layoutInflater, bundle);
        return layoutInflater;
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        super.onDestroyView(view);
        view = this.unbinder;
        if (view == null) {
            C0700j.m2709a();
        }
        view.unbind();
        this.unbinder = (Unbinder) null;
    }
}
