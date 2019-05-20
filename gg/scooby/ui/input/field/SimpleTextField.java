package ru.gg.scooby.ui.input.field;

import android.view.View;
import android.widget.TextView;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.validator.TextValidator;
import ru.gg.scooby.ui.input.validator.Validator;

/* compiled from: SimpleTextField.kt */
public class SimpleTextField extends TextField {
    private final TextView textView;

    public SimpleTextField(String str, View view) {
        this(str, view, null, false, 12, null);
    }

    public SimpleTextField(String str, View view, Validator validator) {
        this(str, view, validator, false, 8, null);
    }

    public /* synthetic */ SimpleTextField(String str, View view, Validator validator, boolean z, int i, C0697g c0697g) {
        if ((i & 4) != null) {
            validator = TextValidator.Companion.getINSTANCE();
        }
        if ((i & 8) != 0) {
            z = true;
        }
        this(str, view, validator, z);
    }

    public SimpleTextField(String str, View view, Validator validator, boolean z) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(view, "view");
        super(str, view, validator, z);
        this.textView = (TextView) getView();
    }

    public TextView getTextView() {
        return this.textView;
    }
}
