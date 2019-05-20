package ru.gg.scooby.ui.input.field;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.MaterialEditText.C2039a;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.ui.input.validator.Validator;
import ru.gg.scooby.util.UIUtils;

/* compiled from: TextField.kt */
public abstract class TextField extends Field {
    private boolean isClearErrorOnTextChange = true;
    private boolean isTrimOnFocusChange;

    public abstract TextView getTextView();

    public final boolean isTrimOnFocusChange() {
        return this.isTrimOnFocusChange;
    }

    public final void setTrimOnFocusChange(boolean z) {
        this.isTrimOnFocusChange = z;
    }

    public final boolean isClearErrorOnTextChange() {
        return this.isClearErrorOnTextChange;
    }

    public final void setClearErrorOnTextChange(boolean z) {
        this.isClearErrorOnTextChange = z;
    }

    public final String getText() {
        if (getTextView() == null) {
            return null;
        }
        TextView textView = getTextView();
        if (textView == null) {
            C0700j.m2709a();
        }
        return textView.getText().toString();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(getText());
    }

    public TextField(String str, View view, Validator validator) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(view, "view");
        super(str, view, validator, false, 8, null);
    }

    public TextField(String str, View view, Validator validator, boolean z) {
        C0700j.m2715b(str, "name");
        C0700j.m2715b(view, "view");
        super(str, view, validator, z);
    }

    public void onFocusChange(View view, boolean z) {
        C0700j.m2715b(view, "v");
        if (!isEmpty()) {
            super.onFocusChange(view, z);
            if (this.isTrimOnFocusChange != null) {
                trim();
            }
        }
    }

    public boolean hasError() {
        TextView textView = getTextView();
        if (textView == null) {
            C0700j.m2709a();
        }
        return textView.getError() != null;
    }

    public void setError(ValidationCode validationCode) {
        C0700j.m2715b(validationCode, "validationCode");
        setLastValidationCode(validationCode);
        if (validationCode == ValidationCode.Ok) {
            validationCode = getTextView();
            if (validationCode == null) {
                C0700j.m2709a();
            }
            validationCode.setError((CharSequence) null);
        } else if (validationCode.isFieldNameRequired()) {
            r0 = getTextView();
            if (r0 == null) {
                C0700j.m2709a();
            }
            r0.setError(getContext().getString(validationCode.getErrorMessage(), new Object[]{getName()}));
        } else if (validationCode == ValidationCode.InvalidField) {
            r0 = getTextView();
            if (r0 == null) {
                C0700j.m2709a();
            }
            r0.setError(getContext().getString(validationCode.getErrorMessage(), new Object[]{getName()}));
        } else {
            r0 = getTextView();
            if (r0 == null) {
                C0700j.m2709a();
            }
            r0.setError(getContext().getString(validationCode.getErrorMessage()));
        }
    }

    public final void trim() {
        if (!isEmpty()) {
            String text = getText();
            if (text == null) {
                C0700j.m2709a();
            }
            CharSequence charSequence = text;
            int length = charSequence.length() - 1;
            int i = 0;
            Object obj = null;
            while (i <= length) {
                Object obj2 = charSequence.charAt(obj == null ? i : length) <= ' ' ? 1 : null;
                if (obj == null) {
                    if (obj2 == null) {
                        obj = 1;
                    } else {
                        i++;
                    }
                } else if (obj2 == null) {
                    break;
                } else {
                    length--;
                }
            }
            charSequence = charSequence.subSequence(i, length + 1).toString();
            if (!TextUtils.equals(getText(), charSequence)) {
                TextView textView = getTextView();
                if (textView == null) {
                    C0700j.m2709a();
                }
                textView.setText(charSequence);
            }
        }
    }

    public final void setEditable(boolean z) {
        TextView textView = getTextView();
        UIUtils uIUtils = UIUtils.INSTANCE;
        if (textView == null) {
            C0700j.m2709a();
        }
        uIUtils.setEditable(textView, z);
    }

    public final void setupClearErrorTextWatcher() {
        TextView textView = getTextView();
        if (textView == null) {
            C0700j.m2709a();
        }
        textView.addTextChangedListener(new TextField$setupClearErrorTextWatcher$1(this));
    }

    public final void setErrorStateListener(C2039a c2039a) {
        C0700j.m2715b(c2039a, "errorStateListener");
        if (getTextView() instanceof MaterialEditText) {
            TextView textView = getTextView();
            if (textView != null) {
                ((MaterialEditText) textView).setErrorStateListener(c2039a);
                return;
            }
            throw new C0724k("null cannot be cast to non-null type com.rengwuxian.materialedittext.MaterialEditText");
        }
    }
}
