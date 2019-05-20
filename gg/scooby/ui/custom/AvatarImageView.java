package ru.gg.scooby.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.AvatarHelper;

/* compiled from: AvatarImageView.kt */
public final class AvatarImageView extends MaskedImageView {
    private HashMap _$_findViewCache;
    private final AvatarHelper avatarHelper;

    public AvatarImageView(Context context) {
        this(context, null, 2, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        C0700j.m2715b(context, "context");
        super(context, attributeSet);
        this.avatarHelper = new AvatarHelper(this);
    }

    public /* synthetic */ AvatarImageView(Context context, AttributeSet attributeSet, int i, C0697g c0697g) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public final AvatarHelper getAvatarHelper() {
        return this.avatarHelper;
    }

    public final void setTargetImageUrl(String str) {
        this.avatarHelper.setTargetAvatarUrl(str);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarHelper.onViewAttachedToWindow(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarHelper.onViewDetachedFromWindow(this);
    }
}
