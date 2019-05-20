package ru.gg.scooby.ui.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0603n;
import p042b.p047e.p049b.C0700j;

/* compiled from: MapController.kt */
public final class MapController$onViewBound$2 extends C0603n {
    private int position = -1;
    final /* synthetic */ MapController this$0;

    MapController$onViewBound$2(MapController mapController) {
        this.this$0 = mapController;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        C0700j.m2715b(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        recyclerView.m20847a(((float) recyclerView.getWidth()) / 1073741824, ((float) recyclerView.getHeight()) / 2.0f);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        C0700j.m2715b(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        View a = recyclerView.m20847a(((float) recyclerView.getWidth()) / 2.0f, 0.0f);
        if (i == 0 && a != null) {
            recyclerView = recyclerView.m20898f(a);
            if (this.position != recyclerView) {
                this.position = recyclerView;
                this.this$0.onPageChanged(this.position);
            }
        }
    }
}
