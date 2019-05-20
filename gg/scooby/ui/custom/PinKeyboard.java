package ru.gg.scooby.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import java.util.HashMap;
import p042b.C0715h;
import p042b.C0723j;
import p042b.C0724k;
import p042b.p043a.ad;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;

/* compiled from: PinKeyboard.kt */
public final class PinKeyboard extends RelativeLayout implements OnClickListener {
    private HashMap _$_findViewCache;
    private View checkMark;
    private final HashMap<Integer, Integer> keyCodeMap;
    private Listener listener;

    /* compiled from: PinKeyboard.kt */
    public interface Listener {
        void onKeyPressed(KeyEvent keyEvent);
    }

    public PinKeyboard(Context context) {
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

    public /* synthetic */ PinKeyboard(Context context, AttributeSet attributeSet, int i, C0697g c0697g) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public PinKeyboard(Context context, AttributeSet attributeSet) {
        C0700j.m2715b(context, "context");
        super(context, attributeSet);
        r0 = new C0715h[11];
        int i = 0;
        r0[0] = C0723j.m2744a(Integer.valueOf(R.id.btn_0), Integer.valueOf(7));
        r0[1] = C0723j.m2744a(Integer.valueOf(R.id.btn_1), Integer.valueOf(8));
        r0[2] = C0723j.m2744a(Integer.valueOf(R.id.btn_2), Integer.valueOf(9));
        r0[3] = C0723j.m2744a(Integer.valueOf(R.id.btn_3), Integer.valueOf(10));
        r0[4] = C0723j.m2744a(Integer.valueOf(R.id.btn_4), Integer.valueOf(11));
        r0[5] = C0723j.m2744a(Integer.valueOf(R.id.btn_5), Integer.valueOf(12));
        r0[6] = C0723j.m2744a(Integer.valueOf(R.id.btn_6), Integer.valueOf(13));
        r0[7] = C0723j.m2744a(Integer.valueOf(R.id.btn_7), Integer.valueOf(14));
        r0[8] = C0723j.m2744a(Integer.valueOf(R.id.btn_8), Integer.valueOf(15));
        r0[9] = C0723j.m2744a(Integer.valueOf(R.id.btn_9), Integer.valueOf(16));
        r0[10] = C0723j.m2744a(Integer.valueOf(R.id.btn_clear), Integer.valueOf(28));
        this.keyCodeMap = ad.m18901b(r0);
        View.inflate(context, R.layout.view_pin_keyboard, this);
        context = getChildCount();
        while (i < context) {
            Object childAt = getChildAt(i);
            C0700j.m2711a(childAt, "it");
            if (childAt.getId() != R.id.ic_check) {
                childAt.setOnClickListener(this);
            }
            i++;
        }
        Object findViewById = findViewById(R.id.ic_check);
        C0700j.m2711a(findViewById, "findViewById(R.id.ic_check)");
        this.checkMark = findViewById;
        this.checkMark.setVisibility(8);
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    public final View getCheckMark() {
        return this.checkMark;
    }

    public final void setCheckMark(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.checkMark = view;
    }

    public void onClick(View view) {
        C0700j.m2715b(view, "v");
        Listener listener = this.listener;
        if (listener != null) {
            view = this.keyCodeMap.get(Integer.valueOf(view.getId()));
            if (view != null) {
                listener.onKeyPressed(new KeyEvent(0, ((Integer) view).intValue()));
                return;
            }
            throw new C0724k("null cannot be cast to non-null type kotlin.Int");
        }
    }
}
