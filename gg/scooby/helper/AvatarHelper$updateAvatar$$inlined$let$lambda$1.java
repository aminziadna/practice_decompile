package ru.gg.scooby.helper;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.C0913a;
import com.bumptech.glide.load.p079b.C0971p;
import com.bumptech.glide.p072f.C0869d;
import com.bumptech.glide.p072f.p073a.C3106h;

/* compiled from: AvatarHelper.kt */
public final class AvatarHelper$updateAvatar$$inlined$let$lambda$1 implements C0869d<Drawable> {
    final /* synthetic */ String $avatarUrl;
    final /* synthetic */ AvatarHelper this$0;

    public boolean onLoadFailed(C0971p c0971p, Object obj, C3106h<Drawable> c3106h, boolean z) {
        return false;
    }

    AvatarHelper$updateAvatar$$inlined$let$lambda$1(String str, AvatarHelper avatarHelper) {
        this.$avatarUrl = str;
        this.this$0 = avatarHelper;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, C3106h<Drawable> c3106h, C0913a c0913a, boolean z) {
        this.this$0.currentAvatarUrl = this.$avatarUrl;
        return null;
    }
}
