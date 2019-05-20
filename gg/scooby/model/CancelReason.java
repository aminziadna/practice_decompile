package ru.gg.scooby.model;

import p042b.p047e.p049b.C0700j;

/* compiled from: CancelReason.kt */
public enum CancelReason {
    ;
    
    public static final Companion Companion = null;
    private final String analyticsId;
    private final int btnId;

    /* compiled from: CancelReason.kt */
    public static final class Companion {
        private Companion() {
        }

        public final CancelReason byId(int i) {
            for (CancelReason cancelReason : CancelReason.values()) {
                if ((i == cancelReason.getBtnId() ? 1 : null) != null) {
                    break;
                }
            }
            CancelReason cancelReason2 = null;
            return cancelReason2 != null ? cancelReason2 : CancelReason.Unknown;
        }
    }

    protected CancelReason(int i, String str) {
        C0700j.m2715b(str, "analyticsId");
        this.btnId = i;
        this.analyticsId = str;
    }

    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    public final int getBtnId() {
        return this.btnId;
    }

    static {
        Companion = new Companion();
    }
}
