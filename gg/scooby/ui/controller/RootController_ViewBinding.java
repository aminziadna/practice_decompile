package ru.gg.scooby.ui.controller;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class RootController_ViewBinding implements Unbinder {
    private RootController target;

    public RootController_ViewBinding(RootController rootController, View view) {
        this.target = rootController;
        rootController.container = (ViewGroup) C0730b.m2751a(view, R.id.controller_container, "field 'container'", ViewGroup.class);
    }

    public void unbind() {
        RootController rootController = this.target;
        if (rootController != null) {
            this.target = null;
            rootController.container = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
