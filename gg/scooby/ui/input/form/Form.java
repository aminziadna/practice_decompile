package ru.gg.scooby.ui.input.form;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.MaterialEditText.C2039a;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.ui.input.field.Field;
import ru.gg.scooby.ui.input.field.TextField;
import ru.gg.scooby.ui.input.validator.ValidationCode;

/* compiled from: Form.kt */
public class Form implements C2039a {
    private ErrorStateListener errorStateListener;
    private final Map<FieldId, Field> fieldsMap = new LinkedHashMap();
    private boolean isFormHasTextError;
    private boolean isSetupFocusLostValidation;

    /* compiled from: Form.kt */
    public interface ErrorStateListener {
        void onErrorStateChanged(Form form, boolean z);
    }

    public final boolean handleErrorForField(String str) {
        C0700j.m2715b(str, "error");
        return false;
    }

    private final void setFormHasTextError(boolean z) {
        this.isFormHasTextError = z;
    }

    public final boolean isFormHasTextError() {
        return this.isFormHasTextError;
    }

    public final boolean isSetupFocusLostValidation() {
        return this.isSetupFocusLostValidation;
    }

    public final void setSetupFocusLostValidation(boolean z) {
        this.isSetupFocusLostValidation = z;
    }

    public final Collection<Field> getAllFields() {
        return this.fieldsMap.values();
    }

    public final void setErrorStateListener(ErrorStateListener errorStateListener) {
        C0700j.m2715b(errorStateListener, "errorStateListener");
        this.errorStateListener = errorStateListener;
    }

    public final void add(FieldId fieldId, Field field) {
        C0700j.m2715b(fieldId, "fieldId");
        C0700j.m2715b(field, "field");
        this.fieldsMap.put(fieldId, field);
        fieldId = field instanceof TextField;
        TextField textField = (TextField) (fieldId == null ? null : field);
        if (textField != null) {
            textField.setErrorStateListener(this);
        }
        if (this.isSetupFocusLostValidation) {
            field.setupFocusLostValidation();
        }
        if (fieldId != null) {
            TextField textField2 = (TextField) field;
            if (textField2.isClearErrorOnTextChange() != null) {
                textField2.setupClearErrorTextWatcher();
            }
        }
    }

    public final Field getField(FieldId fieldId) {
        C0700j.m2715b(fieldId, "fieldId");
        return (Field) this.fieldsMap.get(fieldId);
    }

    public final String getTextValue(FieldId fieldId) {
        C0700j.m2715b(fieldId, "fieldName");
        fieldId = (Field) this.fieldsMap.get(fieldId);
        if (!(fieldId instanceof TextField)) {
            fieldId = null;
        }
        TextField textField = (TextField) fieldId;
        return textField != null ? textField.getText() : null;
    }

    public final void setEditable(boolean z) {
        for (Field field : this.fieldsMap.values()) {
            Field field2;
            if (!(field2 instanceof TextField)) {
                field2 = null;
            }
            TextField textField = (TextField) field2;
            if (textField != null) {
                textField.setEditable(z);
            }
        }
    }

    public final void trimTextFields() {
        for (Field field : this.fieldsMap.values()) {
            Field field2;
            if (!(field2 instanceof TextField)) {
                field2 = null;
            }
            TextField textField = (TextField) field2;
            if (textField != null) {
                textField.trim();
            }
        }
    }

    public final boolean validate() {
        Field field = (Field) null;
        boolean z = true;
        for (Field field2 : this.fieldsMap.values()) {
            z &= field2.validateAndSetError() == ValidationCode.Ok ? 1 : 0;
            if (field == null && !z) {
                field = field2;
            }
        }
        if (field != null) {
            field.requestFocus();
        }
        return z;
    }

    public void onErrorStateChanged(MaterialEditText materialEditText, boolean z) {
        C0700j.m2715b(materialEditText, "editText");
        if (this.errorStateListener != null) {
            if (this.isFormHasTextError != z) {
                materialEditText = null;
                for (Field hasError : this.fieldsMap.values()) {
                    materialEditText |= hasError.hasError();
                }
                if (this.isFormHasTextError != materialEditText) {
                    this.isFormHasTextError = materialEditText;
                    materialEditText = this.errorStateListener;
                    if (materialEditText == null) {
                        C0700j.m2709a();
                    }
                    materialEditText.onErrorStateChanged(this, this.isFormHasTextError);
                }
            }
        }
    }

    public final void setAllFieldsRequired(boolean z) {
        for (Field required : this.fieldsMap.values()) {
            required.setRequired(z);
        }
    }

    public final void clear() {
        this.fieldsMap.clear();
    }
}
