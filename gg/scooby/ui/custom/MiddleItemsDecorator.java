package ru.gg.scooby.ui.custom;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0595h;
import androidx.recyclerview.widget.RecyclerView.C0599j;
import androidx.recyclerview.widget.RecyclerView.C0612u;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;

/* compiled from: MiddleItemsDecorator.kt */
public final class MiddleItemsDecorator extends C0595h {
    private final Drawable mDivider;

    public MiddleItemsDecorator(Drawable drawable) {
        C0700j.m2715b(drawable, "mDivider");
        this.mDivider = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, C0612u c0612u) {
        C0700j.m2715b(canvas, "canvas");
        C0700j.m2715b(recyclerView, "parent");
        C0700j.m2715b(c0612u, "state");
        c0612u = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount() - 2;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Object childAt = recyclerView.getChildAt(i);
                C0700j.m2711a(childAt, "child");
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((C0599j) layoutParams).bottomMargin;
                    this.mDivider.setBounds(c0612u, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                    this.mDivider.draw(canvas);
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
                throw new C0724k("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
