package ru.tinkoff.acquiring.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* compiled from: CardLogoCache */
/* renamed from: ru.tinkoff.acquiring.sdk.k */
class C2771k {
    /* renamed from: a */
    private static final Pattern f8509a = Pattern.compile("^220[0-4]");
    /* renamed from: b */
    private static SparseArray<WeakReference<Bitmap>> f8510b = new SparseArray();
    /* renamed from: c */
    private int f8511c;
    /* renamed from: d */
    private int f8512d;
    /* renamed from: e */
    private int f8513e;
    /* renamed from: f */
    private int f8514f;

    /* renamed from: a */
    protected void m11402a(int i) {
        this.f8511c = i;
    }

    /* renamed from: b */
    protected void m11403b(int i) {
        this.f8512d = i;
    }

    /* renamed from: c */
    protected void m11404c(int i) {
        this.f8513e = i;
    }

    /* renamed from: d */
    protected void m11405d(int i) {
        this.f8514f = i;
    }

    /* renamed from: a */
    public Bitmap m11401a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = m11400a(str);
        if (str == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) f8510b.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                return bitmap;
            }
        }
        context = BitmapFactory.decodeResource(context.getResources(), str);
        f8510b.put(str, new WeakReference(context));
        return context;
    }

    /* renamed from: a */
    private int m11400a(String str) {
        if (f8509a.matcher(str).find()) {
            return this.f8514f;
        }
        return m11399a(str.charAt(0));
    }

    /* renamed from: a */
    private int m11399a(char c) {
        switch (c) {
            case '2':
            case '5':
                return this.f8512d;
            case '4':
                return this.f8511c;
            case '6':
                return this.f8513e;
            default:
                return '\u0000';
        }
    }
}
