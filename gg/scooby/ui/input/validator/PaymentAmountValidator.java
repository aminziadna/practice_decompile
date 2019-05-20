package ru.gg.scooby.ui.input.validator;

import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.util.PriceExKt;

/* compiled from: PaymentAmountValidator.kt */
public final class PaymentAmountValidator extends TextValidator {
    private final double maxAmount;
    private final double minAmount;

    public PaymentAmountValidator(double d, double d2) {
        this.minAmount = d;
        this.maxAmount = d2;
    }

    public final double getMaxAmount() {
        return this.maxAmount;
    }

    public final double getMinAmount() {
        return this.minAmount;
    }

    public ValidationCode validate(Field field) {
        C0700j.m2715b(field, "field");
        ValidationCode validate = super.validate(field);
        if (validate != ValidationCode.Ok) {
            return validate;
        }
        field = ((SimpleTextField) field).getText();
        field = field != null ? PriceExKt.parsePrice(field) : null;
        if (field != null) {
            ((Number) field).doubleValue();
            if (field.doubleValue() < this.minAmount) {
                return ValidationCode.AmountTooSmall;
            }
            if (field.doubleValue() > this.maxAmount) {
                return ValidationCode.AmountTooLarge;
            }
        }
        return ValidationCode.Ok;
    }
}
