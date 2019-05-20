package ru.gg.scooby.presenter;

import io.p181b.p185b.C2468b;
import io.p181b.p185b.C4002a;
import p042b.p047e.p049b.C0700j;

/* compiled from: BasePresenter.kt */
public abstract class BasePresenter {
    private final C4002a disposables = new C4002a();

    public final void addDisposable(C2468b c2468b) {
        C0700j.m2715b(c2468b, "disposable");
        this.disposables.mo1802a(c2468b);
    }

    public final void clearDisposables() {
        this.disposables.m17546c();
    }

    public void destroy() {
        clearDisposables();
    }
}
