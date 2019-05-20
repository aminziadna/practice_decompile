package ru.gg.scooby.ui.custom;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import p042b.p047e.p049b.C0700j;

/* compiled from: CustomLayoutManager.kt */
public final class CustomLayoutManager extends LinearLayoutManager {
    private final int mItemWidth;
    private final int mParentWidth;

    public CustomLayoutManager(Context context, int i, int i2) {
        C0700j.m2715b(context, "context");
        super(context, 0, false);
        this.mParentWidth = i;
        this.mItemWidth = i2;
    }

    public int getPaddingLeft() {
        return Math.round((((float) this.mParentWidth) / 2.0f) - (((float) this.mItemWidth) / 2.0f));
    }

    public int getPaddingRight() {
        return getPaddingLeft();
    }
}
