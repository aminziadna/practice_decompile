package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: AdvStatus.kt */
public enum AdvStatus {
    ;
    
    public static final Companion Companion = null;
    private final int code;
    private final String description;
    /* renamed from: final */
    private final boolean f8285final;

    /* compiled from: AdvStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AdvStatus byCode(int i) {
            for (AdvStatus advStatus : AdvStatus.values()) {
                if ((advStatus.getCode() == i ? 1 : null) != null) {
                    break;
                }
            }
            AdvStatus advStatus2 = null;
            return advStatus2 != null ? advStatus2 : AdvStatus.ADV_UNKNOWN;
        }
    }

    protected AdvStatus(int i, String str, boolean z) {
        C0700j.m2715b(str, "description");
        this.code = i;
        this.description = str;
        this.f8285final = z;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getFinal() {
        return this.f8285final;
    }

    static {
        Companion = new Companion();
    }

    public final boolean isValidStatus() {
        AdvStatus advStatus = this;
        return (advStatus == ADV_DISABLED || advStatus == ADV_DISPUTE || advStatus == ADV_UNKNOWN) ? false : true;
    }
}
