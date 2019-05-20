package ru.gg.scooby.helper;

import android.view.View;
import android.view.Window;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0807a;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0815f;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.controller.ControllerExKt;
import ru.gg.scooby.util.ColorUtils;
import ru.gg.scooby.util.UIUtils;

/* compiled from: StatusBarColorHelper.kt */
public final class StatusBarColorHelper extends C0807a {
    private final int color;
    private final boolean isLight;
    private final View view;
    private final Window window;

    public final Window getWindow() {
        return this.window;
    }

    public final View getView() {
        return this.view;
    }

    public final int getColor() {
        return this.color;
    }

    public StatusBarColorHelper(Window window, View view, int i, boolean z) {
        C0700j.m2715b(view, "view");
        this.window = window;
        this.view = view;
        this.color = i;
        this.isLight = z;
    }

    public /* synthetic */ StatusBarColorHelper(Window window, View view, int i, boolean z, int i2, C0697g c0697g) {
        if ((i2 & 8) != 0) {
            z = ColorUtils.INSTANCE.isLight(i);
        }
        this(window, view, i, z);
    }

    public final boolean isLight() {
        return this.isLight;
    }

    public void onChangeStart(C0809d c0809d, C0814e c0814e, C0815f c0815f) {
        C0700j.m2715b(c0809d, "controller");
        C0700j.m2715b(c0814e, "changeHandler");
        C0700j.m2715b(c0815f, "changeType");
        super.onChangeStart(c0809d, c0814e, c0815f);
        if (c0815f.isEnter != null) {
            if (ControllerExKt.isTopController(c0809d) != null) {
                UIUtils.INSTANCE.setStatusBarColor(this.window, this.color);
                if (this.isLight != null) {
                    UIUtils.INSTANCE.setLightStatusBar(this.view);
                }
            }
        } else if (this.isLight != null) {
            UIUtils.INSTANCE.clearLightStatusBar(this.view);
        }
    }
}
