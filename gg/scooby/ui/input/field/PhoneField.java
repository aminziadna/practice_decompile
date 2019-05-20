package ru.gg.scooby.ui.input.field;

import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import p042b.C0724k;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.PhoneTextWatcher;
import ru.gg.scooby.ui.input.validator.PhoneValidator;
import ru.gg.scooby.ui.input.validator.Validator;
import ru.gg.scooby.util.PhoneUtils;

/* compiled from: PhoneField.kt */
public final class PhoneField extends SimpleTextField {
    public PhoneField(String str, View view) {
        this(str, view, null, false, 12, null);
    }

    public PhoneField(String str, View view, Validator validator) {
        this(str, view, validator, false, 8, null);
    }

    public /* synthetic */ PhoneField(String str, View view, Validator validator, boolean z, int i, C0697g c0697g) {
        if ((i & 4) != null) {
            validator = new PhoneValidator(PhoneUtils.INSTANCE.getRUSSIA_PHONE_LENGTH_WITH_PREFIX());
        }
        if ((i & 8) != 0) {
            z = true;
        }
        this(str, view, validator, z);
    }

    public PhoneField(String str, View view, Validator validator, boolean z) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(view, "view");
        C0700j.m2715b(validator, "validator");
        super(str, view, validator, z);
        str = getTextView();
        if (str != null) {
            validator = getTextView();
            if (validator != null) {
                str.addTextChangedListener((TextWatcher) new PhoneTextWatcher((EditText) validator));
                return;
            }
            throw new C0724k("null cannot be cast to non-null type android.widget.EditText");
        }
    }
}
