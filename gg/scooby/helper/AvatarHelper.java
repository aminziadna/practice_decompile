package ru.gg.scooby.helper;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.ImageView;
import com.bumptech.glide.C0845c;
import com.bumptech.glide.C3125j;
import com.bumptech.glide.load.C1029g;
import com.bumptech.glide.p072f.C0869d;
import com.bumptech.glide.p072f.C0870e;
import com.bumptech.glide.p223g.C3114b;
import p042b.C0727n;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.settings.Settings;
import ru.skooby.R;

/* compiled from: AvatarHelper.kt */
public final class AvatarHelper implements OnAttachStateChangeListener {
    private String currentAvatarUrl;
    private boolean dirty;
    private String targetAvatarUrl;
    private final ImageView view;

    public void onViewDetachedFromWindow(View view) {
    }

    public AvatarHelper(ImageView imageView) {
        C0700j.m2715b(imageView, "view");
        this.view = imageView;
    }

    public final ImageView getView() {
        return this.view;
    }

    public final String getTargetAvatarUrl() {
        return this.targetAvatarUrl;
    }

    public final void setTargetAvatarUrl(String str) {
        this.dirty = true;
        this.targetAvatarUrl = str;
        updateAvatar();
    }

    public final void updateAvatar() {
        Object obj = this.currentAvatarUrl;
        if (obj == null || (C0700j.m2713a(obj, this.targetAvatarUrl) ^ 1) != 0 || this.dirty) {
            this.dirty = false;
            String str = this.targetAvatarUrl;
            if (str != null) {
                C3125j a = C0845c.m3331a((View) this.view);
                C0870e c0870e = new C0870e();
                c0870e.m3433a((int) R.drawable.bg_profile_header);
                c0870e.m3444b((C1029g) new C3114b(Settings.INSTANCE.getAvatarSignature()));
                if (a.m13424b(c0870e).m13419a(str).m3570a((C0869d) new AvatarHelper$updateAvatar$$inlined$let$lambda$1(str, this)).m3568a(this.view) != null) {
                    return;
                }
            }
            this.view.setImageResource(R.drawable.bg_profile_header);
            C0727n c0727n = C0727n.f2066a;
        }
    }

    public void onViewAttachedToWindow(View view) {
        updateAvatar();
    }
}
