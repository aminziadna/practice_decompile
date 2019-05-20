package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0815f;
import io.p181b.p185b.C2468b;
import io.p181b.p185b.C4002a;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.UIUtils;

/* compiled from: BaseController.kt */
public abstract class BaseController extends ButterKnifeController {
    private final C4002a disposables = new C4002a();
    private final boolean dumpLifecycle = true;
    private boolean isBeingPopped;

    public BaseController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
    }

    private final void setBeingPopped(boolean z) {
        this.isBeingPopped = z;
    }

    public final boolean isBeingPopped() {
        return this.isBeingPopped;
    }

    public final boolean getDumpLifecycle() {
        return this.dumpLifecycle;
    }

    public final void setPaddingForStatusAndNavigation() {
        Object view = getView();
        if (view != null) {
            C0700j.m2711a(view, "it");
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            UIUtils uIUtils = UIUtils.INSTANCE;
            Object activity = getActivity();
            if (activity == null) {
                C0700j.m2709a();
            }
            C0700j.m2711a(activity, "activity!!");
            view.setPadding(paddingLeft, paddingTop + uIUtils.getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom() + UIUtils.INSTANCE.getNavBarHeight());
        }
    }

    public final void addDisposable(C2468b c2468b) {
        C0700j.m2715b(c2468b, "disposable");
        this.disposables.mo1802a(c2468b);
    }

    public final void clearDisposables() {
        this.disposables.m17546c();
    }

    protected void onChangeStarted(C0814e c0814e, C0815f c0815f) {
        C0700j.m2715b(c0814e, "changeHandler");
        C0700j.m2715b(c0815f, "changeType");
        super.onChangeStarted(c0814e, c0815f);
        if (c0815f == C0815f.POP_EXIT) {
            this.isBeingPopped = true;
        }
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        if (this.dumpLifecycle != null) {
            view = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAttach ");
            stringBuilder.append(this);
            view.m11183d(stringBuilder.toString());
        }
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        if (this.dumpLifecycle != null) {
            view = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDetach ");
            stringBuilder.append(this);
            view.m11183d(stringBuilder.toString());
        }
    }

    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        if (this.dumpLifecycle) {
            Log log = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onCreateView ");
            stringBuilder.append(this);
            log.m11183d(stringBuilder.toString());
        }
        return super.onCreateView(layoutInflater, viewGroup);
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        clearDisposables();
        super.onDestroyView(view);
        if (this.dumpLifecycle != null) {
            view = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDestroyView ");
            stringBuilder.append(this);
            view.m11183d(stringBuilder.toString());
        }
    }

    protected void onActivityResumed(Activity activity) {
        C0700j.m2715b(activity, "activity");
        super.onActivityResumed(activity);
        if (this.dumpLifecycle != null) {
            activity = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onActivityResumed ");
            stringBuilder.append(this);
            activity.m11183d(stringBuilder.toString());
        }
    }

    protected void onActivityPaused(Activity activity) {
        C0700j.m2715b(activity, "activity");
        super.onActivityPaused(activity);
        if (this.dumpLifecycle != null) {
            activity = Log.INSTANCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onActivityPaused ");
            stringBuilder.append(this);
            activity.m11183d(stringBuilder.toString());
        }
    }
}
