package ru.gg.scooby.ui.input.field;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.ui.input.validator.Validator;
import ru.gg.scooby.util.UIUtils;

/* compiled from: Field.kt */
public abstract class Field implements OnFocusChangeListener {
    private final Context context;
    private boolean isRequired;
    private ValidationCode lastValidationCode;
    private final String name;
    private boolean skipValidationAfterFocusChange;
    private Validator validator;
    private final View view;

    public Field(String str, View view, Validator validator) {
        this(str, view, validator, false, 8, null);
    }

    public abstract boolean isEmpty();

    public abstract void setError(ValidationCode validationCode);

    public Field(String str, View view, Validator validator, boolean z) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(view, "view");
        this.name = str;
        this.view = view;
        this.validator = validator;
        this.isRequired = z;
        this.lastValidationCode = ValidationCode.Ok;
        Object context = this.view.getContext();
        C0700j.m2711a(context, "view.getContext()");
        this.context = context;
    }

    public final String getName() {
        return this.name;
    }

    public final View getView() {
        return this.view;
    }

    public final Validator getValidator() {
        return this.validator;
    }

    public final void setValidator(Validator validator) {
        this.validator = validator;
    }

    public /* synthetic */ Field(String str, View view, Validator validator, boolean z, int i, C0697g c0697g) {
        if ((i & 8) != 0) {
            z = true;
        }
        this(str, view, validator, z);
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final void setRequired(boolean z) {
        this.isRequired = z;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ValidationCode getLastValidationCode() {
        return this.lastValidationCode;
    }

    public final void setLastValidationCode(ValidationCode validationCode) {
        C0700j.m2715b(validationCode, "<set-?>");
        this.lastValidationCode = validationCode;
    }

    public final ValidationCode validateAndSetError() {
        Validator validator = this.validator;
        if (validator != null) {
            if (validator == null) {
                C0700j.m2709a();
            }
            setError(validator.validate(this));
        }
        return this.lastValidationCode;
    }

    public boolean hasError() {
        return this.lastValidationCode != ValidationCode.Ok;
    }

    public final void requestFocus() {
        this.skipValidationAfterFocusChange = true;
        UIUtils.INSTANCE.requestFocus(this.view);
    }

    public final void setupFocusLostValidation() {
        this.view.setOnFocusChangeListener(this);
    }

    public void onFocusChange(View view, boolean z) {
        C0700j.m2715b(view, "v");
        if (this.skipValidationAfterFocusChange != null) {
            this.skipValidationAfterFocusChange = null;
        } else if (!z) {
            validateAndSetError();
        }
    }
}
