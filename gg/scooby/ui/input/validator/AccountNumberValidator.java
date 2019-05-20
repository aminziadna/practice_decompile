package ru.gg.scooby.ui.input.validator;

import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.SimpleTextField;

/* compiled from: AccountNumberValidator.kt */
public final class AccountNumberValidator extends TextValidator {
    public ValidationCode validate(Field field) {
        C0700j.m2715b(field, "field");
        ValidationCode validate = super.validate(field);
        if (validate != ValidationCode.Ok) {
            return validate;
        }
        field = ((SimpleTextField) field).getText();
        if (field != null) {
            if (field.length() == 20) {
                return ValidationCode.Ok;
            }
        }
        return ValidationCode.WrongAccountNumber;
    }
}
