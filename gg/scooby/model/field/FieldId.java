package ru.gg.scooby.model.field;

import android.text.TextUtils;
import p042b.p047e.p049b.C0700j;

/* compiled from: FieldId.kt */
public enum FieldId {
    ;
    
    public static final Companion Companion = null;
    private final int humanStringRes;
    private final String id;

    /* compiled from: FieldId.kt */
    public static final class Companion {
        private Companion() {
        }

        public final FieldId byId(String str) {
            C0700j.m2715b(str, "id");
            for (FieldId fieldId : FieldId.values()) {
                if (TextUtils.equals(fieldId.getId(), str)) {
                    return fieldId;
                }
            }
            return null;
        }
    }

    protected FieldId(String str, int i) {
        this.id = str;
        this.humanStringRes = i;
    }

    public final int getHumanStringRes() {
        return this.humanStringRes;
    }

    public final String getId() {
        return this.id;
    }

    static {
        Companion = new Companion();
    }
}
