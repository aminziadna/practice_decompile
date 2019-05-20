package ru.tinkoff.acquiring.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class FixCompatEditText extends EditText {
    public FixCompatEditText(Context context) {
        super(context);
    }

    public FixCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
