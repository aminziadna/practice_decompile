package ru.gg.scooby.ui.input.validator;

import android.text.TextUtils;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.util.StringExKt;

/* compiled from: PhoneValidator.kt */
public final class PhoneValidator extends TextValidator {
    public static final Companion Companion = new Companion();
    private static final PhoneValidator INSTANCE = new PhoneValidator(0, 1, null);
    private final int maxLength;

    /* compiled from: PhoneValidator.kt */
    public static final class Companion {
        private Companion() {
        }

        public final PhoneValidator getINSTANCE() {
            return PhoneValidator.INSTANCE;
        }
    }

    public PhoneValidator() {
        this(0, 1, null);
    }

    public PhoneValidator(int i) {
        this.maxLength = i;
    }

    public /* synthetic */ PhoneValidator(int i, int i2, C0697g c0697g) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        this(i);
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public ValidationCode validate(Field field) {
        C0700j.m2715b(field, "field");
        ValidationCode validate = super.validate(field);
        if (validate != ValidationCode.Ok) {
            return validate;
        }
        field = ((SimpleTextField) field).getText();
        field = field != null ? StringExKt.removeNonDigits(field) : null;
        if (TextUtils.isEmpty((CharSequence) field) || (field != null && field.length() == this.maxLength)) {
            return ValidationCode.Ok;
        }
        return ValidationCode.InvalidPhone;
    }
}
