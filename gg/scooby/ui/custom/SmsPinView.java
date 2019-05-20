package ru.gg.scooby.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.HashMap;
import p042b.C0724k;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p053i.C4777q;
import ru.gg.scooby.C2660R;
import ru.skooby.R;

/* compiled from: SmsPinView.kt */
public final class SmsPinView extends LinearLayout {
    private HashMap _$_findViewCache;
    private int digitsCount;
    private int textColor;

    /* compiled from: SmsPinView.kt */
    public static final class ViewHolder {
        private final View pin;
        private final TextView text;

        public ViewHolder(View view) {
            C0700j.m2715b(view, "rootView");
            View findViewById = view.findViewById(R.id.text);
            if (findViewById != null) {
                this.text = (TextView) findViewById;
                Object findViewById2 = view.findViewById(R.id.pin);
                C0700j.m2711a(findViewById2, "rootView.findViewById(R.id.pin)");
                this.pin = findViewById2;
                return;
            }
            throw new C0724k("null cannot be cast to non-null type android.widget.TextView");
        }

        public final TextView getText() {
            return this.text;
        }

        public final View getPin() {
            return this.pin;
        }

        public final void setText(Character ch) {
            this.text.setText(ch != null ? String.valueOf(ch.charValue()) : null);
            this.pin.setVisibility(ch != null ? 4 : null);
        }
    }

    public SmsPinView(Context context) {
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

    public SmsPinView(Context context, AttributeSet attributeSet) {
        C0700j.m2715b(context, "context");
        super(context, attributeSet);
        this.textColor = -1;
        setOrientation(0);
        if (attributeSet != null) {
            context = context.obtainStyledAttributes(attributeSet, C2660R.styleable.SmsPinView);
            initWithDigitsCount(context.getInt(0, 0));
            setTextColor(context.getColor(1, -1));
            context.recycle();
        }
    }

    public /* synthetic */ SmsPinView(Context context, AttributeSet attributeSet, int i, C0697g c0697g) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public final String getPinValue() {
        StringBuilder stringBuilder = new StringBuilder();
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Object childAt = getChildAt(i);
                C0700j.m2711a(childAt, "getChildAt(i)");
                childAt = childAt.getTag();
                if (childAt != null) {
                    ViewHolder viewHolder = (ViewHolder) childAt;
                    Object text = viewHolder.getText().getText();
                    C0700j.m2711a(text, "holder.text.text");
                    if ((text.length() > 0 ? 1 : null) != null) {
                        stringBuilder.append(viewHolder.getText().getText());
                    }
                    if (i == childCount) {
                        break;
                    }
                    i++;
                } else {
                    throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.custom.SmsPinView.ViewHolder");
                }
            }
        }
        Object stringBuilder2 = stringBuilder.toString();
        C0700j.m2711a(stringBuilder2, "stringBuilder.toString()");
        return stringBuilder2;
    }

    public final void setPinValue(String str) {
        C0700j.m2715b(str, "value");
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Object childAt = getChildAt(i);
                C0700j.m2711a(childAt, "getChildAt(i)");
                childAt = childAt.getTag();
                if (childAt != null) {
                    ((ViewHolder) childAt).setText(C4777q.m22247a((CharSequence) str, i));
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
                throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.custom.SmsPinView.ViewHolder");
            }
        }
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                Object childAt = getChildAt(i2);
                C0700j.m2711a(childAt, "getChildAt(i)");
                childAt = childAt.getTag();
                if (childAt != null) {
                    ((ViewHolder) childAt).getText().setTextColor(i);
                    if (i2 != childCount) {
                        i2++;
                    } else {
                        return;
                    }
                }
                throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.custom.SmsPinView.ViewHolder");
            }
        }
    }

    public final void initWithDigitsCount(int i) {
        this.digitsCount = i;
        i--;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                Object inflate = View.inflate(getContext(), R.layout.view_sms_pin, null);
                C0700j.m2711a(inflate, "view");
                inflate.setTag(new ViewHolder(inflate));
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                if (i2 < i) {
                    layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.sms_pin_horizontal_margin);
                }
                inflate.setMinimumWidth(getResources().getDimensionPixelSize(R.dimen.sms_pin_min_size));
                inflate.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.sms_pin_min_size));
                inflate.setLayoutParams(layoutParams);
                addView(inflate);
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void append(char c) {
        String pinValue = getPinValue();
        if (pinValue.length() < this.digitsCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pinValue);
            stringBuilder.append(c);
            setPinValue(stringBuilder.toString());
        }
    }

    public final void clearLastDigit() {
        String pinValue = getPinValue();
        if ((((CharSequence) pinValue).length() > 0 ? 1 : null) != null) {
            int length = pinValue.length() - 1;
            if (pinValue != null) {
                Object substring = pinValue.substring(0, length);
                C0700j.m2711a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                setPinValue(substring);
                return;
            }
            throw new C0724k("null cannot be cast to non-null type java.lang.String");
        }
    }
}
