package ru.gg.scooby.ui.input.validator;

import android.text.TextUtils;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.TextField;

/* compiled from: TextValidator.kt */
public class TextValidator implements Validator {
    public static final Companion Companion = new Companion();
    private static final TextValidator INSTANCE = new TextValidator();

    /* compiled from: TextValidator.kt */
    public static final class Companion {
        private Companion() {
        }

        public final TextValidator getINSTANCE() {
            return TextValidator.INSTANCE;
        }
    }

    public ValidationCode validate(Field field) {
        C0700j.m2715b(field, "field");
        if (!(field instanceof TextField)) {
            throw ((Throwable) new IllegalArgumentException("Wrong validator for non-text field"));
        } else if (!field.isRequired() || TextUtils.isEmpty(((TextField) field).getText()) == null) {
            return ValidationCode.Ok;
        } else {
            return ValidationCode.Empty;
        }
    }

    protected final boolean isEmptyAndNotRequired(Field field) {
        C0700j.m2715b(field, "field");
        return (field.isRequired() || TextUtils.isEmpty(((TextField) field).getText()) == null) ? null : true;
    }
}
