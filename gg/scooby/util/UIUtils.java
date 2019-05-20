package ru.gg.scooby.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.KeyListener;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.p098d.p099a.p100a.C1148a;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.skooby.R;

/* compiled from: UIUtils.kt */
public final class UIUtils {
    public static final UIUtils INSTANCE = new UIUtils();

    /* compiled from: UIUtils.kt */
    /* renamed from: ru.gg.scooby.util.UIUtils$a */
    static final class C2699a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ TextView f8323a;

        C2699a(TextView textView) {
            this.f8323a = textView;
        }

        public final void run() {
            TextView textView = this.f8323a;
            textView.setError(textView.getContext().getString(R.string.spaces_arent_allowed));
        }
    }

    /* compiled from: UIUtils.kt */
    /* renamed from: ru.gg.scooby.util.UIUtils$b */
    static final class C2700b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ InputMethodManager f8324a;
        /* renamed from: b */
        final /* synthetic */ View f8325b;

        C2700b(InputMethodManager inputMethodManager, View view) {
            this.f8324a = inputMethodManager;
            this.f8325b = view;
        }

        public final void run() {
            this.f8324a.showSoftInput(this.f8325b, 1);
        }
    }

    public final Handler runInUIThread(Runnable runnable) {
        return runInUIThread$default(this, runnable, false, 2, null);
    }

    public final void setupSpacelessField(android.widget.TextView r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:11:0x0044 in {4, 8, 10} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = "textView";
        p042b.p047e.p049b.C0700j.m2715b(r7, r0);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r7.getFilters();
        r2 = 0;
        if (r1 == 0) goto L_0x001d;
    L_0x0011:
        r3 = r1.length;
        r4 = 0;
    L_0x0013:
        if (r4 >= r3) goto L_0x001d;
    L_0x0015:
        r5 = r1[r4];
        r0.add(r5);
        r4 = r4 + 1;
        goto L_0x0013;
    L_0x001d:
        r1 = new ru.gg.scooby.ui.input.SpacesFilter;
        r3 = new ru.gg.scooby.util.UIUtils$a;
        r3.<init>(r7);
        r3 = (java.lang.Runnable) r3;
        r1.<init>(r3);
        r0.add(r1);
        r0 = (java.util.Collection) r0;
        r1 = new android.text.InputFilter[r2];
        r0 = r0.toArray(r1);
        if (r0 == 0) goto L_0x003c;
    L_0x0036:
        r0 = (android.text.InputFilter[]) r0;
        r7.setFilters(r0);
        return;
    L_0x003c:
        r7 = new b.k;
        r0 = "null cannot be cast to non-null type kotlin.Array<T>";
        r7.<init>(r0);
        throw r7;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.gg.scooby.util.UIUtils.setupSpacelessField(android.widget.TextView):void");
    }

    private UIUtils() {
    }

    public final boolean isMainThread() {
        return C0700j.m2713a(Looper.getMainLooper(), Looper.myLooper());
    }

    public final DisplayMetrics getDisplayMetrics() {
        Object systemService = ContextProvider.INSTANCE.getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        }
        throw new C0724k("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    public final int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public final void requestFocus(View view) {
        C0700j.m2715b(view, "view");
        if (!view.hasFocus()) {
            view.requestFocus();
        } else if (view.getParent() != null) {
            view.getParent().requestChildFocus(view, view);
        }
    }

    public final void setEditable(TextView textView, boolean z) {
        C0700j.m2715b(textView, "textView");
        if (z) {
            KeyListener keyListener = (KeyListener) textView.getTag(R.id.tag_key_listener);
            if (keyListener != null) {
                textView.setKeyListener(keyListener);
            }
            textView.setFocusable(true);
            return;
        }
        textView.setTag(R.id.tag_key_listener, textView.getKeyListener());
        textView.setKeyListener((KeyListener) false);
        textView.setFocusable(false);
    }

    public final void hideKeyboard(Activity activity) {
        C0700j.m2715b(activity, "activity");
        hideKeyboard(activity.getCurrentFocus());
    }

    public final void hideKeyboard(View view) {
        if (view != null) {
            view.clearFocus();
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new C0724k("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final void showKeyboard(Context context, View view) {
        C0700j.m2715b(context, "context");
        if (view != null) {
            context = context.getSystemService("input_method");
            if (context != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) context;
                requestFocus(view);
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    editText.setSelection(editText.getText().length());
                }
                if (!inputMethodManager.showSoftInput(view, 1)) {
                    runInUIThread$default(INSTANCE, new C2700b(inputMethodManager, view), null, 2, null);
                    return;
                }
                return;
            }
            throw new C0724k("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        throw ((Throwable) new NullPointerException());
    }

    public static /* synthetic */ Handler runInUIThread$default(UIUtils uIUtils, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return uIUtils.runInUIThread(runnable, z);
    }

    public final Handler runInUIThread(Runnable runnable, boolean z) {
        if (runnable == null) {
            return null;
        }
        Handler handler;
        if (z && isMainThread()) {
            handler = (Handler) null;
            runnable.run();
        } else {
            handler = new Handler(Looper.getMainLooper());
            handler.post(runnable);
        }
        return handler;
    }

    public final void setStatusBarColor(Window window, int i) {
        if (VERSION.SDK_INT >= 21) {
            if (window != null) {
                window.addFlags(LinearLayoutManager.INVALID_OFFSET);
            }
            if (window != null) {
                window.setStatusBarColor(i);
            }
        }
    }

    public final void setLightStatusBar(View view) {
        C0700j.m2715b(view, "view");
        if (VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 8192);
        }
    }

    public final void clearLightStatusBar(View view) {
        C0700j.m2715b(view, "view");
        if (VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() ^ 8192);
        }
    }

    public final int getStatusBarHeight(Activity activity) {
        C0700j.m2715b(activity, "activity");
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        Rect rect = new Rect();
        Object window = activity.getWindow();
        C0700j.m2711a(window, "window");
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public final int getNavBarHeight() {
        int identifier = ContextProvider.INSTANCE.getContext().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? ContextProvider.INSTANCE.getContext().getResources().getDimensionPixelSize(identifier) : 0;
    }

    public final Bitmap getBitmapFromDrawableResource(int i) {
        Object drawable = ContextProvider.INSTANCE.getContext().getResources().getDrawable(i);
        C0700j.m2711a(drawable, "drawable");
        return getBitmapFromDrawable$default(this, drawable, 0, 0, 6, null);
    }

    public static /* synthetic */ Bitmap getBitmapFromDrawable$default(UIUtils uIUtils, Drawable drawable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != null) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 4) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        return uIUtils.getBitmapFromDrawable(drawable, i, i2);
    }

    public final Bitmap getBitmapFromDrawable(Drawable drawable, int i, int i2) {
        C0700j.m2715b(drawable, "drawable");
        if (drawable instanceof BitmapDrawable) {
            Object bitmap = ((BitmapDrawable) drawable).getBitmap();
            C0700j.m2711a(bitmap, "drawable.bitmap");
            return bitmap;
        }
        Object createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        i2 = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i2.getWidth(), i2.getHeight());
        drawable.draw(i2);
        C0700j.m2711a(createBitmap, "bitmap");
        return createBitmap;
    }

    public final void removeFromSuperview(View view) {
        C0700j.m2715b(view, "view");
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final Spanned setURLSpansAction(Spanned spanned, C0690b<? super String, C0727n> c0690b) {
        C0700j.m2715b(spanned, "spanned");
        C0700j.m2715b(c0690b, "action");
        SpannableString spannableString = new SpannableString(spanned);
        for (Object obj : (URLSpan[]) spanned.getSpans(0, spanned.length(), URLSpan.class)) {
            Object obj2;
            int spanStart = spannableString.getSpanStart(obj2);
            int spanEnd = spannableString.getSpanEnd(obj2);
            spannableString.removeSpan(obj2);
            C0700j.m2711a(obj2, "span");
            Object url = obj2.getURL();
            C0700j.m2711a(url, "span.url");
            if ((((CharSequence) url).length() > 0 ? 1 : null) != null) {
                obj2 = obj2.getURL();
                C0700j.m2711a(obj2, "span.url");
                spannableString.setSpan(new C1148a(obj2, c0690b), spanStart, spanEnd, 33);
            }
        }
        return spannableString;
    }

    public final Spanned fromHtmlWithUrlAction(String str, C0690b<? super String, C0727n> c0690b) {
        C0700j.m2715b(str, "text");
        C0700j.m2715b(c0690b, "action");
        Object fromHtml = Html.fromHtml(str);
        C0700j.m2711a(fromHtml, "Html.fromHtml(text)");
        return setURLSpansAction(fromHtml, c0690b);
    }
}
